package ChatServer.mapper;

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
}