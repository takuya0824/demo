package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.NoClothesFoundException;
import com.example.demo.model.Coordinate;
import com.example.demo.service.GachaService;


@RestController
@RequestMapping("/gacha")
public class GachaController {
	
  @Autowired
  GachaService gachaService;
  
  @GetMapping("/coordinate")
  public Coordinate getCoordinateBySeason(@RequestParam String season) {

    // 季節が選択されていない場合
    if("".equals(season)) {
      throw new NoClothesFoundException("季節が選択されていません。");
    }
    return gachaService.getCoordinateBySeason(season);
  }
}
