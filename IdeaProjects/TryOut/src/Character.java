public abstract class Character {
    String name;
    int health;
    public Character(String name, int health){
        this.name = name;
        this.health = health;
    }
    public void getName(){
        System.out.println(this.name);
    }
    public void castSpell(){
        System.out.println("Character does nothing");
    }
    public void getHealth(){
        System.out.println(this.health);
    }
    public abstract String printOne();

    public void print(){
        System.out.println(printOne());
    }
}
