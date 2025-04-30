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
		//, "Quick Sort", "Counting Sort"
        String[] algos = {"Bubble Sort", "Selection Sort", "Insertion Sort"};
        
        int repetition = 10;
        double[][] results = new double[algos.length][sizes.length];
        
        //Call benchmark on each element of the sizes
        for(int i = 0; i < algos.length; i++) {
        	for(int j = 0; j < sizes.length; j++) {
        		double sum = 0;
        		
        		for (int n = 0; n < repetition; n++) {
        			//Generate array of random integers to perform algorithm
            		int [] array = randomNumbersArrayGenerator(-(sizes[j]), sizes[j], sizes[j]);
            		sum += algorithmBenchmark(array, algos[i]);
        		}
        		
        		//Save result of 10 repetition of algorithm benchmark in the element of array
        		results[i][j] = sum / repetition;    		
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
			case "Bubble Sort":
				bubbleSort(clonned);
				break;
			case "Insertion Sort":
				insertionSort(clonned);
				break;
			case "Selection Sort":
				selectionSort(clonned);
				break;
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