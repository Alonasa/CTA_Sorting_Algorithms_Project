package sorting;

/*
 * Bubble Sort Algorithm
 * Algorithm based on comparing of 2 adjacent elements and swapping them if they are in wrong order.
 * My understanding of algorithm steps explained bellow
 */

public class BubbleSort {
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
