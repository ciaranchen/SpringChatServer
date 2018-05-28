package ChatServer.model;

import java.io.Serializable;

public class ChatDoubles implements Serializable {
    private java.lang.Long id;
    private Long user1;
    private Long user2;

    // ========================

    public ChatDoubles() {
    }

    public ChatDoubles(Long user1, Long user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public Long getUser1() {
        return user1;
    }

    public void setUser1(Long user1) {
        this.user1 = user1;
    }

    public Long getUser2() {
        return user2;
    }

    public void setUser2(Long user2) {
        this.user2 = user2;
    }
}