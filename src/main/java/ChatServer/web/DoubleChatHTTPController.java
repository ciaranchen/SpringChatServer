package ChatServer.web;

import ChatServer.mapper.RecordsDoubleMapper;
import ChatServer.mapper.UserMapper;
import ChatServer.model.ChatDoubles;
import ChatServer.model.RecordsDouble;
import org.apache.ibatis.annotations.Param;
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
public class DoubleChatHTTPController {
    @Autowired
    private RecordsDoubleMapper recordsDoubleMapper;

    @RequestMapping("/http/double/record")
    public List<RecordsDouble> queryRecord(
            @RequestParam("cid") Long channel
    ) {
        System.out.println(channel);
        return recordsDoubleMapper.queryRecord(channel, 0L);
    }

    @RequestMapping("/http/double/record_offset")
    public List<RecordsDouble> offsetQueryRecord(
            @RequestParam("cid") Long channel,
            @RequestParam("offset") Long offset) {
        return recordsDoubleMapper.queryRecord(channel, offset);
    }

    @RequestMapping("/http/double/add")
    @Transactional(propagation = Propagation.REQUIRED)
    public Long addFriend(
            @RequestParam("user") Long user,
            @RequestParam("friend") Long friend
    ) {
        ChatDoubles chatDoubles = new ChatDoubles(user, friend);
        recordsDoubleMapper.addFriend(chatDoubles);
        return recordsDoubleMapper.lastFriend();
    }
}
