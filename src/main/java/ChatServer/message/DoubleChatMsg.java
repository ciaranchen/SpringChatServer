package ChatServer.message;

public class DoubleChatMsg {
    private Long channel;
    private Long sender;
    private Long to;
    private String msg;

    public DoubleChatMsg() {
    }

    public DoubleChatMsg(Long channel, Long sender, Long to, String msg) {
        this.channel = channel;
        this.sender = sender;
        this.to = to;
        this.msg = msg;
    }

    public DoubleChatMsg(Long channel, Long sender, String msg) {
        this.channel = channel;
        this.sender = sender;
        this.msg = msg;
    }

    public Long getChannel() {
        return channel;
    }

    public void setChannel(Long channel) {
        this.channel = channel;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }
}
