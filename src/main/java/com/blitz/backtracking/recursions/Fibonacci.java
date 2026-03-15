package com.blitz.backtracking.recursions;

public class Fibonacci {
  private static int getFibonacciWithoutRecursion(int num) {
    if (num == 0 || num == 1) {
      return num;
    }

    int lastTwo = 0;
    int lastOne = 1;

    for (int i = 2; i <= num; i++) {
      int current = lastOne + lastTwo;
      lastTwo = lastOne;
      lastOne = current;
    }

    return lastOne;
  }

  public static void main(String[] args) {
    int num = 5;
    System.out.println("fibonacci of " + num + " is: " + getFibonacciWithoutRecursion(num));
    num = 3;
    System.out.println("fibonacci of " + num + " is: " + getFibonacciWithoutRecursion(num));
  }
}
