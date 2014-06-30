package com.jonstaff.java.sort;

//  Created by jonstaff on 1/23/14.
//  Adapted from http://gauss.ececs.uc.edu/Courses/C321/html/quicksort.java.html

public class QuickSort {

    public static void sort(int[] list, int first, int last) {
        if (first >= last) return;

        int pivot = partition(list, first, last);

        sort(list, first, pivot);
        sort(list, pivot + 1, last);
    }

    public static int partition(int[] list, int first, int last) {
        int pivot = list[first];
        while (first < last) {

            while (list[first] < pivot) {
                first++;
            }

            while (list[last] > pivot) {
                last--;
            }

            swap(list, first, last);
        }

        return first;
    }

    public static void swap(int[] list, int x, int y) {
        int temp = list[x];
        list[x] = list[y];
        list[y] = temp;
    }
}