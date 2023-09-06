public class MaximumAvgSubArray {
    public double findMaxAverage(int[] nums, int k){
        int left = 0;
        int max = Integer.MIN_VALUE;

        int sum = 0;

        for(int right =0; right< nums.length; right++){
            sum += nums[right];

            if(right >= k -1){
                max = Math.max(sum, max);
                sum -= nums[left];

                left++;
            }
        }

        return (double) max/k;

    }
}
