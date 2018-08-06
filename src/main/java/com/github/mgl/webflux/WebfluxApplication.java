package com.github.mgl.webflux;

import com.github.mgl.webflux.bean.MyEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class WebfluxApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebfluxApplication.class, args);
  }

  @Bean
  public CommandLineRunner initData(MongoOperations mongoOperations) {
    System.out.println("initData Method Invoked!");
    return (String... args) -> {
      mongoOperations.dropCollection(MyEvent.class);
      mongoOperations
          .createCollection(MyEvent.class, CollectionOptions.empty()
              .maxDocuments(100L).size(100000).capped());
    };
  }
}
