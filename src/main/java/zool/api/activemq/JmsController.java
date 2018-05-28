package zool.api.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmsController {

    @Autowired
    JmsTemplate jmsTemplate;

    @RequestMapping("/jmsRun")
    public String run(){
        jmsTemplate.send("my-destination",new Msg());
        return jmsTemplate.toString();
    }

}
