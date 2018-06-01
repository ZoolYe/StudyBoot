package zool.api.activemq.activemq2;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMqServer {

    @JmsListener(destination = "topic")
    public void receiveTopic(String message){
        System.out.println("监听topic=============监听topic");
        System.out.println(message);
    }

}
