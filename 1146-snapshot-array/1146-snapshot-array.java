class SnapshotArray {
    HashMap<Integer,ArrayList<int []>> map;
    int length ;
    int id ;

    public SnapshotArray(int length) {
        map = new HashMap<>();
        this.length = length;
        id = 0;
        for(int i=0;i<length;i++){
            map.put(i,new ArrayList<>());
            map.get(i).add(new int[]{id,0});
        }
    }
    
    public void set(int index, int val) {
        map.get(index).add(new int[]{id,val});
    }
    
    public int snap() {
        id++;
        return id-1;
    }
    
    public int get(int index, int snap_id) {
       int low = 0;
       int high = map.get(index).size()-1;
       ArrayList<int []> list = map.get(index);
       while(low<=high){
        int mid = low+(high-low)/2;
        if(list.get(mid)[0]>snap_id){
            high = mid-1;
        }
        else{
            low = mid+1;
        }
       }
       return list.get(high)[1];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */