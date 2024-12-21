import java.util.*;
public class DNA {
    private String dnaSequence;
    private String source;

    public DNA(String dnaSequence, String source) {
        this.dnaSequence = dnaSequence;
        this.source = source;
    }

    public String getSource(){
        return source;
    }

    public double[] getPercents(){
        return  new double[2];
    }

    public String toString(){
        return "HelloWorld";
    }

}
