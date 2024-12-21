public class BinaryTree {
    Node root;
    private int size = 0;
    class Node{
        Node left;
        Node right;
        int value;
        public Node(int value){
            this.value = value;
        }
    }
    public BinaryTree(int value){
        root = new Node(value);
    }
    public Node insert(int value){
        if(root == null){
            root = new Node(value);
        }else{
            Node current = root;
            Node prev = null;
            Boolean dir = null;
            while(current != null){
                if(current.value > value){
                    prev = current;
                    current = current.left;
                    dir = false;
                }else if(current.value< value){
                    prev = current;
                    current = current.right;
                    dir = true;
                }else{
                    prev = current;
                    current = current.left;
                    dir = false;
                }
            }
            if(dir){
                prev.right = new Node(value);
            }else{
                prev.left = new Node(value);
            }

        }
        return root;
    }

    public Node getNode(int value){
        Node current = root;
        while(current != null){

            if(current.value == value){
                return current;
            }else if(current.value > value){
                System.out.println(current.value);
                current = current.left;
            }else{
                System.out.println(current.value);
                current = current.right;
            }
        }
        return null;
    }

}
