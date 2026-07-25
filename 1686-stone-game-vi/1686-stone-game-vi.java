class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int [][] values = new int[n][2];
        for(int i=0;i<n;i++){
            values[i][0] = aliceValues[i];
            values[i][1] = bobValues[i];
        }
        Arrays.sort(values,(a,b)->Integer.compare((b[0]+b[1]),(a[0]+a[1])));
        int alice =0;
        int bob = 0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                alice += values[i][0];
            }
            else{
                bob += values[i][1];
            }
        }
        
         return alice > bob ? 1 : alice < bob ? -1 : 0;

    }
}