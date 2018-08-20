/* Qimu Co.,Lmt. */
package cn.qimu.mybatis.model;

import cn.qimu.common.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class Shop extends BaseModel implements Serializable {
    /** 序列化ID */
    private static final long serialVersionUID = 1L;

    private Integer id;

    /** 名称  默认值：null */
    private String name;

    /** 100：淘系店
200：渠道店  默认值：null */
    private Integer type;

    /** 描述  默认值：null */
    private String description;

    /** 创建时间  默认值：null */
    private Date createTime;

    /** 是否删除0:未删除1:已删除  默认值：null */
    private Boolean isDeleted;

    /** 
     * 获取 shop.id
     * @return shop.id
     */
    public Integer getId() {
        return id;
    }

    /** 
     * 设置 shop.id
     * @param id shop.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 名称 shop.name
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /** 
     * 设置 名称 shop.name
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /** 
     * 获取 100：淘系店
200：渠道店 shop.type
     * @return 100：淘系店
200：渠道店
     */
    public Integer getType() {
        return type;
    }

    /** 
     * 设置 100：淘系店
200：渠道店 shop.type
     * @param type 100：淘系店
200：渠道店
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /** 
     * 获取 描述 shop.description
     * @return 描述
     */
    public String getDescription() {
        return description;
    }

    /** 
     * 设置 描述 shop.description
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /** 
     * 获取 创建时间 shop.create_time
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 创建时间 shop.create_time
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取 是否删除0:未删除1:已删除 shop.is_deleted
     * @return 是否删除0:未删除1:已删除
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /** 
     * 设置 是否删除0:未删除1:已删除 shop.is_deleted
     * @param isDeleted 是否删除0:未删除1:已删除
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}