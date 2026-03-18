package com.blitz.backtracking.recursions;

/**
 * this class is an implementation of Merge Sort
 * sorting technique with <em>O(nlog(n))</em> time complexity
 * using recursive <em><string>divide and conquer</strong> approach</em>
 * <p>Performance Characteristics:
 * <ul>
 * <li>Time Complexity: O(n log n) in all cases (best, average, worst).</li>
 * <li>Space Complexity: O(n) auxiliary space due to temporary array allocation.</li>
 * <li>Stability: This is a <b>stable</b> sort implementation.</li>
 * </ul>
 * </p>
 * @note Space Complexity: O(n) due to temporary arrays used 
 * during the merge process.
 * @author blitz 
 */
public class MergeSortImpl {

  /**
   * @param int[] array
   * @return int[] ihe same array instance, now sorted array
   * @throws IllegalArgumentException if the array is null 
   */
  public static int[] sort(int[] array) {
    if (array == null) 
      throw new IllegalArgumentException("array cannot be empty");
    if (array.length == 0 || array.length == 1)
      return array; 
    return sort(array, 0, array.length - 1);
  }

  /**
   * @param int[] array
   * @param int left left-index
   * @param int right right-index
   * @return int[] sorted array
   */
  private static int[] sort(int[] array, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      sort(array, left, mid);
      sort(array, mid + 1, right);
      merge(array, left, mid, right);
    }
    return array;
  }

  /**
   * @param int[] array original array
   * @param int left left-index
   * @param int mid calculated middle-index
   * @param int right right-index
   * 
   * this method overrides the contents of the original array by diving the
   * array into different parts according to the indices provided.
   */
  private static void merge(int[] array, int left, int mid, int right) {
    int[] leftArr = new int[mid - left + 1];
    int[] rightArr = new int[right - mid];

    for (int i = 0; i < leftArr.length; i++)
      leftArr[i] = array[left + i];

    for (int i = 0; i < rightArr.length; i++)
      rightArr[i] = array[mid + 1 + i];

    int leftIndex = 0;
    int rightIndex = 0;
    int z = left;

    while (leftIndex < leftArr.length && rightIndex < rightArr.length) 
      if (leftArr[leftIndex] < rightArr[rightIndex])
        array[z++] = leftArr[leftIndex++];
      else
        array[z++] = rightArr[rightIndex++];

    while (leftIndex < leftArr.length)
      array[z++] = leftArr[leftIndex++];
      
    while (rightIndex < rightArr.length)
      array[z++] = rightArr[rightIndex++];
  }
}
