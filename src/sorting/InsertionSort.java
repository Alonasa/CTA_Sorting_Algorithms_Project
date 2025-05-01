package sorting;

/*Insertion sort
*/

public class InsertionSort {
	public void insertionSort(int[] arr) {
		// 1. Define loop which will iterate over elements starts from 2nd
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * 2. If condition true we shift element on index j + 1 with index j then we
			 * will quit from the condition as key become bigger than arr[j]
			 */
			while (j >= 0 && key < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			/*
			 * 3.Set key to the one element behind element which we set in while loop
			 * 
			 */
			arr[j + 1] = key;
		}
	}
}
