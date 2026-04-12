# Java Data Structures & Algorithms Library
Developed by:GROUP MEMBERS
Academic Institution: Masinde Muliro University of Science and Technology (MMUST)  

## Overview
This project is a comprehensive implementation of fundamental Data Structures and Algorithms, structured as a modular Java library.

## Project Architecture

| Package | Description |
| :--- | :--- |
| **`com.nesh.dsa.scratch`** | Manual implementations of Stacks and Queues using primitive Arrays. |
| **`com.nesh.dsa.linked`** | Pointer-based implementations utilizing custom Node objects (Linked Lists). |
| **`com.nesh.dsa.hybrid`** | Advanced "Array-based Linked List" implementation (mapping nodes over arrays). |
| **`com.nesh.dsa.inbuilt`** | Demonstrations of Java's built-in Collections Framework (ArrayList, Stack, Queue). |
| **`com.nesh.dsa.ui`** | An interactive Command Line Interface (CLI) for real-time testing. |

## Features Implemented

### 1. Array-Based Structures (The "Scratch" Package)
- Linear Stack: LIFO implementation with overflow/underflow checks.
- Linear Queue: Standard FIFO implementation using front and rear pointers.
- Circular Queue: Space-efficient queue that wraps around the array.
- Priority Queue: Elements processed based on value rather than arrival time.

### 2. Linked-List-Based Structures
- Dynamic Stack/Queue: No capacity limits; utilizes dynamic memory allocation.
- Circular & Priority Linked Versions: Advanced pointer manipulation for specialized data flow.

### 3. Hybrid Implementation
- Array-Linked List: A sophisticated data structure that simulates a linked list within a static array, demonstrating deep understanding of memory management and indexing.

## How to Run

### Prerequisites
- JDK 11 or higher installed.
- VS Code with "Extension Pack for Java" (Recommended).

### Compilation
From the root directory (`DSA_CAT`), run the following command in your terminal:
```bash
javac -d bin src/main/java/com/nesh/dsa/Main.java src/main/java/com/nesh/dsa/scratch/*.java src/main/java/com/nesh/dsa/linked/*.java src/main/java/com/nesh/dsa/hybrid/*.java src/main/java/com/nesh/dsa/inbuilt/*.java src/main/java/com/nesh/dsa/ui/*.java

java -cp bin com.nesh.dsa.Main
