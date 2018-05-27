package ChatServer.web;

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

//    @Autowired private ProfanityChecker profanityFilter;
//
//    @Autowired private SessionProfanity profanity;

//    @MessageMapping("/send/{user_id}")
//    public void sendMessage(@Payload ChatMessage message, @DestinationVariable    ("user_id") String user_id, Principal principal) {
//        simpMessagingTemplate.convertAndSend("/relation_msg/get/" + user_id, ChatMessage);
//    }
//
//    @MessageMapping("/getpass/")
//    public List<SingleMessage> getSingleMessage(Long user_id, Principal principal) {
//        return recordsRelation.getAllMessages(user_id, new Date());
//    }

    @MessageMapping("/send")
    public void doubleChatMessage(DoubleChatMsg msg) throws Exception {
        System.out.println(msg);

        simpMessagingTemplate.convertAndSend("/recv/", msg);
    }


}
