package heaps;
import java.util.PriorityQueue;
import java.util.Comparator;
public class KthLargestElem {


    public static int findKthLargest(int[] nums, int k){
        // Create a maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // We just have to insert the numbers in the maxHeap
        for(int num : nums){
            maxHeap.add(num);
        }

        //maxHeap.forEach(System.out::println);
        int kthLargest = 0;

        for(int i=0; i<k; i++){
            kthLargest = maxHeap.poll();
        }

        return kthLargest;


    }

    public static void main(String[] args){
        int[] nums = {1};
        int k = 1;
        System.out.println(findKthLargest(nums, k));
    }



}
