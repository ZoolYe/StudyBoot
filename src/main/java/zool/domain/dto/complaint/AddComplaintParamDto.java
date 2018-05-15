package zool.domain.dto.complaint;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 旺旺投诉添加投诉单实体
 */
@Data
public class AddComplaintParamDto {

    /**
     * 旺旺人员id
     */
    @NotNull(message = "旺旺人员id不能为空")
    private int personnelId;

    /**
     * 旺旺人员姓名
     */
    @NotNull
    private String personnel;

    /**
     * 投诉原因
     */
    @NotNull
    private String reason;

    /**
     * 附件地址
     */
    private String filepath;

    /**
     * 备注
     */
    @NotNull
    private String remarks;

}
