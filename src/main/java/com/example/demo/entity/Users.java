package com.example.demo.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class Users {
  private int users_id;
  private String email;
  private String password;
}
