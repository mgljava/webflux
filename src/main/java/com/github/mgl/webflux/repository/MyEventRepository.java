package com.github.mgl.webflux.repository;

import com.github.mgl.webflux.bean.MyEvent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MyEventRepository extends ReactiveMongoRepository<MyEvent, Long> { // 1

}