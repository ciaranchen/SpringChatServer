package ChatServer.model;

import java.io.Serializable;
import java.util.Date;

public class RecordsDouble implements Serializable {
    private Long id;
    private ChatDoubles channel;
    private String msg;
    private Date stamp;

    public RecordsDouble() {
    }

    public RecordsDouble(ChatDoubles channel, String msg) {
        this.channel = channel;
        this.msg = msg;
        this.stamp = new Date();
        System.out.println(stamp);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChatDoubles getChannel() {
        return channel;
    }

    public void setChannel(ChatDoubles channel) {
        this.channel = channel;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getStamp() {
        return stamp;
    }

    public void setStamp(Date stamp) {
        this.stamp = stamp;
    }
}
