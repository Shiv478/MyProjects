public class Car extends Vehicle{
    private String name;
    public Car(String name){
        super(name);
        this.name = name;
    }
    public void printName(){
        System.out.println("Car");
    }
    public void start(){
        System.out.println(name + " is brrrring");
    }
}
