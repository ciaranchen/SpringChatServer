package ChatServer.web;

import ChatServer.Entity.ChatUsersEntity;
import ChatServer.Entity.DoubleChannelEntity;
import ChatServer.mapper.UserMapper;
import ChatServer.model.ChatRooms;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
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
    public List<ChatRooms> queryRoom(
            @RequestParam("user") Long id
    ) {
        return userMapper.queryRoom(id);
    }

    @RequestMapping("/http/user/setting")
    public Long getSetting() {
        return 1L;
    }

    @RequestMapping("/http/user/searchUser")
    public List<ChatUsersEntity> searchName(
            @RequestParam("name") String name
    ) {
        System.out.println(name);
        return userMapper.searchName(name);
    }

    @RequestMapping("/http/user/searchRoom")
    public List<ChatRooms> searchRoom(
            @RequestParam("name") String name
    ) {
        return userMapper.searchRoom(name);
    }

    @RequestMapping(value="/http/user/upload/{id}",method = RequestMethod.POST)
    @ResponseBody
    public int uploadAvatar(
            @PathVariable("id") Long id,
            @RequestParam("file") MultipartFile file
    ) {
        if (!file.isEmpty()) {
            try {
                String filePath = "upload/" + file.getOriginalFilename();
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(filePath)));
                out.write(file.getBytes());
                out.flush();
                out.close();
                // update avatar load
                userMapper.updateAvatar(id, file.getOriginalFilename());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return 1;
            } catch (IOException e) {
                e.printStackTrace();
                return 1;
            }
        }
        return 0;
    }

    @RequestMapping(value="/http/user/avatar/{id}")
    public void downloadFileAction(@PathVariable("id") Long uid, HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");
        FileInputStream fis = null;
        // get user file;
        String filename = userMapper.getAvatar(uid);
        try {
            String filePath = "upload/" + filename;
            File file = new File(filePath);
            fis = new FileInputStream(file);
            response.setHeader("Content-Disposition", "attachment; filename="+file.getName());
            IOUtils.copy(fis,response.getOutputStream());
            response.flushBuffer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
