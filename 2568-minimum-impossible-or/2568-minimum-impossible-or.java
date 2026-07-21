class Solution {
    public int minImpossibleOR(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int e:nums){
            set.add(e);
        }
        for(int i=0;i<32;i++){
            if(!set.contains(1<<i)){
                return 1<<i;
            }
        }
        return 1000000000;
    }
}