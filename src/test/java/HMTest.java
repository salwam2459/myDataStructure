// tests for MyHashMap

import java.util.Iterator;

/**
 * Test class for MyHashMap and HMIterator.
 */
public class HMTest {
    
    public static void main(String[] args) {
        System.out.println("=== MyHashMap Test Suite ===\n");
        
        // Test MyHashMap constructor
        testMyHashMapConstructor();
        
        // Test each MyHashMap method
        testPutMethod();
        testGetMethod();
        testContainsMethod();
        testSizeMethod();
        testIsEmptyMethod();
        testReplaceMethod();
        
        // Test HMIterator
        testHMIterator();
        
        // Test forEach loop
        testForEachLoop();
        
        System.out.println("\n✅ All minimum MyHashMap requirements met!");
    }
    
    /**
     * Test MyHashMap constructor
     */
    private static void testMyHashMapConstructor() {
        System.out.println("Testing MyHashMap constructor...");
        
        MyHashMap<String> map = new MyHashMap<>("testKey", "testValue");
        assert map.size() == 1 : "Constructor size test failed";
        assert !map.isEmpty() : "Constructor isEmpty test failed";
        assert map.contains("testKey") : "Constructor contains test failed";
        assert map.get("testKey").equals("testValue") : "Constructor get test failed";
        System.out.println("✅ MyHashMap constructor test passed");
    }
    
    /**
     * Test put method
     */
    private static void testPutMethod() {
        System.out.println("\nTesting put() method...");
        
        MyHashMap<String> map = new MyHashMap<>("key1", "value1");
        map.put("key2", "value2");
        assert map.size() == 2 : "Put size test failed";
        assert map.get("key2").equals("value2") : "Put retrieval test failed";
        
        // Test update existing key
        map.put("key1", "updatedValue");
        assert map.size() == 2 : "Put update size test failed";
        assert map.get("key1").equals("updatedValue") : "Put update test failed";
        System.out.println("✅ put() method test passed");
    }
    
    /**
     * Test get method
     */
    private static void testGetMethod() {
        System.out.println("\nTesting get() method...");
        
        MyHashMap<String> map = new MyHashMap<>("apple", "fruit");
        map.put("carrot", "vegetable");
        
        assert map.get("apple").equals("fruit") : "Get existing key test failed";
        assert map.get("carrot").equals("vegetable") : "Get second key test failed";
        assert map.get("banana") == null : "Get non-existent key test failed";
        System.out.println("✅ get() method test passed");
    }
    
    /**
     * Test contains method
     */
    private static void testContainsMethod() {
        System.out.println("\nTesting contains() method...");
        
        MyHashMap<String> map = new MyHashMap<>("existingKey", "value");
        map.put("anotherKey", "anotherValue");
        
        assert map.contains("existingKey") : "Contains existing key test failed";
        assert map.contains("anotherKey") : "Contains second key test failed";
        assert !map.contains("nonExistentKey") : "Contains non-existent key test failed";
        System.out.println("✅ contains() method test passed");
    }
    
    /**
     * Test size method
     */
    private static void testSizeMethod() {
        System.out.println("\nTesting size() method...");
        
        MyHashMap<Integer> map = new MyHashMap<>("first", 1);
        assert map.size() == 1 : "Size initial test failed";
        
        map.put("second", 2);
        map.put("third", 3);
        assert map.size() == 3 : "Size after additions test failed";
        
        map.put("first", 10); // Update existing
        assert map.size() == 3 : "Size after update test failed";
        System.out.println("✅ size() method test passed");
    }
    
    /**
     * Test isEmpty method
     */
    private static void testIsEmptyMethod() {
        System.out.println("\nTesting isEmpty() method...");
        
        MyHashMap<String> map = new MyHashMap<>("key", "value");
        assert !map.isEmpty() : "IsEmpty test failed";
        System.out.println("✅ isEmpty() method test passed");
    }
    
    /**
     * Test replace method
     */
    private static void testReplaceMethod() {
        System.out.println("\nTesting replace() method...");
        
        MyHashMap<String> map = new MyHashMap<>("replaceKey", "oldValue");
        
        String oldValue = map.replace("replaceKey", "newValue");
        assert oldValue.equals("oldValue") : "Replace return test failed";
        assert map.get("replaceKey").equals("newValue") : "Replace update test failed";
        
        String nullResult = map.replace("nonExistent", "someValue");
        assert nullResult == null : "Replace non-existent test failed";
        System.out.println("✅ replace() method test passed");
    }
    
    /**
     * Test HMIterator
     */
    private static void testHMIterator() {
        System.out.println("\nTesting HMIterator...");
        
        MyHashMap<String> map = new MyHashMap<>("first", "value1");
        map.put("second", "value2");
        map.put("third", "value3");
        
        Iterator<String> it = map.iterator();
        int count = 0;
        while (it.hasNext()) {
            String value = it.next();
            count++;
            assert value != null : "Iterator returned null value";
        }
        
        assert count == 3 : "Iterator count test failed";
        assert !it.hasNext() : "Iterator hasNext final test failed";
        System.out.println("✅ HMIterator test passed");
    }
    
    /**
     * Test forEach loop implementation
     */
    private static void testForEachLoop() {
        System.out.println("\nTesting forEach loop implementation...");
        
        MyHashMap<Integer> map = new MyHashMap<>("A", 100);
        map.put("B", 200);
        map.put("C", 300);
        
        System.out.print("forEach output: ");
        int count = 0;
        for (Integer value : map) {
            System.out.print(value + " ");
            count++;
        }
        System.out.println();
        
        assert count == 3 : "ForEach loop count test failed";
        System.out.println("✅ forEach loop implementation works");
    }
}