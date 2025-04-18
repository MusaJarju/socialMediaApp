import java.util.*;

public class User {
    private String username;
    private List<Post> posts;
    private Set<User> following;
    private Set<User> followers;

    public User(String username) {
        this.username = username;
        this.posts = new ArrayList<>();
        this.following = new HashSet<>();
        this.followers = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void createPost(String content) {
        posts.add(new Post(content));
        System.out.println("Post created!");
        System.out.println("Total posts: " + posts.size());

    }

    public List<Post> getPosts() {
        return posts;
    }

    public void follow(User other) {
        if (other == this) {
            System.out.println("You can't follow yourself!");
            return;
        }
        if (following.add(other)) {
            other.followers.add(this);
            System.out.println("You are now following " + other.getUsername());
        } else {
            System.out.println("You are already following " + other.getUsername());
        }
    }

    public void showFeed() {
        System.out.println("---- " + username + "'s Feed ----");
    
        // Show your own posts
        for (Post post : posts) {
            System.out.println(username + ": " + post);
        }
    
        // Show posts from users you follow
        for (User user : following) {
            for (Post post : user.getPosts()) {
                System.out.println(user.getUsername() + ": " + post);
            }
        }
    }
    

    @Override
    public String toString() {
        return username + " (Followers: " + followers.size() + ", Following: " + following.size() + ")";
    }
}
