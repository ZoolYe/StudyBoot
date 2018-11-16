package zool.domain.model.tkmapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "yy_refund",catalog = "achievement")
public class OperateRefund {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 分部门名
     */
    @Column(name = "class_name")
    private String className;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 公司名称
     */
    @Column(name = "company")
    private String company;

    /**
     * 合同类型名
     */
    @Column(name = "contract_type_name")
    private String contractTypeName;

    /**
     * 合同编号
     */
    @Column(name = "contract_id")
    private String contractId;

    /**
     * 退款金额
     */
    @Column(name = "refund_money")
    private BigDecimal refundMoney;

    /**
     * 退款类型名
     */
    @Column(name = "refund_type_name")
    private String refundTypeName;

    /**
     * 退款原因
     */
    @Column(name = "refund_reason")
    private String refundReason;

    /**
     * 报表月份
     */
    @Column(name = "report_time")
    private String reportTime;

    /**
     * 客服ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 分部门id
     */
    @Column(name = "class2")
    private Integer class2;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取分部门名
     *
     * @return class_name - 分部门名
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置分部门名
     *
     * @param className 分部门名
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取公司名称
     *
     * @return company - 公司名称
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置公司名称
     *
     * @param company 公司名称
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取合同类型名
     *
     * @return contract_type_name - 合同类型名
     */
    public String getContractTypeName() {
        return contractTypeName;
    }

    /**
     * 设置合同类型名
     *
     * @param contractTypeName 合同类型名
     */
    public void setContractTypeName(String contractTypeName) {
        this.contractTypeName = contractTypeName;
    }

    /**
     * 获取合同编号
     *
     * @return contract_id - 合同编号
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * 设置合同编号
     *
     * @param contractId 合同编号
     */
    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    /**
     * 获取退款金额
     *
     * @return refund_money - 退款金额
     */
    public BigDecimal getRefundMoney() {
        return refundMoney;
    }

    /**
     * 设置退款金额
     *
     * @param refundMoney 退款金额
     */
    public void setRefundMoney(BigDecimal refundMoney) {
        this.refundMoney = refundMoney;
    }

    /**
     * 获取退款类型名
     *
     * @return refund_type_name - 退款类型名
     */
    public String getRefundTypeName() {
        return refundTypeName;
    }

    /**
     * 设置退款类型名
     *
     * @param refundTypeName 退款类型名
     */
    public void setRefundTypeName(String refundTypeName) {
        this.refundTypeName = refundTypeName;
    }

    /**
     * 获取退款原因
     *
     * @return refund_reason - 退款原因
     */
    public String getRefundReason() {
        return refundReason;
    }

    /**
     * 设置退款原因
     *
     * @param refundReason 退款原因
     */
    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    /**
     * 获取报表月份
     *
     * @return report_time - 报表月份
     */
    public String getReportTime() {
        return reportTime;
    }

    /**
     * 设置报表月份
     *
     * @param reportTime 报表月份
     */
    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    /**
     * 获取客服ID
     *
     * @return user_id - 客服ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置客服ID
     *
     * @param userId 客服ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取分部门id
     *
     * @return class2 - 分部门id
     */
    public Integer getClass2() {
        return class2;
    }

    /**
     * 设置分部门id
     *
     * @param class2 分部门id
     */
    public void setClass2(Integer class2) {
        this.class2 = class2;
    }
}