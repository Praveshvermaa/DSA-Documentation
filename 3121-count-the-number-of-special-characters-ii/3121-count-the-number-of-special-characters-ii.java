class Solution {
    public int numberOfSpecialChars(String word) {
        int [] upper = new int[26];
        int lower [] = new int[26];
        Arrays.fill(upper,-1);
        Arrays.fill(lower,-1);
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(c<='Z'){
                if(upper[c-'A']==-1){
                    upper[c-'A'] = i;
                }
            }
            else{
                lower[c-'a'] = i;
            }
        }
        int [] special = new int[26];
        for(char c:word.toCharArray()){
            if(c>'Z'){
                if(upper[c-'a']!=-1&&upper[c-'a']>lower[c-'a']){
                    special[c-'a']++;
                }
            }
        } 
        int count = 0;
        for(int e:special){
            if(e!=0) count++;
        }
        return count;
    }

}