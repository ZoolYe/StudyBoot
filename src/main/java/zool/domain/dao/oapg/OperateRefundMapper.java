package zool.domain.dao.oapg;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import zool.domain.model.tkmapper.OperateRefund;

@Repository
public interface OperateRefundMapper extends Mapper<OperateRefund> {

    /**
     * 通过id修改退款原因
     * @param id
     * @return
     */
    Integer updateRefundReasonById(@Param("id") Integer id,@Param("reason") String reason);

}