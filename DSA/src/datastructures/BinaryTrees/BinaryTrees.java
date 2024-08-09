package datastructures.BinaryTrees;

public class BinaryTrees {
    private Node root;
    class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
    public Node getRoot(){
        return root;
    }
    public void printRoot(){
        System.out.print("Root : " + root.value);
    }
    public Boolean contains(int value){
        Node current = root;
        while(current != null){
            if(value< current.value){
                current = current.left;
                System.out.println("LEFT");
            }else if(value > current.value){
                current = current.right;
                System.out.println("RIGHT");
            }else{
                System.out.println("FOUND");
                return true;

            }
        }
        return false;
    }
    public Boolean insert(int insertN){
        if(root == null){
            root = new Node(insertN);
            return true;
        }
        Node current = root;

        while(current != null){
            if(insertN < current.value) {
                if (current.left == null) {
                    current.left = new Node(insertN);
                    return true;
                }
                current = current.left;
            } else if(insertN>current.value){
                if(current.right == null) {
                    current.right = new Node(insertN);
                    return true;
                }
                current = current.right;
            }else{
                return false;
            }

        }
        return false;
    }

 /*   public Boolean insert(int insertN){
        Node insertNode = new Node(insertN);
        Node currentNode = root;
        int value = 0;
        if(root == null){
            root = insertNode;
        }
        while((currentNode.left!= null && currentNode.right != null) || value != 0){
            if(insertN < currentNode.value){
                if(currentNode.left == null){
                    currentNode.left = insertNode;
                    value = 1;
                }
                currentNode = currentNode.left;

            }else if(insertN>currentNode.value){
                if(currentNode.right == null){
                    currentNode.right = insertNode;
                    value = 1;
                }
                currentNode = currentNode.right;
            }else{
                if(currentNode.left == null){
                    currentNode.left = insertNode;
                    value = 1;
                }
                currentNode = currentNode.left;
            }
        }

    }*/
}
