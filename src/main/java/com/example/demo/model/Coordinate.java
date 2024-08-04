package com.example.demo.model;

import com.example.demo.entity.Clothes;

import lombok.Data;

@Data
public class Coordinate {
	
	private Clothes top;
    private Clothes bottom;
    private Clothes shoes;
    private Clothes glasses;
	
}
