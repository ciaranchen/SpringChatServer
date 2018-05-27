package ChatServer.mapper;

/**
 * Created by 1 on 2018/4/18 下午4:13.
 */

import ChatServer.model.ChatUserBaseInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
//    @Select("SELECT * FROM chat_users")
//    @Results({
//            @Result(property = "username",  column = "username"),
//            @Result(property = "passwd", column = "passwd"),
//            @Result(property = "id", column = "id"),
//            @Result(property = "setting", column = "setting")
//    })
//    List<ChatUsers> getAll();

//    @Select("SELECT * FROM users WHERE id = #{id}")
//    @Results({
//            @Result(property = "username",  column = "username"),
//            @Result(property = "passwd", column = "passwd"),
//            @Result(property = "setting", column = "setting")
//    })
//    ChatUsers getOne(Long id);
//
//    @Insert("INSERT INTO users(userName, passWord, setting) VALUES(#{username}, #{passWord}, #{setting})")
//    void insert(ChatUsers user);
//
//    @Update("UPDATE users SET userName=#{username},nick_name=#{nickName} WHERE id =#{id}")
//    void update(ChatUsers user);
//
//    @Delete("DELETE FROM users WHERE id =#{id}")
//    void delete(Long id);

//    @Select("SELECT id FROM chat_users WHERE username=#{username} and passwd=#{passwd}")
//    @Result(property = "id", column = "id")
//    Long login(@Param("username") String username, @Param("passwd") String passwd);

    @Select("SELECT id, username FROM users LEFT OUTER JOIN chat_relations ON chat_relations.user1=chat_users.id where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username")
    })
    List<ChatUserBaseInfo> getRelationship(Long id);
}