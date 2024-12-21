import java.util.*;
public class AdmissionsEntry implements Comparable<AdmissionsEntry> {
    private String id;
    private int numRatings;
    private double ratingSum;
    private Boolean flagResult;
    public AdmissionsEntry(String id){
        this.id = id;
        this.numRatings = 0;
        this.ratingSum = 0;
        this.flagResult = false;
    }

    public void rate(double rating){
        this.ratingSum += rating;
        this.numRatings++;
        if(rating>=4.0){
            flag();
        }
    }
    public void flag(){
        this.flagResult = true;
    }
    public String getId(){
        return this.id;
    }
    public double getRating(){
        if(numRatings == 0){
            return 0;
        }
        return this.ratingSum/this.numRatings;
    }
    public String toString(){
        return getId() + ": " + getRating();
    }

    public int compareTo(AdmissionsEntry other){
        if(this.flagResult != other.flagResult){
            if(this.flagResult){
                return -1;
            }else{
                return 1;
            }
        }
        else if(this.getRating() != other.getRating()) {
            return (int) (other.getRating() - this.getRating());
        }else{
            return id.compareTo(other.id);
        }
    }
}
