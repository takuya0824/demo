package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Coordinate;
import com.example.demo.model.GachaRequest;
import com.example.demo.service.GachaService;


@RestController
@RequestMapping("/gacha")
public class GachaController {
	
  @Autowired
  GachaService gachaService;
  
  @GetMapping("/coordinate")
  public Coordinate getCoordinateBySeason(@RequestBody GachaRequest request) {
    return gachaService.getCoordinateBySeason(request);
  }
}
