package ChatServer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;


@Configuration
@EnableScheduling
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /**
     * 注册STOMP协议节点并映射url
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .withSockJS();                                      //指定使用SockJS协议

        registry.addEndpoint("/ws")                         //注册一个 /ws 的 websocket 节点
                .addInterceptors(myHandshakeInterceptor())          //添加 websocket握手拦截器
                .setHandshakeHandler(myDefaultHandshakeHandler())   //添加 websocket 握手处理器
                .setAllowedOrigins("*");                            //设置允许可跨域的域名
    }


    private HandshakeInterceptor myHandshakeInterceptor(){
        return new WsInterceptor();
    }

    //WebSocket 握手处理器
    private DefaultHandshakeHandler myDefaultHandshakeHandler(){
        return new WsHandler();
    }

    /**
     * 定义一些消息连接规范
     */
}