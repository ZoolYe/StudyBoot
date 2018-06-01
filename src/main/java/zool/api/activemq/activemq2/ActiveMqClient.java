package zool.api.activemq.activemq2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@RestController
@RequestMapping("/activeMq")
public class ActiveMqClient {

    @Autowired
    JmsTemplate jmsTemplate;

    @RequestMapping("/send")
    public void send(){
        jmsTemplate.send("topic", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText("send data");
                return textMessage;
            }
        });
    }

}
