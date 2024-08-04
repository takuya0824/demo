package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GachaDao;
import com.example.demo.entity.Clothes;
import com.example.demo.exception.NoClothesFoundException;
import com.example.demo.exception.NoMatchingCategoryException;
import com.example.demo.model.GachaRequest;
import com.example.demo.model.Outfit;

@Service
public class GachaService {
  
  @Autowired
  private GachaDao gachaDao;

  public Outfit getCoordinateBySeason(GachaRequest request) {
    // 選択した季節の服データを全て取得
    List<Clothes> clothes = gachaDao.selectAll(request.getSeason());
    
    // 季節に一致する服がない場合
    if (clothes.isEmpty()) {
    	throw new NoClothesFoundException(request.getSeason() + "の服が登録されていません。");
    }
    
    // 取得した服のデータからコーディネートを決定
    Outfit outfit = new Outfit();
    
    if (Math.random() < 0.5) {
    	// 50%の確率でトップス、スカートを選択
        outfit.setTop(selectItem(clothes, "トップス"));
        outfit.setBottom(selectItem(clothes, "スカート,ズボン"));
    } else {
    	// 50%の確率でワンピースを選択
        outfit.setBottom(selectItem(clothes, "ワンピース"));
    }
    
    // 100%の確率で靴を選択
    outfit.setShoes(selectItem(clothes, "靴"));

    // 50%の確率でメガネを選択
    if (Math.random() < 0.5) {
        outfit.setGlasses(selectItem(clothes, "メガネ"));
    }
    // 決定したコーディネートをレスポンスする
    return outfit;
  }
  
  private Clothes selectItem(List<Clothes> items, String categories) {
	  // カテゴリーごとに服をランダムに選択（確率は全て同じ）
      List<String> categoryList = Arrays.asList(categories.split(","));
      List<Clothes> filteredItems = items.stream()
          .filter(item -> categoryList.contains(item.getCategory()))
          .collect(Collectors.toList());
      
      // カテゴリーに一致する服がない場合
      if (filteredItems.isEmpty()) {
    	  throw new NoMatchingCategoryException("以下のカテゴリーのデータが登録されていません: " + String.join("、", categoryList));
      }
      // ランダムに選択した服をレスポンス（カテゴリーごと）
      return filteredItems.get(new Random().nextInt(filteredItems.size()));
  }
}
