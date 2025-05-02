package sorting;
import java.util.Arrays;

/*
 * Algorithm benchmarking, switch between algorithms and count time of the
 * execution
 * Source: https://vlegalwaymayo.atu.ie/mod/url/view.php?id=1136860
 */

public class Benchmark {
	/*
	 * Create encapsulated instances of certain sorting algorithms classes for
	 * future usage
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
		}
		
		long endTime = System.nanoTime();
		double timeElapsed = (endTime - startTime) / 1000000.0;
		return timeElapsed;
	}
}
