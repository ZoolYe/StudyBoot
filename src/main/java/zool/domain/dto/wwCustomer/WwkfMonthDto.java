package zool.domain.dto.wwCustomer;

import lombok.Data;

/**
 * 旺旺客服续费率月份DTO
 */
@Data
public class WwkfMonthDto {

    /**
     * 开始月份
     */
    private String sDate;

    /**
     * 结束月份
     */
    private String eDate;

}
