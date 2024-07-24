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
    public static Stackk sortStack(Stackk<Integer> ogS){
        Stackk<Integer> newS = new Stackk<>();
        while(ogS.isEmpty() == false){
            if(newS.isEmpty() == true){
                newS.push(ogS.pop());
            }else{
                if(newS.peek() > ogS.peek()){
                    newS.push(ogS.pop());
                }else{
                    Boolean verdict = false;
                    while(verdict == false){
                        verdict = newS.isEmpty();
                        int temp = (int) ogS.pop();
                        if(temp>newS.peek()){
                            ogS.push(newS.pop());
                        }
                        else{
                            ogS.push(temp);
                            verdict = true;
                        }
                    }
                }
            }


        }
        return newS;
    }



    public static void main(String[] args) {

        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);
        Stackk ogS = new Stackk();
        ogS.push(3);
        ogS.push(4);
        ogS.push(5);
        ogS.push(2);
        ogS.push(6);

        ogS.printStack();

        ogS = sortStack(ogS);

        ogS.printStack();


        /*
            EXPECTED OUTPUT:
            ----------------
            olleh
        */

    }

}
