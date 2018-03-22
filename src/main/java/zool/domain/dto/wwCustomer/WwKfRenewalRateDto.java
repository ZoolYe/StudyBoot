package zool.domain.dto.wwCustomer;

import lombok.Data;

/**
 * 旺旺客服续费率实体
 */
@Data
public class WwKfRenewalRateDto {


    /**
     * 旺旺客服id
     */
    private int kfid;

    /**
     * 分母
     */
    private int fenmu;

    /**
     * 分子
     */
    private int fenzi;

    /**
     * 退款
     */
    private int tuikuan;

    /**
     * 月份
     */
    private String yue;

}
