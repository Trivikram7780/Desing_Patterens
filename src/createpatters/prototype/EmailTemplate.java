package createpatters.prototype;

public interface EmailTemplate extends Cloneable{
    EmailTemplate clone();
    void setContent(String content);
    void send(String to);

}
