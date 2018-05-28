package ChatServer.web;

import ChatServer.mapper.UserMapper;
import ChatServer.model.RecordsDouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoubleChatHTTPController {
    @RequestMapping("/http/double/record")
    public List<RecordsDouble> queryRecord(
            @RequestParam("user1") Long user1,
            @RequestParam("user2") Long user2) {
        // todo: finish it
        return null;
    }
}
