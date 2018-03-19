package zool.domain.dao.oasqlserver;

import org.springframework.stereotype.Repository;
import zool.domain.dto.plevel.MGYueJieDanParamDto;
import zool.domain.dto.plevel.PersonnelBasicInfoDto;

import java.util.Map;

/**
 * p级申请mapper层
 * @author zoolye
 * @date 2018年3月8日11:01:09
 */
@Repository
public interface PlevelMapper {

/**/
    /**
     * 根据用户id获取原有p级
     * @param id 用户id
     * @return 原有p级
     */
    String oldPlevel(int id);


    /**
     * 根据id获取人员的基本信息
     * @param id
     * @return
     */
    PersonnelBasicInfoDto getBasicInfoDto(int id);

    /**
     * 获取美工月结单数量
     * @param paramDto
     * @return
     */
    int getMGYueJieDanSize(MGYueJieDanParamDto paramDto);


    /**
     * 获取一个月的美工月结单总数量
     * @param objectMap
     * @return
     */
    int getMonthlyMGYueJieDanSize(Map<String,Object> objectMap);


    /**
     * 根据月份获取本月客户总数
     * @param objectMap
     * @return
     */
    int getCustomerCount(Map<String,Object> objectMap);



}
