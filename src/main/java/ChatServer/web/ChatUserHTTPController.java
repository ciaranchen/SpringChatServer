package ChatServer.web;

import ChatServer.Entity.ChatUsersEntity;
import ChatServer.Entity.DoubleChannelEntity;
import ChatServer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@RestController
public class ChatUserHTTPController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/http/user/login")
    public java.lang.Long login(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        System.out.println("login");
        return userMapper.login(username, password);
    }

    @RequestMapping("/http/user/relationship")
    public List<DoubleChannelEntity> queryRelationship(
            @RequestParam("user") java.lang.Long id
    ) {
        return userMapper.queryRelationship(id);
    }

    @RequestMapping("/http/user/room")
    public List<Long> queryRoom(
            @RequestParam("user") java.lang.Long id
    ) {
        return userMapper.queryRoom(id);
    }

    @RequestMapping("/http/user/setting")
    public Long getSetting() {
        return 1L;
    }

    @RequestMapping("/http/user/searchName")
    public ChatUsersEntity searchName(
            @RequestParam("username") String name
    ) {
        return userMapper.searchName(name);
    }

    @RequestMapping(value="/http/user/upload",method = RequestMethod.POST)
    @ResponseBody
    public int uploadAvatar(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String filePath = "upload/" + file.getOriginalFilename();
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(filePath)));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return 1;
            } catch (IOException e) {
                e.printStackTrace();
                return 1;
            }
            return 0;
        } else {
            return 0;
        }
    }



}
