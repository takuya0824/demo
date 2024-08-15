package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Clothes;
import com.example.demo.exception.NoClothesFoundException;
import com.example.demo.model.Coordinate;
import com.example.demo.service.GachaService;


@RestController
@RequestMapping("/gacha")
public class GachaController {
	
  @Autowired
  GachaService gachaService;
  
  @PostMapping("/coordinate")
  public Coordinate getCoordinateBySeason(@RequestBody Clothes request) {

    // 季節が選択されていない場合
    if(request.getSeason() == null) {
      throw new NoClothesFoundException("季節が選択されていません。");
    }
    return gachaService.getCoordinateBySeason(request);
  }
}
