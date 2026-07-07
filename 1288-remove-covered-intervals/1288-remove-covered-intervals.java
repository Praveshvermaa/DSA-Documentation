class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            else return a[0]-b[0];
        });
        int c = intervals[0][0];
        int d = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int a = intervals[i][0];
            int b =intervals[i][1];
            if(c <= a && b <= d){
                n--;
            }
            else{
                c = a;
                d = b;
            }
        }
        return n;
    }
}