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
        newS.push(ogS.pop());
        while(ogS.isEmpty() == false){
            if(ogS.peek() < newS.peek()){
                newS.push(ogS.pop());
            }else{
              Boolean verdict = true;
              int ogNum = ogS.pop();
              while(verdict == true){
                  if(newS.peek() == null){
                      newS.push(ogNum);
                      verdict = false;
                  }
                  else if(ogNum>newS.peek()) {
                      ogS.push(newS.pop());
                  }
                  else{
                      newS.push(ogNum);
                      verdict = false;
                  }
              }
            }
        }
        return newS;
    }



    public static void main(String[] args) {

        /*String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);*/
        Stackk ogS = new Stackk();
        ogS.push(21);
        ogS.push(100);
        ogS.push(250);
        ogS.push(15);
        ogS.push(-1);

        ogS.printStack();

        ogS = sortStack(ogS);
        System.out.println("Sorted Stack");
        ogS.printStack();


        //ogS.printStack();


        /*
            EXPECTED OUTPUT:
            ----------------
            olleh
        */

    }

}
