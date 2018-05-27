package ChatServer.model;

import java.io.Serializable;

public class ChatRooms implements Serializable {
    private Long id;
    private String name;
    private ChatUsers owner;


    // ============= Generic function ===================

    public ChatRooms(String name, ChatUsers owner) {
        this.name = name;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChatUsers getOwner() {
        return owner;
    }

    public void setOwner(ChatUsers owner) {
        this.owner = owner;
    }
}