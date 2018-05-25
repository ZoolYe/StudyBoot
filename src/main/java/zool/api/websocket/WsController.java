package zool.api.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/welcome")//当浏览器向服务器发送请求时，通过@MessageMapping映射/welcome这个地址，类似于RequestMapping
    @SendTo("/topic/getResponse")//当服务端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
    public WiselyResponse say(WiselyMessage message) throws InterruptedException {
        //Thread.sleep(3000);
        return new WiselyResponse("消息:"+message.getName()+"!");
    }

    public void handleChat(Principal principal,String msg){
        if(principal.getName().equals("zool")){
            messagingTemplate.convertAndSendToUser("zoolye","/queue/notifications",principal.getName()+"-send:"+msg);
        }else {
            messagingTemplate.convertAndSendToUser("zool","/queue/notifications",principal.getName()+"-send:"+msg);
        }
    }

}
