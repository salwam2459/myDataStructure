import java.util.Iterator;
import java.util.ArrayList;

/**
 * Iterator class for traversing MyHashMap values.
 * This implementation collects all values into a list first, then iterates through them.
 * */
public class HMIterator<T> implements Iterator<T>{
	
	//list containing all values from the HashMap
	private ArrayList<T> allValues;
	private int currentIndex;
	//private GenericList.Node<T> currentNode;
	
	//constructor that collects all values from the HashMap into a list.
	public HMIterator(MyHashMap<T> hashMap) {
		allValues = new ArrayList<>();
		currentIndex = 0;
		
		//get reference to hashmap's internal structure
		ArrayList<GenericQueue<T>> map = hashMap.getMap();
		//iterate thru each bucket
		for (int bucketIndex = 0; bucketIndex < map.size(); bucketIndex++) {
			//get queue
			GenericQueue<T> queue = map.get(bucketIndex);
			
			//skip empty buckets
			if (queue == null) {
				continue;
			}
			//traverse the entire chain at this bucket
			GenericList.Node<T> current = queue.getHead();
			while (current != null) {
				allValues.add(current.data);  //add this node's value to list
				current = current.next;
			}
		}
			
	}
	@Override 
	public boolean hasNext() {
		//Check if current index is within bounds of our collected values
		return currentIndex < allValues.size();
	}
	
	@Override
	public T next() {
		// Get the value at current index and increment the index
		T value = allValues.get(currentIndex);
		currentIndex++;
		
		return value;
	}
	
}
