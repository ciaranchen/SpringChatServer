package ChatServer.model;

import java.io.Serializable;
import java.util.Date;

public class RecordsDouble implements Serializable {
    private Long id;
    private Long channel;
    private Long sender;
    private String msg;
    private Date stamp;

    public RecordsDouble() {
    }

    public RecordsDouble(Long channel, Long sender, String msg) {
        this.channel = channel;
        this.sender = sender;
        this.msg = msg;
        this.stamp = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getStamp() {
        return stamp;
    }

    public void setStamp(Date stamp) {
        this.stamp = stamp;
    }

    @Override
    public String toString() {
        return "RecordsDouble{" +
                "id=" + id +
                ", channel=" + channel +
                ", sender=" + sender +
                ", msg='" + msg + '\'' +
                ", stamp=" + stamp +
                '}';
    }
}
