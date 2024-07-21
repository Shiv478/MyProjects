package datastructures.Stacks.L1;

public class Main {

    // WRITE THE REVERSESTRING METHOD HERE //
    //                                     //
    //                                     //
    //                                     //
    //                                     //
    /////////////////////////////////////////
    public static String reverseString(String myString){
        Stackk reverse = new Stackk();
        int length = myString.length();
        for(int i = 0; i<length; i++){
            reverse.push(myString.charAt(i));
        }
        String reversedString = "";
        for(int i = 0; i<length; i++){
            reversedString += reverse.pop();
        }
        return reversedString;
    }



    public static void main(String[] args) {

        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);

        /*
            EXPECTED OUTPUT:
            ----------------
            olleh
        */

    }

}
