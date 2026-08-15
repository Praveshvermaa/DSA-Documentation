class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder s = new StringBuilder();
           String first = strs[0];
           for(int i = 0;i<first.length();i++){
            char c = first.charAt(i);
            boolean check = true;
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length()){
                    check = false;
                    return s.toString();
                }
                if(i<strs[j].length()&&strs[j].charAt(i)!=c){
                    check = false;
                    return s.toString();
                }

            }
            if(check){
                s.append(c);
            }
     
           }
           return s.toString();
    }
}