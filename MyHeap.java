import java.util.ArrayList;

/**
 * Class to create a Heap by using ArrayList
 */

public class MyHeap {

    private ArrayList<Integer> heapArray = new ArrayList<>();  // Array that will contain our heap

    /**
     * Method to insert a new element to the heap
     *
     * @param element, int we want to add to the heap
     */

    public void insert(int element) {

        heapArray.add(element);             // adds the new element to the last position
        upHeap(heapArray.size() - 1); // we use upHeap method to position the new element in the correct index
    }

    /**
     * Metho to return the min value of the heap, located at the root (index 0)
     *
     * @return min value
     */
    public int min() {
        return heapArray.get(0);
    }

    /**
     * Method to remove the min value of the heap (located at the root) and place the new min value at the root
     *
     * @return value removed
     */
    public int removeMin() {

        // if heap is empty, inform the user and exit the program.
        if (heapArray.size() == 0) {
            System.out.println("Heap is empty, nothing to remove");
            System.exit(1);
        }
        int temp = heapArray.get(0);                              // create temp variable with min value
        heapArray.set(0, heapArray.get(heapArray.size() - 1));    // replace root with last element of the heap
        heapArray.remove(heapArray.size() - 1);             // remove last element of the heap

        // if we have more than 1 element we use the downHeap method to rearrange the heap properties, including
        // maintaining the min value at the root. If only one element is left there is no need to rearrange anything.
        if (heapArray.size() > 1) {
            downHeap();
        }
        return temp;   // return the previously created temp value with the removed element
    }

    /**
     * Method to return the heap's size
     *
     * @return size
     */
    public int size() {
        return heapArray.size();
    }

    /**
     * Method to show the heap's elements
     *
     * @return String with the heap (array) elements
     */
    @Override
    public String toString() {
        return heapArray.toString();
    }

    /**
     * Method to rearrange the elements and maintain the heap's properties
     *
     * @param index, where the first element we need to check is located (last element)
     */
    private void upHeap(int index) {
        int indexElement = heapArray.get(index);    // element value of the index we are currently checking

        // loop to rearrange the positions until we achieve all the correct positions, or we reach the root (index 0)
        while (index > 0) {
            int parent = (index - 1) / 2;               // index of the element's parent
            int parentElement = heapArray.get(parent);  // value of the element's parent to compare with current value

            // if the current value is greater than its parent's value we are done rearranging
            if (indexElement >= parentElement) {
                break;
            // if the current value is lower than its parent's value, we switch the values
            } else {
                int temp = parentElement;
                heapArray.set(parent, indexElement);
                heapArray.set(index, temp);
                index = parent;
            }
        }
    }

    /**
     * Method to rearrange the elements and maintain the heap's properties
     */
    private void downHeap() {

        int index = 0;                                     // index where we start to check and rearrange (root)
        int indexElement = heapArray.get(index);           // element value of index we are currently checking
        int lastParent = (heapArray.size() - 2) / 2;       // last element's parent index
        int childIndex;                                    // param. to store index of curr. element's child that has the lowest value
        int childElement;                                  // element value of the child at index childIndex

        // loop to rearrange the element's positions until we achieve all the correct positions, or we reach the last parent
        while (index <= lastParent) {

            // check if the current element has one or two children. If it only has the left child, then this is the only
            // element we are checking. If the child's value is lower, then we switch the values, and we are done
            if (heapArray.size() - (2 * index + 2) == 0) {
                if (heapArray.get(2*index+1) < indexElement) {
                    int temp = indexElement;
                    heapArray.set(index, heapArray.get(1));
                    heapArray.set(1, temp);
                }
                return;
            }

            // if it has 2 children then we check for the one with the lowest value and set it as the child index and element
            // to use in our comparison
            if (heapArray.get(2 * index + 1) <= heapArray.get(2 * index + 2)) {  // left child is lower or equal right child
                childIndex = 2 * index + 1;
                childElement = heapArray.get(childIndex);
            } else {                                                             // right child is lower than left child
                childIndex = 2 * index + 2;
                childElement = heapArray.get(childIndex);
            }

            // we compare the current element value with the value of the previously defined child. If child's value is
            // lower we switch the elements
            if (childElement < indexElement) {
                heapArray.set(index, childElement);
                heapArray.set(childIndex, indexElement);
            }
            else {
                break;     // if child's element is higher we are done rearranging
            }
            index = childIndex;                     // update index to the index of the child we use for comparison
            indexElement = heapArray.get(index);    // update current element value
        }
    }
}

