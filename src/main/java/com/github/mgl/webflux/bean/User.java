package com.github.mgl.webflux.bean;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

  @Id
  private String id;
  @Indexed(unique = true)
  private String username;
  private String phone;
  private String email;
  private String name;
  private Date birthday;
}
