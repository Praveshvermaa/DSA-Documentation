class Solution {
    public int minimumDeletions(int[] num) {
        int min = 1000000;
        int minind = -1;
        int mac = -10000000;
        int macind = -1;
         int n = num.length;
        int hf = num.length/2;
        for(int i=0;i<n;i++){
            if(num[i]>mac){
                mac = num[i];
                macind = i;
            }
            if(num[i]<min){
                min = num[i];
                minind = i;
            }
        }
       
        // if(macind>=hf&&minind>=hf){
        //     return n-Math.min(macind,minind);
        // }
        // if(n%2==0&&macind<hf&&minind<hf){
        //     return Math.max(macind,minind)+1;
        // }
        // if(n%2!=0&&macind<=hf&&minind<=hf){
        //     return Math.max(macind,minind)+1;
        // }
        int diff = Math.abs(macind-minind);
        int temp1 = Math.min(minind+1,n-minind);
         int temp3 =  Math.min(macind+1,n-macind);
        return Math.min(Math.min(temp1+diff,temp3+diff),temp1+temp3);
    }
}