package ChatServer.model;

import java.io.Serializable;

public class RecordsRoom implements Serializable {
    private Long id;
    private ChatRooms room;
    private ChatUsers user;
    private String msg;

    public RecordsRoom() {
    }

    public RecordsRoom(ChatRooms room, ChatUsers user, String msg) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChatUsers getUser() {
        return user;
    }

    public void setUser(ChatUsers user) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
