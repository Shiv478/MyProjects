package datastructures.Classes;

import java.util.Collection;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection<Food> foods = new ArrayList<Food>();
        foods.add(new Cabbage());
        foods.add(new Sausage());
        foods.add(new Pizza());

        for (Food food : foods) {
            System.out.println(food.name() + ": " + food.kind());
        }
    }
}