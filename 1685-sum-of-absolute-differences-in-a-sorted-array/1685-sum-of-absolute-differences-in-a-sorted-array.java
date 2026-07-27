class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];
        for(int i=n-2;i>=0;i--){
            int diff = nums[i+1]-nums[i];
            ans[i] = diff*(n-i-1);
            ans[i] += ans[i+1];
        }
        int [] prefix = new int[n];
        for(int i=1;i<n;i++){
            int diff = nums[i]-nums[i-1];
            prefix[i] = diff*i;
            prefix[i] += prefix[i-1];
            ans[i] += prefix[i];
        }
        return ans;
    }
}