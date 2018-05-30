package ChatServer.mapper;

/**
 * Created by 1 on 2018/4/18 下午4:13.
 */

import ChatServer.Entity.ChatUsersEntity;
import ChatServer.Entity.DoubleChannelEntity;
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
    List<Long> queryRoom(@Param("id") Long id);

    // 请注意：这里是有一个SQL注入问题的
    @Select("SELECT id, username FROM chat_users WHERE username=\'%${username}%\'")
    ChatUsersEntity searchName(@Param("username") String username);
}