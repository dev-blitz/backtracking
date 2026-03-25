package com.blitz.backtracking;

public class SubarrayWithMaxSum {
  public static int maxSumInUnsortedArray(int[] arr) {
    int current = arr[0];
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
       current = arr[i] + current > arr[i] ? arr[i] + current : arr[i];
       max = max > current ? max : current;
    }
    return max;
  }
}
