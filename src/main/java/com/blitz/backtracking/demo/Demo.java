package com.blitz.backtracking.demo;

import java.util.Arrays;

import com.blitz.backtracking.recursions.Permutations;

public class Demo {
  public static void main(String[] args) {
    String str = "ABC";
    System.out.println("permutations of " + str + " are:\n\t" + Permutations.permute(str));
    int[] array = new int[] {1, 2, 3};
    System.out.println("permutations of " + Arrays.toString(array) + " are:\n\t" + Permutations.permute(array));
  }
}
