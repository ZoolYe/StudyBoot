package zool.service.wwCustomer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zool.domain.dao.oasqlserver.WwCostomerMapper;
import zool.domain.dto.wwCustomer.WwKfRenewalRateDto;
import zool.domain.dto.wwCustomer.WwkfMonthDto;
import zool.service.wwCustomer.WwCustomerService;
import zool.utils.RD;

import java.text.NumberFormat;
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

        //获取获取制定月份的旺旺客服续费率
        List<WwKfRenewalRateDto> wwKf_list =costomerMapper.getWwfkRenewalRate(monthDto);

        //创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        //设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);

        for(int i=0; i<wwKf_list.size();i++){

            WwKfRenewalRateDto rateDto = wwKf_list.get(i);
            float fenmu = rateDto.getFenmu();
            float fenzi = rateDto.getFenzi();

            if(fenmu!=0 && fenzi!=0){
                //获取续费率,fenzi是已续fenmu是未续
                String xfl = numberFormat.format(fenzi / fenmu*100);
                rateDto.setXfl(xfl);
            }else if(fenzi==0){
                rateDto.setXfl("0");
            }
            wwKf_list.set(i,rateDto);
        }
        return RD.success(wwKf_list);
    }
}
