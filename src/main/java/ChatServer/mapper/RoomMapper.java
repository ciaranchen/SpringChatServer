package ChatServer.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface RoomMapper {
    @Select("select * from chat_rooms where id = #{id}")
    @Results(
            @Result(property = "name", column = "name")
    )
    Long searchById(java.lang.Long id);
}
