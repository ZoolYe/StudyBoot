package zool.api.complaint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import zool.domain.dto.complaint.AddComplaintParamDto;
import zool.service.complaint.impl.ComplaintImpl;
import zool.utils.RD;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


/**
 * 旺旺投诉功能Controller层
 * @author zoolye
 * @date 2018年3月6日15:02:26
 */
@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    ComplaintImpl complaint;

    /**
     * 添加旺旺投诉单
     * @return
     */
    @RequestMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public RD addComplaint(@Validated AddComplaintParamDto paramDto, BindingResult bindingResult){

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
