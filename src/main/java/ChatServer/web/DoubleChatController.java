package ChatServer.web;

import ChatServer.mapper.RecordsDoubleMapper;
import ChatServer.message.DoubleChatMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;

@Controller
@AutoConfigureMybatis
public class DoubleChatController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private RecordsDoubleMapper recordsDoubleMapper;

//    @Autowired private ProfanityChecker profanityFilter;
//
//    @Autowired private SessionProfanity profanity;

    @MessageMapping("/send")
    public void doubleChatMessage(DoubleChatMsg msg) throws Exception {
        System.out.println(msg);
        // save this msg to database;

        simpMessagingTemplate.convertAndSend("/recv/" + msg.getTo(), msg);
    }


}
