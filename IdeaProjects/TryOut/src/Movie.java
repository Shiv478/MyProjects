public class Movie implements Comparable<Movie>{
    private String title;
    private int rating; // Scale 0 to 10
    private double boxOffice; // Revenue in millions
    private int releaseYear;
    public Movie(String title, int rating, double boxOffice, int releaseYear){
        this.title = title;
        this.rating = rating;
        this.boxOffice = boxOffice;
        this.releaseYear = releaseYear;
    }

    public int compareTo(Movie other){
        if(rating != other.rating){
            return other.rating - rating;
        }else if(boxOffice != other.boxOffice){
            if(boxOffice > other.boxOffice){
                return -1;
            }else if(boxOffice < other.boxOffice){
                return 1;
            }
        }else if(releaseYear != other.releaseYear){
            return releaseYear - other.releaseYear;
        }else if(!(title.equals(other.title))){
            int size = Math.min(title.length(), other.title.length());
            for(int i = 0; i<size; i++){
                if(title.charAt(i) != other.title.charAt(i)){
                    return title.charAt(i) - other.title.charAt(i);
                }
            }
        }
        return 0;
    }
}
