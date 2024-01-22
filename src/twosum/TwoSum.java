package twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            int complement = target - nums[i];
            if(numMap.containsKey(complement)){
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int[] result;

        result  = twoSum(nums, 9);
        for (int j : result) {
            System.out.print(j + " ");
        }


    }
}
