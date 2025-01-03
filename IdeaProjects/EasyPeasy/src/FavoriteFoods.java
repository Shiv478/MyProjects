import java.util.*;

public class FavoriteFoods {
    /* TODO */
    // implement the favoriteFoods() method below
    public static Map<String, Set<String>> favoriteFoods(Map<String, Map<String,Double>> map, double minRating){
        Map<String, Set<String>> favoriteFoods = new HashMap<>();
        for(String name: map.keySet()){
            Map<String, Double> foods= map.get(name);
            for(String food: foods.keySet()) {
                if (foods.get(food) >= minRating) {
                    Set<String> addFood = favoriteFoods.getOrDefault(name, new HashSet<>());
                    addFood.add(food);
                    favoriteFoods.put(name, addFood);
                }
            }
            favoriteFoods.put(name, favoriteFoods.getOrDefault(name, new HashSet<>()));
        }
        return  favoriteFoods;
    }



    public static void main(String[] args) {
        Map<String, Map<String, Double>> ratings = makeRatingsMap();
        System.out.println(ratings);
        Map<String, Set<String>> result = favoriteFoods(ratings, 4.3);
        System.out.println(result);
    }

    private static Map<String, Map<String, Double>> makeRatingsMap() {
        Map<String, Map<String, Double>> ratings = new HashMap<>();

        Map<String, Double> jake = new HashMap<>();
        jake.put("pie", 5.0);
        jake.put("ice cream", 5.0);
        jake.put("mushrooms", 0.0);

        Map<String, Double> chloe = new HashMap<>();
        chloe.put("chicken strips", 4.3);
        chloe.put("cranberry sauce", 4.2);

        Map<String, Double> karen = new HashMap<>();
        karen.put("lettuce", 2.4);

        Map<String, Double> esther = new HashMap<>();

        ratings.put("Jake", jake);
        ratings.put("Chloe", chloe);
        ratings.put("Karen", karen);
        ratings.put("Esther", esther);

        return ratings;
    }
}

