// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 12, 1, 6, 3};

        InsertionSort.insertionSort(arr);

        System.out.println("Sorted Array:");
        for(int num : arr){
            System.out.print(num + " ");
        }

    }
}