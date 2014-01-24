package com.jonstaff.java.sort;

//  Created by jonstaff on 1/22/14.
//  Adapted from http://en.wikibooks.org/wiki/Algorithm_Implementation/Sorting/Merge_sort

public class MergeSort {

	public static void main(String[] args) {
		int[] list = {7, 2, 9, 3, 8, 6, 11, 4, 1, 5, 10, 15, 16, 14, 12, 13};

		System.out.println("The list unsorted:");
		for (int x : list) {
			System.out.println(x);
		}

		sort(list);

		System.out.println("\n And the list sorted:");
		for (int x : list) {
			System.out.println(x);
		}
	}

	public static void sort(int array[]) {
		// if the array has more than 1 element, we need to split it and merge the sorted halves
		if (array.length > 1) {

			int elementsInA1 = array.length / 2;
			int elementsInA2 = array.length - elementsInA1;

			int arr1[] = new int[elementsInA1];
			int arr2[] = new int[elementsInA2];

			// fill 'arr1' with the first portion of 'array'
			for (int i = 0; i < elementsInA1; i++) {
				arr1[i] = array[i];
			}

			// fill 'arr2' with the remaining elements of 'array'
			for (int i = elementsInA1; i < elementsInA1 + elementsInA2; i++) {
				arr2[i - elementsInA1] = array[i];
			}

			// recursively call the method again for each smaller array
			sort(arr1);
			sort(arr2);

			// the three variables below are indexes that we'll need for merging
			// [i] stores the index of the main array. it will be used to let us
			// know where to place the smallest element from the two sub-arrays.
			// [j] stores the index of which element from arr1 is currently being compared
			// [k] stores the index of which element from arr2 is currently being compared
			int i = 0, j = 0, k = 0;

			// the below loop will run until one of the sub-arrays becomes empty
			while (arr1.length != j && arr2.length != k) {
				if (arr1[j] < arr2[k]) {
					array[i++] = arr1[j++];
				} else {
					array[i++] = arr2[k++];
				}
			}

			// at this point, one of the sub-arrays has been exhausted and there are no more
			// elements in it to compare. this means that all the elements in the remaining
			// array are the highest (and sorted), so it's safe to copy them all into the
			// final array.
			while (arr1.length != j) {
				array[i++] = arr1[j++];
			}
			while (arr2.length != k) {
				array[i++] = arr2[k++];
			}
		}
	}
}
