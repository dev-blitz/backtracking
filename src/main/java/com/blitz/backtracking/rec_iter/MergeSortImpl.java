package com.blitz.backtracking.rec_iter;

import java.util.Arrays;

public class MergeSortImpl {
  /**
   * merge-sort implementation with recursion
   * @param arr array that we want to sort
   * @return sorted-array
   */
  public static int[] sortRec(int[] arr) {
    return sortRec(arr, 0, arr.length - 1);
  }
  
  /**
   * @param arr array that we want to sort
   * @param left left-index of the array
   * @param right right-index of the array
   * @return sorted array
   */
  private static int[] sortRec(int[] arr, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      sortRec(arr, left, mid);
      sortRec(arr, mid + 1, right);
      merge(arr, left, mid, right);
    }
    return arr;
  }
  
  /**
   * implementation to merge the arrays by sorting them
   * @param arr array we want to sort
   * @param left left-index of the array
   * @param mid mid-index of the array
   * @param right right-index of the array
   */
  private static void merge(int[] arr, int left, int mid, int right) {
    int[] leftArr = new int[mid - left + 1];
    for (int i = 0; i < leftArr.length; i++)
      leftArr[i] = arr[left + i];

    int[] rightArr = new int[right - mid];
    for (int i = 0; i < rightArr.length; i++)
      rightArr[i] = arr[mid + 1 + i];

    int x = 0;
    int y = 0;
    int z = left;
  
    while (x < leftArr.length && y < rightArr.length)
      if (leftArr[x] < rightArr[y])
        arr[z++] = leftArr[x++];
      else
        arr[z++] = rightArr[y++];

    while (x < leftArr.length)
      arr[z++] = leftArr[x++];
    
    while (y < rightArr.length)
      arr[z++] = rightArr[y++];
  }

  public static void main(String[] args) {
    int[] arr = new int[] {35, 8, 11, 17, 9};
    System.out.println("un-sorted array: " + Arrays.toString(arr));
    sortRec(arr);
    System.out.println("array after sorting ascending order: " + Arrays.toString(arr));
  }
}
