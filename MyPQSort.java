
import java.util.ArrayList;
/**
 * Class to create a sorted priority queue using Arraylist
 */
public class MyPQSort {

    private ArrayList<Integer> sortedArray = new ArrayList<>();      // array that will contain the sorted pq

    /**
     * Method to insert a new element in increasing order
     *
     * @param element, int we want to add
     */
    public void insert(int element) {

        // If queue is empty or element to be added is greater than last element, we add it to the end of the queue
        if (sortedArray.size() == 0 || element > sortedArray.get(sortedArray.size() - 1)) {
            sortedArray.add(element);
            return;
        }

        // loop to find the correct position of the element we want to add
        for (int i = 0; i < sortedArray.size(); i++) {
            if (element <= sortedArray.get(i)) {                             // compare elements to find location to add
                sortedArray.add(sortedArray.get(sortedArray.size() - 1));    // copy last element and add it to the end
                // loop to move all the elements by one position, so that we can add the new one
                for (int j = sortedArray.size() - 1; j > i; j--) {
                    sortedArray.set(j, sortedArray.get(j - 1));
                }
                sortedArray.set(i, element);                               // set new element at correct position
                return;
            }
        }
    }

    /**
     * Method to return min value element. It is located at first index (0)
     *
     * @return min value element
     */
    public int min() {
        return sortedArray.get(0);
    }

    /**
     * Method to remove the min value element from the queue. It is located at first index (0)
     *
     * @return value of element removed
     */
    public int removeMin() {

        int temp = sortedArray.get(0);
        sortedArray.remove(0);
        return temp;
    }

    /**
     * Method to return the size of the queue
     *
     * @return size
     */
    public int size() {
        return sortedArray.size();
    }

    /**
     * Method to remove the element with the min. value
     *
     * @return the value of the element removed
     */
    public String toString() {
        return sortedArray.toString();
    }
}
