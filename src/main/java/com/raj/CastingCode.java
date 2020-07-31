package com.raj;

import java.math.BigDecimal;
import java.util.Random;

public class CastingCode {

  public static void main(String[] args) {
    Object result;

    Integer randomNumber = new Random().nextInt(3);
    if (randomNumber == 1) {
      result = new BigDecimal(30);
    }else {
      result = "hello";
    }
    System.out.println("Result is currently "+ result);

    if (result instanceof BigDecimal) {
      result = ((BigDecimal) result).add(BigDecimal.TEN);
    }else {
      String tempResult = (String) result;
      result = tempResult.toUpperCase();
    }
    System.out.println("Result is currently "+ result);
  }
}
