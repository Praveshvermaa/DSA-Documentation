class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] num, int lower, int upper) {
            HashSet<Integer> t  = new HashSet<>();
            for(int e:num){
                t.add(e);
            }
            t.add(upper+1);
            List<List<Integer>> an = new ArrayList<>();
            int firt = -1;
            for(int i=lower;i<=upper+1;i++){
                if(!t.contains(i)){
                    if(firt==-1) firt = i;
                }
                else{
                    if(firt!=-1){
                        List<Integer> li = new ArrayList<>();
                        li.add(firt);
                        li.add(i-1);
                        an.add(li);
                        firt = -1;
                    }
                }
            }
            // if(!t.conatins(upper)){
            //      List<Integer> li = new ArrayList<>();
            //      li.add(firt);
            //      li.add(upper);
            //      an.add(li);
            // }
            return an;
    }
}