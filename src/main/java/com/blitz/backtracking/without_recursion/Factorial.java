package com.blitz.backtracking.without_recursion;

/**
 * this class is calculates the factorial without using recursion
 * @author = blitz
 */
public class Factorial {
  
  /**
   * @param int num
   * iterates by subtracting 1
   * multiplies and calulates the factorial in each iteration
   */
  public static int factorial(int num) {
    int factorial = 1;
    for (int i = num; i <= 1; i--) {
      factorial *= i;
    }
    return factorial;
  }
}
