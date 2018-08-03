package com.github.mgl.webflux.webclient;

import com.github.mgl.webflux.bean.User;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class WebClientTest {

  private static final String URL = "http://localhost:8080";

  /**
   * 获取字符串
   * @throws Exception
   */
  @Test
  public void webClientTest1() throws Exception {
    // 创建WebClient对象并指定baseUrl
    WebClient webClient = WebClient.create(URL);
    // http GET请求
    Mono<String> resp = webClient.get().uri("/hello")
        .retrieve() // 异步的获取response的信息
        .bodyToMono(String.class); // 将response body 解析为字符串
    resp.subscribe(System.out::println);
    // 由于是异步的，我们将测试线程sleep 1秒确保拿到response，也可以像前边的例子一样用CountDownLatch
    TimeUnit.SECONDS.sleep(1);
  }

  /**
   * 获取所有user
   * @throws Exception
   */
  @Test
  public void webClientTest2() throws Exception {
    // 使用WebClientBuilder来构建WebClient对象
    WebClient webClient = WebClient.builder().baseUrl(URL).build();
    webClient.get().uri("/user")
        .accept(MediaType.APPLICATION_STREAM_JSON) // 配置请求Header
        .exchange() // 获取response信息，返回值为ClientResponse，retrive()可以看做是exchange()方法的“快捷版”
        .flatMapMany(clientResponse -> clientResponse
            .bodyToFlux(User.class)) // 使用flatMap来将ClientResponse映射为Flux
        .doOnNext(System.out::println) // 只读地peek每个元素，然后打印出来  不会触发流
        .blockLast(); // 在收到最后一个元素前会阻塞，响应式业务场景中慎用。
  }

  /**
   * 服务端推送
   * @throws Exception
   */
  @Test
  public void webClientTest3() throws Exception {

  }
}
