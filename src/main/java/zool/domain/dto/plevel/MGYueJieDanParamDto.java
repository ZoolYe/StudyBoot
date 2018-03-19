package zool.domain.dto.plevel;


import lombok.Data;

/**
 * 美工月结单实体
 * @author zoolye
 * @date 2018年3月8日14:46:54
 */
@Data
public class MGYueJieDanParamDto {

    /**
     * 用户id
     */
    private int userId;

    /**
     * 开始月份
     */
    private String sDate;

    /**
     * 结束月份
     */
    private String eDate;

}
