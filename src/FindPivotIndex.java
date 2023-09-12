public class FindPivotIndex {
    public int pivotIndex(int[] nums){
        for(int i=0; i<nums.length; i++){
            int sumLeft = 0;
            int sumRight = 0;
            for(int j=0; j<i; j++){
                sumLeft += nums[j];
            }

            for(int k=i+1; k<nums.length; k++){
                sumRight += nums[k];
            }

            if(sumLeft == sumRight){
                return i;
            }
        }
        return -1;
    }
}
