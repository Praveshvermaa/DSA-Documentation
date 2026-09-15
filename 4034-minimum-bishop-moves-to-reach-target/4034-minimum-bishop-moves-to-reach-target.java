class Solution {
    public int minBishopMoves(int[] ource, int[] target) {
        int add1 = ource[0]+ource[1];
        int add = target[0]+target[1];
        if(add1%2!=add%2) return -1;
        if(add1==add||Math.abs(ource[0]-target[0])==Math.abs(ource[1]-target[1])) return 1;
        return 2;

    }
}