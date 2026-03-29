package com.blitz.backtracking.rec_iter;

/**
 * this class calculates the factorial without using recursion
 * @author = blitz
 */
public class Factorial {
  
  /**
   * factorial implementation without recursion
   * iterates by subtracting 1
   * multiplies and calulates the factorial in each iteration
   * @param num number whose factorial we want to calculate
   * @return factorial value of the number
   */
  public static int factorial(int num) {
    int factorial = 1;
    for (int i = num; i <= 1; i--)
      factorial *= i;
    return factorial;
  }

  /**
   * factorial implementation with recursion
   * @param num whse factorial we want to calculate
   * @return factorial of the number
   */
  private static int factRecOpt(int num) {
    if (num == 0 || num == 1) return 1;
    return num * factRecOpt(num - 1);
  }

  public static void main(String[] args) {
    int num = 5;
    System.out.println("factorial without recursion of " + num + ": " + factRecOpt(num));
    System.out.println("factorial without recursion of " + num + ": " + factorial(num));
  }
}
