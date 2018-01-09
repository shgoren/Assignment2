package test;

import java.util.Arrays;
import java.util.Random;

import dheap.DHeap;
import dheap.DHeap_Item;

public class Test {

	public static void main(String[] args) {
		/**
		 * 
		DHeap heap = DHeap.constructBadHeap();
		DHeap heap2 = DHeap.constructTestHeap();
		int[] badArr = new int[20];
		Random rnd = new Random();
		System.out.println(heap.toString());
		System.out.println(heap.getItemParent(heap.getItem(heap.getSize()-1)).getKey());
		System.out.println(heap.isHeap());
		heap2.arrayToHeap(heap.getArray());
		System.out.println(heap2.toString());
		System.out.println(heap2.isHeap());
		
		for(int i=0; i<20; i++)
			badArr[i] = rnd.nextInt(100);
		
		DHeap.DHeapSort(badArr, 4);
		System.out.println(Arrays.toString(badArr));
		
		
		 */
		
		/**DHeap_Item item = heap.Get_Min();
		System.out.println(heap.Delete_Min());
		heap.Delete(heap.getItem(7));
		heap.Insert(new DHeap_Item("a",7));
		System.out.println(heap.toString());
		heap.isHeap();
		heap.getItem(8).setKey(200);
		heap.isHeap();
		heap.Decrease_Key(heap.getItem(8),200);
		
		heap.Insert(new DHeap_Item("a",0));
		heap.Insert(new DHeap_Item("a",0));
		heap.Insert(new DHeap_Item("a",0));
		System.out.println(heap.toString());
		System.out.println(heap.isHeap());
		
		
		
		/** check get item child and parent
		 * 
		System.out.println(item);
		System.out.println(heap.getItemParent(item));
		System.out.println(heap.getItemChild(item, 1));
		System.out.println(heap.getItemChild(item, 3));
		item = heap.getItem(15);
		System.out.println(heap.getItemParent(item));
		System.out.println(heap.getItemChild(item, 1));
		System.out.println(heap.getItemChild(item, 2));
		System.out.println(heap.getItemChild(item, 3));
		*/
		
		/**
		 * check get minimal son
		 *
		System.out.println(heap.getMinSon(item));
		item = heap.getItem(15);
		System.out.println(heap.getMinSon(item));
		item = heap.getItem(13);
		System.out.println(heap.getMinSon(item));
		System.out.println(heap.getItemChild(item, 3));
		*/
		
		
		int size = 15; //THIS IS THE HEAP's SIZE - CAN BE CHANGED
		int max_Size = 20; //THIS IS THE HEAP's max_SIZE - CAN BE CHANGED
		int d = 3; //THIS IS THE HEAP's d_field - CAN BE CHANGED
		int[] numArray = createIntArray(15);
		System.out.println("numArray is: " + Arrays.toString(numArray));
		DHeap heap = new DHeap(d, max_Size);
		DHeap_Item[] itemArray = DHeap.convertIntArrayToItemsArray(numArray);
		System.out.println("itemArray is: " + Arrays.toString(itemArray));
		System.out.println("*********** CHECK ArrayToHeap + isHeap() ***********");
		int cnt = heap.arrayToHeap(itemArray);
		System.out.println("cnt is: " + cnt);
		System.out.println("is 'heap' a legal DHeap? " + heap.isHeap());
		System.out.println("heap size is: " + heap.getSize() + " (this should be: " + size + ")");
		System.out.println("This is the heap: ");
		System.out.println(Arrays.toString(heap.getArray()));
	
		System.out.println("*********** CHECK DELETE_MIN() ***********");
		System.out.println(heap.Get_Min().toString());
		cnt = heap.Delete_Min();
		System.out.println("cnt is: " + cnt);
		System.out.println("is 'heap' a legal DHeap? " + heap.isHeap());
		System.out.println("heap size is: " + heap.getSize() + " (this should be: " + --size + ")");
		System.out.println("new Heap is: " + Arrays.toString(heap.getArray()));
		
		

		System.out.println("\n-----------------------------------tests---------------\n");
		System.out.println("*********** CHECK HeapSort ***********");
		cnt = DHeap.DHeapSort(numArray, d);
		System.out.println("cnt is: " + cnt);
		System.out.println("numArray is: " + Arrays.toString(numArray));
		System.out.println("*********** CHECK INSERT(7) ***********");
		DHeap_Item item7 = new DHeap_Item(null, 7);
		cnt = heap.Insert(item7);
		System.out.println("cnt is: " + cnt);
		System.out.println("is 'heap' a legal DHeap? " + heap.isHeap());
		System.out.println("heap size is: " + heap.getSize() + " (this should be: " + ++size + ")");
		System.out.println("new Heap is: " + Arrays.toString(heap.getArray()));
		System.out.println("*********** CHECK Delete(19) ***********");
		DHeap_Item item19 = heap.getArray()[2];
		System.out.println("item19: " + item19);
		cnt = heap.Delete(item19);
		System.out.println("cnt is: " + cnt);
		System.out.println("is 'heap' a legal DHeap? " + heap.isHeap());
		System.out.println("heap size is: " + heap.getSize() + " (this should be: " + --size + ")");
		System.out.println("new Heap is: " + Arrays.toString(heap.getArray()));
		System.out.println("*********** CHECK Delete(67) ***********");
		DHeap_Item item67 = heap.getArray()[12];
		cnt = heap.Delete(item67);
		System.out.println("cnt is: " + cnt);
		System.out.println("is 'heap' a legal DHeap? " + heap.isHeap());
		System.out.println("heap size is: " + heap.getSize() + " (this should be: " + --size + ")");
		System.out.println("new Heap is: " + Arrays.toString(heap.getArray()));
		System.out.println("*********** CHECK Decrese_Key(89 becomes 5) ***********");
		DHeap_Item item89 = heap.getArray()[heap.getSize() -1];
		System.out.println("item89: " + item89);
		cnt = heap.Decrease_Key(item89, 84);
		System.out.println("cnt is: " + cnt);
		System.out.println("is 'heap' a legal DHeap? " + heap.isHeap());
		System.out.println("heap size is: " + heap.getSize() + " (this should be: " + size + ")");
		System.out.println("new Heap is: " + Arrays.toString(heap.getArray()));
		
		
		System.out.println("\n-----------------------------------measurments---------------\n");
		int count = 0;
		
		for(int m =1000; m<=100000; m=m*10) {
			for(d =2; d<5; d++) {
				count = 0;
				for(int i=0; i<10; i++) {
					count += makeMeasures(d, m);
				}
				System.out.println("**********  D = "+d+" ; M = "+m+" **********");
				System.out.println("counter is: " + count/10);
				System.out.println("****************************************");
			}
		}
		int[] deltas = {1,100,1000};
		
		for(int x : deltas) {
			for(d =2; d<5; d++) {
				count = 0;
				for(int i=0; i<10; i++) {
					count += makeMeasures2(d, x);
				}
				System.out.println("**********  D = "+d+" ; X = "+x+" **********");
				System.out.println("counter is: " + count/10);
				System.out.println("****************************************");
			}
		}
		
	}
		
	public static int makeMeasures(int d, int m) {
		int counter = 0;
		DHeap heap = new DHeap(d, m);
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
		heap.arrayToHeap(DHeap.convertIntArrayToItemsArray(intArray1));
		counter = DHeap.DHeapSort(intArray1, d);
		return counter;
	}

		
		public static int[] createIntArray(int m) {
			//m is the size of the array; m = {1000, 10000, 100000}
			int[] result = new int[m];
			Random randomGenerator = new Random();
			for (int i=0; i<m; i++) {result[i] = randomGenerator.nextInt(1000);}
			return result;
		}
	
		public static int makeMeasures2(int d, int x) {
			int counter = 0;
			DHeap heap = new DHeap(d, 100000);
			DHeap_Item[] itemArray1 = new DHeap_Item[100000];
			Random randomGenerator = new Random();
			DHeap_Item newItem;
			
			for (int i=0; i<100000; i++) {
				int tmp = randomGenerator.nextInt(1000);
				newItem = new DHeap_Item("", tmp);
				heap.Insert(newItem);
				itemArray1[i] = newItem;
			}
			
			for (int i=0; i<100000; i++)
				counter += heap.Decrease_Key(itemArray1[i], x);
			
			return counter;
		}
		

}
