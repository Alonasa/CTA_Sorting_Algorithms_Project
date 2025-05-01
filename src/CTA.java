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
		int[] sizes = {100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000};
        String[] algos = {"Bubble Sort", "Selection Sort", "Insertion Sort", "Quick Sort", "Counting Sort"};
        
        
        double[][] results = new double[algos.length][sizes.length];
        
        //Call benchmark on each element of the sizes
        for(int i = 0; i < algos.length; i++) {
        	for(int j = 0; j < sizes.length; j++) {
        		double sum = 0;
        		int repetitions = 10;
        		
        		//Run algorithm for each of sizes n times
        		for (int n = 0; n < repetitions; n++) {
        			//Generate array of random integers to perform algorithm
            		int [] array = randomNumbersArrayGenerator(-(sizes[j]), sizes[j], sizes[j]);
            		sum += algorithmBenchmark(array, algos[i]);
        		}
        		
        		//Save result of 10 repetition of algorithm benchmark in the element of array
        		results[i][j] = sum / repetitions;    		
        	}
        }
        
        //Print header
        System.out.printf("%-16s", "Size");
        for (int size : sizes) {
        	System.out.printf("%10d", size);
        }
        System.out.println();
        
        //Print results of algorithm performance on the benchmark test 
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
		//Create copy of initial array to prevent mutation
		int[] clonned = Arrays.copyOf(arr, arr.length);
		//Start time execution counter
		long startTime = System.nanoTime();
		switch(algorithm) {
			case "Bubble Sort" -> bubbleSort(clonned);
				
			case "Insertion Sort" -> insertionSort(clonned);
			
			case "Selection Sort" -> selectionSort(clonned);
			case "Quick Sort" -> quickSort(clonned, 0, clonned.length - 1);
			case "Counting Sort" -> countingSort(clonned);
		}
		long endTime = System.nanoTime();
		double timeElapsed = (endTime - startTime) / 1000000.0;
		return timeElapsed;
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
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < n; j++) {
				if(arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			
			int swap = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = swap;
		}
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
	
	
	public static void quickSort(int[] arr, int min, int max) {
		if(min < max) {
			int iteration = partition(arr, min, max);
			quickSort(arr, min, iteration - 1);
            quickSort(arr, iteration + 1, max);
		}
	}
	
	
	public static void countingSort(int[] arr) {
		if (arr.length == 0) return;

	    // 1. Find min and max to determine the range
	    int min = arr[0];
	    int max = arr[0];
	    for (int value : arr) {
	        if (value < min) min = value;
	        if (value > max) max = value;
	    }

	    // 2. Create count array of the needed size
	    int range = max - min + 1;
	    int[] count = new int[range];

	    // 3. Count occurrences, shifting by -min so negative values work
	    for (int value : arr) {
	        count[value - min]++;
	    }

	    // 4. Write sorted values back into the array
	    int idx = 0;
	    for (int i = 0; i < range; i++) {
	        while (count[i] > 0) {
	            arr[idx++] = i + min;
	            count[i]--;
	        }
	    }
	}
	
	
	//Partitions for the quick sort algorithm, as quick sort assume to call it recursively
	public static int partition(int[] arr, int min, int max) {
		int pivot = arr[max];
		int j = min - 1;
		
		for (int i = min; i < max; i++) {
			if(arr[i] < pivot) {
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