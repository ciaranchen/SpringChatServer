package ChatServer.mapper;

/**
 * Created by 1 on 2018/4/18 下午4:13.
 */

import ChatServer.Entity.ChatUsersEntity;
import ChatServer.Entity.DoubleChannelEntity;
import ChatServer.model.ChatRooms;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("SELECT id FROM chat_users WHERE username=#{username} and password=#{password}")
    @Results({
            @Result(property = "id", column = "id")
    })
    Long login(@Param("username") String username, @Param("password") String password);

    @Select("select t.id as cid, uid, username from (" +
            "select id, user2 as uid from double_chats where user1 = #{id} " +
            "union " +
            "select id, user1 as uid from double_chats where user2 = #{id} " +
            ") left outer join chat_users as c on c.id = uid")
    @Results({
            @Result(property = "cid", column = "cid"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "username", column = "username")
    })
    List<DoubleChannelEntity> queryRelationship(@Param("id") Long id);

    @Select("SELECT chat_rooms.id, name, owner FROM room_user LEFT OUTER JOIN chat_rooms ON room = chat_rooms.id WHERE user=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "owner", column = "owner")
    })
    List<ChatRooms> queryRoom(@Param("id") Long id);

    // 请注意：这里是有一个SQL注入问题的
    @Select("SELECT id, username FROM chat_users WHERE username LIKE \'%${username}%\'")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username")
    })
    List<ChatUsersEntity> searchName(@Param("username") String username);

    // 请注意：这里是有一个SQL注入问题的
    @Select("SELECT * FROM chat_rooms WHERE name LIKE \'%${username}%\'")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "owner", column = "owner")
    })
    List<ChatRooms> searchRoom(@Param("username") String username);

    @Select("SELECT avatar FROM chat_users WHERE id=#{id}")
    String getAvatar(@Param("id") Long id);

    @Update("UPDATE chat_users SET avatar=#{filename} WHERE id=#{id}")
    void updateAvatar(@Param("id") Long id, @Param("filename") String filename);
}