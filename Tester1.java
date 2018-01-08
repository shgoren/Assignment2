
import java.util.Arrays;
import java.util.Random;

public class Tester1 {

	public static void main(String[] args) {
		int size = 15; //THIS IS THE HEAP's SIZE - CAN BE CHANGED
		int max_Size = 20; //THIS IS THE HEAP's max_SIZE - CAN BE CHANGED
		int d = 3; //THIS IS THE HEAP's d_field - CAN BE CHANGED
		int[] numArray = new int[size];
		Random randomGenerator = new Random(2);
		for (int i=0; i<15; i++) {
			numArray[i] = randomGenerator.nextInt(100);
		}
		System.out.println("numArray is: " + Arrays.toString(numArray));
		DHeap heap = new DHeap(d, max_Size);
		DHeap_Item[] itemArray = DHeap.intArraytoItemsArray(numArray);
		System.out.println("itemArray is: " + Arrays.toString(itemArray));
		System.out.println("*********** CHECK ArrayToHeap + isHeap() ***********");
		int cnt = heap.arrayToHeap(itemArray);
		System.out.println("cnt is: " + cnt);
		System.out.println("is 'heap' a legal DHeap? " + heap.isHeap());
		System.out.println("heap size is: " + heap.getSize() + " (this should be: " + size + ")");
		System.out.println("This is the heap: ");
		System.out.println(Arrays.toString(heap.getArray()));
		/*
		System.out.println("*********** CHECK DELETE_MIN() ***********");
		System.out.println(heap.Get_Min().toString());
		cnt = heap.Delete_Min();
		System.out.println("cnt is: " + cnt);
		System.out.println("is 'heap' a legal DHeap? " + heap.isHeap());
		System.out.println("heap size is: " + heap.getSize() + " (this should be: " + --size + ")");
		System.out.println("new Heap is: " + Arrays.toString(heap.getArray()));
		*/
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
	}

}
