package ChatServer.mapper;

import ChatServer.Entity.ChatUsersEntity;
import ChatServer.model.ChatRooms;
import ChatServer.model.RecordsRoom;
import ChatServer.model.RoomUser;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 2018/5/30 10:13.
 */
public interface RecordsRoomMapper {
    @Insert("INSERT INTO records_room(room, user, msg, stamp) VALUES(#{room}, #{user}, #{msg}, #{stamp})")
    void insertRecord(RecordsRoom recordsDouble);

    @Select("select * from records_room where room=#{rid} ORDER BY(stamp) DESC LIMIT 20 OFFSET #{offset}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "room", column = "room"),
            @Result(property = "user", column = "user"),
            @Result(property = "msg", column = "msg"),
            @Result(property = "stamp", column = "stamp", javaType = Date.class)
    })
    List<RecordsRoom> queryRecord(@Param("rid") Long rid, @Param("offset") Long offset);

    @Select("SELECT user, username FROM room_user LEFT OUTER JOIN chat_users as c ON c.id = user where room = #{room}")
    @Results({
            @Result(property = "id", column = "user"),
            @Result(property = "username", column = "username")
    })
    List<ChatUsersEntity> getAllUsers(@Param("room") Long room);

    @Insert("INSERT INTO chat_rooms(name, owner) VALUES(#{name}, #{owner})")
    void createRoom(ChatRooms rooms);

    @Select("select last_insert_rowid() from chat_rooms LIMIT 1")
    Long lastRoom();

    @Insert("INSERT INTO room_user(room, user) VALUES(#{room}, #{user})")
    void addUser(RoomUser roomUser);

    @Delete("DELETE FROM room_user WHERE room=#{room} AND user=#{user}")
    void removeRoomUser(@Param("room") Long room, @Param("user") Long user);
}
