class Solution {
    public String longestPalindrome(String s) {
        String ansstr = "";
        for(int i=0;i<s.length();i++){
            int low = i;
            int high = i;
            while(low>=0&&high<s.length()){
                if(s.charAt(low)==s.charAt(high)){
                    low--;
                    high++;
                }
                else{
                    break;
                }
            }
            if((high-1)-(low+1)+1>ansstr.length()){
                ansstr  = s.substring(low+1,high);
            }
             low = i-1;
             high = i;
            while(low>=0&&high<s.length()){
                if(s.charAt(low)==s.charAt(high)){
                    low--;
                    high++;
                }
                else{
                    break;
                }
            }
            if((high-1)-(low+1)+1>ansstr.length()){
                ansstr  = s.substring(low+1,high);
            }
        }
        return ansstr;
    }
}