package datastructures.Classes;

public class ClassProgram {
    public static void main(String[] args){
        Cookie newCookie = new Cookie("Brown");
        Cookie newCookie2 = new Cookie("Blue");
        System.out.println(newCookie.getColor());
        newCookie2.setColor("Yellow");
        System.out.println(newCookie2.getColor());
    }
}
