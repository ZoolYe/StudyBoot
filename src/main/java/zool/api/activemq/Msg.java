package zool.api.activemq;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 定义jms发送的消息需要实现MessageCreator并重写createMessage
 */
public class Msg implements MessageCreator {

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("测试消息!");
    }

}
