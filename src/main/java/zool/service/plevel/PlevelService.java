package zool.service.plevel;

import zool.utils.RD;

/**
 * p级业务层接口
 * @author zoolye
 * @date 2018年3月7日20:31:39
 */
public interface PlevelService {

    /**
     * 美工添加页面的详情信息
     * @param id 当前登录人的id
     * @param p p级
     */
    RD artDesignerDetails(int id,String p);

}
