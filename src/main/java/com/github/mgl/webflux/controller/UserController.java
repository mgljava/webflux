package com.github.mgl.webflux.controller;

import com.github.mgl.webflux.bean.User;
import com.github.mgl.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("")
  public Mono<User> save(User user) {
    return this.userService.save(user);
  }

  @DeleteMapping("/{username}")
  public Mono<Long> deleteByUsername(@PathVariable String username) {
    return this.userService.deleteByUsername(username);
  }

  @GetMapping("/{username}")
  public Mono<User> findByUsername(@PathVariable String username) {
    return this.userService.findByUsername(username);
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Flux<User> findAll() {
    // return this.userService.findAll().delayElements(Duration.ofSeconds(2));
    return this.userService.findAll();
  }
}
