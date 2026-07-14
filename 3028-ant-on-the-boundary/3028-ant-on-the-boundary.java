class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int sum= 0;
        int count = 0;
        for(int e:nums){
            sum+=e;
            if(sum==0) count++;
        }
        return count;
    }
}