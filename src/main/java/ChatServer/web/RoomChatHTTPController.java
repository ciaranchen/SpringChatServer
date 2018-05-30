package ChatServer.web;

import ChatServer.Entity.ChatUsersEntity;
import ChatServer.mapper.RecordsRoomMapper;
import ChatServer.model.ChatRooms;
import ChatServer.model.RecordsRoom;
import ChatServer.model.RoomUser;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
            @RequestParam("room") Long room
    ) {
        System.out.println(room);
        return recordsRoomMapper.queryRecord(room, 0L);
    }

    @RequestMapping("/http/room/record_offset")
    public List<RecordsRoom> offsetQueryRecord(
            @RequestParam("room") Long room,
            @RequestParam("offset") Long offset) {
        return recordsRoomMapper.queryRecord(room, offset);
    }

    @RequestMapping("/http/room/create")
    @Transactional(propagation = Propagation.REQUIRED)
    public Long createRoom(
            @RequestParam("user") Long user,
            @RequestParam("name") String name
    ) {
        ChatRooms rooms = new ChatRooms(name, user);
        recordsRoomMapper.createRoom(rooms);
        // the id of the room that we create
        Long rid = recordsRoomMapper.lastRoom();
        // insert the owner into room;
        recordsRoomMapper.addUser(new RoomUser(rid, user));
        return rid;
    }

    @RequestMapping("/http/room/add")
    public Long addUser(
            @RequestParam("room") Long room,
            @RequestParam("user") Long user
    ) {
        recordsRoomMapper.addUser(new RoomUser(room, user));
        return 0L;
    }

    @RequestMapping("/http/room/users")
    public List<ChatUsersEntity> addUser(
            @RequestParam("room") Long room
    ) {
        return recordsRoomMapper.getAllUsers(room);
    }

    @RequestMapping("/http/room/kick")
    public int kickUser(
            @RequestParam("room") Long room,
            @RequestParam("user") Long user
    ) {
        recordsRoomMapper.removeRoomUser(room, user);
        return 0;
    }
}
