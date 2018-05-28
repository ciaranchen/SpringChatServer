package ChatServer.mapper;

import org.apache.ibatis.annotations.Insert;

public interface RecordsDoubleMapper {
    @Insert("INSERT INTO records_double values(,,)")
    void insertRecord();
}
