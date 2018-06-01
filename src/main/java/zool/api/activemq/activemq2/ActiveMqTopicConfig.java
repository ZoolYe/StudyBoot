package zool.api.activemq.activemq2;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Topic;

@Configuration
public class ActiveMqTopicConfig {

    @Bean
    public Topic topic(){
        return new ActiveMQTopic("topic");
    }

}
