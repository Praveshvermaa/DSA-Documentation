class Solution {
    public String smallestPalindrome(String s) {
        int [] hash = new int [26];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            hash[c-97]++;
        }
        StringBuilder sb = new StringBuilder();
        int odd = -1;
        for(int i=0;i<26;i++){
            if(hash[i]!=0){
                if(hash[i]%2==1){
                    odd=i;
                }
                for(int j=0;j<hash[i]/2;j++){
                    sb.append((char)(i+97));
                }
            }
        }
        if(odd!=-1){
            sb.append((char)(odd+97));
        }
        for(int i=25;i>=0;i--){
            if(hash[i]!=0){
                for(int j=0;j<hash[i]/2;j++){
                    sb.append((char)(i+97));
                }
            }
        }
        return sb.toString();

    }
}