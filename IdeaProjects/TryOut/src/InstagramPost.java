public class InstagramPost implements Comparable<InstagramPost> {
    private int likes;
    private int comments;
    private User user;

    @Override
    public int compareTo(InstagramPost other) {
        if(likes > other.likes){
            return -1;
        }else if(likes<other.likes){
            return 1;
        }else{
            if(comments > other.comments){
                return -1;
            }else if(comments < other.comments){
                return 1;
            }else{
                if(user.getFollowersCount() > other.user.getFollowersCount()){
                    return -1;
                }else if(user.getFollowersCount() < other.user.getFollowersCount()){
                    return 1;
                }else{
                    if(user.getUsername().charAt(0) > other.user.getUsername().charAt(0)){
                        return -1;
                    }else if(user.getUsername().charAt(0) < other.user.getUsername().charAt(0)){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        }
    }
}
