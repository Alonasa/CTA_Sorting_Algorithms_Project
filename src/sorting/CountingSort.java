package sorting;

/*Counting sort
 * Algorithm based on non-comperative sorting approach, its counts number occurrences of each unique value in the input
 * and then put them in its position
*/

public class CountingSort {
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
