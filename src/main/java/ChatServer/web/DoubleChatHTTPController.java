package ChatServer.web;

import ChatServer.mapper.RecordsDoubleMapper;
import ChatServer.mapper.UserMapper;
import ChatServer.model.RecordsDouble;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
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
            @RequestParam("cid") Long channel) {
        System.out.println(channel);
        return recordsDoubleMapper.queryRecord(channel, 0L);
    }

    @RequestMapping("/http/double/record_offset")
    public List<RecordsDouble> offsetQueryRecord(
            @RequestParam("cid") Long channel,
            @RequestParam("offset") Long offset) {
        return recordsDoubleMapper.queryRecord(channel, offset);
    }
}
