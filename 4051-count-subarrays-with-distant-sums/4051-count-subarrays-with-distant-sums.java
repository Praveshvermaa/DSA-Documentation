class Solution {
    public long distantSubarrays(int[] num, int goal, int k) {
        long[] arr = new long[num.length + 1];
        for (int i = 0; i < num.length; i++) {
            arr[i + 1] = arr[i] + num[i];
        }
        long close = mergesort(arr, 0, num.length, goal, k);

        long total = (long) num.length * (num.length + 1) / 2;

        return total - close;
        //return mergesort(arr,0,num.length,goal,k);
    }

    public long mergesort(long[] num, int b, int e, int goal, int k) {
        if (b >= e)
            return 0l;
        int m = b + (e - b) / 2;
        long left = mergesort(num, b, m, goal, k);
        long right = mergesort(num, m + 1, e, goal, k);
        int x = m + 1;
        int y = m + 1;
        long an = 0;
        for (int l = b; l <= m; l++) {
            long lower = num[l] + goal - k;
            long upper = num[l] + goal + k;
             if (lower >= upper)
                continue;

            while (x <= e && num[x] <= lower) {
                x++;
            }
            while (y <= e && num[y] < upper) {
                y++;
            }
            an += y - x;
        }
        merge(num, b, m, e);

        return an + left + right;
    }

    void merge(long[] arr, int l, int m, int r) {
        ArrayList<Long> li = new ArrayList<>();
        int tr = m + 1;
        int tl = l;
        while (l <= m && tr <= r) {
            if (arr[l] < arr[tr]) {
                li.add(arr[l++]);
            } else {
                li.add(arr[tr++]);
            }
        }
        while (l <= m) {
            li.add(arr[l++]);
        }
        while (tr <= r) {
            li.add(arr[tr++]);
        }
        int ind = 0;
        for (int i = tl; i <= r; i++) {
            arr[i] = li.get(ind++);
        }
    }
}