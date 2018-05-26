package zool.service.complaint;

import zool.domain.dto.complaint.AddComplaintParamDto;
import zool.domain.dto.complaint.GetComplaintDto;
import zool.utils.RD;

import java.util.List;

public interface ComplaintService {

    RD detailsComplaint(int id);

    RD addComplaint(AddComplaintParamDto paramDto);

    List<GetComplaintDto> getComplaint(int userId);

}
