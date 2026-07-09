class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int [] rightRange = new int[n];
        for(int i=n-1;i>=0;i--){
            if(i<n-1&&nums[i+1]-nums[i]<=maxDiff){
                rightRange[i] = rightRange[i+1];
            }
            else{
                rightRange[i] = i;
            }
        }
        boolean [] ans = new boolean[queries.length];
        for(int i = 0; i < queries.length;i++){
            int u = Math.min(queries[i][0],queries[i][1]);
            int v = queries[i][0]+queries[i][1]-u;
            if(rightRange[u]>=v){
                ans[i] = true;
            }
        }
        return ans;

    }
}