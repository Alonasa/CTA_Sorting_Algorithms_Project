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
		int[] sizes = {10, 100, 250, 1000, 2500, 3500, 5000, 7000, 10000, 20000};
        String[] algos = {"Bubble Sort", "Selection Sort", "Insertion Sort", "Quick Sort", "Counting Sort"};
        
        //Generate array of random integers to perform algorithm
        int [] array = randomNumbersArrayGenerator(-(sizes[sizes.length - 1]), sizes[sizes.length - 1], sizes[0]);
        
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
		System.out.println("Hello Algorithms");
	}
	
	
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
            if (!swapped)
                break;
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