package com.blitz.backtracking.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * this class has the implementations of the permutations in recursive and iterative approaches
 * along with class has some most common and basic permutation problems
 *
 * @author blitz
 */
public class Permutations {
 
  /**
   * recursive call to compute all the permutations of the string as a <em>List</em>
   * @param str whose permutations we want to compute
   * @return List<String> all the permutations of the string
   */
  public static List<String> permute(String str) {
    return permute(str, 0, str.length() - 1, new ArrayList<String>());
  }

  /**
   * overloaded method which will be called <em>recursively</em> to compute the permutations
   * @param str whose permutations we want to compute
   * @param left left-index from where we want to start permutating the values
   * @param right right-index from where we want to start permutating the values
   * @param list list which will retain the values during each permutation
   * @return List<String> list of all the permutations of the string
   */
  private static List<String> permute(String str, int left, int right, List<String> list) {
    if (left <= right) {
      for (int i = left; i <= right; i++) {
        str = swap(str, left, i);
        permute(str, left + 1, right, list);
        str = swap(str, left, i);
      }
    }
    return list;
  }

  /**
   * method to swap the characters of a string at the indices provided
   * the function will swap the character at the left-index with the right-index
   * @param str string where we want to swap the characters
   * @param left left-index 
   * @param right right-index
   * @return String string after returning
   */
  private static String swap(String str, int left, int right) {
    char[] array = str.toCharArray();
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;
    return String.valueOf(array);
  }
}
