package createpatters.prototype;

public class WelcomeEmail implements EmailTemplate{

    private String subject;
    private String content;

    public WelcomeEmail(){
        this.subject = "Welcome to TUF+";
        this.content = "Hi there! Thanks for joining us";
    }
    @Override
    public EmailTemplate clone() {
        try {
            return (WelcomeEmail) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException("Clone Failed" , e);
        }
    }

    @Override
    public void setContent(String content) {
        this.content = content;

    }

    @Override
    public void send(String to) {
        System.out.println("Sending to " + to + ": [" + subject + "] " + content);
    }
}
