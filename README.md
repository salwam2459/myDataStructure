# Data Structure Library

A custom implementation of HashMap and Queue data structures in Java, built from scratch without using Java's Collections Framework. This project demonstrates fundamental computer science concepts including generic programming, the Iterator design pattern, and collision resolution strategies.

## Overview

This library provides production-ready implementations of:
- **GenericQueue**: A FIFO (First In, First Out) queue using a singly linked list
- **MyHashMap**: A hash table with separate chaining for collision resolution
- **Custom Iterators**: Three iterator implementations for flexible data traversal

All data structures are generic and follow standard Java conventions, making them drop-in replacements for learning and experimentation.

## Features

### GenericQueue\<T>
- **FIFO Operations**: `enqueue()` and `dequeue()` with O(1) time complexity
- **Generic Type Support**: Works with any object type
- **Tail Pointer Optimization**: Efficient additions to the back of the queue
- **Flexible Adding**: Standard `add()` method plus `add(data, code)` for metadata storage

### MyHashMap\<T>
- **Key-Value Storage**: String keys mapped to generic values
- **Collision Resolution**: Separate chaining using GenericQueue
- **Hash Function**: Uses Java's built-in `hashCode()` with bitwise operations
- **Standard Operations**: `put()`, `get()`, `contains()`, `replace()`, `size()`, `isEmpty()`
- **O(1) Average Time Complexity**: For insertions and lookups

### Iterator Pattern
- **Forward Iterator (GLLIterator)**: Head-to-tail traversal
- **Reverse Iterator (ReverseGLLIterator)**: Tail-to-head traversal
- **HashMap Iterator (HMIterator)**: Iterates through all values in the map
- **Enhanced For-Loop Support**: All data structures work with Java's `for-each` syntax

## Technical Architecture


GenericList<T> (Abstract)
    ├── Node<T> (Inner Class)
    │   ├── T data
    │   ├── int code
    │   └── Node<T> next
    └── GenericQueue<T>
        └── Node<T> tail

MyHashMap<T>
    └── ArrayList<GenericQueue<T>> map


## Installation & Usage

### Prerequisites
- Java JDK 8+
- Maven 3.6.3+

### Build & Run

# Compile the project
mvn compile

# Run main demonstration
mvn exec:java

# Run test suite
mvn test

### Code Examples

#### GenericQueue

// Create a queue of integers
GenericQueue<Integer> queue = new GenericQueue<>(10);

// Add elements (FIFO)
queue.enqueue(20);
queue.enqueue(30);
queue.enqueue(40);

// Remove elements
Integer first = queue.dequeue(); // Returns 10
Integer second = queue.dequeue(); // Returns 20

// Use enhanced for-loop
for (Integer num : queue) {
    System.out.println(num);
}

// Access by index
Integer value = queue.get(0); // Returns 30

// Get queue length
int length = queue.getLength(); // Returns 2


#### MyHashMap


// Create a hashmap
MyHashMap<String> map = new MyHashMap<>("name", "Salwa");

// Add key-value pairs
map.put("major", "Computer Science");
map.put("university", "UIC");

// Retrieve values
String name = map.get("name"); // Returns "Salwa"

// Check for existence
boolean hasMajor = map.contains("major"); // Returns true

// Replace existing values
String oldValue = map.replace("name", "Salwa Majeed"); // Returns "Salwa"

// Get map size
int size = map.size(); // Returns 3

// Iterate through all values
for (String value : map) {
    System.out.println(value);
}

#### Custom Iterators

GenericQueue<String> queue = new GenericQueue<>("A");
queue.add("B");
queue.add("C");

// Forward iteration
Iterator<String> forward = queue.iterator();
while (forward.hasNext()) {
    System.out.println(forward.next()); // Prints: A, B, C
}

// Reverse iteration
Iterator<String> reverse = queue.descendingIterator();
while (reverse.hasNext()) {
    System.out.println(reverse.next()); // Prints: C, B, A
}

## Testing

Comprehensive test coverage includes:
- **GQTest.java**: 15+ test cases for GenericQueue and iterators
- **HMTest.java**: 8+ test cases for MyHashMap functionality
- Tests cover constructors, all public methods, edge cases, and iterator behavior

Run tests with assertions enabled:
mvn test

## Project Structure

src/
├── main/java/
│   ├── GLProject.java           # Main demonstration class
│   ├── GenericList.java         # Abstract base class with Node inner class
│   ├── GenericQueue.java        # FIFO queue implementation
│   ├── MyHashMap.java           # HashMap with chaining
│   ├── GLLIterator.java         # Forward iterator
│   ├── ReverseGLLIterator.java  # Reverse iterator
│   └── HMIterator.java          # HashMap iterator
└── test/java/
    ├── GQTest.java              # GenericQueue test suite
    └── HMTest.java              # MyHashMap test suite

## Key Implementation Details

### Hash Function
int hashCode = key.hashCode();     // Generate hash code
int hashValue = hashCode & 9;      // Map to array index (0-9)

### Collision Handling
When multiple keys hash to the same index, they're stored in a GenericQueue at that index. Each node stores its original hash code for key identification.

### Generic Programming
All data structures use Java generics (`<T>`) allowing type-safe operations with any object type:

GenericQueue<Integer> intQueue = new GenericQueue<>(1);
GenericQueue<String> stringQueue = new GenericQueue<>("hello");
MyHashMap<Double> doubleMap = new MyHashMap<>("pi", 3.14);


## Learning Outcomes

This project demonstrates:
- Deep understanding of data structure internals
- Generic programming and type parameters
- Abstract classes and inheritance hierarchies
- Interface implementation (Iterable, Iterator)
- Design patterns (Iterator pattern)
- Collision resolution in hash tables
- Test-driven development
- Maven build system and project structure

## Performance Characteristics

| Operation | GenericQueue | MyHashMap |
|-----------|--------------|-----------|
| Add/Put | O(1) | O(1) average |
| Remove/Get | O(1) | O(1) average |
| Search | O(n) | O(1) average |
| Space | O(n) | O(n + k) where k=10 |

## Author

**Salwa A. Majeed**  
Computer Science, University of Illinois at Chicago  
smaje4@uic.edu  
