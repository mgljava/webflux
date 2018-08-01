package com.github.mgl.webflux.repository;

import com.github.mgl.webflux.bean.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

// 响应式的Spring Data也提供了相应的Repository库
public interface UserRepository extends ReactiveCrudRepository<User, String> {

  Mono<User> findByUsername(String username);

  Mono<Long> deleteByUsername(String username);
}
