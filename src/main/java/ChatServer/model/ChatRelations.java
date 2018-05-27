package ChatServer.model;

import java.io.Serializable;

public class ChatRelations implements Serializable {
    private Long id;
    private ChatUsers user1;
    private ChatUsers user2;

    // ========================

    public ChatRelations() {
    }

    public ChatRelations(ChatUsers user1, ChatUsers user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChatUsers getUser1() {
        return user1;
    }

    public void setUser1(ChatUsers user1) {
        this.user1 = user1;
    }

    public ChatUsers getUser2() {
        return user2;
    }

    public void setUser2(ChatUsers user2) {
        this.user2 = user2;
    }
}