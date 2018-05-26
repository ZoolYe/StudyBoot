package zool.domain.dto.complaint;

import lombok.Data;

import java.util.Date;

@Data
public class GetComplaintDto {

    private int id;

    private int personnelid;

    private String personnel;

    private int teamid;

    private String team;

    private String reason;

    private String filepath;

    private int add_personid;

    private Date add_time;

    private String remarks;

}
