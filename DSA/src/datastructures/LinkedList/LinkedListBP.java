package datastructures.LinkedList;

public class LinkedListBP {
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
        }
        public LinkedListBP(int value) {
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            length = 1;
        }
        public int binaryToDecimal(){
            int num = 0;
            Node current = head;
            int count = 0;
            while(current != null){
                count++;
                current = current.next;
            }
            current = head;
            while(current != null){
                num +=
            }

            return num;
        }
}


