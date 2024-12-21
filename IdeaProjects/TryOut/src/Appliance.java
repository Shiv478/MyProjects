public class Appliance {
    private String brand;

    public Appliance(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
    public void start(){
        System.out.println("Appliance started");
    }
    public void turnOn() {
        System.out.println(brand + " appliance is turning on.");
    }
}
