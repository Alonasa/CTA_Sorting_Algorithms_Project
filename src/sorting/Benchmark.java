package sorting;
import java.util.Arrays;

/**
 * Provides benchmarking utilities for comparing the performance of sorting algorithms
 * Encapsulates Bubble Sort, Insertion Sort, Selection Sort, Quick Sort, Counting Sort
 * sorting algorithm implementations and measure their execution time
 * Source: https://vlegalwaymayo.atu.ie/mod/url/view.php?id=1136860
 */

public class Benchmark {
	/**
	 * Benchmarks execution time of specified algorithm. 
	 * Input array cloned before each algorithm execution to prevent data mutation
	 * @param arr        The array of integers to sort (the original array is not modified).
     * @param algorithm  The name of the sorting algorithm to use. Must be one of the above.
     * @return           The time taken to sort the array, in milliseconds.
     * @throws IllegalArgumentException if the algorithm name is not recognized.
	 */
	private static final BubbleSort bubbleSorter = new BubbleSort();
	private static final InsertionSort insertionSorter = new InsertionSort();
	private static final SelectionSort selectionSorter = new SelectionSort();
	private static final QuickSort quickSorter = new QuickSort();
	private static final CountingSort countingSorter = new CountingSort();

	public double algorithmsBenchmark(int[] arr, String algorithm) {
		// Create copy of initial array to prevent mutation
		int[] clonned = Arrays.copyOf(arr, arr.length);
		// Start time execution counter
		long startTime = System.nanoTime();
		
		switch (algorithm) {
			case "Bubble Sort"    -> bubbleSorter.bubbleSort(clonned);
			case "Insertion Sort" -> insertionSorter.insertionSort(clonned);
			case "Selection Sort" -> selectionSorter.selectionSort(clonned);
			case "Quick Sort"     -> quickSorter.quickSort(clonned, 0, clonned.length - 1);
			case "Counting Sort"  -> countingSorter.countingSort(clonned);
			default -> throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
		}
		
		long endTime = System.nanoTime();
		double timeElapsed = (endTime - startTime) / 1000000.0;
		return timeElapsed;
	}
}
