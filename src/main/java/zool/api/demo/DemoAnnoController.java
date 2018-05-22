package zool.api.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zool.domain.dto.demo.DemoObj;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

    @RequestMapping(produces = "text/plain;charset=UTF-8")//produces可制定返回的response的媒体类型和字符集
    public @ResponseBody String index(HttpServletRequest request){//可接受HttpServletRequest作为参数
        return "url:    "+request.getRequestURI()+" can access";
    }

    @RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=UTF-8")//接收路径参数
    public @ResponseBody String demoPathVar(@PathVariable String str,HttpServletRequest request){
        return "url:    "+request.getRequestURI()+" can access,str: "+str;
    }

    @RequestMapping(value = "/requestParam",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id,HttpServletRequest request){
        return "url:    "+request.getRequestURI()+" can access,id:  "+id;
    }

    @RequestMapping(value = "/obj",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String passObj(DemoObj obj,HttpServletRequest request){
        return "url:    "+request.getRequestURI()+" can access,obj id:"+obj.getId()+"obj name:"+obj.getName();
    }

    @RequestMapping(value = {"/name1","/name2"},produces ="text/plain;charset=UTF-8")//映射不同的路径到相同的方法
    public @ResponseBody String remove(HttpServletRequest request){
        return "url:    "+request.getRequestURI()+" can access.....";
    }

}
