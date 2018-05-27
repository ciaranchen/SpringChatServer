package ChatServer.model;

import java.io.Serializable;

public class RecordsRelation implements Serializable {
    private Long id;
    private ChatRelations channel;
    private String msg;

    public RecordsRelation() {
    }

    public RecordsRelation(ChatRelations channel, String msg) {
        this.channel = channel;
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChatRelations getChannel() {
        return channel;
    }

    public void setChannel(ChatRelations channel) {
        this.channel = channel;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
