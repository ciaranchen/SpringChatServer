package ChatServer.model;

import java.io.Serializable;

public class RoomUser implements Serializable {
    private java.lang.Long id;
    private ChatRooms room;
    private Long user;

    public RoomUser() {
    }

    public RoomUser(ChatRooms room, Long user) {
        this.room = room;
        this.user = user;
    }

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public ChatRooms getRoom() {
        return room;
    }

    public void setRoom(ChatRooms room) {
        this.room = room;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
