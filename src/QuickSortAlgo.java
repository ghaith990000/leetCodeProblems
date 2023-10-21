import java.io.*;
public class QuickSortAlgo {
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
    This function takes last element as pivot, places the pivot element at its correct
    position in sorted array, and places all smaller to left of pivot and all greater
    elements to right of pivot
     */
    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];

        int i = (low-1);

        for(int j=low; j<=high - 1; j++){
            // If current element is smaller than the pivot
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return (i+1);
    }

    /*
    The main function that implements QuickSort
    arr[] --> Array to be sorted,
    low   --> Starting index,
    high  --> Ending index
     */
    static void quickSort(int[] arr, int low, int high)
    {
        if(low < high){
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    public static void printArr(int[] arr)
    {
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        int[] arr = {10, 7, 8, 9, 1, 5};
        int N = arr.length;

        quickSort(arr, 0, N-1);
        System.out.println("Sorted Array: ");
        printArr(arr);
    }
}
