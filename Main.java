/**
 * Main Class and main method to test the methods in the other classes
 */

public class Main {
    public static void main(String[] args) {

        MyHeap test = new MyHeap();   // Heap creation

        // Test insert method for heap
        test.insert(34);
        test.insert(52);
        test.insert(11);
        test.insert(8);
        test.insert(10);

        System.out.println("Heap: " + test.toString());      // test toString for heap.
        System.out.println("Heap's size = " + test.size());   // test size() method
        System.out.println("Min value = " + test.min());       // test min() method

        // test removeMin and print again
        test.removeMin();
        System.out.println("After removing min: " + test.toString());
        System.out.println("Heap's size = " + test.size());

        System.out.println();

        MyPQ test2 = new MyPQ();      // Queue creation

        // test insert method for queue
        test2.insert(65);
        test2.insert(16);
        test2.insert(2);
        test2.insert(93);
        test2.insert(28);

        System.out.println("PQ: " + test2.toString());        // test toString for queue
        System.out.println("PQ's size = " + test2.size());    // test size() method
        System.out.println("Min value = " + test2.min());     // test min() method

        // test removeMin and print again
        test2.removeMin();
        System.out.println("After removing min: " + test2.toString());
        System.out.println("PQ's size = " + test2.size());

        System.out.println();


        MyPQSort test3 = new MyPQSort();  // sorted queue creation

        // test insert method for sorted queue
        test3.insert(5);
        test3.insert(3);
        test3.insert(46);
        test3.insert(135);
        test3.insert(38);
        test3.insert(9);

        System.out.println("sortedPQ: " + test3.toString());       // test toString for sorted queue
        System.out.println("sortedPQ's size = " + test3.size());   // test size() method
        System.out.println("Min value = " + test3.min());          // test min() method

        // test removeMin and print again
        test3.removeMin();
        System.out.println("After removing min: " + test3.toString());
        System.out.println("sortedPQ's size = " + test3.size());



    }
}