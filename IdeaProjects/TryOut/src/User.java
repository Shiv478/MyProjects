import java.util.*;

public class User {
    private String name;
    private String username;
    private Set<User> followers;
    private Set<User> following;

    public String getName(){
        return name;
    }
    public String getUsername(){
        return username;
    }
    public int getFollowersCount(){
        return followers.size();
    }
    public int getFollowingCount(){
        return following.size();
    }

}
