class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int [][] ans = new int[m][n];
        Queue<int [] > queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    ans[i][j]=0;
                    queue.add(new int[]{i,j});
                }
                else{
                    ans[i][j]=-1;
                }
            }
        }
        int [] deltarow = {0,-1,0,1};
        int [] deltacol = {-1,0,1,0};
        while(!queue.isEmpty()){
            int [] arr = queue.poll();
            int r = arr[0];
            int c = arr[1];
            for(int i=0;i<4;i++){
                int temprow = r + deltarow[i];
                int tempcol = c + deltacol[i];
                if(temprow>=0&&temprow<m&&tempcol>=0&&tempcol<n&&ans[temprow][tempcol]==-1){
                    ans[temprow][tempcol] = ans[r][c]+1;
                    queue.offer(new int[]{temprow,tempcol});
                }
            }
        }
        return ans;
    }
}