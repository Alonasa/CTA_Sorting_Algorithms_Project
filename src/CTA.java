/*Sorting Algorithms
1. Bubble Sort
2. Selection Sort
3. Insertion Sort
4. An efficient comparison-based sort as Quick Sort
5. A non-comparison sort as Counting Sort
*/
import java.util.Arrays;
import java.util.Random;

class CTA {
	public static void main (String[] args) {
		//Lets define initial data for expecting output. 10 sizes and sorting algorithms names
		int[] sizes = {10, 100, 250, 1000, 2000, 2500, 2000, 5000, 7000, 10000};
		//, "Quick Sort", "Counting Sort"
        String[] algos = {"Bubble Sort", "Selection Sort", "Insertion Sort"};
        
        //Generate array of random integers to perform algorithm
        
        double[][] results = new double[algos.length][sizes.length];
        
        
        for(int i = 0; i < algos.length; i++) {
        	System.out.println(algos[i]);
        	for(int j = 0; j < sizes.length; j++) {
        		int [] array = randomNumbersArrayGenerator(-(sizes[j]), sizes[j], sizes[j]);
        		results[i][j] = algorithmBenchmark(array, algos[i]);    		
        	}
        }
        
        for (int al = 0; al < algos.length; al++) {
            System.out.printf("%-16s", algos[al]);
        	for (int si = 0; si < sizes.length; si++) {
        		System.out.printf("%10.3f", results[al][si]);
        	}
        	System.out.println();
        }
       
        	
	}
	
	
	
	//Algorithm benchmarking, switch between algorithms and count time of the execution
	public static double algorithmBenchmark(int[] arr, String algorithm) {
		int[] clonned = copyArr(arr);
		long startTime = System.nanoTime();
		switch(algorithm) {
			case "Bubble Sort" -> bubbleSort(clonned);
			case "Insertion Sort" -> insertionSort(clonned);
		}
		long endTime = System.nanoTime();
		double timeElapsed = (endTime - startTime) / 1000000.0;
		
		
		System.out.println(Arrays.toString(clonned));


		System.out.println("39 " + Arrays.toString(arr));

		return timeElapsed;
	}
	
	
	//Create copy of initial array to prevent mutation
	public static int[] copyArr(int[] arr) {
		return Arrays.copyOf(arr, arr.length);
	}
	
	//Bubble sort
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
        boolean swapped;
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
            if (!swapped) {
                break;
              }
        }
	}
	
	public static void selectionSort(int[] arr) {
		
	}
	
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			
			while (j >= 0 && key < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			
			arr[j + 1] = key;
		}
	}
	
	public static int[] randomNumbersArrayGenerator(int min, int max, int arrLength) {
		// Generate array of random integers in range min-max
		Random rand = new Random();
		int[] arrayOfRandom = new int[arrLength];
		
		for(int i = 0; i < arrLength; i++) {
            arrayOfRandom[i] = rand.nextInt(min, (max + 1));
		}
		
		return arrayOfRandom;
	}
}