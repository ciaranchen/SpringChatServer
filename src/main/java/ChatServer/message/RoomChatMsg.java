package ChatServer.message;

public class RoomChatMsg {
    private Long room;
    private Long user;
    private String content;

    public RoomChatMsg() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "RoomChatMsg{" +
                "room=" + room +
                ", user=" + user +
                ", content='" + content + '\'' +
                '}';
    }
}
