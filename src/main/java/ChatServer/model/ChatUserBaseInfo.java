package ChatServer.model;

import java.io.Serializable;

public class ChatUserBaseInfo implements Serializable {
    private Long id;
    private String username;

    public ChatUserBaseInfo(String username) {
        this.username = username;
    }

    public ChatUserBaseInfo() {
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
