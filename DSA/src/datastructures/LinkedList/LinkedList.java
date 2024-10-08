package datastructures.LinkedList;

import java.util.Stack;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    static class Node {
        int value;
        Node next;
        int index;

        public Node(int value) {
            this.value = value;
            index = 1;
        }

        public int printNode() {
            return value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead1() {
        return head;
    }

    public Node getTail1() {
        return tail;
    }

    public void append(int num) {
        Node append = new Node(num);
        if (length == 0) {
            head = append;
            tail = append;
        } else {
            tail.next = append;
            tail = append;
        }
        length++;
    }


    public void prepend() {

    }


    public boolean insert(int index, int value) {
        return true;
    }


    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public Node removeLast() {
        Node current = head;
        Node removedNode;
        if (length == 0) {
            return null;
        }
        if (current.next == null) {
            removedNode = current;
            current = null;
            head = null;
            tail = null;
            length--;
            return removedNode;
        } else {
            while (current.next != tail) {
                current = current.next;
            }
            removedNode = current.next;
            current.next = null;
            tail = current;
            length--;
            return removedNode;
        }

    }
    public void trial(){
        Node fast = head;
        Node slow = head;
        System.out.println(fast.value + " " + slow.value);
        while(fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            System.out.println(fast.value + " " + slow.value);
            if(fast.next == null){
                break;
            }
        }
    }
    public boolean isPalindrome(Node head) {
        Stack<Integer> newStack = new Stack<>();
        Node slow = head;
        Node fast = head;
        newStack.push(slow.value);
        while(fast.next.next != null){
            fast = fast.next.next;
            if(fast.next == null){
                break;
            }
            slow = slow.next;
            newStack.push(slow.value);
        }
        System.out.println(newStack);
        while(slow.next != null){
            if(slow.next.value != newStack.pop()){
                return false;
            }
            slow = slow.next;
        }
       return true;
    }

    public boolean hasLoop() {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        int i = 1;
        while (fast.next != null && i < 20) {
            fast = fast.next;
            System.out.println(fast.value);
            if (i % 2 == 0) {
                slow = slow.next;
                //System.out.println("Slow :" + slow.value + " Fast: " + fast.value + " i: " + i);
                if (fast == slow) {
                    System.out.println(fast.value + " = " + slow.value);
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    public Node findKthFromEnd(int k) {
        Node fast = head;
        Node slow = head;
        int fastIndex = 1;
        int slowIndex = 1;
        slow = slow.next;
        fast = fast.next;
        if (fast == null) {
            return null;
        }
        while (fast.next != null) {
            if (fastIndex - slowIndex == k - 1) {
                slow = slow.next;
                slowIndex++;
            }
            fast = fast.next;
            fastIndex++;
            System.out.println(fast.value + " " + slow.value);
        }
        System.out.println(fastIndex);
        if (fastIndex < k) {
            return null;
        }
        return slow;
    }
    /*public Node removeRepeatNode(){
        Node slow = head;
        Node prev = new Node(5000);
        Node fast = slow;
        Node current = head;
        prev.next = fast;

        while(current != null){
            System.out.print(current.value + " ");
            current = current.next;
        }

        fast = head;
        System.out.println();
        while(fast.next != null){
            if(slow.value == fast.value){
                removeMiddleNode(prev, fast);
                fast = fast.next;
            }else {
                fast = fast.next;
                prev = prev.next;
            }
            System.out.println("Fast: " + fast.value + " Prev: " + prev.value + " Slow: " + slow.value);
        }
        System.out.println("Fast: " + fast.value + " Prev: " + prev.value + " Slow: " + slow.value);
        if(fast.value == slow.value){
            prev.next = null;
        }

        Node curr = head;

        System.out.println();

        while(curr != null){
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        return head;

    }
    public void removeMiddleNode(Node prev, Node current){
        prev.next = current.next;
    }*/
    public void removeRepeats(){
        Node slow = head;
        Node fast;
        while(slow != null) {
            fast = slow.next;
            while (fast != null) {
                if(fast.value == slow.value){
                    fast.index = 0;
                    System.out.println();
                    System.out.println("Fast: " + fast.value + " Slow: " + slow.value + " Index: " + fast.index);
                }
                System.out.print(fast.value + " ");
                fast = fast.next;
            }
            System.out.println();
            slow = slow.next;

        }
        fast = head;
        Node add = head;

        while(fast != null){
            if(fast.index == 1){
                System.out.print(fast.value + " ");
                add = fast;

                add = add.next;
            }
            fast = fast.next;
        }
        add = head;
        System.out.println();
        while(add != null){
            System.out.print(add.value + " ");
            add = add.next;
        }


    }
    public void partitiionList2(int x){
        Node part1 = head;
        Node part2 = new Node(0);
        Node prevForPart1 = new Node(20);
        Node traversal = null;
        prevForPart1.next = head;
        int i = 0;
        while(part1.next != null){
            if(part1.value<x){
                Node temp = part1.next;
                prevForPart1.next = part1.next;
                if(i == 0){
                    part2 = new Node(part1.value);
                    traversal = part2;
                }else{
                    part2.next = new Node(part1.value);
                    traversal = traversal.next;
                }
                i++;
            }else {
                prevForPart1 = prevForPart1.next;
                part1 = part1.next;
            }

        }
    }


    public void partitionList(int x) {
        Node slow = head;
        Node fast = head;
        Node prev = new Node(20);
        Node prevLocation = prev;
        Node temp;
        Node fastLocation;
        prev.next = head;
        int i = 0;
        Node end;
        while ((fast.next != null)) {
            if (fast.value < x && prev != prevLocation) {
                System.out.println("0: " + prev.value);
                fastLocation = fast.next;
                prev.next = fast.next;
                temp = slow.next;
                slow.next = fast;
                fast.next = temp;
                slow = slow.next;
                fast = fastLocation;
                end = prev;
                //prev = prev.next;
                System.out.println("1: " + prev.value);
            }else {
                prev = prev.next;
                fast = fast.next;
                System.out.println("2: " + prev.value);
            }
            printList();
            System.out.println();
            System.out.println("Info: " + prev.value + " " + fast.value);
            i++;
        }
        if(fast.value < x){
            prev.next = null;
            fast.next = slow.next;
            slow.next = fast;
        }
    }

    public Node getHead() {
        /*if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);*/
        return head;
    }


    public void getTail() {
        if (tail == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length " + length);
    }
}


