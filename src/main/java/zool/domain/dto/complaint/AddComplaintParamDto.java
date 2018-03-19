package zool.domain.dto.complaint;

import lombok.Data;

/**
 * 旺旺投诉添加投诉单实体
 */
@Data
public class AddComplaintParamDto {

    /**
     * 旺旺人员id
     */
    private int personnelId;

    /**
     * 旺旺人员姓名
     */
    private String personnel;

    /**
     * 投诉原因
     */
    private String reason;

    /**
     * 附件地址
     */
    private String filepath;

    /**
     * 备注
     */
    private String remarks;

}
