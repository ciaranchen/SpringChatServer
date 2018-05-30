package ChatServer.mapper;

import ChatServer.model.RecordsRoom;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 2018/5/30 10:13.
 */
public interface RecordsRoomMapper {
    @Insert("INSERT INTO records_room(room, user, msg, stamp) VALUES(#{room}, #{user}, #{msg}, #{stamp})")
    void insertRecord(RecordsRoom recordsDouble);

    @Select("select * from records_double where channel=#{cid} ORDER BY(stamp) DESC LIMIT 20 OFFSET #{offset}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "room", column = "room"),
            @Result(property = "user", column = "user"),
            @Result(property = "msg", column = "msg"),
            @Result(property = "stamp", column = "stamp", javaType = Date.class)
    })
    List<RecordsRoom> queryRecord(@Param("cid") Long cid, @Param("offset") Long offset);
}
