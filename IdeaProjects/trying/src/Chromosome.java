import java.util.*;
public class Chromosome extends DNA implements Comparable<Chromosome>{
    private Map<String, String> allGenes;
    private int chromosomeNumber;
    public Chromosome(int chromosomeNumber,String DNAsequence, String source){
        super(DNAsequence, source);
        this.chromosomeNumber = chromosomeNumber;
        this.allGenes = new HashMap<>();
    }

    public void discoverGene(String sequence, String geneName){
        allGenes.put(sequence, geneName);
    }

    public int genesDiscovers(){
        return allGenes.size();
    }

    public double averageGeneLength(){
        int sum = 0;
        for(String geneName: allGenes.keySet()){
            sum += geneName.length();
        }
        return (double)sum/allGenes.size();
    }
    @Override
    public int compareTo(Chromosome other) {
        if(this.allGenes.size() != other.allGenes.size()){
            if(this.allGenes.size() > other.allGenes.size()){
                return -1;
            }else{
                return 1;
            }
        }else if(this.averageGeneLength() != other.averageGeneLength()){
            if(this.averageGeneLength() > other.averageGeneLength()){
                return -1;
            }else{
                return 1;
            }
        }else{
            if(chromosomeNumber > other.chromosomeNumber){
                return -1;
            }else{
                return 1;
            }
        }
    }
}
