package com.github.mgl.webflux.bean;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

  private String id;
  private String username;
  private String phone;
  private String email;
  private String name;
  private Date birthday;
}
