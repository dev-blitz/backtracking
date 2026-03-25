package com.blitz.backtracking.without_recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * this class provides the implementation of Fibonacci sequence without using recursions
 * @author blitz
 */
public class Fibonacci {
  
  /**
   * calculates the fibonacci without recursion;
   * @param int num number whose fibonacci value we want to calculate
   * @return int the integer fibonacci value
   */
  public static int fibonacci(int num) {
    int[] arr = new int[num + 1];
    int first = 0;
    int second = 1;
    arr[0] = first;
    arr[1] = second;
    int fibonacci = 0;
    for (int i = 2; i <= num; i++) {
      fibonacci = first + second;
      arr[i] = fibonacci;
      first = second;
      second = fibonacci;
    }
    return fibonacci;
  }
  
  /**
   * un-optimised fibonacci implementation
   * @param int num whose fibonacci we want to calculate
   * @return int fibonnaci value of the number
   */
  private static int fibRecUnOpt(int num) {
    if (num == 0 || num == 1)
      return num;
    return fibRecUnOpt(num - 1) + fibRecUnOpt(num - 2);
  }
  
  /**
   * optimised recursive fibonnaci implementation
   * @param int num whose value we want to calculate
   * @return int fibonnaci value
   */
  private static int fibRecOpt(int num) {
    return fibRecOpt(num, new HashMap<Integer, Integer>());
  }

  /**
   * overloaded optimised fibonnaci implementation for reference
   * @param int num whose fibonnaci value we want to calculate
   * @param Map<Integer, Integer> map to retain the values calculated
   * @return int fibonnaci value of the number
   */
  private static int fibRecOpt(int num, Map<Integer, Integer> map) {
    if (map.containsKey(num))
      return map.get(num);
    else if (num == 0 || num == 1)
      return num;
    int result = fibRecOpt(num - 1, map) + fibRecOpt(num - 2, map);
    map.put(num, result);
    return result;
  }

  public static void main(String[] args) {
    int num = 5;
    System.out.println("fibonacci of " + num + ": " + fibonacci(num));
    num = 6;
    System.out.println("fibonacci of " + num + ": " + fibonacci(num));
    num = 21;
    System.out.println("fibonacci of " + num + ": " + fibonacci(num));
    System.out.println("OPTIMISED-RECUSION");
    num = 5;
    System.out.println("fibonacci of " + num + ": " +fibRecOpt(num));
    num = 6;
    System.out.println("fibonacci of " + num + ": " +fibRecOpt(num));
    num = 21;
    System.out.println("fibonacci of " + num + ": " +fibRecOpt(num));
    System.out.println("UN-OPTIMISED-RECUSION");
    System.out.println("fibonacci of " + num + ": " +fibRecUnOpt(num));
    num = 6;
    System.out.println("fibonacci of " + num + ": " +fibRecUnOpt(num));
    num = 21;
    System.out.println("fibonacci of " + num + ": " +fibRecUnOpt(num));
    num = 5;
  }
}
