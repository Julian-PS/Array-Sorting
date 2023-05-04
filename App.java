import java.util.Arrays;  // to show the array elements before and after being sorted with our methods
import java.util.Random; // this creates random for our program

public class App {

    /**
     * Method to sort by using Heap.
     * Since the requirements only mention the sorting of an array (no other return), I made the method void, so it will only
     * take the provided array and sort it. In order to show the contents I use Arrays.toString
     *
     * @param arr, the array we want to sort
     */
    public static void heapSort(int[] arr) {

        // Create a heap using the elements of the provided array. The resulting heap will always keep the lowest value
        // element at the root.
        MyHeap myHeap = new MyHeap();
        for (int i = 0; i < arr.length; i++) {
            myHeap.insert(arr[i]);
        }

        // We now refill the original array by constantly removing the heap's min. value (that will always be at the root)
        // and adding it to the array.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = myHeap.removeMin();
        }
    }

    /**
     * Method to sort by using Priority Queue.
     * Since the requirements only mention the sorting of an array (no other return), I made the method void, so it will only
     * take the provided array and sort it. In order to show the contents I use Arrays.toString
     *
     * @param arr, the array we want to sort
     */
    public static void selectionSort(int[] arr){
        // create a priority queue using the elements of the provided array. The  resulting queue will have the same
        // order of the array (not sorted)
        MyPQ myPq = new MyPQ();
        for (int i = 0; i < arr.length; i++) {
            myPq.insert(arr[i]);
        }
        // to sort it we refill the array by constantly removing the min value of the priority queue and adding it to
        // the array. For this we take advantage of the removeMin method
        for (int i = 0; i < arr.length; i++) {
            arr[i] = myPq.removeMin();
        }
    }

    /**
     * Method to sort by using a sorted Priority Queue.
     * Since the requirements only mention the sorting of an array (no other return), I made the method void, so it will only
     * take the provided array and sort it. In order to show the contents I use Arrays.toString
     *
     * @param arr, the array we want to sort
     */
    public static void insertionSort(int[] arr){
        // create a sorted priority queue using the elements of the provided array. By using the insert method, the  resulting
        // queue will already be sorted
        MyPQSort sorted = new MyPQSort();
        for (int i = 0; i < arr.length; i++) {
            sorted.insert(arr[i]);
        }
        // we now refill the array by constantly removing the min value of the sorted priority queue, that will always be
        // located at the first index of the queue (0)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sorted.removeMin();
        }
    }
    public static void main(String[] args) throws Exception {
        int numItem = 100; // This decides how big you array is
        int[] myArr = new int[numItem];

        int[] myArr2 = new int[numItem];
        int[] myArr3 = new int[numItem];


        Random myRand = new Random(); // creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        int indexMin = 0;

        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = myRand.nextInt(max - min + 1) + min; // storing random integers in an array
            myArr2[i] = myRand.nextInt(max - min + 1) + min;
            myArr3[i] = myRand.nextInt(max - min + 1) + min;
        }

        // Now sort it

        System.out.println("Not sorted: " + Arrays.toString(myArr));
        double startTime = System.nanoTime();
        heapSort(myArr);
        double endTime = System.nanoTime();
        double duration = (endTime - startTime)/1000000; // divide by 1000000 to get milliseconds.
        System.out.println("Heap Sorted: " + Arrays.toString(myArr));
        System.out.println("the time it took to sort is " + duration);


        System.out.println();

        System.out.println("Not sorted: " + Arrays.toString(myArr2));
        startTime = System.nanoTime();
        selectionSort(myArr2);
        endTime = System.nanoTime();
        duration = (endTime - startTime)/1000000; // divide by 1000000 to get milliseconds.
        System.out.println("PQ Sorted: " + Arrays.toString(myArr2));
        System.out.println("the time it took to sort is " + duration);



        System.out.println();

        System.out.println("Not sorted: " + Arrays.toString(myArr3));
        startTime = System.nanoTime();
        insertionSort(myArr3);
        endTime = System.nanoTime();
        duration = (endTime - startTime)/1000000; // divide by 1000000 to get milliseconds.
        System.out.println("sortedPQ Sorted: " + Arrays.toString(myArr3));
        System.out.println("the time it took to sort is " + duration);
    }
}