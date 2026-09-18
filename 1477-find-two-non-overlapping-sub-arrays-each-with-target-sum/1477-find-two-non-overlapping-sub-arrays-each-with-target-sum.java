class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        // int len1 = Integer.MAX_VALUE;
        // int len2 = Integer.MAX_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] dp = new int[arr.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        map.put(0,-1);
        int min = 10000000;
        int total = 0;
        int an = Integer.MAX_VALUE;
        for(int it = 0;it<arr.length;it++){
            total+=arr[it];
            if(map.containsKey(total-target)){
                int b = map.get(total-target)+1;
                int e = it;
                int len = e-b+1;
                if(b>0&&dp[b-1]!=Integer.MAX_VALUE){
                    an = Math.min(an,len+dp[b-1]);
                }
                if(len<dp[it]){
                    dp[it] = len;
                }
            }
            map.put(total,it);
            if(it>0){
                dp[it] = Math.min(dp[it-1],dp[it]);
            }
        }
        

        return an == Integer.MAX_VALUE ? -1 : an;
    }
}