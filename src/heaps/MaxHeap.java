package heaps;
import java.util.Arrays;
import java.util.Scanner;
public class MaxHeap {
    int[] arr;

    int maxSize;

    int heapSize;


    MaxHeap(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        heapSize = 0;
    }

    // Heapifies a sub-tree taking the given index as the root
    void MaxHeapify(int i){
        int l = lChild(i);
        int r = rChild(i);
        int largest = i;
        if(l < heapSize && arr[l] > arr[i])
            largest = l;
        if(r < heapSize && arr[r] > arr[largest])
            largest = r;
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            MaxHeapify(largest);
        }
    }

    // Returns the index of the parent
    int parent(int i){
        return (i-1)/2;
    }

    // Returns the index of the left child.
    int lChild(int i){
        return (2 * i + 1);
    }

    // Returns the index of the right child.
    int rChild(int i){
        return (2 * i + 2);
    }

    // Removes the root which in this case contains the maximum element
    int removeMax(){
        // Checking whether the heap array is empty or not
        if(heapSize <= 0)
            return Integer.MIN_VALUE;
        if(heapSize == 1){
            heapSize--;
            return arr[0];
        }

        // Storing the maximum element to remove it
        int root = arr[0];
        arr[0]= arr[heapSize - 1];
        heapSize--;

        // To restore the property of the Max Heap
        MaxHeapify(0);

        return root;
    }
}
