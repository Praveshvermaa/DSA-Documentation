class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int [] compute = new int[n+1];
        int [] ans = new int[n];
        for(int i=0;i<n;i++){
            if(i>0) ans[i] = ans[i-1];
            compute[A[i]]--;
            if(compute[A[i]]==0){
                ans[i]++;
            }
            compute[B[i]]++;
            if(compute[B[i]]==0){
                ans[i]++;
            }
        }
        return ans;
    }
}