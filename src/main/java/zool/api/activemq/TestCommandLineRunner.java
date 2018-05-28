package zool.api.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * SpringBoot为我们提供了CommandLineRunner接口
 * 用于程序启动后执行的代码，通过重写其run方法
 */
//@Component
public class TestCommandLineRunner  implements CommandLineRunner {

    /**
     * 注入springboot为我们配置好的JmsTemplate bean
     */
    @Autowired
    JmsTemplate jmsTemplate;
    /**
     * 通过jmsTemplate的send方法向my-destination目的地发送Msg的消息
     * 这等于在消息代理上定义了一个目的地叫my-destination
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        jmsTemplate.send("my-destination",new Msg());
    }

}
