package test;

import dheap.DHeap;
import dheap.DHeap_Item;

public class Test {

	public static void main(String[] args) {
		DHeap heap = DHeap.constructBadHeap();
		System.out.println(heap.toString());
		System.out.println(heap.getItemParent(heap.getItem(heap.getSize()-1)).getKey());
		heap.isHeap();
		heap.arrayToHeap(heap.getArray());
		System.out.println(heap.toString());
		heap.isHeap();
		
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
		
		
	}

}
