package ChatServer.web;

import ChatServer.Entity.ChatUsersEntity;
import ChatServer.mapper.UserMapper;
import ChatServer.model.ChatRooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserHTTPController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/http/user/login")
    public Long login(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password) {
        System.out.println("login");
        return userMapper.login(username, password);
    }

    @RequestMapping("/http/user/relationship")
    public List<ChatUsersEntity> queryRelationship(@RequestParam(value="user") Long id) {
        return userMapper.queryRelationship(id);
    }

    @RequestMapping("/http/user/room")
    public List<ChatRooms> queryRoom(@RequestParam(value="user") Long id) {
        return userMapper.queryRoom(id);
    }
}
