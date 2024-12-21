import java.util.*;
import java.io.*;

/*
Class Explanation: This class is a classification tree used for organizing data
                    into categories based on specific criteria. It serves as a tool
                    for classification tasks, allowing for efficient decision-making and
                    organization of data.
*/

public class ClassificationTree extends Classifier {
    // Write your code here...
    private ClassificationTreeNode overallRoot;


    /*
    Behavior: Constructs a ClassificationTree from a Scanner input.
              The input should contain lines with "Feature:" followed by the feature name
              and threshold.And lines should be in pre-order traversal order of the tree.
    Exceptions: if the tree is still empty after the scanner, an
                illegal state exception is thrown
    Returns: Nothing
    Parameters: The Scanner sc, the scanner is assumed to not be null
    */
    public ClassificationTree(Scanner sc){
        overallRoot = createTree(sc);
        if (overallRoot == null) {
            throw new IllegalStateException("The tree is empty");
        }
    }

    /*
    Behavior: uses the scanner to load the tree
    Exceptions: if the tree is still empty after the scanner, an
                illegal state exception is thrown in public method
    Returns: Nothing
    Parameters: The Scanner sc, the scanner is assumed to not be null
    */
    private ClassificationTreeNode createTree(Scanner sc){
        String text = sc.nextLine();
        if(!(text.contains("Feature: "))){
            return new ClassificationTreeNode(text,null);
        }else{
            String feature = text.substring("Feature: ".length());
            double threshold = Double.parseDouble(sc.nextLine().substring("Threshold: ".length()));
            return new ClassificationTreeNode(new Split(feature, threshold),createTree(sc),
                    createTree(sc));
        }
    }

    /*
    Behavior: Constructs a ClassificationTree from a list of data and corresponding labels.
    Exceptions: if the list of data and the labels are not the same size or data or labels is
                empty, there is a IllegalArgumentException
    Returns: Nothing
    Parameters: A list of data(Classifiable instances) and a lists of labels also both parameters
                should not be passed in as null.
    */
    public ClassificationTree(List<Classifiable> data, List<String> labels) {
        if(data.size() != labels.size() || data.isEmpty()){
            throw new IllegalArgumentException("the size of data and labels are not the same"
                    + " or one of the lists are empty");
        }
        for(int i = 0; i<data.size(); i++){
            overallRoot = createTrainedTree(overallRoot, data.get(i), labels.get(i));
        }
    }

    /*
    Behavior: Creates the tree based off the data and labels creating a decision tree
              that is accurately able to guess the outcome of labels connected to the data.
    Exceptions: if the list of data and the labels are not the same size or data or labels
                is empty, there is a IllegalArgumentException
    Returns: Nothing
    Parameters: A list of data(Classifiable instances) and a lists of labels, and the current
                tree node being traversed
    */
    private ClassificationTreeNode createTrainedTree(ClassificationTreeNode curr,Classifiable data,
                                                     String result){
        if (curr == null) {
            curr = new ClassificationTreeNode(result, data);
        }else if (curr.left == null && curr.right == null) {
            if (!curr.label.equals(result)) {
                // Need to partition
                Split newSplit = data.partition(curr.data);
                ClassificationTreeNode newCurr;
                if (newSplit.evaluate(data)) {
                    // curr belongs on the left
                    newCurr = new ClassificationTreeNode(newSplit,new
                            ClassificationTreeNode(result, data),curr);
                } else {
                    newCurr = new ClassificationTreeNode(newSplit,curr,
                            new ClassificationTreeNode(result, data));
                }
                curr = newCurr;
            }
        } else if (curr.split.evaluate(data)) {
            curr.left = createTrainedTree(curr.left, data, result);
        } else {
            curr.right = createTrainedTree(curr.right, data, result);
        }
        return curr;
    }

    /*
    Behavior: Saves the tree to a PrintStream ps using a pre-order traversal.
              The traversal follows the order: root, left subtree, right
              subtree.
    Exceptions: None
    Returns: None
    Parameters: The PrintStream ps, ps cannot be null
    */
    public void save(PrintStream ps){
        save(ps,overallRoot);
    }

