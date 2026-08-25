class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==target){
                    return sum;
                }
                else if(sum>target){
                    if(Math.abs(target-ans)>(sum-target)){
                        ans = sum;
                    }
                    right--;
                }
                else{
                    if(Math.abs(target-ans)>(target-sum)){
                        ans = sum;
                    }
                    left++;
                }

            }
        }
        return ans;
    }
}