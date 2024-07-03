// Define the Node class
class Node {
    String data;
    Node next;

    public Node(String number)
    {
        this.data = number;
        this.next = null;
    }
}

// Define a LinkedList class to encapsulate operations
public class LinkedList {
    // Function to traverse and print the elements of the
    // linked list
    public static void traverseLinkedList(Node head)
    {
        // Start from the head of the linked list
        Node current = head;

        // Traverse the linked list until reaching the end
        // (null)
        while (current != null) {
            // Print the data of the current node
            System.out.print(current.data + " ");

            // Move to the next node
            current = current.next;
        }

        System.out.println();
    }

    // Main method for example usage
    public static void main(String[] args)
    {
        // Create nodes
        Node head = new Node("1");
        Node second = new Node("2");
        Node third = new Node("3");
        Node fourth = new Node("4");
        Node fifth = new Node("5");
        Node sixth = new Node("6");
        Node seventh = new Node("7");
        Node eighth = new Node("8");
        Node ninth = new Node("9");

        String prev = null;
        String current =


        // Connect nodes
        while(head.next != null){

        }

        // Call the traverseLinkedList function to print the
        // linked list elements
        traverseLinkedList(head);
    }
}