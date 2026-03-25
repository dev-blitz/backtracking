package com.blitz.backtracking;

/**
 * implemtation to find sub-array with maximum sum with <strong>Kaden's</strong> algorithm
 * @author blitz
 */
public class SubarrayWithMaxSum {
  /**
   * @param arr array in which we want to find the sub-array with maxim sum
   * @return int the sum of the sub-array with maximum sum
   */
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