    /*
    Behavior: Saves the tree to a PrintStream using a pre-order traversal.
              The traversal follows the order: root, left subtree, right
              subtree.
    Exceptions: None
    Returns: None, return type is void
    Parameters: The PrintStream ps, that is assumed to not be null, and the
                curr that traverses the tree
    */
    private void save(PrintStream ps, ClassificationTreeNode curr){
        if(curr!=null){
            if(curr.split == null){
                ps.println(curr.label);
            }else{
                ps.println(curr.split.toString());
                save(ps,curr.left);
                save(ps,curr.right);
            }
        }
    }

    /*
    Behavior: checks whether all nodes contain features which apply to the Classifiable
              object: input
    Exceptions: None
    Returns: true, if all nodes have features that apply to the Classifiable object and
             false if all features dont apply to the Classifiable object
    Parameters: The Classifiable object input, it is assumed to not be null
    */
    public boolean canClassify(Classifiable input){
        return canClassify(input,overallRoot);
    }

    /*
    Behavior: checks whether all nodes contain features which apply to the Classifiable
              object: input
    Exceptions: None
    Returns: true, if all nodes have features that apply to the Classifiable object and
             false if all features dont apply to the Classifiable object
    Parameters: The Classifiable object input, it is assumed to not be null, and the curr
                ClassificationTreeNode that traverses the tree
    */
    private boolean canClassify(Classifiable input, ClassificationTreeNode curr){
        if(curr.split == null){
            return true;
        }else{
            return (input.getFeatures().contains(curr.split.getFeature()) &&
                    canClassify(input,curr.left) && canClassify(input,curr.right));
        }
    }

    /*
    Behavior: Classifies a classifiable object based on the tree
    Exceptions: if not all nodes have features that apply to input, there will be an
                illegal argument exception
    Returns: a string which is a label that is most appropriate to the Classifiable object
    Parameters: The classifiable input, which is assumed to not be null
    */
    public String classify(Classifiable input){
        if(!canClassify(input)){
            throw new IllegalArgumentException("Not all nodes in the classification tree"
                    + " have features in input");
        }
        return classify(input,overallRoot);
    }

    /*
    Behavior: Classifies a classifiable object based on the tree
    Exceptions: None
    Returns: a string which is a label that is most appropriate to the Classifiable object
    Parameters: The classifiable input, which is assumed to not be null and the current node
                for the tree being traversed
    */
    private String classify(Classifiable input, ClassificationTreeNode curr){
        if(curr.left == null && curr.right == null){
            return curr.label;
        }else {
            if (curr.split.evaluate(input)) {
                return classify(input, curr.left);
            } else {
                return classify(input, curr.right);
            }
        }
    }


    /*
    Behavior: It represents the building blocks of the classification tree, serving as both
              intermediary and leaf nodes.
    */
    private static class ClassificationTreeNode {
        private String label;
        private Split split;
        private Classifiable data;
        private ClassificationTreeNode left;
        private ClassificationTreeNode right;


        /*
        Behavior: Constructs an node with a split condition and child nodes.
        Exceptions: None
        Returns: None
        Parameters: split the split condition for the node,left the left child node,
                    right the right child node

        */
        public ClassificationTreeNode(Split split,ClassificationTreeNode left,
                                      ClassificationTreeNode right) {
            this.split = split;
            this.left = left;
            this.right = right;
        }

        /*
        Behavior: Constructs leaf node with the classification label
        Exceptions: None
        Returns: None
        Parameters: label of the leaf node
        */
        public ClassificationTreeNode(String label){
            this.label = label;
        }

        /*
        Behavior: Constructs a leaf node with the classification label and data associated
                  with the node
        Exceptions: None
        Returns: None
        Parameters:Label of leaf node and data associated with the constructed node
        */
        public ClassificationTreeNode(String label, Classifiable data){
            this.label = label;
            this.data = data;
        }

    }
}
