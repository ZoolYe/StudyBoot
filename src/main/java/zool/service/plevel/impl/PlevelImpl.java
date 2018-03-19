package zool.service.plevel.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zool.domain.dao.oasqlserver.ManageMapper;
import zool.domain.dao.oasqlserver.PlevelMapper;
import zool.domain.dto.plevel.MGYueJieDanParamDto;
import zool.domain.dto.plevel.PersonnelBasicInfoDto;
import zool.service.plevel.PlevelService;
import zool.utils.Fn;
import zool.utils.RD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PlevelImpl implements PlevelService {

    /**
     * p级相关
     */
    @Autowired
    PlevelMapper plevelMapper;

    /**
     * 人员相关
     */
    @Autowired
    ManageMapper manageMapper;

    /**
     * 美工添加页面的详情信息
     * @param id 当前登录人的id
     * @param p p级
     */
    public RD artDesignerDetails(int id,String p){

        if(id <=0 || "".equals(p)){
            return RD.error("当前登录人信息错误");
        }

        if("P3".equals(p)){
           return getPlevel3(id);
        }

        return RD.error("未知错误");
    }

    /**
     * 获取美工p3业绩信息
     * @param id
     * @return
     */
    public RD getPlevel3(int id){

        Map<String,Object> retuMap = new HashMap<>();
        //第一个月
        Map<String,Object> oneMonthly = new HashMap<>();
        //第二个月
        Map<String,Object> towMonthly = new HashMap<>();
        //第三个月
        Map<String,Object> threeMonthly = new HashMap<>();

        //获取人员的基本信息
        PersonnelBasicInfoDto basicInfoDto = getBasicInfo(id);
        retuMap.put("人员基本信息",basicInfoDto);

        //获取当前时间的前三个月集合
        List<String> dataList = Fn.getBefore3month();

        //获取当前登录人连续三个月美工业绩的月结单总条数
        MGYueJieDanParamDto mgYueJieDanParamDto = new MGYueJieDanParamDto();
        mgYueJieDanParamDto.setUserId(id);
        mgYueJieDanParamDto.setSDate(dataList.get(0));
        mgYueJieDanParamDto.setEDate(dataList.get(2));
        int mgNumber = plevelMapper.getMGYueJieDanSize(mgYueJieDanParamDto);

        Map<String,Object> monthlyMGYueJieDanParam = new HashMap<>();
        Map<String,Object> tempMap = new HashMap<>();

        monthlyMGYueJieDanParam.put("userId",id);

        for(int i=0; i<dataList.size(); i++){

            monthlyMGYueJieDanParam.put("monthly",dataList.get(i));

            //获取月结单总数
            tempMap.put("yueJieDanNumber1"+i+1,plevelMapper.getMonthlyMGYueJieDanSize(monthlyMGYueJieDanParam));

            //获取当月客户总数
            tempMap.put("customerCount"+i+1,plevelMapper.getCustomerCount(monthlyMGYueJieDanParam));

            //月结单总数
            if(i==0){
                oneMonthly.put("YueJieDanSize",tempMap.get("yueJieDanNumber1"+i+1));
                oneMonthly.put("CustomerCount",tempMap.get("customerCount"+i+1));
                retuMap.put(Fn.toString(dataList.get(i)),oneMonthly);
            }else if(i==1){
                towMonthly.put("YueJieDanSize",tempMap.get("yueJieDanNumber1"+i+1));
                towMonthly.put("CustomerCount",tempMap.get("customerCount"+i+1));
                retuMap.put(Fn.toString(dataList.get(i)),towMonthly);
            }else {
                threeMonthly.put("YueJieDanSize",tempMap.get("yueJieDanNumber1"+i+1));
                threeMonthly.put("CustomerCount",tempMap.get("customerCount"+i+1));
                retuMap.put(Fn.toString(dataList.get(i)),threeMonthly);
            }

        }

        retuMap.put("avgYueJieDan",mgNumber/3);

        if(mgNumber/3 <= 10){
            return RD.error("业绩不达标，不符合",retuMap);
        }
        return RD.success(retuMap);
    }

    /**
     * 根据人员id获取人员的基本信息
     * @return 人员基本信息
     */
    public PersonnelBasicInfoDto getBasicInfo(int id){

        //获取人员的基本信息
        PersonnelBasicInfoDto basicInfoDto = plevelMapper.getBasicInfoDto(id);
        //创建一个日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        //将入职时间的字符串转成时间格式
        try {
                date = sdf.parse(basicInfoDto.getJoinTime());
            } catch (ParseException e) {
                e.printStackTrace();
        }
        //再将时间格式转成字符串
        String time = sdf.format(date);
        basicInfoDto.setJoinTime(time);

        //获取人员的部门中文名称
        Map<String,Object> classMap = manageMapper.getManageClass(id);
        basicInfoDto.setClass1(Fn.toString(classMap.get("class1name")));
        basicInfoDto.setClass2(Fn.toString(classMap.get("class2name")));

        return basicInfoDto;
    }

}
