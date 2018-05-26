package zool.domain.dto.complaint;

import lombok.Data;

@Data
public class ComplaintVo {

    private int personnelid;

    private int id;

    private String personnel;

    private String reason;

    private String filepath;

    private String remarks;

}
