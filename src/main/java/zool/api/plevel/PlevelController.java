package zool.api.plevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zool.service.plevel.PlevelService;
import zool.utils.Fn;
import zool.utils.RD;

/**
 * p级控制层
 * @author zoolye
 * @date 2018年3月7日20:25:57
 */
@RestController
@RequestMapping("/plevel")
public class PlevelController {

    @Autowired
    PlevelService plevelService;


    /**
     * 美工添加页面的详情信息
     * @param id 当前登录人的id
     * @param p p级
     */
    @RequestMapping("/BasicInfoDto")
    public RD artDesignerDetails(int id,String p){
        id = Fn.toInt(id);
        return plevelService.artDesignerDetails(id,p);
    }

}
