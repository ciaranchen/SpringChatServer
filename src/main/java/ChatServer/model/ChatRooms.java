package ChatServer.model;

/**
 * Created by 1 on 2018/5/30 18:01.
 */
public class ChatRooms {
    private Long id;
    private String name;
    private Long owner;

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
