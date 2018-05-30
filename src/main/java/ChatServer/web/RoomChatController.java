package ChatServer.web;


import ChatServer.mapper.RecordsDoubleMapper;
import ChatServer.mapper.RecordsRoomMapper;
import ChatServer.message.RoomChatMsg;
import ChatServer.model.RecordsRoom;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@AutoConfigureMybatis
public class RoomChatController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private RecordsRoomMapper recordsRoomMapper;

    @MessageMapping("/room/send")
    public void roomChatMessage(RoomChatMsg msg) throws Exception {
        System.out.println(msg);
        RecordsRoom recordsRoom = new RecordsRoom(msg.getRoom(), msg.getUser(), msg.getMsg());
        System.out.println(recordsRoom);
        recordsRoomMapper.insertRecord(recordsRoom);
        simpMessagingTemplate.convertAndSend("/room/recv/" + msg.getRoom(), msg);
    }
}
