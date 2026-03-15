package com.blitz.backtracking.recursions;

public class Factorial {
  private static int getFactorialWithoutRecursion(int num) {
    if (num == 0 || num == 1) {
      return 1;
    }

    int ans = 1;
    for (int i = num; i >= 1; i--) {
      ans *= i; 
    }

    return ans;
  }

  public static void main(String[] args) {
    int num = 3;
    System.out.println("factorial of " + num + " is: " + getFactorialWithoutRecursion(num));
    num = 5;
    System.out.println("factorial of " + num + " is: " + getFactorialWithoutRecursion(num));
  }
}
