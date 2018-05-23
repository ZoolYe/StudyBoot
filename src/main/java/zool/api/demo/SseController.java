package zool.api.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SseController {

    //获取application.properties文件的值
    @Value("${spring.datasource.oapg.jdbcUrl}")
    private String datasource;

    @Autowired
    private Properties properties;

    //这里使用的媒体类型为text/event-strean，这是服务器端的SSE的支持
    @RequestMapping(value = "push",produces = "text/event-stream")
    public @ResponseBody
    String push(){
        Random random = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3"+random.nextInt()+"\n\n";
    }

    @RequestMapping("/testProFile")
    public String testProFile(){
        return datasource;
    }

    @RequestMapping("/testProFile2")
    public String testProFile2(){
        return properties.getDriverClassName()+" : "+properties.getJdbcUrl();
    }

}
