package com.example.demo.entity;



import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "clothes")
public class Clothes {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "clothes_id")
  private int clothesId;

  @Column(name = "clothes_url")
  private String clothesUrl;

  @Column(name = "season")
  private String season;

  @Column(name = "category")
  private String category;
  
  @Column(name = "users_id")
  private int usersId;
}
