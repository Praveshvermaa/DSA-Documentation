class Pair{
    int freq ;
    char letter ;
    Pair(int f,char c){
        freq=f;
        letter = c;
    }

}
class Solution {
    public String frequencySort(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));
        int [] hash = new int[123];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)]++;
        }
        for(int i=0;i<hash.length;i++){
            if(hash[i]!=0){
                pq.offer(new Pair(hash[i],(char)(i)));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair obj = pq.poll();
            for(int i=0;i<obj.freq;i++){
                sb.append(obj.letter);
            }
        }
        return sb.toString();
    }
}