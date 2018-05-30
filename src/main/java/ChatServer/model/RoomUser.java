package ChatServer.model;

import java.io.Serializable;

public class RoomUser implements Serializable {
    private java.lang.Long id;
    private Long room;
    private java.lang.Long user;

    public RoomUser() {
    }

    public RoomUser(Long room, java.lang.Long user) {
        this.room = room;
        this.user = user;
    }

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long room) {
        this.room = room;
    }

    public java.lang.Long getUser() {
        return user;
    }

    public void setUser(java.lang.Long user) {
        this.user = user;
    }
}
