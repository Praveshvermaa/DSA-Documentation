class Solution {
    public long shadowPairs(int[] num) {
        Stack<int[]> t = new Stack<>();
        long an = 0;
        int total = 0;
        for (int i = 0; i < num.length; i++) {
            while (!t.isEmpty() && t.peek()[0] > num[i]) {
                total -= t.peek()[1];
                t.pop();
            }
            if (!t.isEmpty()) {
                if (t.peek()[0] != num[i]) {
                    an += total;
                   t.push(new int[] { num[i], 1 });
                   total++;

                } else {
                    an += total - t.peek()[1];
                    t.peek()[1]++;
                    total++;
                }
            } else {
                t.push(new int[] { num[i], 1 });
                total++;
            }

        }
        return an;
    }
}