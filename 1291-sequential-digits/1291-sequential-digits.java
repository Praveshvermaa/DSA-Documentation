class Solution {
    public void numberFinder(int low,int high,List<Integer> list,String s){
        for(int i=2;i<=9;i++){
           int j = 0;
           while(j+i<=s.length()){
            int num = Integer.parseInt(s.substring(j,j+i));
            if(num>high) return;
            if(low<=num&&num<=high){
                list.add(num);
            }
            j++;
           }
        }
    }
    public List<Integer> sequentialDigits(int low, int high) {
         List<Integer> ans = new ArrayList<>();
        String s ="123456789";
        numberFinder(low,high,ans,s);
        return ans;
    }
}