package zool.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zool.rabbitMq.HelloSender;

/**
 * @author : zoolye
 * @date : 2018-11-12 11:29
 * @describe :
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitMqHelloTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello(){
        helloSender.send();
    }

}
