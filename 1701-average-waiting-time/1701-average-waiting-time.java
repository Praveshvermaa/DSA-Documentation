class Solution {
    public double averageWaitingTime(int[][] customers) {
        long total = 0;
        long sum = 0;
        for(int  i=0;i<customers.length;i++){
            if(customers[i][0]>total){
                total = customers[i][0];
            }
           total+=customers[i][1];
           sum+=total-customers[i][0];

        }
        return sum*1.0/customers.length;
    }
}