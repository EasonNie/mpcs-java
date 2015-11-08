package P8_11;

/**
 * Created by Eason on 10/15/15.
 */
public class Letter {
    private String sender;
    private String receiver;
    private StringBuilder main_text;

    public Letter(String sender, String receiver) {
        this.sender = sender;
        this.receiver = receiver;
        main_text = new StringBuilder();
    }

    public void addLine(String line) {
        main_text.append(line);
        main_text.append("\n");
    }

    public String getText() {
        StringBuilder text = new StringBuilder();
        text.append(this.getHead());
        text.append("\n");
        text.append(this.main_text);
        text.append("\n");
        text.append(this.getTail());
        return text.toString();
    }

    public String getHead() {
        return new String("Dear " + this.receiver + ":\n");
    }

    public String getTail() {
        return new String("Sincerely,\n\n" + sender);
    }
}
