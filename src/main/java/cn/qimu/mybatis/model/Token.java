/* Qimu Co.,Lmt. */
package cn.qimu.mybatis.model;

import cn.qimu.common.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class Token extends BaseModel implements Serializable {
    /** 序列化ID */
    private static final long serialVersionUID = 1L;

    /** 主键，同时表示令牌  默认值：null */
    private String tokenCode;

    /** 用户编号  默认值：null */
    private String userCode;

    private Integer userRole;

    /** token最近更新时间  默认值：null */
    private Date lastUpdateTime;

    /** 
     * 获取 主键，同时表示令牌 token.token_code
     * @return 主键，同时表示令牌
     */
    public String getTokenCode() {
        return tokenCode;
    }

    /** 
     * 设置 主键，同时表示令牌 token.token_code
     * @param tokenCode 主键，同时表示令牌
     */
    public void setTokenCode(String tokenCode) {
        this.tokenCode = tokenCode == null ? null : tokenCode.trim();
    }

    /** 
     * 获取 用户编号 token.user_code
     * @return 用户编号
     */
    public String getUserCode() {
        return userCode;
    }

    /** 
     * 设置 用户编号 token.user_code
     * @param userCode 用户编号
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /** 
     * 获取 token.user_role
     * @return token.user_role
     */
    public Integer getUserRole() {
        return userRole;
    }

    /** 
     * 设置 token.user_role
     * @param userRole token.user_role
     */
    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    /** 
     * 获取 token最近更新时间 token.last_update_time
     * @return token最近更新时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /** 
     * 设置 token最近更新时间 token.last_update_time
     * @param lastUpdateTime token最近更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tokenCode=").append(tokenCode);
        sb.append(", userCode=").append(userCode);
        sb.append(", userRole=").append(userRole);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append("]");
        return sb.toString();
    }
}