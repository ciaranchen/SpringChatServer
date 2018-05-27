package ChatServer.model;

import java.io.Serializable;

public class RoomUser implements Serializable {
    private Long id;
    private ChatRooms room;
    private ChatUsers user;

    public RoomUser() {
    }

    public RoomUser(ChatRooms room, ChatUsers user) {
        this.room = room;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChatRooms getRoom() {
        return room;
    }

    public void setRoom(ChatRooms room) {
        this.room = room;
    }

    public ChatUsers getUser() {
        return user;
    }

    public void setUser(ChatUsers user) {
        this.user = user;
    }
}
