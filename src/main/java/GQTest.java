import java.util.ArrayList;
import java.util.Iterator;

/**
 * Test class for GenericQueue and its associated iterators.
 */
public class GQTest {
    
    public static void main(String[] args) {
        System.out.println("=== GenericQueue Test Suite ===\n");
        
        // Test constructors (minimum requirement)
        testNodeConstructors();
        testGenericQueueConstructor();
        
        // Test each method
        testEnqueueMethod();
        testDequeueMethod();
        testAddMethod();
        testDeleteMethod();
        testAddWithCodeMethod();
        testPrintMethod();
        testGetMethod();
        testSetMethod();
        testDumpListMethod();
        testGetLengthMethod();
        testDescendingIteratorMethod();
        
        // Test forEach loop
        testForEachLoop();
        
        // Test iterators
        testGLLIterator();
        testReverseGLLIterator();
        
        System.out.println("\n✅ All minimum required tests completed!");
    }
    
    /**
     * Test Node constructors
     */
    private static void testNodeConstructors() {
        System.out.println("Testing Node constructors...");
        
        // Test Node(T data) constructor
        GenericList.Node<String> node1 = new GenericList.Node<>("test");
        assert node1.data.equals("test") : "Node data constructor failed";
        System.out.println("✅ Node(data) constructor test passed");
        
        // Test Node(T data, int code) constructor  
        GenericList.Node<Integer> node2 = new GenericList.Node<>(42, 12345);
        assert node2.data.equals(42) && node2.code == 12345 : "Node(data, code) constructor failed";
        System.out.println("✅ Node(data, code) constructor test passed");
    }
    
    /**
     * Test GenericQueue constructor
     */
    private static void testGenericQueueConstructor() {
        System.out.println("\nTesting GenericQueue constructor...");
        
        GenericQueue<String> queue = new GenericQueue<>("initial");
        assert queue.getLength() == 1 : "Constructor length test failed";
        assert queue.getHead().data.equals("initial") : "Constructor head test failed";
        assert queue.getTail().data.equals("initial") : "Constructor tail test failed";
        System.out.println("✅ GenericQueue constructor test passed");
    }
    
    /**
     * Test enqueue method
     */
    private static void testEnqueueMethod() {
        System.out.println("\nTesting enqueue() method...");
        
        GenericQueue<String> queue = new GenericQueue<>("first");
        queue.enqueue("second");
        assert queue.getLength() == 2 : "Enqueue length test failed";
        assert queue.getTail().data.equals("second") : "Enqueue tail test failed";
        System.out.println("✅ enqueue() method test passed");
    }
    
    /**
     * Test dequeue method
     */
    private static void testDequeueMethod() {
        System.out.println("\nTesting dequeue() method...");
        
        GenericQueue<String> queue = new GenericQueue<>("first");
        queue.enqueue("second");
        String result = queue.dequeue();
        assert result.equals("first") : "Dequeue return test failed";
        assert queue.getLength() == 1 : "Dequeue length test failed";
        System.out.println("✅ dequeue() method test passed");
    }
    
    /**
     * Test add method
     */
    private static void testAddMethod() {
        System.out.println("\nTesting add() method...");
        
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.add(2);
        assert queue.getLength() == 2 : "Add length test failed";
        assert queue.getTail().data.equals(2) : "Add tail test failed";
        System.out.println("✅ add() method test passed");
    }
    
    /**
     * Test delete method (1 test minimum)
     */
    private static void testDeleteMethod() {
        System.out.println("\nTesting delete() method...");
        
        GenericQueue<Integer> queue = new GenericQueue<>(10);
        queue.add(20);
        Integer result = queue.delete();
        assert result.equals(10) : "Delete return test failed";
        assert queue.getLength() == 1 : "Delete length test failed";
        System.out.println("✅ delete() method test passed");
    }
    
    /**
     * Test add with code method
     */
    private static void testAddWithCodeMethod() {
        System.out.println("\nTesting add(data, code) method...");
        
        GenericQueue<String> queue = new GenericQueue<>("first");
        queue.add("second", 12345);
        assert queue.getTail().code == 12345 : "Add with code test failed";
        assert queue.getTail().data.equals("second") : "Add with code data test failed";
        System.out.println("✅ add(data, code) method test passed");
    }
    
