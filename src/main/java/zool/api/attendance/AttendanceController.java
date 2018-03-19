package zool.api.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zool.service.attendance.impl.AttendanceImpl;
import zool.utils.RD;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    AttendanceImpl attendance;

    @RequestMapping("/listType")
    public RD getAttendanceType(){
        return attendance.getAttendanceType();
    }

}
