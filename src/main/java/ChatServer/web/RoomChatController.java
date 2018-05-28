package ChatServer.web;


import ChatServer.mapper.RecordsDoubleMapper;
import ChatServer.message.RoomChatMsg;
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
    private RecordsDoubleMapper recordsDoubleMapper;

//    @Autowired private ProfanityChecker profanityFilter;
//
//    @Autowired private SessionProfanity profanity;

    @MessageMapping("/room/send")
    public void roomChatMessage(RoomChatMsg msg) throws Exception {
        System.out.println(msg);
        // todo: save this msg to database;
        simpMessagingTemplate.convertAndSend("/room/recv/" + msg.getRoom(), msg);
    }
}
