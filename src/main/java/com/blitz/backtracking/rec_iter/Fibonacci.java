package com.blitz.backtracking.rec_iter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * this class provides the implementation of Fibonacci sequence without using recursions
 * @author blitz
 */
public class Fibonacci {
  
  /**
   * calculates the fibonacci without recursion
   * <p>
   *    time-complexity: O(n)<br>
   *    optimised space-complexity: O(1)
   * </p>
   * @param num number whose fibonacci value we want to calculate
   * @return int fibonacci value
   */
  public static int fibIteOpt(int num) {
    int first = 0;
    int second = 1;
    for (int i = 2; i <= num; i++) {
      int fibonacci = first + second;
      first = second;
      second = fibonacci;
    }
    return second;
  }

  /**
   * calculates the fibonacci without recursion;
   * <p>
   *    time-complexity: O(n)<br>
   *    space-complexity: O(n)
   * </p>
   * @param num number whose fibonacci value we want to calculate
   * @return int fibonacci value
   */
  public static void fibIteUnOpt(int num) {
    int[] arr = new int[num];
    arr[0] = 0;
    arr[1] = 1;
    for (int i = 2; i <= num; i++)
      arr[i] = arr[i - 1] + arr[i - 2];
    System.out.println("fibonacci-sequence: " + Arrays.toString(arr));
  }

  
  /**
   * un-optimised fibonacci implementation
   * <p>
   *    time-complexity: O(n^2)<br>
   *    space-complexity: O(n^2)
   * </p>
   * @param num whose fibonacci we want to calculate
   * @return int fibonnaci value of the number
   */
  private static int fibRecUnOpt(int num) {
    if (num == 0 || num == 1)
      return num;
    return fibRecUnOpt(num - 1) + fibRecUnOpt(num - 2);
  }
  
  /**
   * optimised recursive fibonnaci implementation
   * <p>
   *    time-complexity: O(n^2)<br>
   *    space-complexity: O(n^2)
   * </p>
   * @param num whose value we want to calculate
   * @return int fibonnaci value
   */
  private static int fibRecOpt(int num) {
    return fibRecOpt(num, new HashMap<Integer, Integer>());
  }

  /**
   * overloaded optimised fibonnaci implementation for reference
   * <p>
   *    time-complexity: O(n^2)<br>
   *    space-complexity: O(n^2)
   * </p>
   * @param num whose fibonnaci value we want to calculate
   * @param map to retain the values calculated
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
    System.out.println("fibonacci of " + num + ": " + fibIteOpt(num));
    num = 6;
    System.out.println("fibonacci of " + num + ": " + fibIteOpt(num));
    num = 21;
    System.out.println("fibonacci of " + num + ": " + fibIteOpt(num));
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
