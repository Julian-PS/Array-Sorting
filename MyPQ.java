import java.util.ArrayList;

/**
 * Class to create a priority queue using Arraylist
 */
public class MyPQ {

    private ArrayList<Integer> queueArray = new ArrayList<>();    // array that will contain the pq

    /**
     * Method to insert a new element at the end of the queue
     *
     * @param element, int we want to add
     */
    public void insert(int element){
        queueArray.add(element);
    }

    /**
     * Method to find and return the minimum value element in the queue
     *
     * @return min. value element
     */
    public int min(){

        int index = 0;   // we set the value in the first index as the min value to start comparing from there

        // to compare the predetermined min value (index) with every value in the array, since we determined index as 0 we can start from 1
        for (int i = 1; i < queueArray.size(); i++) {
            // update index each time we find a lower value
            if (queueArray.get(index) > queueArray.get(i)) {
                index = i;
            }
        }
        return queueArray.get(index);   // return the value of the element located at index identified
    }

    /**
     * Method to find and remove the element in the priority queue that has the min. value
     *
     * @return the value of the element removed
     */
    public int removeMin(){

        // first we need to find the index of the element we need to eliminate, so we set the value in the first index
        // as the min value to start comparing from there and find the index with the min value
        int index = 0;

        // loop to compare the predetermined min value (index) with every value in the array, since we determined index
        // as 0 we can start from 1
        for (int i = 1; i < queueArray.size(); i++) {
            // update index each time we find a lower value
            if (queueArray.get(index) > queueArray.get(i)) {
                index = i;
            }
        }
        int temp = queueArray.get(index);      //create temp variable to store the value
        queueArray.remove(index);              // remove the element located at the identified index containing the min value

        return temp;                           // return temp with stored min value removed
    }

    /**
     * Method to return the size of the queue
     *
     * @return size
     */
    public int size(){
        return queueArray.size();
    }

    /**
     * Method to return the queue's contents as String
     *
     * @return queues contents
     */
    public String toString(){
        return queueArray.toString();
    }
}
