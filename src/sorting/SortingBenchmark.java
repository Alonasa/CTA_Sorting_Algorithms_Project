package sorting;
import java.util.Random;

/*Sorting Algorithms
1. Bubble Sort
2. Selection Sort
3. Insertion Sort
4. An efficient comparison-based sort as Quick Sort
5. A non-comparison sort as Counting Sort
*/

class SortingBenchmark {	
	public static void main(String[] args) {
		/*
		 * Lets define initial data for expecting output. 10 sizes and sorting
		 * algorithms names
		 */
		int[] sizes = { 100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000 };
		String[] algos = { "Bubble Sort", "Selection Sort", "Insertion Sort", "Quick Sort", "Counting Sort" };
		double[][] results = new double[algos.length][sizes.length];
		final Benchmark benchmark = new Benchmark();
		

		// Call benchmark on each element of the sizes
		for (int i = 0; i < algos.length; i++) {
			for (int j = 0; j < sizes.length; j++) {
				double sum = 0;
				int repetitions = 10;

				// Run algorithm for each of sizes n times
				for (int n = 0; n < repetitions; n++) {
					// Generate array of random integers to perform algorithm
					int[] array = randomNumbersArrayGenerator(-(sizes[j]), sizes[j], sizes[j]);
					sum += benchmark.algorithmsBenchmark(array, algos[i]);
				}

				// Save result of 10 repetition of algorithm benchmark in the element of array
				results[i][j] = sum / repetitions;
			}
		}

		// Print header
		System.out.printf("%-16s", "Size");
		for (int size : sizes) {
			System.out.printf("%10d", size);
		}
		System.out.println();

		// Print results of algorithm performance on the benchmark test
		for (int al = 0; al < algos.length; al++) {
			System.out.printf("%-16s", algos[al]);
			for (int si = 0; si < sizes.length; si++) {
				System.out.printf("%10.3f", results[al][si]);
			}
			System.out.println();
		}
	}

	
	private static int[] randomNumbersArrayGenerator(int min, int max, int arrLength) {
		// Generate array of random integers in range min-max
		Random rand = new Random();
		int[] arrayOfRandom = new int[arrLength];

		for (int i = 0; i < arrLength; i++) {
			arrayOfRandom[i] = rand.nextInt(min, (max + 1));
		}

		return arrayOfRandom;
	}
}