class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if(nums.length<3) return nums.length;
        int n = nums.length;
        int count = 0;
        while(n>0){
            count++;
            n=n>>1;
        }
        StringBuilder s =new StringBuilder();
        for(int i=0;i<count;i++){
            s.append('1');
        }
        return Integer.parseInt(s.toString(), 2)+1;
    }
}