package zool.domain.dao.oasqlserver;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import zool.domain.dto.manage.UserDto;

import java.util.List;
import java.util.Map;

/**
 * 人员管理mapper层
 * @author zoolye
 * @date 2018年3月8日11:01:50
 */
@Repository
public interface ManageMapper {


    /**
     * 获取人员一级部门，二级部门
     * @param id
     * @return
     */
    Map<String,Object> getManageClass(@Param("id")int id);

    UserDto getUserInfo(@Param("username") String username);

}
