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
        List<OperateRefund> operateRefund = operateRefundMapper.selectAll();
        return RD.success(operateRefund);
    }

}
