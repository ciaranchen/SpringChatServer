package ChatServer.mapper;

import ChatServer.model.ChatDoubles;
import ChatServer.model.RecordsDouble;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface RecordsDoubleMapper {
    @Insert("INSERT INTO records_double(channel, sender, msg, stamp) VALUES(#{channel}, #{sender}, #{msg}, #{stamp})")
    void insertRecord(RecordsDouble recordsDouble);

    @Select("select * from records_double where channel=#{cid} ORDER BY(stamp) DESC LIMIT 20 OFFSET #{offset}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "channel", column = "channel"),
            @Result(property = "sender", column = "sender"),
            @Result(property = "msg", column = "msg"),
            @Result(property = "stamp", column = "stamp", javaType = Date.class)
    })
    List<RecordsDouble> queryRecord(@Param("cid") Long cid, @Param("offset") Long offset);

    @Insert("INSERT INTO chat_doubles(user1, user2) VALUES(#{user1}, #{user2})")
    void addFriend(ChatDoubles doubles);

    @Select("select last_insert_rowid() from chat_doubles LIMIT 1")
    Long lastFriend();
}