import java.sql.Struct;

public class UserAccount {
    private String email;
    private String userName;
    private Post[] timeline = new Post[10];
    private Post[] posts = new Post[200];
    private UserAccount[] followers = new UserAccount[1000];
    private int idxTimeline = 0;
    private int idxPosts = 0;
    private int idxFollowers = 0;

    public UserAccount(String email, String userName){
        this.email = email;
        this.userName = email;
    }

    public void publish(String quote) {
        Post newPost = new Post(this, quote);

        if (idxPosts < posts.length-1) {
            posts[idxPosts++] = newPost;
            for (UserAccount follower : followers) follower.updateTimeline(newPost);
            return;
        }

        increasePostsSize();
        for (UserAccount follower : followers) follower.updateTimeline(newPost);
        posts[idxPosts++] = newPost;
    }

    private void increasePostsSize() {
        Post[] newPosts = new Post[posts.length * 2];
        newPosts = posts.clone();
        posts = newPosts;
    }

    private void increaseFollowersSize() {
        UserAccount[] newFollowers = new UserAccount[followers.length * 2];
        newFollowers = followers.clone();
        followers = newFollowers;
    }

    public boolean delete(int postIdx) {
        if(posts.length > 0){
            for (int i = posts.length; i >= postIdx; i--) {
                posts[i] = posts[i - 1];
            }
            idxPosts--;
            return true;
        }
        return false;
    }

    private StringBuilder appendPosts(StringBuilder builder, Post[] array){
        for (Post post : array) builder.append("\n").append(post.show());
        return builder;
    }

    public String showTimeline() {
        StringBuilder convertedTimeline = new StringBuilder();
        convertedTimeline = appendPosts(convertedTimeline, timeline);

        return convertedTimeline.toString();
    }

    public String showMyPosts() {
        StringBuilder convertedPosts = new StringBuilder();
        convertedPosts = appendPosts(convertedPosts, posts);

        return convertedPosts.toString();
    }

    public String showMyFriends() {
        StringBuilder followersList = new StringBuilder();
        for (UserAccount follower : followers) followersList.append("\n").append(follower.userName);

        return followersList.toString();
    }

    public void clapPost(int postIdx) {
        posts[postIdx].clap();
    }

    public void booPost(int postIdx) {
        posts[postIdx].boo();
    }

    public void updateTimeline(Post newPost) {
        if (idxTimeline < timeline.length-1){
            timeline[idxTimeline++] = newPost;
        } else {
            for (int i = 0; i < timeline.length-1; i++) {
                timeline[i+1] = timeline[i];
            }
            timeline[0] = newPost;
            idxTimeline--;
        }
    }

    public void acceptFollower(UserAccount newFollower) {
        if (idxFollowers < followers.length-1){
            followers[idxFollowers++] = newFollower;
            return;
        }
        increaseFollowersSize();
        followers[idxFollowers++] = newFollower;
    }

    public void blockFollower(UserAccount newFollower) {
        int followerIdx = -1;

        for(int i = 0; i < this.idxFollowers; i++){
            if (this.followers[i].equals(newFollower)){
                followerIdx = i;
                break;
            }
        }

        if (followerIdx == -1) return;;

        for (int i = followers.length; i >= followerIdx; i--) {
            followers[i] = followers[i - 1];
        }

        idxFollowers--;
    }

    public String getUserName() {
        return userName;
    }
}
