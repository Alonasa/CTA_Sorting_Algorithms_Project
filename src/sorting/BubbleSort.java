package sorting;

/**
 * Bubble Sort Algorithm
 * Is stable in-place comparison based algorithm. Algorithm based on
 * comparing of 2 adjacent elements and swapping them if they are in wrong order.
 * My understanding of algorithm steps explained bellow
 * Source: https://www.geeksforgeeks.org/bubble-sort-algorithm/
 */

public class BubbleSort {
	/**
	* Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping adjacent elements
    * if they are in the wrong order. After each pass, the largest unsorted element "bubbles" to its correct
    * position at the end of the array. This process is repeated for all elements until the array is sorted.
    * Time Complexity:
    * Best Case: O(n) (when the array is already sorted; optimized version with swapped check)
    * Average Case: O(n^2)
    * Worst Case: O(n^2)
    * Auxiliary Space: O(1) (in-place sorting)
    * Stability: Stable (maintains the relative order of equal elements).
    * 
	* @param arr the array of integers to be sorted
	*/
	public void bubbleSort(int[] arr) {
		int n = arr.length;
		/*
		 * 1.Define swapped variable where we will store boolean value It helps not
		 * iterate over array as values already sorted
		 */
		boolean swapped;

		/*
		 * 2.Define outer loop. That needed as inner for loop will pass over all
		 * elements only once which might be not enough for sorting all items in the
		 * array
		 */
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			// If inner loop didn't swap any elements that means that all items sorted
			if (!swapped) {
				break;
			}
		}
	}

}
