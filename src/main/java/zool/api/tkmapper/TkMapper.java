package zool.api.tkmapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zool.domain.dao.oapg.OperateRefundMapper;
import zool.domain.model.tkmapper.OperateRefund;
import zool.utils.RD;

import java.util.List;

/**
 * @author : zoolye
 * @date : 2018-10-16 18:08
 * @describe :
 */
@RestController
@RequestMapping("/tkmapper")
public class TkMapper {

    @Autowired
    OperateRefundMapper operateRefundMapper;

    @RequestMapping("/demo")
    public RD tkDemo(){

        OperateRefund operateRefund = OperateRefund.builder()
                .id(123).refundReason("中国有嘻哈吗").build();

        operateRefundMapper.updateByPrimaryKeySelective(operateRefund);
        operateRefundMapper.selectAll();
        return RD.success(operateRefundMapper.selectAll());
    }

}
