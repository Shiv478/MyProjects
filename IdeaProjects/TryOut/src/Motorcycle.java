public class Motorcycle extends Vehicle{
    private String name;
    public Motorcycle(String name){
        super(name);
        this.name = name;
    }
    public void start(){
        super.start();
        System.out.println("(revving the engine)");
    }
    public void honk(){
        System.out.println(name + " is ringing the bell");
    }

}
