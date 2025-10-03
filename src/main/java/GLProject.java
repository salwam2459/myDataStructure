/* ----------------------------------------------
 * Author: Salwa A. Majeed
 * NetID: smaje4
 * Email: smaje4@uic.edu
 * CS 342 Project 1 Overview: Implementation of a custom data structure library including
 * GenericQueue (FIFO linked list) and MyHashMap (hash table with collision resolution)
 * using separate chaining. Includes iterator design pattern for traversal.
 ------------------------------------------------*/


public class GLProject {

	public static void main(String[] args) {
			System.out.println("Welcome to Project 1!");
			
			// GenericQueue Demo
	        System.out.println("\n=== GenericQueue Demo ===");
	        GenericQueue<Integer> myQueue = new GenericQueue<>(77);
	        System.out.println("Initial queue:");
	        myQueue.print();
	        
	        Integer[] arr = {61, 24, 17, 45, 53};
	        for (int i = 0; i < 5; i++) {
	            myQueue.add(arr[i]);
	        }
	        System.out.println("After adding elements:");
	        myQueue.print();
	        
	        // Test FIFO behavior
	        System.out.println("Dequeue test (FIFO): " + myQueue.dequeue()); // Should be 69
	        System.out.println("Queue after dequeue:");
	        myQueue.print();
	        
	        // Test forEach loop
	        System.out.print("forEach loop: ");
	        for (Integer item : myQueue) {
	            System.out.print(item + " ");
	        }
	        System.out.println();
	        
	        // MyHashMap Demo  
	        System.out.println("\n=== MyHashMap Demo ===");
	        MyHashMap<String> myMap = new MyHashMap<>("key1", "value1");
	        myMap.put("key2", "value2");
	        myMap.put("key3", "value3");
	        
	        System.out.println("HashMap size: " + myMap.size());
	        System.out.println("Get key1: " + myMap.get("key1"));
	        System.out.println("Contains key2: " + myMap.contains("key2"));
	        
	        // Test HashMap forEach
	        System.out.print("HashMap values: ");
	        for (String value : myMap) {
	            System.out.print(value + " ");
	        }
	        System.out.println();
	        
	        System.out.println("\nProject 1 complete!");
	        /*
	        // Run test suites
	        System.out.println("\n\n========================================");
	        System.out.println("Running Test Suites");
	        System.out.println("========================================");
	        
	        GQTest.main(args);
	        
	        System.out.println("\n");
	        
	        HMTest.main(args);
	        */
		}
		
	}