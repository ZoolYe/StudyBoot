package zool.rabbitMq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : zoolye
 * @date : 2018-11-12 11:22
 * @describe :
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){

        String context = "hello" + new Date();
        System.out.println("Sender: "+context);
        this.rabbitTemplate.convertAndSend("hello",context);
    }

}
