package zool.domain.dao.oapg;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ComplaintMapper {

    Map<String,Object> detailsComplaint(int id);

}
