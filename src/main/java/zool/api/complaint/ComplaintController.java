package zool.api.complaint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zool.domain.dto.complaint.AddComplaintParamDto;
import zool.service.complaint.ComplaintService;
import zool.utils.RD;


/**
 * 旺旺投诉功能Controller层
 * @author zoolye
 * @date 2018年3月6日15:02:26
 */
@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    ComplaintService complaint;

    /**
     * 添加旺旺投诉单
     * @return
     */
    @RequestMapping("/add")
    @Transactional(rollbackFor = IllegalArgumentException.class)
    public RD addComplaint(@Validated AddComplaintParamDto paramDto, BindingResult bindingResult) {

        complaint.addComplaint(paramDto);

        if(complaint.getComplaint(1210).size()>0){
            throw new IllegalArgumentException("数据已存在将回滚");
        }
        return RD.success(paramDto);
    }

    @RequestMapping("/details")
    public RD detailsComplaint(int id){
        return complaint.detailsComplaint(id);
    }

    @RequestMapping("/index")
    public String getIndex(){
        return "index";
    }

}
