package zool.service.wwCustomer;

import zool.utils.RD;

public interface WwCustomerService {

    /**
     * 获取旺旺客服人员续费率
     * @param sDate 开始月份
     * @param eDate 结束月份
     * @return
     */
    RD getWwKfRenewalrate(String sDate,String eDate);

}
