package cn.qimu.mybatis.model;

import cn.qimu.common.BaseModel;
import java.io.Serializable;

public class Brand extends BaseModel implements Serializable {
    /**主键 id*/
    private Integer id;
    /**品牌名称*/
    private String brand;
    /**品牌描述*/
    private String describe;
    /**品牌图标路径*/
    private String iconUrl;
    /**是否需要删除：默认0 不需要，1需要*/
    private Boolean isDelete;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brand=").append(brand);
        sb.append(", describe=").append(describe);
        sb.append(", iconUrl=").append(iconUrl);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}