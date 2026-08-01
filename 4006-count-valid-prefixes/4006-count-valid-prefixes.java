class Solution {
    public int countValidPrefixes(String s) {
        int zero = 0;
        int one = 0;
        int ans = 0;
        for(char c:s.toCharArray()){
            if(c=='1'){
                one++;
            }
            else{
                zero++;
            }
            if(Math.abs(zero-one)<2){
                ans++;
            }
        }
        return ans;
    }
}