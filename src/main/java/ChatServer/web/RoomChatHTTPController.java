package ChatServer.web;

import ChatServer.mapper.RecordsRoomMapper;
import ChatServer.model.RecordsRoom;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AutoConfigureMybatis
public class RoomChatHTTPController {
    @Autowired
    private RecordsRoomMapper recordsRoomMapper;

    @RequestMapping("/http/room/record")
    public List<RecordsRoom> queryRecord(
            @RequestParam("room") Long room) {
        return recordsRoomMapper.queryRecord(room, 0L);
    }

    @RequestMapping("/http/room/record_offset")
    public List<RecordsRoom> offsetQueryRecord(
            @RequestParam("room") Long room,
            @RequestParam("offset") Long offset) {
        return recordsRoomMapper.queryRecord(room, offset);
    }
}
