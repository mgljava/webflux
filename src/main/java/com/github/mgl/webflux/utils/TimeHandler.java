package com.github.mgl.webflux.utils;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TimeHandler {

  public Mono<ServerResponse> getTime(ServerRequest serverRequest) {
    return ok().contentType(MediaType.TEXT_PLAIN)
        .body(Mono.just("Now is : " + new SimpleDateFormat("HH:mm:ss").format(new Date())),
            String.class);
  }

  public Mono<ServerResponse> getDate(ServerRequest serverRequest) {
    return ok().contentType(MediaType.TEXT_PLAIN)
        .body(Mono.just("Today is " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())),
            String.class);
  }

  public Mono<ServerResponse> getTimePerSec(ServerRequest serverRequest) {
    // MediaType.TEXT_EVENT_STREAM 表示服务端推送，即SSE
    // 利用interval生成每秒一个数据的流。
    return ok().contentType(MediaType.TEXT_EVENT_STREAM)
        .body(Flux.interval(Duration.ofSeconds(1))
            .map(time -> new SimpleDateFormat("HH:ss:mm").format(new Date())), String.class);
  }
}
