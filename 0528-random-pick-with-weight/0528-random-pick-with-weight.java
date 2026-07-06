class Solution {
  int [] presum;
    public Solution(int[] w) {
      int sum = 0;
      presum = new int[w.length];
      for(int i=0;i<w.length;i++){
        sum+=w[i];
        presum[i] = sum;
      }
    }
    
    public int pickIndex() {
      int tar = 1+(int)(Math.random()*presum[presum.length-1]);
      int s = 0;
      int e = presum.length-1;
      while(s<=e){
        int m = s+(e-s)/2;
        if(presum[m]<tar){
            s = m+1;
        }
        else{
            e = m-1;
        }

      }
      return s;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */