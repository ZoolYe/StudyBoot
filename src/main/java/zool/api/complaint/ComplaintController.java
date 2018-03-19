package zool.api.complaint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zool.domain.dto.complaint.AddComplaintParamDto;
import zool.service.complaint.impl.ComplaintImpl;
import zool.utils.RD;

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
    public RD addComplaint(AddComplaintParamDto paramDto){
        Map<String,Object> map = new HashMap<>();
        map.put("id",paramDto.getPersonnelId());
        map.put("name",paramDto.getPersonnel());
        map.put("reason",paramDto.getReason());
        map.put("file",paramDto.getFilepath());
        map.put("remarks",paramDto.getRemarks());
        return RD.success(paramDto);
    }

    @RequestMapping("details")
    public RD detailsComplaint(int id){
        return complaint.detailsComplaint(id);
    }

}
