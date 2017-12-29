package test;

import dheap.DHeap_Item;
import dheap.DHeap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DHeap heap = DHeap.constructTestHeap();
		DHeap_Item item = heap.Get_Min();
		
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
		
		
	}

}
