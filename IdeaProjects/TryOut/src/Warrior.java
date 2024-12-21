public class Warrior{
    private String name;
    private int health;
    public Warrior(String name, int health){
        this.name = name;
        this.health = health;
    }
    public Warrior(){
        this("Warrior", 100);
    }
    public void printName(){
        System.out.println(this.name);
    }
    public void attack(){
        System.out.println("Warrior attacking!");
    }
    public void setHealth(int h){
        this.health = h;
    }
    public int getHealth(){
        return this.health;
    }
}
