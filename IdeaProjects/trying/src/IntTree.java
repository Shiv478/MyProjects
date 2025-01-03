// This class represents a tree of integers.
public class IntTree {
    private static IntTreeNode overallRoot;

    public void completeToLevel(int target) {
        // TODO: Your code here
        this.overallRoot = completeToLevel(overallRoot, target);
    }

    private IntTreeNode completeToLevel(IntTreeNode curr, int target){
        if(target >= 1){
            if(curr == null){
                return new IntTreeNode(-1);
            }else{
                curr.left = completeToLevel(curr.left, target - 1);
                curr.right = completeToLevel(curr.right, target - 1);
                return curr;
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        // Write testing code here!
        IntTree tree = new IntTree("[17 [83 [19 null [48]]] [6 null [87 [75]]]]");
        tree.print(overallRoot);
    }

//////////////////////////////////////////////

    // Constructs a tree with default numbers.
    public IntTree() {
        overallRoot = null;
    }

    public IntTree(String s) {
        overallRoot = fromString(new StringBuilder(s.toLowerCase().trim()));
    }

    public IntTreeNode getRoot() {
        return overallRoot;
    }

    public void setRoot(IntTreeNode root) {
        overallRoot = root;
    }

    // post: Prints the numbers in this tree in a pre-order fashion.
    public void print() {
        print(overallRoot);
    }

    private void print(IntTreeNode root) {
        if(root == null){
            System.out.print(" null");
        }else{
            System.out.print("[");
            System.out.print(root.data);
            System.out.print("[");
            print(root.left);
            System.out.print("] [");
            print(root.right);
            System.out.print("]");
            System.out.print("]");
        }
    }

    public boolean equals(Object o) {
        if (o instanceof IntTree) {
            IntTree other = (IntTree) o;
            return toString().equals(other.toString());
        } else {
            return false;
        }
    }

    // post: Returns a text representation of the tree.
    public String toString() {
        return toString(overallRoot);
    }

    private String toString(IntTreeNode root) {
        if (root == null) {
            return "null";
        } else if (root.left == null && root.right == null) {
            return "[" + root.data + "]";
        } else {
            return "[" + root.data + " "
                    + toString(root.left) + " "
                    + toString(root.right) + "]";
        }
    }

    private IntTreeNode fromString(StringBuilder s) {
        String next = nextToken(s);
        if (next.length() == 0 || next.equals("null") || next.equals("/")) {
            return null;
        } else {
            next = next.substring(1, next.length() - 1).trim();  // remove [] from ends
            StringBuilder nextBuilder = new StringBuilder(next);
            String rootStr  = nextToken(nextBuilder);
            int data = Integer.parseInt(rootStr);
            String leftStr  = nextToken(nextBuilder);
            String rightStr = nextToken(nextBuilder);
            return new IntTreeNode(data,
                    fromString(new StringBuilder(leftStr)),
                    fromString(new StringBuilder(rightStr)));
        }
    }

    // Returns string representation of next complete node or data value from given buffer.
    private String nextToken(StringBuilder s) {
        while (s.indexOf(" ") == 0) {
            s.deleteCharAt(0);
        }
        if (s.length() == 0) {
            return "";
        }

        int i = 0;
        if (s.charAt(0) == '[' || s.charAt(0) == '(') {
            int depth = 0;
            do {
                if (s.charAt(i) == '[' || s.charAt(i) == '(') {
                    depth++;
                } else if (s.charAt(i) == ']' || s.charAt(i) == ')') {
                    depth--;
                }
                i++;
            } while (i < s.length() && depth > 0);
            if (depth > 0) {
                throw new IllegalArgumentException("missing closing bracket in " + s);
            }
        } else {
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
        }

        String result = s.substring(0, i).trim();
        s.delete(0, i);
        while (s.indexOf(" ") == 0) {
            s.deleteCharAt(0);
        }
        return result;
    }

    // Class that represents a single node in the tree.
    private static class IntTreeNode {
        public int data;
        public IntTreeNode left;
        public IntTreeNode right;

        // Constructs a leaf node with the given data.
        public IntTreeNode(int data) {
            this(data, null, null);
        }

        // Constructs a leaf or branch node with the given data and links.
        public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}