    /**
     * Test print method
     */
    private static void testPrintMethod() {
        System.out.println("\nTesting print() method...");
        
        GenericQueue<String> queue = new GenericQueue<>("hello");
        queue.enqueue("world");
        System.out.println("Expected: hello, world");
        queue.print();
        System.out.println("✅ print() method test completed");
    }
    
    /**
     * Test get method
     */
    private static void testGetMethod() {
        System.out.println("\nTesting get() method...");
        
        GenericQueue<String> queue = new GenericQueue<>("index0");
        queue.enqueue("index1");
        assert queue.get(0).equals("index0") : "Get index 0 test failed";
        assert queue.get(1).equals("index1") : "Get index 1 test failed";
        assert queue.get(5) == null : "Get invalid index test failed";
        System.out.println("✅ get() method test passed");
    }
    
    /**
     * Test set method
     */
    private static void testSetMethod() {
        System.out.println("\nTesting set() method...");
        
        GenericQueue<String> queue = new GenericQueue<>("original");
        String oldValue = queue.set(0, "updated");
        assert oldValue.equals("original") : "Set return test failed";
        assert queue.get(0).equals("updated") : "Set update test failed";
        System.out.println("✅ set() method test passed");
    }
    
    /**
     * Test dumpList method
     */
    private static void testDumpListMethod() {
        System.out.println("\nTesting dumpList() method...");
        
        GenericQueue<String> queue = new GenericQueue<>("A");
        queue.enqueue("B");
        queue.enqueue("C");
        ArrayList<String> result = queue.dumpList();
        assert result.size() == 3 : "DumpList size test failed";
        assert result.get(0).equals("A") : "DumpList content test failed";
        System.out.println("✅ dumpList() method test passed");
    }
    
    /**
     * Test getLength method
     */
    private static void testGetLengthMethod() {
        System.out.println("\nTesting getLength() method...");
        
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        assert queue.getLength() == 1 : "GetLength test failed";
        queue.enqueue(2);
        assert queue.getLength() == 2 : "GetLength after enqueue test failed";
        System.out.println("✅ getLength() method test passed");
    }
    
    /**
     * Test descendingIterator method
     */
    private static void testDescendingIteratorMethod() {
        System.out.println("\nTesting descendingIterator() method...");
        
        GenericQueue<String> queue = new GenericQueue<>("first");
        queue.enqueue("second");
        queue.enqueue("third");
        
        Iterator<String> descIt = queue.descendingIterator();
        assert descIt.next().equals("third") : "Descending iterator first test failed";
        assert descIt.next().equals("second") : "Descending iterator second test failed";
        assert descIt.next().equals("first") : "Descending iterator third test failed";
        System.out.println("✅ descendingIterator() performs as expected");
    }
    
    /**
     * Test forEach loop
     */
    private static void testForEachLoop() {
        System.out.println("\nTesting forEach loop implementation...");
        
        GenericQueue<String> queue = new GenericQueue<>("A");
        queue.enqueue("B");
        queue.enqueue("C");
        
        System.out.print("forEach output: ");
        for (String item : queue) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("✅ forEach loop implementation works");
    }
    
    /**
     * Test GLLIterator
     */
    private static void testGLLIterator() {
        System.out.println("\nTesting GLLIterator...");
        
        GenericQueue<String> queue = new GenericQueue<>("first");
        queue.enqueue("second");
        
        Iterator<String> it = queue.iterator();
        assert it.hasNext() : "GLLIterator hasNext test failed";
        assert it.next().equals("first") : "GLLIterator next test failed";
        assert it.next().equals("second") : "GLLIterator second next test failed";
        assert !it.hasNext() : "GLLIterator final hasNext test failed";
        System.out.println("✅ GLLIterator test passed");
    }
    
    /**
     * Test ReverseGLLIterator
     */
    private static void testReverseGLLIterator() {
        System.out.println("\nTesting ReverseGLLIterator...");
        
        GenericQueue<String> queue = new GenericQueue<>("first");
        queue.enqueue("second");
        
        Iterator<String> reverseIt = new ReverseGLLIterator<>(queue);
        assert reverseIt.hasNext() : "ReverseGLLIterator hasNext test failed";
        assert reverseIt.next().equals("second") : "ReverseGLLIterator next test failed";
        assert reverseIt.next().equals("first") : "ReverseGLLIterator second next test failed";
        assert !reverseIt.hasNext() : "ReverseGLLIterator final hasNext test failed";
        System.out.println("✅ ReverseGLLIterator test passed");
    }
}