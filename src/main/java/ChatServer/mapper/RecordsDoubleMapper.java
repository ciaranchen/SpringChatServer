package ChatServer.mapper;

import ChatServer.model.RecordsDouble;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RecordsDoubleMapper {
    @Insert("INSERT INTO records_double(channel, msg, stamp) VALUES(#{room}, #{msg}, #{stamp})")
    void insertRecord(RecordsDouble recordsDouble);

//    select * from records_double LEFT OUTER JOIN double_chats ON channel=double_chats.id where ( user1 = 1 AND user2 = 2 ) or (user1 = 2 AND user1 = 2);
//    @Select("")
//    @Results({
//            @Result()
//    })
//    List<RecordsDouble> queryRecord();
}
