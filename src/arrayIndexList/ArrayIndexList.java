package arrayIndexList;

import indexList.IndexList;

public class ArrayIndexList<E> implements IndexList<E> {
	private static final int INITCAP = 1; 
	private static final int CAPTOAR = 1; 
	private static final int MAXEMPTYPOS = 2; 
	private E[] element; 
	private int size; 

	public ArrayIndexList() { 
		element = (E[]) new Object[INITCAP]; 
		size = 0; 
	} 
	

	public void add(int index, E e) throws IndexOutOfBoundsException {
		if(index<0 || index>size){
			throw new IndexOutOfBoundsException("index is out of bounds");
		}
		if(size == element.length) {
			changeCapacity(size*CAPTOAR);
		}
		moveDataOnePositionTR(index, size-1);
		element[index] = e;
		// ADD CODE AS REQUESTED BY EXERCISES
		size++;
	}


	public void add(E e) {
		if(size == element.length){
			changeCapacity(size*CAPTOAR);
		}
		element[size] = e;
		size++;
		// ADD CODE AS REQUESTED BY EXERCISES
	}


	public E get(int index) throws IndexOutOfBoundsException {
		if(!(index>=0 && index<size)){
			throw new IndexOutOfBoundsException("index is out of bounds");
		}
		// ADD AND MODIGY CODE AS REQUESTED BY EXERCISES
		return element[index]; 
	}


	public boolean isEmpty() {
		return size == 0;
	}


	public E remove(int index) throws IndexOutOfBoundsException {
		if(!(index>=0 && index<size)){
			throw new IndexOutOfBoundsException("index is out of bounds");
		}
		E etr = element[index];
		moveDataOnePositionTL(index+1,size);
		// ADD AND MODIFY CODE AS REQUESTED BY EXERCISES
		size--;
		/*if(size - element.length > MAXEMPTYPOS) {
			changeCapacity(size*)
		}*/
		return etr;
	}


	public E set(int index, E e) throws IndexOutOfBoundsException {
		if(!(index>=0 && index<size)){
			throw new IndexOutOfBoundsException("index is out of bounds");
		}
		E etr = element[index];
		element[index] = e;
		// ADD AND MODIFY CODE AS REQUESTED BY EXERCISES
		return etr;
	}


	public int size() {
		return size;
	}	
	
	
	
	// private methods  -- YOU CAN NOT MODIFY ANY OF THE FOLLOWING
	// ... ANALYZE AND USE WHEN NEEDED
	
	// you should be able to decide when and how to use
	// following method.... BUT NEED TO USE THEM WHENEVER
	// NEEDED ---- THIS WILL BE TAKEN INTO CONSIDERATION WHEN GRADING
	
	private void changeCapacity(int change) { 
		int newCapacity = element.length + change; 
		E[] newElement = (E[]) new Object[newCapacity]; 
		for (int i=0; i<size; i++) { 
			newElement[i] = element[i]; 
			element[i] = null; 
		} 
		element = newElement; 
	}
	
	// useful when adding a new element with the add
	// with two parameters....
	private void moveDataOnePositionTR(int low, int sup) { 
		// pre: 0 <= low <= sup < (element.length - 1)
		for (int pos = sup; pos >= low; pos--)
			element[pos+1] = element[pos]; 
	}

	// useful when removing an element from the list...
	private void moveDataOnePositionTL(int low, int sup) { 
		// pre: 0 < low <= sup <= (element.length - 1)
		for (int pos = low; pos <= sup; pos++)
			element[pos-1] = element[pos]; 
	}


	// The following two methods are to be implemented as part of an exercise
	public Object[] toArray() {
		Object[] newArray = new Object[size];
		for(int i = 0; i<size;i++) {
			newArray[i] = element[i];
		}
		// TODO es in Exercise 3
		return newArray;
	}


	@Override
	public <T1> T1[] toArray(T1[] array) {
		if(size<array.length) {
			for(int i = 0;i<size;i++) {
				array[i] = (T1) element[i];
			}
			for(int i = size; i<array.length ;i++) {
				array[i] = null;
			}
		}
		// TODO as in Exercise 3
		return array;
	}


	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return element.length;
	}

}
