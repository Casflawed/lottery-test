package com.flameking.lottery.test.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author WangWei
 * @dateTime 2023/7/17 23:52
 */
public class GoldDivide {
  private static final int HASH_INCREMENT = 0x61c88647;

  public static void main(String[] args) {
    int size = 100;
    HashMap<Integer, List<Integer>> distributeMap = new HashMap<>();
    while (size > 0){
      int data = 101 - size;
      int idx = (data * HASH_INCREMENT + HASH_INCREMENT) & (128 - 1);
      if (distributeMap.containsKey(idx)){
        distributeMap.get(idx).add(size);
      }else {
        distributeMap.put(idx, new ArrayList<>());
        distributeMap.get(idx).add(data);
      }
      size--;
    }
    distributeMap.forEach((key, value) -> {
      System.out.print(key + "：");
      for (Integer data : value) {
        System.out.print(data + " ");
      }
      System.out.println();
    });
  }
}
