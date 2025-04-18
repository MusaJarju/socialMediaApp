import java.util.Date;

public class Post {
    private String content;
    private Date timestamp;
    private int likes = 0;



    public Post(String content) {
        this.content = content;
        this.timestamp = new Date();
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    public void like() {
        likes++;
    }
    
    public int getLikes() {
        return likes;
    }

    @Override
    public String toString() {
        return "\"" + content + "\" (" + timestamp + ")"
     + "  - Likes: " + likes;
    }
    
   
    

    
}
