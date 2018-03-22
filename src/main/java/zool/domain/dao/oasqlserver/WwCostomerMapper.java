package zool.domain.dao.oasqlserver;

import org.springframework.stereotype.Repository;
import zool.domain.dto.wwCustomer.WwKfRenewalRateDto;
import zool.domain.dto.wwCustomer.WwkfMonthDto;

import java.util.List;

@Repository
public interface WwCostomerMapper {


    /**
     * 获取旺旺客服续费率
     * @return
     */
    List<WwKfRenewalRateDto> getWwfkRenewalRate(WwkfMonthDto wwkfMonthDto);
}
