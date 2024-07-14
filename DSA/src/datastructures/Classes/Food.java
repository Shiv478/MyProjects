package datastructures.Classes;

public interface Food {

    String name();

    default String kind() {
        return "Food";
    }
}
class Cabbage implements Food {

    //@Override
    public String name() {
        return "Cabbage";
    }

    //@Override
    public String kind() {
        return "Vegetable";
    }
}
class Sausage implements Food {

    @Override
    public String name() {
        return "Sausage";
    }

    @Override
    public String kind() {
        return "Meat";
    }
}
class Pizza implements Food {

    @Override
    public String name() {
        return "Pizza";
    }
}

