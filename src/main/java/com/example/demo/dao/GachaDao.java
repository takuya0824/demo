package com.example.demo.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.demo.entity.Clothes;

@Dao
@ConfigAutowireable
public interface GachaDao {

  @Select
  public List<Clothes> selectAll(String season);
}
