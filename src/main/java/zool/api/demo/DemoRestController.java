package zool.api.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zool.domain.dto.demo.DemoObj;

@RestController
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value = "/getjson",produces = {"application/json;charset=UTF-8"})//返回的数据媒体类型为json(引入包com.fasterxml.jackson.core)
    public DemoObj getjson(DemoObj obj){
        return new DemoObj(obj.getId()+1,obj.getName()+"yy");//直接返回对象，对象会自动转成json
    }

    @RequestMapping(value = "/getxml",produces = {"application/xml;charset=UTF-8"})//返回的数据媒体类型为xml(引入包com.fasterxml.jackson.dataformat)
    public DemoObj getxml(DemoObj obj){
        return new DemoObj(obj.getId()+1,obj.getName()+"yy");//直接返回对象，对象会自动转成xml
    }

}
