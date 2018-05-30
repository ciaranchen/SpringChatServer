package ChatServer.message;

public class RoomChatMsg {
    private Long room;
    private Long user;
    private String msg;

    public RoomChatMsg() {
    }

    public RoomChatMsg(Long room, Long user, String msg) {
        this.room = room;
        this.user = user;
        this.msg = msg;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "RoomChatMsg{" +
                "room=" + room +
                ", user=" + user +
                ", msg='" + msg + '\'' +
                '}';
    }
}
