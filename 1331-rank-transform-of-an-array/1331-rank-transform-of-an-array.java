class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int [][] valueAndIndex = new int[n][2];
        for(int i=0;i<n;i++){
            valueAndIndex[i][0] = arr[i];
            valueAndIndex[i][1] = i;
        }
        Arrays.sort(valueAndIndex,(a,b)-> Integer.compare(a[0],b[0]));
        int [] ranks = new int[n];
        int rank = 1;
        for(int i=0;i<n;i++){
            int val = valueAndIndex[i][0];
            int ind = valueAndIndex[i][1];
            if(i==0){
                ranks[ind] = rank;
            }
            else{
                if(val==valueAndIndex[i-1][0]){
                    ranks[ind] = rank;
                }
                else{
                    rank++;
                    ranks[ind] = rank;
                }
            }
        }
        return ranks;

    }
}