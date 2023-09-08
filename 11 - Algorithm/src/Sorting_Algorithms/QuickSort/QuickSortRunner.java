package Sorting_Algorithms.QuickSort;

import java.util.Arrays;

public class QuickSortRunner {

    public static void main(String[] args) {

        int[] arr = {3,5,4};

        System.out.println("QSort oncesi Array : ");
        System.out.println(Arrays.toString(arr));
        System.out.println("******************");

        System.out.println("QSort Sonrasi Array :");
        QuickSort.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
