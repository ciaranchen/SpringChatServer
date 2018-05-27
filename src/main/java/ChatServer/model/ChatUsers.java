package ChatServer.model;


import java.io.Serializable;

public class ChatUsers implements Serializable {
    private Long id;
    private String username;
    private String passwd;

    private ChatSettings setting;

    public ChatUsers(String username, String passwd, ChatSettings setting) {
        this.username = username;
        this.passwd = passwd;
        this.setting = setting;
    }

    public ChatUsers() {
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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public ChatSettings getSetting() {
        return setting;
    }

    public void setSetting(ChatSettings setting) {
        this.setting = setting;
    }
}
