package zool.service.attendance.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zool.domain.dao.hrmysql.AttendanceMapper;
import zool.service.attendance.AttendanceService;
import zool.utils.RD;

@Service
public class AttendanceImpl implements AttendanceService {

    @Autowired
    AttendanceMapper mapper;

    public RD getAttendanceType(){
        return RD.success(mapper.listType());
    }

}
