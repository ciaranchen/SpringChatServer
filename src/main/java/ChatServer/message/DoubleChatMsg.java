package ChatServer.message;

public class DoubleChatMsg {
    private Long from;
    private Long to;
    private String content;

    public DoubleChatMsg(Long from, Long to, String content) {
        this.from = from;
        this.content = content;
        this.to = to;
    }

    public DoubleChatMsg() {
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "DoubleChatMsg{" +
                "from=" + from +
                ", to=" + to +
                ", content='" + content + '\'' +
                '}';
    }
}
