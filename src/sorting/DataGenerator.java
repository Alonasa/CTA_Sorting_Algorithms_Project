package sorting;
import java.util.Random;

public class DataGenerator {
	/**
	 * Generates a 3D array of random integer arrays for benchmarking sorting algorithms.
	 * For each size in 'sizes' and for each repetition, generates an array of random ints
	 * in the range [-size, size], with 'size' elements.
	 *
	 * @param sizes Array of sizes for each test case.
	 * @param  repetitions Number of random arrays to generate per size.
	 * @return 3D array: testData[sizeIndex][repetitionIndex][arrayElements].
	 */
	
	public int[][][] testData(int[] sizes, int repetitions){
		int datasetLength = sizes.length;
		int[][][] dataForSorting = new int[datasetLength][repetitions][]; 
		for(int sizeIdx = 0; sizeIdx < datasetLength; sizeIdx++) {
			for (int repIdx = 0; repIdx < repetitions; repIdx++) {
				// Generate array of random integers to perform algorithm
				int[] array = randomNumbersArrayGenerator(-(sizes[sizeIdx]), sizes[sizeIdx], sizes[sizeIdx]);
				dataForSorting[sizeIdx][repIdx] = array;
			}
		}
		return dataForSorting;
	}
	
	
	private static int[] randomNumbersArrayGenerator(int min, int max, int arrLength) {
		/*
		 * Generate array of random integers in range min-max Source:
		 * https://stackoverflow.com/questions/25768435/how-to-fill-an-array-with-random
		 * -numbers-from-0-to-99-using-the-class-math
		 */
		Random rand = new Random();
		int[] arrayOfRandom = new int[arrLength];

		for (int i = 0; i < arrLength; i++) {
			arrayOfRandom[i] = rand.nextInt(min, (max + 1));
		}

		return arrayOfRandom;
	}
}
