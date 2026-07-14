class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int [] prefix = new int[n];
        prefix[0] = -1;
        for(int i=1;i<n;i++){
            if(nums[i-1]%2==nums[i]%2){
                prefix[i] = i;
            }
            else{
                prefix[i] = prefix[i-1];
            }
        }
        boolean [] ans = new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int low = queries[i][0];
            int high = queries[i][1];
            if(low<prefix[high]){
                ans[i] = false;
            }
            else ans[i] = true;
        }
        return ans;
    }
}