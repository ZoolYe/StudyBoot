package zool.service.wwCustomer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zool.domain.dao.oasqlserver.WwCostomerMapper;
import zool.domain.dto.wwCustomer.WwKfRenewalRateDto;
import zool.domain.dto.wwCustomer.WwkfMonthDto;
import zool.service.wwCustomer.WwCustomerService;
import zool.utils.RD;

import java.util.List;

@Service
public class WwCustomerImpl implements WwCustomerService {


    /**
     * 旺旺客服续费率相关
     */
    @Autowired
    WwCostomerMapper costomerMapper;

    /**
     * 获取旺旺客服续费率
     * @param sDate 开始月份
     * @param eDate 结束月份
     * @return
     */
    @Override
    public RD getWwKfRenewalrate(String sDate, String eDate) {

        if("".equals(sDate) || "".equals(eDate)){
            return RD.error("月份信息错误");
        }

        WwkfMonthDto monthDto = new WwkfMonthDto();
        monthDto.setSDate(sDate);
        monthDto.setEDate(eDate);

        List<WwKfRenewalRateDto> list =costomerMapper.getWwfkRenewalRate(monthDto);
        return RD.success(list);
    }
}
