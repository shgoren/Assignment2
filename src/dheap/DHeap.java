package dheap;

import java.util.Arrays;
import java.util.Map;
import dheap.DHeap_Item;

/**
 * D-Heap
 */

public class DHeap
{
	
    private int size, max_size, d;
    private DHeap_Item[] array;

	// Constructor
	// m_d >= 2, m_size > 0
    DHeap(int m_d, int m_size) {
               max_size = m_size;
			   d = m_d;
               array = new DHeap_Item[max_size];
               Arrays.fill(array, null);
               size = 0;
    }
    
    //*****************method for testing only!! delete after done********
    public static DHeap constructTestHeap() {
		DHeap_Item[] heapArr = new DHeap_Item[1000];
		Arrays.fill(heapArr, null);
		DHeap newHeap = new DHeap(3, 1000);
		int numOfItemsToInsert = 42; //4 full levels
		
		for(int i=0; i<numOfItemsToInsert; i++) {
			heapArr[i] = new DHeap_Item(i+"",i);
			heapArr[i].setPos(i);
		}
		newHeap.array = heapArr;
		newHeap.size = numOfItemsToInsert;
	return newHeap;
}

    //*****************method for testing only!! delete after done********
    public DHeap_Item getItem(int i) {
    	return array[i];
    }
    
    
    
	
	/**
	 * public int getSize()
	 * Returns the number of elements in the heap.
	 */
	public int getSize() {
		return size;
	}
	
  /**
     * public int arrayToHeap()
     *
     * The function builds a new heap from the given array.
     * Previous data of the heap should be erased.
     * preconidtion: array1.length() <= max_size
     * postcondition: isHeap()
     * 				  size = array.length()
     * Returns number of comparisons along the function run. 
	 */
	/**
	 * count items in array1
	 * copy items from array1 to the new array
	 * heapify down starting from father of array[size] in the array 
	*/
    public int arrayToHeap(DHeap_Item[] array1) 
    {
        return 0; // just for illustration - should be replaced by student code
    }

    /**
     * public boolean isHeap()
     *
     * The function returns true if and only if the D-ary tree rooted at array[0]
     * satisfies the heap property or has size == 0.
     *   
     */
    // loop over array and check if parent<= this heapItem
    // root has no parent
    public boolean isHeap() 
    {
        return false; // just for illustration - should be replaced by student code
    }


    /**
     * public static int parent(i,d), child(i,k,d)
     * (2 methods)
     *
     * precondition: i >= 0, d >= 2, 1 <= k <= d
     *
     * The methods compute the index of the parent and the k-th child of 
     * vertex i in a complete D-ary tree stored in an array.
     * Note that indices of arrays in Java start from 0.
     */
    // floor(i/d)
    public static int parent(int i, int d) { return i/d;} // just for illustration - should be replaced by student code
    // i*d+k (kids between 1 to d)
    public static int child (int i, int k, int d) { return i*d+k;} // just for illustration - should be replaced by student code 

    /**
    * public int Insert(DHeap_Item item)
    * 
	* Inserts the given item to the heap.
	* Returns number of comparisons during the insertion.
	*
    * precondition: item != null
    *               isHeap()
    *               size < max_size
    * 
    * postcondition: isHeap()
    */
    // insert in place array[size]
    // set item.pos
    // heapifyUp(item)
    // return number of comp
    public int Insert(DHeap_Item item) 
    {        
    	return 0;// should be replaced by student code
    }

 /**
    * public int Delete_Min()
    *
	* Deletes the minimum item in the heap.
	* Returns the number of comparisons made during the deletion.
    * 
	* precondition: size > 0
    *               isHeap()
    * 
    * postcondition: isHeap()
    */
    // delete(array[0])
    public int Delete_Min()
    {
     	return 0;// should be replaced by student code
    }


    /**
     * public DHeap_Item Get_Min()
     *
	 * Returns the minimum item in the heap.
	 *
     * precondition: heapsize > 0
     *               isHeap()
     *		size > 0
     * 
     * postcondition: isHeap()
     */
    // return array[0]
    public DHeap_Item Get_Min()
    {
    	return array[0];// should be replaced by student code
    }
	
  /**
     * public int Decrease_Key(DHeap_Item item, int delta)
     *
	 * Decerases the key of the given item by delta.
	 * Returns number of comparisons made as a result of the decrease.
	 *
     * precondition: item.pos < size;
     *               item != null
     *               isHeap()
     * 
     * postcondition: isHeap()
     */
    // set key
    // heapifyUp(item)
    public int Decrease_Key(DHeap_Item item, int delta)
    {
	return 0;// should be replaced by student code
    }
	
	  /**
     * public int Delete(DHeap_Item item)
     *
	 * Deletes the given item from the heap.
	 * Returns number of comparisons during the deletion.
	 *
     * precondition: item.pos < size;
     *               item != null
     *               isHeap()
     * 
     * postcondition: isHeap()
     */
    // switch between item and array[size]
    // nullify array[size]
    // set pos in deleted item to -1 (for safety)
    // size--
    // heapifyDown(newItem)
    public int Delete(DHeap_Item item)
    {
	return 0;// should be replaced by student code
    }
	
	/**
	* Sort the input array using heap-sort (build a heap, and 
	* perform n times: get-min, del-min).
	* Sorting should be done using the DHeap, name of the items is irrelevant.
	* 
	* Returns the number of comparisons performed.
	* 
	* postcondition: array1 is sorted 
	*/
    
	public static int DHeapSort(int[] array1, int d) {
		return 0;
	}
	
	/**
	 * compare with parent (if exists)
	 * if needed switch places
	 * heapifyUp(parent)
	 */
	public int heapifyUp(DHeap_Item item) {
		
		return 0;
	}

	/**
	 * getMinSon(item)
	 * if needed switch places
	 * heapifyDown(minSon)
	 */
	public int heapifyDown(DHeap_Item item) {
		return 0;
	}

	/**
	 * switch place in array and set pos accordingly
	 */
	public void switchItems(DHeap_Item item1, DHeap_Item item2) {
		
	}

	/**
	 * loop over sons to find minimal using getItemChild(dad,k)
	 * makes d comparisons
	 */
	public DHeap_Item getMinSon(DHeap_Item dad) {
		DHeap_Item son = getItemChild(dad,1),
				   minSon = son;
		for (int i=2; i<=d; i++) {
			son = getItemChild(dad ,i);
				if(son != null && minSon != null)
					if(son.getKey() < minSon.getKey())
						minSon = son;
		}
		return minSon;
	}

	/**
	 * use item pos and d of array with child(i,k,d)
	 * return the appropriate item
	 * return null if out of bounds
	 */
	public DHeap_Item getItemChild(DHeap_Item item, int k) {
		if(child(item.getPos(),k,d) > max_size)
			return null;
		return array[child(item.getPos(),k,d)];
	}

	/**
	 * use item pos and d of array with parent(i,d)
	 * return the appropriate item
	 */
	public DHeap_Item getItemParent(DHeap_Item item) {
		if(item.getPos() == 0)
			return null;
		return array[parent(item.getPos(),d)];
	}
}
