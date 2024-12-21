public class WashingMachine extends Appliance{
    public WashingMachine(String brand){
        super(brand);
    }
    public void start(){
        System.out.println("Starting wash cycle.");
    }
}
