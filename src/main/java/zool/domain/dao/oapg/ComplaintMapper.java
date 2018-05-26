package zool.domain.dao.oapg;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import zool.domain.dto.complaint.AddComplaintParamDto;
import zool.domain.dto.complaint.ComplaintVo;
import zool.domain.dto.complaint.GetComplaintDto;

import java.util.List;

@Repository
public interface ComplaintMapper {

    ComplaintVo detailsComplaint(int id);

    int addComplaint(@Param("paramDto") AddComplaintParamDto paramDto);

    List<GetComplaintDto> getComplaint(int userId);
}
