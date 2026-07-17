class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long [] prefix = new long[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]= prefix[i]+nums[i];
        }
        long max = Long.MIN_VALUE;
        long [] longestchain = new long[n+1];
        for(int i=k;i<=n;i++){
            long tempsum = prefix[i]-prefix[i-k];
            max  = Math.max(max,tempsum);
            if(longestchain[i-k]+tempsum>0){
                longestchain[i] = longestchain[i-k]+tempsum;
                 max  = Math.max(max,longestchain[i-k]+tempsum);
            }
            else{
                longestchain[i] = 0;
            }
        }
        return max;
    }
}