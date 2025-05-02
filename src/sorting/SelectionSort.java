package sorting;

/*
 * Selection sort
 * Algorithm based on 2 loops one outer one inner, it's repetitively iterate over elements 
 * and compare if element in outer loop bigger than in inner, if so then its save its index
 * and swap elements positions
 * Source: https://www.geeksforgeeks.org/selection-sort-algorithm-2/
 */

public class SelectionSort {
	public void selectionSort(int[] arr) {
		int n = arr.length;
		// 1. define outer loop
		for (int i = 0; i < n - 1; i++) {
			int minIdx = i;
			/*
			 * 2.Define inner loop which will make a comparison between 2 elements and if
			 * element from outer loop bigger than inner then rewrite min index for the
			 * future swap
			 */
			for (int j = i + 1; j < n; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			/*
			 * 2.Make a swap between element with minIdx and element with index of outer
			 * loop
			 */
			int swap = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = swap;
		}
	}
}
