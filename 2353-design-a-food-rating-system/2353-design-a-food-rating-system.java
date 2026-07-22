class Pair{
    int rating;
    String food ;
    Pair(int r,String fo){
        rating = r;
        food = fo;
    }
}
class FoodRatings {
    HashMap<String,PriorityQueue<Pair>> cuisinesToFood = new HashMap<>();
    HashMap<String,Integer> updatedrating = new HashMap<>();
    HashMap<String,String> foodTocuisine = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i=0;i<foods.length;i++){
             updatedrating.put(foods[i],ratings[i]);
             foodTocuisine.put(foods[i],cuisines[i]);
             if(!cuisinesToFood.containsKey(cuisines[i])){
                PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
                    if(a.rating!=b.rating){
                        return Integer.compare(b.rating,a.rating);
                    }
                    else{
                        if(a.food.compareTo(b.food)<0){
                            return -1;
                        }
                        else{
                            return 1;
                        }
                    }
                });
                pq.offer(new Pair(ratings[i],foods[i]));
                cuisinesToFood.put(cuisines[i],pq);
             }
             else{
                cuisinesToFood.get(cuisines[i]).offer(new Pair(ratings[i],foods[i]));
             }
        }
    }
    
    public void changeRating(String food, int newRating) {
        updatedrating.put(food,newRating);
        String cuisine = foodTocuisine.get(food);
        cuisinesToFood.get(cuisine).offer(new Pair(newRating,food));
    }
    
    public String highestRated(String cuisine) {
         PriorityQueue<Pair> pq = cuisinesToFood.get(cuisine);
         while(!pq.isEmpty()&&pq.peek().rating!=updatedrating.get(pq.peek().food)){
            pq.poll();
         }
         return pq.peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */