package sorting;

/*Selection sort
 * 
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
