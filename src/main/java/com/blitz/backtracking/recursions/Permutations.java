package com.blitz.backtracking.recursions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class is the implementation to compute all the permutations
 * of a String or an array
 * @author blitz
 */
public class Permutations {

  /**
   * @param String string whose permutations are to be computed
   * @return List<String> all the permutations of the string
   */
  public static List<String> permute(String str) {
    return permute(str, 0, str.length() - 1, new ArrayList<String>());
  }

  /**
   * @param String string whose permutations are to be computed
   * @param int leftIndex-index
   * @param int rightIndex-index
   * @param List<String> list of String
   * @return List<String> all the permutations of the string
   */
  private static List<String> permute(String str, int leftIndex, int rightIndex, List<String> list) {
    if (leftIndex == rightIndex) {
      if (!list.contains(str)) {
        list.add(str);
      }
    } else {
      for (int i = leftIndex; i <= rightIndex; i++) {
        str = swap(str, leftIndex, i);
        permute(str, leftIndex + 1, rightIndex, list);
        str = swap(str, leftIndex, i);
      }
    }
    return list;
  }

  /**
   * @param String str
   * @param int leftIndex-index
   * @param int rightIndex-index
   * @return String the string after swapping the characters at the indices
   */
  private static String swap(String str, int leftIndex, int rightIndex) {
    char[] array = str.toCharArray();
    char temp = array[leftIndex];
    array[leftIndex] = array[rightIndex];
    array[rightIndex] = temp;
    return String.valueOf(array);
  }

  /**
   * @param int[] array
   * @return List<List<Integer>> list of all the combinations of the array as a list
   */
  public static List<List<Integer>> permute(int[] array) {
    return permute(array, 0, array.length - 1, new ArrayList<List<Integer>>());
  }

  /**
   * @param int[] arry which has to be sorted
   * @param int leftIndex-index
   * @param int rightIndex-index
   * @param List<List<Integer>> list of list of integer where all the combinations will be added and returned
   * @return List<List<Integer>> the same list which was passed as a parameter but now contains all the
   * combinations of the array
   */
  private static List<List<Integer>> permute(int[] array, int leftIndex, int rightIndex, List<List<Integer>> list) {
    if (leftIndex == rightIndex) {
      List<Integer> combination = Arrays.stream(array)
          .boxed()
          .toList();
      if (!list.contains(combination)) {
        list.add(combination);
      }
    } else if (leftIndex < rightIndex) {
      for (int i = leftIndex; i <= rightIndex; i++) {
        array = swap(array, leftIndex, i);
        permute(array, leftIndex + 1, rightIndex, list);
        array = swap(array, leftIndex, i);
      }
    }
    return list;
  }

  /**
   * @param int[] array
   * @param int left-index
   * @param int right-index
   * @return array after swapping the contents of the indices
   */
  private static int[] swap(int[] array, int leftIndex, int rightIndex) {
    int temp = array[leftIndex];
    array[leftIndex] = array[rightIndex];
    array[rightIndex] = temp;
    return array;
  }
}
