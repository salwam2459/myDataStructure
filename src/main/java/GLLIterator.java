import java.util.Iterator;
/**
 * Iterator class for traversing GenericList from head to tail (forward direction).
 * Implements the Iterator interface to provide standard iteration functionality.
 * */
public class GLLIterator<T> implements Iterator<T>{
	private GenericList.Node<T> current;
	
	//Constructor that initializes the iterator at the head of the list.
	public GLLIterator(GenericList<T> list) {
		this.current = list.getHead();  //start iteration at the head
	}
	public boolean hasNext() {
		return current != null;
	}
	
	public T next() {
		T data = current.data; // Store the current data to return
		current = current.next;
		return data; // Return the data from the previous current node
	}

}
