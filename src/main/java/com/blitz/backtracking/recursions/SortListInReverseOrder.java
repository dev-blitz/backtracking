package com.blitz.backtracking.recursions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class SortListInReverseOrder {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(list);
        sortListInReverseOrderComparator(list);
        System.out.println(list);
    }

    private static List<Integer> sortListInReverseOrderComparator(List<Integer> list) {         
        /* without using Lambda
         *
         * Collections.sort(list, new Comparator<Integer>() {
         *      @Override
         *      public int compare(Integer num1, Integer num2) {
         *          return -1 * Integer.compare(num1, num2);
         *      }
         *  });
         */

        Collections.sort(list, Comparator.reverseOrder());
        // list.sort(Comparator.reverseOrder());
        return list;
    }

    private static List<Integer> sortListInReverseOrder(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++)
            array[i] = list.get(i);
        System.out.println("copied array: " + Arrays.toString(array));
        System.out.println("reverse-sorted-array: " + Arrays.toString(sort(array)));
        return IntStream.of(array)
            .boxed()
            .toList();
    }

    private static int[] sort(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    private static int[] mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            mergeSort(array, leftIndex, midIndex);
            mergeSort(array, midIndex + 1, rightIndex);
            merge(array, leftIndex, midIndex, rightIndex);
        }
        return array;
    }

    private static void merge(int[] array, int leftIndex, int midIndex, int rightIndex) {
        int[] leftArr = new int[midIndex - leftIndex + 1];
        for (int i = 0; i < leftArr.length; i++)
            leftArr[i] = array[leftIndex + i];

        int[] rightArr = new int[rightIndex - midIndex];
        for (int i = 0; i < rightArr.length; i++)
            rightArr[i] = array[midIndex + 1 + i];

        int x = 0;
        int y = 0;
        int z = leftIndex;

        while (x < leftArr.length && y < rightArr.length) {
            if (leftArr[x] < rightArr[y]) {
                array[z] = rightArr[y];
                z++;
                y++;
            } else {
                array[z++] = leftArr[x++];
            }
        }

        while (x < leftArr.length) {
            array[z++] = leftArr[x++];
        }

        while (y < rightArr.length) {
            array[z++] = rightArr[y++];
        }
    }
}
