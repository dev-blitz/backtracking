package com.blitz.backtracking.recursive;

import java.util.HashSet;
import java.util.Set;

/**
 * this class has the implementations of the permutations in recursive and iterative approaches
 * along with class has some most common and basic permutation problems
 * @author blitz
 */
public class Permutations {

  /**
   * <strong><em>iterative</em></strong> implementation of permutation
   * @param str string whose permutations we want to compute
   * @return Set<String> all the permutations as a set
   */
  public static Set<String> permuteIter(String str) {
    return permuteIter(str, 0, str.length() - 1, new HashSet<String>());
  }

  /**
   * overloaded private method to compute the permutations in an <em>iterative</em> approach
   * @param str
   * @param left left-index
   * @param right right-index
   * @param set set to retain the permutations computed
   * @return Set<String> set containing all the permutations
   */
  private static Set<String> permuteIter(String str, int left, int right, Set<String> set) {
    if (left == right) {
      set.add(str);
    } else if (left < right) {
      for (int i = left; i <= right; i++) {
        str = swap(str, left, right);

        str = swap(str, left, right);
      }
    }
    return set;
  }

  /**
   * recursive call to compute all the permutations of the string as a <em>Set</em>
   * @param str whose permutations we want to compute
   * @return Set<String> all the permutations of the string
   */
  public static Set<String> permute(String str) {
    return permute(str, 0, str.length() - 1, new HashSet<String>());
  }

  /**
   * overloaded method which will be called <em>recursively</em> to compute the permutations
   * @param str whose permutations we want to compute
   * @param left left-index from where we want to start permutating the values
   * @param right right-index from where we want to start permutating the values
   * @param set set which will retain the values during each permutation
   * @return Set<String> set of all the permutations of the string
   */
  private static Set<String> permute(String str, int left, int right, Set<String> set) {
    if (left == right) {
      set.add(str);
    } else if (left < right) {
      for (int i = left; i <= right; i++) {
        str = swap(str, left, i);
        permute(str, left + 1, right, set);
        str = swap(str, left, i);
      }
    }
    return set;
  }

  /**
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

  public static void main(String[] args) {
    String str = "ABC";
    System.out.println("permutations of " + str + " are: " + permute(str));
  }
}
