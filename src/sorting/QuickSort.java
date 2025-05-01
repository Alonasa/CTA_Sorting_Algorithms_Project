package sorting;

/*
 * Quick sort
 * It's fast algorithm divide-and-concer algorithm that picks "pivot" element,
 * and partitions the array on elements less than pivot and greater than pivot and recursively sorts the partitions  
 */

public class QuickSort {
	public void quickSort(int[] arr, int min, int max) {
		/*
		 * Recursively call quickSort function till condition become false one part
		 * executing from minimal index to result of partition another from result of
		 * partition till maximum index
		 */
		if (min < max) {
			int iteration = partition(arr, min, max);
			quickSort(arr, min, iteration - 1);
			quickSort(arr, iteration + 1, max);
		}
	}

	/*
	 * Partitions for the quick sort algorithm, as quick sort assume to call it /
	 * recursively
	 */

	private static int partition(int[] arr, int min, int max) {
		int pivot = arr[max];
		int j = min - 1;

		for (int i = min; i < max; i++) {
			if (arr[i] < pivot) {
				j++;
				int temp = arr[i];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}

		int temp = arr[j + 1];
		arr[j + 1] = arr[max];
		arr[max] = temp;
		return j + 1;
	}
}
