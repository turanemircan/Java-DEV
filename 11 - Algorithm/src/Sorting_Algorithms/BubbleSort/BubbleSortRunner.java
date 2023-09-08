package Sorting_Algorithms.BubbleSort;

import java.util.Arrays;

public class BubbleSortRunner {

    public static void main(String[] args) {

        int[] arr = {3,1,2};

        System.out.println("BSort oncesi Array : ");
        System.out.println(Arrays.toString(arr));
        System.out.println("************************");

        System.out.println("BSort Sonrasi Array : ");
        BubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
