public class InsertionSort {
    public static void insertionSort(int[] arr){
        int n = arr.length;

        for(int i=1; i<n; i++){
            int key = arr[i];
            int j = i-1;

            // Compare key with elements before it and shift larger elements to the right
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }

            // Place the key in its correct position
            arr[j+1] = key;
        }
    }
}
