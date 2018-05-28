package zool.api.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class Receiver {

    @JmsListener(destination = "my-destination")//指定要监控的目的地
    public void receiveMessage(String message){
        System.out.println("接收到：< "+" >");
    }

}
