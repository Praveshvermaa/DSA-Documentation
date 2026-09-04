class Solution {
    int mod = (int)1e9+7;
    public long square(long base, long power){
        long ans = 1;
        while(power>0){
            if(power%2==0){
                base = (base*base)%mod;
                power = power/2;
            }
            else{
                ans = (ans * base)%mod;
                power--;
            }
        }
        return ans;
    }
    public int sumDecoded(long[] nums) {
        long ans = 0;
        for(long e:nums){
            int wi = (int)(e%10);
            long di = e/10;
            String str = String.valueOf(di);
            long x = Long.parseLong(str.substring(0,wi));
            long y = Long.parseLong(str.substring(wi));
            ans = (ans+square(x,y))%mod;
        }
        return (int)ans;
    }
}