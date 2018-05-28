package ChatServer.mapper;

/**
 * Created by 1 on 2018/4/18 下午4:13.
 */

import ChatServer.Entity.ChatUsersEntity;
import ChatServer.model.ChatRooms;
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

    @Select("SELECT id FROM chat_users WHERE username=#{username} and passwd=#{passwd}")
    @Results({
            @Result(property = "id", column = "id")
    })
    Long login(@Param("username") String username, @Param("passwd") String passwd);

    @Select("SELECT user2, c2.username FROM chat_users as c1 LEFT OUTER JOIN double_chats ON user1=c1.id LEFT OUTER JOIN chat_users as c2 ON c2.id = user2 where c1.id=#{id}")
    @Results({
            @Result(property = "id", column = "user2"),
            @Result(property = "username", column = "username")
    })
    List<ChatUsersEntity> queryRelationship(Long id);

    @Select("SELECT chat_rooms.id, name, owner FROM chat_users LEFT OUTER JOIN room_user ON user=chat_users.id LEFT OUTER JOIN chat_rooms ON room = chat_rooms.id where chat_users.id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "owner", column = "owner")
    })
    List<ChatRooms> queryRoom(Long id);
}