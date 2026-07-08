class Solution {
    int mod = (int) 1e9 + 7;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        // for(int i=0;i<n;i++){
        //     int digit = 
        //     pow10[i+1] = 
        // }
        long[] prefixSum = new long[n + 1];
        long[] prefixNum = new long[n + 1];
        int[] len = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            prefixNum[i + 1] = digit == 0 ? prefixNum[i] : (prefixNum[i] * 10 + digit) % mod;
            prefixSum[i + 1] = prefixSum[i] + digit;
            pow10[i + 1] = (pow10[i] * 10) % mod;
            len[i + 1] = len[i] + (digit == 0 ? 0 : 1);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int templen = len[r + 1] - len[l];
            long num = (prefixNum[r + 1]
                    - ((prefixNum[l] * pow10[templen]) % mod)
                    + mod) % mod;

            long sum = prefixSum[r + 1] - prefixSum[l];

            int val = (int)((num * sum) % mod);
            ans[i] = val;
        }
        return ans;

    }
}