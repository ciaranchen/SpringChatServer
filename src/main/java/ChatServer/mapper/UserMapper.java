package ChatServer.mapper;

/**
 * Created by 1 on 2018/4/18 下午4:13.
 */

import ChatServer.Entity.ChatUsersEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
//    @Select("SELECT * FROM chat_users")
//    @Results({
//            @Result(property = "username",  column = "username"),
//            @Result(property = "passwd", column = "passwd"),
//            @Result(property = "id", column = "id"),
//            @Result(property = "setting", column = "setting")
//    })
//    List<Long> getAll();

//    @Select("SELECT * FROM users WHERE id = #{id}")
//    @Results({
//            @Result(property = "username",  column = "username"),
//            @Result(property = "passwd", column = "passwd"),
//            @Result(property = "setting", column = "setting")
//    })
//    Long getOne(Long id);
//
//    @Insert("INSERT INTO users(userName, passWord, setting) VALUES(#{username}, #{passWord}, #{setting})")
//    void insert(Long user);
//
//    @Update("UPDATE users SET userName=#{username},nick_name=#{nickName} WHERE id =#{id}")
//    void update(Long user);
//
//    @Delete("DELETE FROM users WHERE id =#{id}")
//    void delete(Long id);

    @Select("SELECT id FROM chat_users WHERE username=#{username} and password=#{password}")
    @Results({
            @Result(property = "id", column = "id")
    })
    java.lang.Long login(@Param("username") String username, @Param("password") String password);


//    select t.id as channel_id, uid, username from (select id, user2 as uid from double_chats where user1 = 1 union select id, user1 as uid from double_chats where user2 = 1) as t left outer join chat_users as c on c.id = uid;
    @Select("SELECT user2, username FROM double_chats LEFT OUTER JOIN chat_users as c2 ON c2.id = user2 where user1 = #{id}")
    @Results({
            @Result(property = "id", column = "user2"),
            @Result(property = "username", column = "username")
    })
    List<ChatUsersEntity> queryRelationship(@Param("id") java.lang.Long id);

    @Select("SELECT chat_rooms.id, name, owner FROM room_user LEFT OUTER JOIN chat_rooms ON room = chat_rooms.id WHERE user=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "owner", column = "owner")
    })
    List<Long> queryRoom(@Param("id") java.lang.Long id);
}