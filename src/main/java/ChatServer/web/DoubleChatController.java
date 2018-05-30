package ChatServer.web;

import ChatServer.mapper.RecordsDoubleMapper;
import ChatServer.message.DoubleChatMsg;
import ChatServer.model.RecordsDouble;
import ChatServer.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Controller
@AutoConfigureMybatis
public class DoubleChatController {
    @Autowired
    private RecordsDoubleMapper recordsDoubleMapper;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

//    @Autowired private ProfanityChecker profanityFilter;
//
//    @Autowired private SessionProfanity profanity;

    @MessageMapping("/double/send")
    @Transactional(propagation = Propagation.REQUIRED)
    public void doubleChatMessage(DoubleChatMsg msg) throws Exception {
        System.out.println(msg);
        // insert record into database
        RecordsDouble recordsDouble = new RecordsDouble(
                msg.getChannel(), msg.getSender(), msg.getMsg());
        System.out.println(recordsDouble);
        recordsDoubleMapper.insertRecord(recordsDouble);
        simpMessagingTemplate.convertAndSend("/double/recv/" + msg.getTo(), msg);
    }
}
