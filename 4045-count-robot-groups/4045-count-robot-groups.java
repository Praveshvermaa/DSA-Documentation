
class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        Stack<int [] > t = new Stack<>();
        int n = position.length;
        int i=0;
        HashSet<Integer> et = new HashSet<>();
        for(int ii=0;ii<n;ii++){
            if(ii>0&&position[ii]-position[ii-1]<=distance){
                et.add(ii-1);
            }
        }
        while(i<n){
            if(et.contains(i)){
                i++;
                continue;
            };
            if(t.isEmpty()){
                t.push(new int[]{position[i],speed[i]});
            }
            else{
                while(!t.isEmpty()&&(position[i]-t.peek()[0]<=distance||t.peek()[1]>speed[i])){
                    t.pop();
                }
                t.push(new int[]{position[i],speed[i]});
            }
            i++;
        }
        return t.size();

    }
}