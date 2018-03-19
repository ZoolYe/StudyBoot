package zool.service.complaint.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zool.domain.dao.oapg.ComplaintMapper;
import zool.service.complaint.ComplaintService;
import zool.utils.RD;

@Service
public class ComplaintImpl implements ComplaintService {

    @Autowired
    ComplaintMapper complaintMapper;

    @Override
    public RD detailsComplaint(int id) {
        return RD.success(complaintMapper.detailsComplaint(id));
    }
}
