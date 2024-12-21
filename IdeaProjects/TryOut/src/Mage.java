public class Mage extends Character{
    public Mage(String name, int health){
        super(name, health);
    }
    public void castSpell(){
        System.out.println("Mage casting spell");
    }
    public String printOne(){
        return "Mage";
    }
}
