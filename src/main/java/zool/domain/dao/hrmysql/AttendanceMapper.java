package zool.domain.dao.hrmysql;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AttendanceMapper {

    List<Map<String,Object>> listType();

}
