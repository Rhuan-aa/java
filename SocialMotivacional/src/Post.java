import java.time.LocalDate;

public class Post {
    private String quote;
    private LocalDate date;
    private int claps;
    private int boos;
    private UserAccount user;

    public Post(UserAccount account, String quote){
        this.user = account;
        this.quote = quote;
        this.date = LocalDate.now();
        this.claps = 0;
        this.boos = 0;
    }

    public String show(){
        StringBuilder postShow = new StringBuilder();

        postShow.append(String.format("[%s] %s\n", date.toString(), user.getUserName()));
        postShow.append(String.format("%s | %s | %s", this.quote, this.claps, this.boos));

        return postShow.toString();
    }

    public void clap(){
        this.claps++;
    }

    public void boo(){
        this.boos++;
    }
}
