class Solution {
    public int lengthOfLongestSubstring(String s) {
       int hash [] = new int[256];
        int max = 0;
        int k=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(hash[c]>0){
                if(hash[c]>=k)
                k=hash[c];
            }
            hash[c]=i+1;
            max = Math.max(max,i-k+1);
        }
        return max;
    }
}