/* Qimu Co.,Lmt. */
package cn.qimu.mybatis.model;

import cn.qimu.common.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class Sms extends BaseModel implements Serializable {
    /** 序列化ID */
    private static final long serialVersionUID = 1L;

    /** 主键  默认值：null */
    private String code;

    /** 手机号  默认值：null */
    private String mobile;

    private Integer userRole;

    /** 短信内容  默认值：null */
    private String content;

    /** 验证码  默认值：null */
    private String validCode;

    /** 创建时间  默认值：null */
    private Date createTime;

    /** 发送时间  默认值：null */
    private Date sendTime;

    /** 业务类型，0：用户注册；1：忘记密码；  默认值：null */
    private Short bussnessType;

    /** 状态1-有效2-过期3-验证  默认值：0 */
    private Short smsStatus;

    /** 供应商返回状态值  默认值：null */
    private Integer sendStatus;

    /** 
     * 获取 主键 sms.code
     * @return 主键
     */
    public String getCode() {
        return code;
    }

    /** 
     * 设置 主键 sms.code
     * @param code 主键
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /** 
     * 获取 手机号 sms.mobile
     * @return 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /** 
     * 设置 手机号 sms.mobile
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /** 
     * 获取 sms.user_role
     * @return sms.user_role
     */
    public Integer getUserRole() {
        return userRole;
    }

    /** 
     * 设置 sms.user_role
     * @param userRole sms.user_role
     */
    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    /** 
     * 获取 短信内容 sms.content
     * @return 短信内容
     */
    public String getContent() {
        return content;
    }

    /** 
     * 设置 短信内容 sms.content
     * @param content 短信内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /** 
     * 获取 验证码 sms.valid_code
     * @return 验证码
     */
    public String getValidCode() {
        return validCode;
    }

    /** 
     * 设置 验证码 sms.valid_code
     * @param validCode 验证码
     */
    public void setValidCode(String validCode) {
        this.validCode = validCode == null ? null : validCode.trim();
    }

    /** 
     * 获取 创建时间 sms.create_time
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 创建时间 sms.create_time
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取 发送时间 sms.send_time
     * @return 发送时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /** 
     * 设置 发送时间 sms.send_time
     * @param sendTime 发送时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /** 
     * 获取 业务类型，0：用户注册；1：忘记密码； sms.bussness_type
     * @return 业务类型，0：用户注册；1：忘记密码；
     */
    public Short getBussnessType() {
        return bussnessType;
    }

    /** 
     * 设置 业务类型，0：用户注册；1：忘记密码； sms.bussness_type
     * @param bussnessType 业务类型，0：用户注册；1：忘记密码；
     */
    public void setBussnessType(Short bussnessType) {
        this.bussnessType = bussnessType;
    }

    /** 
     * 获取 状态1-有效2-过期3-验证 sms.sms_status
     * @return 状态1-有效2-过期3-验证
     */
    public Short getSmsStatus() {
        return smsStatus;
    }

    /** 
     * 设置 状态1-有效2-过期3-验证 sms.sms_status
     * @param smsStatus 状态1-有效2-过期3-验证
     */
    public void setSmsStatus(Short smsStatus) {
        this.smsStatus = smsStatus;
    }

    /** 
     * 获取 供应商返回状态值 sms.send_status
     * @return 供应商返回状态值
     */
    public Integer getSendStatus() {
        return sendStatus;
    }

    /** 
     * 设置 供应商返回状态值 sms.send_status
     * @param sendStatus 供应商返回状态值
     */
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", code=").append(code);
        sb.append(", mobile=").append(mobile);
        sb.append(", userRole=").append(userRole);
        sb.append(", content=").append(content);
        sb.append(", validCode=").append(validCode);
        sb.append(", createTime=").append(createTime);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", bussnessType=").append(bussnessType);
        sb.append(", smsStatus=").append(smsStatus);
        sb.append(", sendStatus=").append(sendStatus);
        sb.append("]");
        return sb.toString();
    }
}