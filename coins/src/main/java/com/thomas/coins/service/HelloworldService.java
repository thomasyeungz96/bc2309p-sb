package com.thomas.coins.service;

import org.springframework.stereotype.Service;

@Service
public class HelloworldService {

  // Method A
  public int sum(int x, int y) {
    return x + y;
  }

  // Method B
  public String concat(String a, String b) {
    int sum = sum(10,11); 
    return a.concat(b).concat(String.valueOf(sum)); 
  }

}
