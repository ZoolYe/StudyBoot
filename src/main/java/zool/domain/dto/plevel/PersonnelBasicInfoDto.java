package zool.domain.dto.plevel;


import lombok.Data;


/**
 * 人员基本信息实体
 * @author zoolye
 * @date 2018年3月8日09:36:05
 */
@Data
public class PersonnelBasicInfoDto {

    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 入职时间
     */
    private String joinTime;
    /**
     * 部门
     */
    private String class1;
    /**
     * 分部门
     */
    private String class2;
    /**
     * 原有P级
     */
    private String oldPlevel;
}
