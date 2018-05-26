package zool.service.complaint.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import zool.domain.dao.oapg.ComplaintMapper;
import zool.domain.dto.complaint.AddComplaintParamDto;
import zool.domain.dto.complaint.ComplaintVo;
import zool.domain.dto.complaint.GetComplaintDto;
import zool.service.complaint.ComplaintService;
import zool.utils.RD;

import java.util.List;

@Service
public class ComplaintImpl implements ComplaintService {

    @Autowired
    ComplaintMapper complaintMapper;

    @Override
    @Cacheable(value ="ComplaintVo")//在方法执行前spring先查看缓存中是否有数据，如果有数据直接返回缓存中的数据，若没有，调用方法并将返回值存入缓存
    public RD detailsComplaint(int id) {
        ComplaintVo vo = complaintMapper.detailsComplaint(id);
        return RD.success(vo);
    }

    @Override
    public RD addComplaint(AddComplaintParamDto paramDto) {
        return RD.success(complaintMapper.addComplaint(paramDto));
    }

    public List<GetComplaintDto> getComplaint(int userId){
        return complaintMapper.getComplaint(userId);
    }

}
