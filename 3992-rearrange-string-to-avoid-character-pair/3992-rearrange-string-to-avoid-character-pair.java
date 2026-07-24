class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder sb1  = new StringBuilder();
         StringBuilder sb2  = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c==y){
                sb1.append(c);
            }
            else if(c==x){
                sb2.append(c);
            }
            else{
                sb1.append(c);
            }
        }
        sb1.append(sb2);
        return sb1.toString();
    }
}