class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int left = 0;
        int right = 0;
        int n1 = series1.length;
        int n2 = series2.length;
        List<List<Integer>> list = new ArrayList<>();
        while(left<n1&&right<n2){
             List<Integer> ls = new ArrayList<>();
            if(series1[left][0]==series2[right][0]){
                ls.add(series1[left][0]);
                ls.add(series1[left][1]+series2[right][1]);
                left++;
                right++;
            }
           else if(series1[left][0]<series2[right][0]){
               ls.add(series1[left][0]);
                ls.add(series1[left][1]+series2[right][1]);
                left++;
            }
            
            else{
                 ls.add(series2[right][0]);
                ls.add(series1[left][1]+series2[right][1]);
                right++;
            }
            list.add(ls);
        }
        while(left<n1){
            List<Integer> ls = new ArrayList<>();
            ls.add(series1[left][0]);
            ls.add(series1[left][1]);
            list.add(ls);
            left++;
        }
        while(right<n2){
            List<Integer> ls = new ArrayList<>();
            ls.add(series2[right][0]);
            ls.add(series2[right][1]);
            list.add(ls);
            right++;
        }
        return list;
    }
}