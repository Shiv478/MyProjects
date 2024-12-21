import java.util.Arrays;

public class testing {
    public static void main(String[] args){
        int[] arr = {1, 1, 1};
        System.out.println(isCantor(arr));
    }

    public static Boolean isCantor(int[] arr){
        int[] actualArr = {1};
        return isCantor(arr,actualArr);
    }
    private static Boolean isCantor(int[] arr,int[] actualArray){
        if(arr.length == actualArray.length){
            int size = arr.length;
            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(actualArray));
            for(int i = 0; i < size; i++){
                if(arr[i] != actualArray[i]){
                    return false;
                }
            }
            return true;
        }else{
            int[] tempArray = new int[actualArray.length*3];
            for(int i = 0; i<actualArray.length; i++){
                for(int j = 0; j<3; j++){
                    if(actualArray[i] == 1 && ((i*3+j) % 2 == 0)){
                        tempArray[i*3+j] = 1;
                    }else {
                        tempArray[i * 3 + j] = 0;
                    }
                }
            }
            return isCantor(arr,tempArray);
        }
    }
}
