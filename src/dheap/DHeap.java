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
    public DHeap(int m_d, int m_size) {
               max_size = m_size;
			   d = m_d;
               array = new DHeap_Item[max_size];
               Arrays.fill(array, null);
               size = 0;
    }
    
    public DHeap_Item[] getArray() {
    	return this.array;
    }
    
    public DHeap_Item getItem(int i) {
    	return array[i];
    }
    
    public String toString(){
    	String ans = "";
    	for(DHeap_Item item : this.array) {
    		if(item==null)
    			ans+="x ";
    		else {
    			ans=ans+item.getKey()+" ";
    		}
    	}
    	return ans;
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
	 * heapify down starting from father of array[size-1] in the array 
	 * assumptions - array1 has no nulls (size = array1.length). don't know if maxSize should be changed if.
	*/
    public int arrayToHeap(DHeap_Item[] array1) {
    	int ans = 0,
    		newSize = 0;
    	
    	Arrays.fill(this.array, null);
    	for(int i=0;i<array1.length;i++) {
    		if(array1[i]==null)
    			continue;
    		this.array[newSize] = array1[i];
    		array[i].setPos(newSize);
    		newSize++;
    	}
    	this.size = newSize;
    	
    	DHeap_Item startingItem = getItemParent(this.getItem(size-1));
    	int i = startingItem.getPos();
    	while(i>=0) {
    		ans+= heapifyDown(this.getItem(i));
    		i--;
    	}
    	
    	
        return ans; 
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
    public boolean isHeap() {
    	boolean passedFirstNullNode = false;
    	if(this.size<2)
    		return true;
    	for(int i=1;i<this.size;i++) {
    		DHeap_Item curr = this.getItem(i);
    		DHeap_Item currDad = getItemParent(curr);
    		if(curr.getKey()<currDad.getKey()) {
    			return false;
    		}
    		// check if the heap has holes
    		if(passedFirstNullNode && curr!=null)
    			return false;
    		passedFirstNullNode = curr == null;
    		
    		
    	}
        return true; 
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
    public static int parent(int i, int d) {
    	if(i==0)
    		return 0;
    	return (i-1)/d;
    	} 
    public static int child (int i, int k, int d) { return i*d+k;} 
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
    public int Insert(DHeap_Item item)  { 
    	this.array[this.size]=item;
    	item.setPos(size);
    	this.size++;
    	return heapifyUp(item);
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
    public int Delete_Min()   {
    	return Delete(this.Get_Min());
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
    public int Decrease_Key(DHeap_Item item, int delta)    {
    	int newKey = item.getKey() - delta;
    	item.setKey(newKey);
	return heapifyUp(item);
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
    public int Delete(DHeap_Item item)  {
    	int pos = item.getPos(),
    		ans = 0;
    	if(array[pos] == null)
    		System.out.println();
    	switchItems(item,array[size-1]);
    	remove(array[size-1]);
    	this.size--;
    	if (size != 0)
    		ans += heapifyDown(array[pos]);
	return ans;
    }
    
    public void remove(DHeap_Item item) {
    	int pos = item.getPos();
    	this.array[pos]=null;
    	item.setPos(-1);
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
		DHeap heap = new DHeap(d, array1.length);
		int i =0;
		int counter = 0;
		counter += heap.arrayToHeap(convertIntArrayToItemsArray(array1));
		while(heap.Get_Min() != null) {
			array1[i] = heap.Get_Min().getKey();
			counter += heap.Delete_Min();
			i++;
		}
		
		return counter;
	}
	
	public static DHeap_Item[] convertIntArrayToItemsArray(int[] intArray) {
		DHeap_Item[] itemsArray = new DHeap_Item[intArray.length];
		for (int i=0; i<intArray.length; i++) {
			DHeap_Item item = new DHeap_Item("", intArray[i]);
			itemsArray[i] = item;
		}
		return itemsArray;
	}

	/**
	 * compare with parent (if exists)
	 * if needed switch places
	 * heapifyUp(parent)
	 */
	public int heapifyUp(DHeap_Item item) {
		DHeap_Item parent = getItemParent(item);
		int cnt = 1;
		while(item.getPos()!=0 && item.getKey()<parent.getKey()) {
			switchItems(item,parent);
			parent = getItemParent(item);
			cnt++;
		}
		return cnt;
	}

	/**
	 * getMinSon(item)
	 * if needed switch places
	 * heapifyDown(minSon)
	 */
	public int heapifyDown(DHeap_Item item) {
		DHeap_Item minSon = (DHeap_Item)getMinSon(item)[0];
		int cnt = (Integer)getMinSon(item)[1]+1;
		while(minSon!=null && item.getKey()>minSon.getKey()) {
			switchItems(item,minSon);
			minSon = (DHeap_Item)getMinSon(item)[0];
			if(minSon!=null)
				cnt+= (Integer)getMinSon(item)[1] +1;
		}
		return cnt;
	}

	/**
	 * switch place in array and set pos accordingly
	 */
	public void switchItems(DHeap_Item item1, DHeap_Item item2) {
		int origPosItem1 = item1.getPos(),
			origPosItem2 = item2.getPos();
		setPosition(item1, origPosItem2);
		setPosition(item2, origPosItem1);	
	}
	
	private void setPosition(DHeap_Item item, int newPos) {
		array[newPos] = item;
		item.setPos(newPos);
	}

	/**
	 * loop over sons to find minimal using getItemChild(dad,k)
	 * makes d comparisons
	 */
	public Object[] getMinSon(DHeap_Item dad) {
		DHeap_Item son = getItemChild(dad,1),
				   minSon = son;
		int counter = 0;
		Object[] retTuple = new Object[2];
		for (int i=2; i<=d; i++) {
			son = getItemChild(dad ,i);
				if(son != null && minSon != null) {
					counter++;
					if(son.getKey() < minSon.getKey())
						minSon = son;
				}
		}
		retTuple[0] = minSon;
		retTuple[1] = counter;
		return retTuple;
	}

	/**
	 * use item pos and d of array with child(i,k,d)
	 * return the appropriate item
	 * return null if out of bounds
	 */
	public DHeap_Item getItemChild(DHeap_Item item, int k) {
		if(child(item.getPos(),k,d) >= max_size)
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
