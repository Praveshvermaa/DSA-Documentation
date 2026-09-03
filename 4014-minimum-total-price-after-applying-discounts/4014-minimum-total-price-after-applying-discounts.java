class Solution {
    public void reverse(int [] arr){
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        reverse(prices);
        Arrays.sort(discounts);
        reverse(discounts);
        double ans = 0;
        int j = 0;
        int n2 = discounts.length;
        int n1 = prices.length;
        for(int i=0;i<n1;i++){
            if(j<n2){
                ans += prices[i]*(100-discounts[j++])/100.0;
            }
            else{
                ans += prices[i];            }
        }
        return ans;
    }
}