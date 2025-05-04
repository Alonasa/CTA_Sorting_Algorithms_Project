package sorting;

/**
 * Selection sort
 * It's a comparison based in-pace sorting algorithm.
 * Algorithm based on 2 loops one outer one inner, it's repetitively iterate over elements 
 * and compare if element in outer loop bigger than in inner, if so then its save its index
 * and swap elements positions and continues until entire array is sorted.
 * Source: https://www.geeksforgeeks.org/selection-sort-algorithm-2/
 */

public class SelectionSort {
	/**
     * Sorts the given array in ascending order using the Selection Sort algorithm.
     * The sorting is done in-place, modifying the input array.
     * Time Complexity: O(n^2) in the best, average, and worst cases as here we use two loops.
     * Auxiliary Space: O(1) (in-place sorting).
     * Stability: Not stable.
     *
     * @param arr the array of integers to be sorted
     */
	
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
