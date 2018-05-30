package ChatServer.Entity;

import java.io.Serializable;

/**
 * Created by 1 on 2018/5/30 18:22.
 */
public class DoubleChannelEntity implements Serializable {
    private Long cid;
    private Long uid;
    private String username;

    public DoubleChannelEntity(Long cid, Long uid, String username) {
        this.cid = cid;
        this.uid = uid;
        this.username = username;
    }

    public DoubleChannelEntity() {
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "DoubleChannelEntity{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                '}';
    }
}
