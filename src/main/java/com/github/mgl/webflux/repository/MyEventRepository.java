package com.github.mgl.webflux.repository;

import com.github.mgl.webflux.bean.MyEvent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface MyEventRepository extends ReactiveMongoRepository<MyEvent, Long> {

  // @Tailable注解的作用类似于linux的tail命令，
  // 被注解的方法将发送无限流，需要注解在返回值为Flux这样的多个元素的Publisher的方法上；
  @Tailable
  Flux<MyEvent> findBy();
}