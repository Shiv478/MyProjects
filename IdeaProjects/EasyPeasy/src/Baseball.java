import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class Baseball {
    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        Boolean valid = true;
        for(int i = 0; i<operations.length; i++){
            try {
                Integer.parseInt(operations[i]);
                valid = true; ;  // It is a valid integer
            }
            catch (NumberFormatException e) {
                valid = false;  // Not an integer
            }
            if (valid) {
                stack.push(Integer.parseInt(operations[i]));
            }
            else if(operations[i] == "C"){
                stack.pop();
            }else if(operations[i] == "D"){
                stack.push(stack.peek() * 2);
            }else if(operations[i] == "+"){
                int temp = stack.pop();
                int newNum = stack.peek() + temp;
                stack.push(temp);
                stack.push(newNum);
            }
        }
        int sum = 0;
        while(!stack.empty()){
            sum += stack.pop();
        }
        return sum;
    }
    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = s.length() - 1; i>=0; i--){
            if(!stack.isEmpty() && (Math.abs(stack.peek() - s.charAt(i)) == 32)){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        String res = "";
        while(!stack.empty()){
            res += stack.pop();
        }

        return res;
    }
    public static String simplifyPath(String path) {
        int periodCount = 0;
        int slashCount = 1;
        Stack<Character> stack = new Stack<>();
        stack.push('/');
        for(int i = 1; i<path.length(); i++){
            System.out.println(stack.toString());
            if(path.charAt(i) == '/'){
                slashCount++;
                periodCount = 0;
                if(stack.isEmpty()){
                    stack.push(path.charAt(i));
                }
                else if(!(stack.isEmpty()) && (!(stack.peek() == '/')) && !(i == (path.length() -1))){
                    stack.push(path.charAt(i));
                }
            }else if(path.charAt(i) == '.'){
                periodCount++;
                slashCount = 0;
                if((periodCount == 1) && ((i == path.length() - 1) || (path.charAt(i+1) == '/'))){
                    if(periodCount == 1){
                        stack.pop();
                    }
                }
                else if((i != path.length() - 1) && (periodCount == 2) && (path.charAt(i+1) != '.')){
                    stack.pop();
                    stack.pop();

                    while((!(stack.isEmpty()) && !(stack.peek() == '/'))){
                        stack.pop();
                    }
                }else{
                    stack.push(path.charAt(i));
                }
            }else{
                System.out.println(path.charAt(i));
                stack.push(path.charAt(i));
            }
        }
        if(stack.size() > 1 && stack.peek() == '/'){
            stack.pop();
        }
        String word = "";
        while(!stack.isEmpty()){
            word += stack.pop();
        }
        String rev = "";
        for(int i = word.length() - 1; i>=0; i--){
            rev += word.charAt(i);
        }
        return rev;
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<tokens.length; i++){
            int num1 = 0;
            int num2 = 0;
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                num1 = stack.pop();
                num2 = stack.pop();
                if(tokens[i].equals("+")){
                    stack.push(num1 + num2);
                }else if(tokens[i].equals("-")){
                    stack.push(num2 - num1);
                }else if(tokens[i].equals("*")){
                    stack.push(num2 * num1);
                }else if(tokens[i].equals("/")){
                    stack.push(num2 / num1);
                }
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hs = new HashSet<>();
        ListNode current1 = headA;
        ListNode current2 = headB;
        ListNode intersection = null;
        while((current1 != null && current2!=null)){
            if(!hs.contains(current1)){
                hs.add(current1);
                current1 = current1.next;
            }else{
                return current1;
            }
            if(!hs.contains(current2)){
                hs.add(current2);
                current2 = current2.next;
            }else{
                return current2;
            }
        }
        return null;
    }
    public static int removeElement(int[] nums, int val) {
        int reader = 0;
        int writer = 0;
        int count = 0;
        for(; reader<nums.length; reader++){
            if(nums[reader] == val){
                count++;
            }else{
                nums[writer] = nums[reader];
                writer++;
            }
        }
        return nums.length - count;
    }
    public static boolean isIsomorphic(String s, String t) {
        int length = s.length();
        if(s.length() != t.length()){
            return false;
        }else{
            Map<Character, Character> hm = new HashMap<>();
            for(int i = 0; i<length; i++){
                char sChar = s.charAt(i);
                if(hm.containsKey(sChar)){
                    if(hm.get(sChar) != t.charAt(i)){
                        return false;
                    }
                }else{
                    if(hm.containsValue(t.charAt(i))){
                        return false;
                    }
                    hm.put(sChar, t.charAt(i));
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }
}
