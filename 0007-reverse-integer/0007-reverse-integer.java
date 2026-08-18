class Solution {
    public int reverse(int x) {
         int num = Math.abs (x);
        long rev =0;
        while (num>0){
            rev = rev*10+num%10;

            num = num/10;
        }
        if(rev>Integer.MAX_VALUE||rev<Integer.MIN_VALUE){
                return 0;
            }
          int rev1 = (int) rev;




            return x<0?-rev1:rev1;
        }
}
