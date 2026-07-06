class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        int n = s.length();
        for(char c:t.toCharArray()){
            if(j<n&&s.charAt(j)==c){
                    j++;
            }
            j = Math.max(j,i+1);
            if(i<n&&s.charAt(i)==c){
                i++;
            }
        }
        return j>=n;
    }
}