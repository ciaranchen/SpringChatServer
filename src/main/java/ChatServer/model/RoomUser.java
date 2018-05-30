package ChatServer.model;

import java.io.Serializable;

public class RoomUser implements Serializable {
    private Long id;
    private Long room;
    private Long user;

    public RoomUser() {
    }

    public RoomUser(Long room, Long user) {
        this.room = room;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long room) {
        this.room = room;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
