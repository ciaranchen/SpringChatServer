package ChatServer.Entity;

import java.io.Serializable;

public class ChatUsersEntity implements Serializable {
    private Long id;
    private String username;

    public ChatUsersEntity(String username) {
        this.username = username;
    }

    public ChatUsersEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
