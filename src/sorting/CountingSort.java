package sorting;

/**Counting sort
 * Algorithm based on non-comperative sorting approach, its counts number occurrences of each unique value in the input
 * and then put them in its position
 * Source: https://www.geeksforgeeks.org/counting-sort/
 * Source: https://stackoverflow.com/questions/40476521/using-counting-sort-with-negative-values-descending-order
*/

public class CountingSort {
	/**
     * Sorts the given integer array in ascending order using the Counting Sort algorithm.
     * This method modifies the input array in place. It works for arrays containing both
     * positive and negative integers by shifting the count array according to the minimum value.
     * The algorithm is stable and runs in O(n + k) time, where n is the number of elements in
     * the array and k is the range of the input values.
     * Source: https://en.wikipedia.org/wiki/Counting_sort
     * Time Complexity: O(n + k) in all cases
     * Auxiliary Space: O(n + k).
     * Stability: Stable.
     *
     * @param arr the array of integers to be sorted.
     *            If the array is empty, the method does nothing.
     */
	public void countingSort(int[] arr) {
		if (arr.length == 0)
			return;

		/*
		 * 1.We need to find minimum and maximum values to determine range of elements
		 * with which we will work
		 */
		int min = arr[0];
		int max = arr[0];
		for (int value : arr) {
			if (value < min)
				min = value;
			if (value > max)
				max = value;
		}

		// 2.We need to create the count array of the range size from previous step
		int range = max - min + 1;
		int[] count = new int[range];

		/*
		 * 3.Initially this algorithm work only with positive numbers, so for make it
		 * work with negative we need shifting by (-min). Lets count occurrences of
		 * the values
		 */
		for (int value : arr) {
			count[value - min]++;
		}

		// 4.Add sorted values to the array
		int idx = 0;
		for (int i = 0; i < range; i++) {
			while (count[i] > 0) {
				arr[idx++] = i + min;
				count[i]--;
			}
		}
	}
}
