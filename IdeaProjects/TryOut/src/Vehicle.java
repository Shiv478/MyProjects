public class Vehicle {
    private String name;
    public Vehicle(String name){
        this.name = name;
    }
    public void start(){
        System.out.println(name + " is starting");
    }
    public void honk(){
        System.out.println(name + " is honking");
    }

}
