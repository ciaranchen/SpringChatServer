package ChatServer.model;

import java.io.Serializable;

public class ChatSettings implements Serializable {
    private Long id;
    // something front end settings;


    public ChatSettings() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}