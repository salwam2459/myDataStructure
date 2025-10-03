import java.util.ArrayList;
import java.util.Iterator;
/**
 * Iterator class for traversing GenericList from tail to head (reverse direction).
 * Implements the Iterator interface to provide reverse iteration functionality.
 * */

public class ReverseGLLIterator<T> implements Iterator<T>{
	//ArrayList to store elements in reverse order
	private ArrayList<T> reverseList;
	private int currentIndex;
		
	//constructor that builds a reverse list from the GenericList.
	public ReverseGLLIterator(GenericList<T> list) {
		reverseList = new ArrayList<>();
		
		//Traverse the linked list from head to tail and collect all elements
		GenericList.Node<T> current = list.getHead();
		while (current != null) {
			reverseList.add(current.data);
			current = current.next;
		}
		//Start from last element
		currentIndex = reverseList.size() - 1;
	}
	@Override
	public boolean hasNext() {
		// There's a next element if currentIndex is valid (>= 0)
		return currentIndex >= 0;
	}
	@Override
	public T next() {
		T data = reverseList.get(currentIndex); // Get the element at the current index
		currentIndex--; // Move to the previous index (going backwards)
		return data;
	}
}
