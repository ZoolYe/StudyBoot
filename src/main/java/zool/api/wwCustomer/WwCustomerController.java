package zool.api.wwCustomer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zool.service.wwCustomer.WwCustomerService;
import zool.utils.Fn;
import zool.utils.RD;

/**
 * 旺旺客服业绩控制层
 */
@RestController
@RequestMapping("/wwcustomer")
public class WwCustomerController {

    @Autowired
    WwCustomerService wwCustomerService;

    /**
     * 获取旺旺客服人员续费率
     * @param sDate 开始月份
     * @param eDate 结束月份
     * @return
     */
    @RequestMapping("/getwwKfrenewalrate")
    public RD getWwKfRenewalrate(String sDate,String eDate){

        sDate = Fn.toString(sDate);
        eDate = Fn.toString(eDate);

        return wwCustomerService.getWwKfRenewalrate(sDate,eDate);
    }

}
