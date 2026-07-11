class Solution {
    public int findMinArrowShots(int[][] points) {
        int i = 1;
        int n = points.length;
        int ans = n ;
        Arrays.sort(points,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1], b[1]);
            }
            else return Integer.compare(a[0], b[0]);
        });
       // int s = points[0][0];
        int e = points[0][1];
        while(i<n){
         if(points[i][0]<=e){
            ans--;
            e = Math.min(e,points[i][1]);
         }
         else{
            e = points[i][1];
         }
         i++;
        }
        return ans;
    }
}