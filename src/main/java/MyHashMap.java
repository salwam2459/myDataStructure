import java.util.ArrayList;
import java.util.Iterator;

/**
* Custom HashMap implementation using ArrayList of GenericQueues for collision resolution.
* Uses separate chaining to handle hash collisions.
* */
public class MyHashMap<T> implements Iterable<T> {
	//ArrayList of GenericQueues to handle collisions
	private ArrayList<GenericQueue<T>> map;
	private int size = 0; //number of key-value mappings
	
	//constructor, initializes Hashmap with first key-value pair
	public MyHashMap(String key, T value) {
		//initialize ArrayList to size 10 with null values
		map = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			map.add(null);
		}
		put(key, value); //Add the first key-value pair
	}
	public void put(String key, T value) {
		int hashCode = key.hashCode();   //generate hashcode
		int hashValue = hashCode & 9;    //hashcode to array index using bitwise opers.
		GenericQueue<T> queueAtIndx = map.get(hashValue);  //get queue at this index position
		if (queueAtIndx == null) {   //case: no queue exists at this index position
			GenericQueue<T> newQueue = new GenericQueue<>(value); //create a new queue with head=value
			newQueue.getHead().code = hashCode; //set first node's code as the hashcode
			map.set(hashValue, newQueue);  //place this new queue at the calculated index in the map
			size++;  //increment because new pair was added
		} 
		else {   //case: queue already exists 
			boolean keyExists = false;  //flag
			GenericList.Node<T> current = queueAtIndx.getHead();  //start at the head
			
			while (current != null) { // go through each node in list
				if (current.code == hashCode) {  //if matches hashcode
					keyExists = true;  
					current.data = value;  //update its value to value
					break;
				}
				current = current.next;  //check next node
			}
			if (!keyExists) {   
				queueAtIndx.add(value, hashCode);  //add key pair to queue
				size++;  //added a pair
			}
		}
	}
	 /**
     * Checks if the HashMap contains the specified key.
     * */
	public boolean contains(String key) {
		int hashCode = key.hashCode();
		int hashValue = hashCode & 9;
		
		GenericQueue<T> queueAtIndx = map.get(hashValue);
		
		if (queueAtIndx == null) {
			return false;
		}
		//search through the chain for the key
		GenericList.Node<T> current = queueAtIndx.getHead();
		while (current != null) {
			if (current.code == hashCode) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	/**
     * Retrieves the value associated with the specified key.
     * */
	public T get(String key) {
		int hashCode = key.hashCode();
		int hashValue = hashCode & 9;
				
		GenericQueue<T> queueAtIndx = map.get(hashValue);
				
		if (queueAtIndx == null) {
			return null;
		}
		//search through the chain for the key
		GenericList.Node<T> current = queueAtIndx.getHead();
		while (current != null) {
			if(current.code == hashCode) {
				return current.data;
			}
			current = current.next;
		}
		return null;
	}
	
	//Returns the number of key-value mappings in this map.
	public int size() {
		return size;
	}
	
	//Checks if this map contains no key-value mappings.
	public boolean isEmpty() {
		return size == 0;
	}
	
	//Replaces the entry for the specified key only if it is currently mapped to some value.
	public T replace(String key, T value) {
		int hashCode = key.hashCode();
		int hashValue = hashCode & 9;
						
		GenericQueue<T> queueAtIndx = map.get(hashValue);
						
		if (queueAtIndx == null) {
			return null;
		}
		GenericList.Node<T> current = queueAtIndx.getHead();
		while (current != null) {
			if(current.code == hashCode) {
				//key found - replace the value
				T oldValue = current.data;
				current.data = value;
				return oldValue;
			}
			current = current.next;
		}
		return null;
	}
	public ArrayList<GenericQueue<T>> getMap() {
        return map;
    }
	/**
     * Returns an iterator over the values in this HashMap.
     * Required by the Iterable interface. 
     * */
	@Override
    public Iterator<T> iterator() {
        return new HMIterator<T>(this);
    }
}
