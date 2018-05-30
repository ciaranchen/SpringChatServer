package ChatServer.web;

import ChatServer.Entity.ChatUsersEntity;
import ChatServer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatUserHTTPController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/http/user/login")
    public java.lang.Long login(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password) {
        System.out.println("login");
        return userMapper.login(username, password);
    }

    @RequestMapping("/http/user/relationship")
    public List<ChatUsersEntity> queryRelationship(@RequestParam(value="user") java.lang.Long id) {
        return userMapper.queryRelationship(id);
    }

    @RequestMapping("/http/user/room")
    public List<Long> queryRoom(@RequestParam(value="user") java.lang.Long id) {
        return userMapper.queryRoom(id);
    }

    @RequestMapping("/http/user/addFriend")
    public int addFriend() {
        // todo: insert record to double chat.
        return 0;
    }

    public int deleteFriend() {
        // todo: delete record from double chat.
        // todo: delete all chatting record of this double chatting.
        return 0;
    }

    public int getSetting() {
        // todo: get setting.
        return 1;
    }
}
