public class tryingOutr {

    public static void main(String[] args){
        System.out.println(doubleDigit(323,3));
    }

    public static int doubleDigit(int num, int repeat){
        if(num/10 == 0){
            if(num == repeat){
                return (num * 10 + num);
            }else{
                return num;
            }
        }else if(num%10 == repeat){
            return doubleDigit(num/10,repeat)*100 + repeat * 10 + repeat;
        }else{
            return doubleDigit(num/10,repeat)*10 + num%10;
        }
    }
}
