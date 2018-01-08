
import java.util.Arrays;
import java.util.Random;

public class Measuerments1 {

	public static void main(String[] args) {
		System.out.println("**********  D = 2 ; M = 1000  **********");
		System.out.println("counter is: " + makeMeasures(2, 1000));
		System.out.println("****************************************");
		System.out.println("**********  D = 2 ; M = 10000  **********");
		System.out.println("counter is: " + makeMeasures(2, 10000));
		System.out.println("****************************************");
		System.out.println("**********  D = 2 ; M = 100000  **********");
		System.out.println("counter is: " + makeMeasures(2, 100000));
		System.out.println("****************************************");
		System.out.println("**********  D = 3 ; M = 1000  **********");
		System.out.println("counter is: " + makeMeasures(3, 1000));
		System.out.println("****************************************");
		System.out.println("**********  D = 3 ; M = 10000  **********");
		System.out.println("counter is: " + makeMeasures(3, 10000));
		System.out.println("****************************************");
		System.out.println("**********  D = 3 ; M = 100000  **********");
		System.out.println("counter is: " + makeMeasures(3, 100000));
		System.out.println("****************************************");
		System.out.println("**********  D = 4 ; M = 1000  **********");
		System.out.println("counter is: " + makeMeasures(4, 1000));
		System.out.println("****************************************");
		System.out.println("**********  D = 4 ; M = 10000  **********");
		System.out.println("counter is: " + makeMeasures(4, 10000));
		System.out.println("****************************************");
		System.out.println("**********  D = 4 ; M = 100000  **********");
		System.out.println("counter is: " + makeMeasures(4, 100000));
		System.out.println("****************************************");
	}
	
	
	public static int makeMeasures(int d, int m) {
		int counter = 0;
		//DHeap heap = new DHeap(d, m);
		int[] intArray1 = new int[m];
		int[] intArray2 = new int[m];
		Random randomGenerator = new Random();
		for (int i=0; i<m; i++) {
			int tmp = randomGenerator.nextInt(1000);
			intArray1[i] = tmp;
			intArray2[i] = tmp;
		}
		//at this point array1.equals(array2) == true;
		//System.out.println("1 equals 2: " + Arrays.equals(intArray1, intArray1));
		Arrays.sort(intArray2);
		counter = DHeap.DHeapSort(intArray1, d);
		System.out.println("is sorted: " + Arrays.equals(intArray1, intArray1));
		return counter;
	}

	/*
	public static int[] createIntArray(int m) {
		//m is the size of the array; m = {1000, 10000, 100000}
		int[] result = new int[m];
		Random randomGenerator = new Random();
		for (int i=0; i<m; i++) {result[i] = randomGenerator.nextInt(1000);}
		return result;
	}
	
	public static DHeap_Item[] convertIntArrayToItemsArray(int[] intArray) {
		DHeap_Item[] itemsArray = new DHeap_Item[intArray.length];
		for (int i=0; i<intArray.length; i++) {
			DHeap_Item item = new DHeap_Item(null, intArray[i]);
			itemsArray[i] = item;
		}
		return itemsArray;
	}
	*/
}
