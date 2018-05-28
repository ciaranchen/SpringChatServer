package ChatServer.model;

import java.io.Serializable;

public class ChatRooms implements Serializable {
    private Long id;
    private Long owner;
    private String name;


    // ============= Generic function ===================

    public ChatRooms(Long id, Long owner, String name) {
        this.id = id;
        this.owner = owner;
        this.name = name;
    }

    public ChatRooms(String name, Long owner) {
        this.name = name;
        this.owner = owner;
    }

    public ChatRooms() {
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

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }
}