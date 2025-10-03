
public class GenericQueue<T> extends GenericList<T> {
	private Node<T> tail;
	
	public GenericQueue(T data) {
		Node<T> firstNode = new Node<T>(data);
		//set head and tail to point to the first node
		setHead(firstNode);
		this.tail = firstNode;
		
		setLength(1);
	}
	// adds new element to the back of the queue
	public void add(T data) {
		Node<T> newNode = new Node<>(data);
		
		// if queue is empty, then set head and tail to newNode just made
		if (getLength() == 0) {
			setHead(newNode);
			tail = newNode;
		}
		else { //add to the back of the queue
			tail.next = newNode;
			tail = newNode;
		}
		setLength(getLength() + 1);
	}
	//overloaded add method that also sets the code field in the node.
	public void add(T data, int code) {
		Node<T> newNode = new Node<>(data, code);
		
		// if queue is empty, then set head and tail to newNode just made
		if (getLength() == 0) {
			setHead(newNode);
			tail = newNode;
		}
		else { //add to the back of the queue
			tail.next = newNode;
			tail = newNode;
		}
		setLength(getLength() + 1);
	}
	public T delete() {
		// empty
		if (getLength() == 0) {
			return null;
		}
		// retrieve data from head
		T returnData = getHead().data;
		//set head to next node
		setHead(getHead().next);
		//decrement length because of deletion
		setLength(getLength() - 1);
		
		//if empty queue, reset tail to null
		if (getLength() == 0) {
			tail = null;
		}
		return returnData;
	}
	
	//Queue-specific method for adding elements (calls add method).
	public void enqueue (T data) {
		add(data);
	}
	
	//Queue-specific method for removing elements (calls delete method).
	public T dequeue () {
		return delete();
	}
	
	public Node<T> getTail() {
		return tail;
	}
	
	public void setTail(Node<T> tail) {
		this.tail = tail;
	}
	
}
