import java.util.ArrayList;
import java.util.Iterator;

/**
 * Generic abstract class that serves as the base for linked list data structures.
 * Implements Iterable interface to support enhanced for-loops.
 * */
public abstract class GenericList<T> implements Iterable<T> {
		private Node<T> head;
		private int length;
				
		//Node class
		public static class Node<T> {
			T data;
			int code;
			Node<T>next;
					
			//Node constructor with data only
			public Node(T data) {
				this.data = data;
				this.code = 0;
				this.next = null;
			}
					
			//Node constructor with data and code
			public Node(T data, int code) {
				this.data = data;
				this.code = code;
				this.next = null;
			}
		}
		public Iterator<T> descendingIterator() {
			    return new ReverseGLLIterator<T>(this);
		}
				
		public Iterator<T> iterator() {
			    return new GLLIterator<T>(this);
		}
				
		public void print() {
			//check if list is empty -> "Empty List"
			if (length == 0) {
				System.out.println("Empty List");
				return;
			}
			// print list
			Node<T> current = head;
			while (current != null) {
				System.out.println(current.data);
				current = current.next;
			}
					
		}
		public abstract void add(T data);
				
		public abstract T delete();
				
		//stores and returns all values currently in the list into an ArrayList
		public ArrayList<T>dumpList() {
			ArrayList result = new ArrayList();
			Node<T> current = head;
					
			while (current != null) {
				result.add(current.data);
				current = current.next;
			}
			return result;
					
		}
		// returns the value at specified index, index out of bounds -> return null
		public T get(int index) {
			if (index < 0 || index >= length) {
				return null;
			}
			Node<T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.data;
		}
		// replaces the element at the specified position with the specified element.
		public T set(int index, T element) {
			if (index < 0 || index >= length) {
				return null;
			}
			Node<T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
					
			T oldData = current.data;
			current.data = element;
			return oldData;
					
		}
		// getters/setters
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
		public Node<T> getHead() {
			return head;
		}
		public void setHead(Node<T> head) {
			this.head = head;
		}
}
