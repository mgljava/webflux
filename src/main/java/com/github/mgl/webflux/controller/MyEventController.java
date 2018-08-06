package com.github.mgl.webflux.controller;

import com.github.mgl.webflux.bean.MyEvent;
import com.github.mgl.webflux.repository.MyEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/events")
public class MyEventController {

  @Autowired
  private MyEventRepository myEventRepository;

  @PostMapping(path = "")
  public Mono<Void> loadEvents(@RequestBody Flux<MyEvent> events) {   // 1
    // TODO
    return this.myEventRepository.insert(events).then();
  }

  @GetMapping(path = "", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Flux<MyEvent> getEvents() {  // 2
    // TODO
    return this.myEventRepository.findBy();
  }
}
