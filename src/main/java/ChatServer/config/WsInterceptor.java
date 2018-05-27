package ChatServer.config;

//import ChatServer.mapper.UserMapper;
import ChatServer.util.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.security.Principal;
import java.util.Map;


/**
 * WebSocket 握手拦截器
 * 可做一些用户认证拦截处理
 */
public class WsInterceptor extends HttpSessionHandshakeInterceptor implements HandshakeInterceptor {
    @Autowired
//    private UserMapper userMapper;

    /**
     * 根据token认证授权
     */
    private Principal authenticate(String token){
        //用户信息需继承 Principal 并实现 getContent() 方法，返回全局唯一值
//        String str = Arrays.toString(Base64.getDecoder().decode(token));
        String str = token;
        String[] msgs = str.split("#");
//        Long users = userMapper.login(msgs[0], msgs[1]);
//        if (users != 0) {
//            System.out.print(users);
//            return new UserPrincipal(msgs[0]);
//        }
        return new UserPrincipal("asdjkla");
//        return null;
    }

    private String getToken(ServletServerHttpRequest req) {
        String[] strs = req.getURI().getQuery().split("&");
        for (String s: strs) {
            String[] temp = s.split("=");
            if (temp[0].equals("token")) {
                return temp[1];
            }
        }
        return null;
    }
    /**
     * websocket握手连接
     * @return 返回是否同意握手
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request,
                                   ServerHttpResponse response, WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) throws Exception {
        System.out.println("before handshake");
        ServletServerHttpRequest req = (ServletServerHttpRequest) request;
        //通过url的token参数获取认证参数
        System.out.println(req.getHeaders());

        //根据token认证用户，不通过返回拒绝握手
        Principal user = new UserPrincipal("asdjkla");
//        Principal user = authenticate(token);
//        if(user == null){
//            return false;
//        }
        //保存认证用户
        attributes.put("user", user);
        return true;
//        // 解决The extension [x-webkit-deflate-frame] is not supported问题
//        if (request.getHeaders().containsKey("Sec-WebSocket-Extensions")) {
//            request.getHeaders().set("Sec-WebSocket-Extensions",
//                    "permessage-deflate");
//        }
    }

    @Override
    public void afterHandshake(ServerHttpRequest request,
                               ServerHttpResponse response, WebSocketHandler wsHandler,
                               Exception ex) {
        System.out.println("After Handshake");
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
