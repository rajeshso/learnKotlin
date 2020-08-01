package com.raj;

import java.util.function.Function;

public class ExploringFunctionsInJava {
  public static String applySomeFunctionAsAString(String inputString, Function<String, String> myFunction) {
    return myFunction.apply(inputString);
  }

  public static void main(String[] args) {
    String result = applySomeFunctionAsAString("hello", x->x.toUpperCase());
    System.out.println(result);
  }
}
