class Solution {
    public int countGoodRotations(int[] nums) {
        int s = 0;
        int e = -1;
        long sum1 = 0;
        long sum2 = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i<n/2){
                sum1 += nums[i];
            }
            else{
                if(e==-1){
                    e = i;
                }
                sum2 += nums[i];
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(sum1>sum2){
                ans++;
            }
            sum1 -= nums[i];
            sum1 += nums[e%n];
            sum2 -= nums[e%n];
            sum2 += nums[i];
            e++;
        }
        return ans;
    }
}