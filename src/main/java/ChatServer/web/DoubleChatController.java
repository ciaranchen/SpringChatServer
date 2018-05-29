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
        // todo: save this msg to database;
//        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        RecordsDouble recordsDouble = new RecordsDouble();
        recordsDoubleMapper.insertRecord(recordsDouble);


        simpMessagingTemplate.convertAndSend("/recv/" + msg.getTo(), msg);
    }


}
