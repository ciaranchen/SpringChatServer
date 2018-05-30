package ChatServer.model;

import java.io.Serializable;
import java.util.Date;

public class RecordsRoom implements Serializable {
    private Long id;
    private Long room;
    private Long user;
    private String msg;
    private Date stamp;

    public RecordsRoom() {
    }

    public RecordsRoom(Long room, Long user, String msg) {
        this.room = room;
        this.user = user;
        this.msg = msg;
        this.stamp = new Date();
    }

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long room) {
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "RecordsRoom{" +
                "id=" + id +
                ", room=" + room +
                ", user=" + user +
                ", msg='" + msg + '\'' +
                ", stamp=" + stamp +
                '}';
    }
}
