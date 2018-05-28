package ChatServer.model;

import java.io.Serializable;

public class RecordsRoom implements Serializable {
    private java.lang.Long id;
    private ChatRooms room;
    private Long user;
    private String msg;

    public RecordsRoom() {
    }

    public RecordsRoom(ChatRooms room, Long user, String msg) {
        this.room = room;
        this.user = user;
        this.msg = msg;
    }

    public ChatRooms getRoom() {
        return room;
    }

    public void setRoom(ChatRooms room) {
        this.room = room;
    }

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
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
}
