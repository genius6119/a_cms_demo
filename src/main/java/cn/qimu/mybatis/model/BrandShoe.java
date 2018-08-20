package cn.qimu.mybatis.model;

import cn.qimu.common.BaseModel;
import java.io.Serializable;

public class BrandShoe extends BaseModel implements Serializable {
    /**主键 id*/
    private Integer id;
    /**鞋子品牌名称*/
    private String brandId;
    /**鞋子名称*/
    private String shoeName;
    /**鞋子图片路径*/
    private String shoePicture;
    /**旗舰店路径*/
    private String shoeUrl;
    /**是否需要删除：默认0，需要，1 不需要*/
    private Boolean isDelete;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName == null ? null : shoeName.trim();
    }

    public String getShoePicture() {
        return shoePicture;
    }

    public void setShoePicture(String shoePicture) {
        this.shoePicture = shoePicture == null ? null : shoePicture.trim();
    }

    public String getShoeUrl() {
        return shoeUrl;
    }

    public void setShoeUrl(String shoeUrl) {
        this.shoeUrl = shoeUrl == null ? null : shoeUrl.trim();
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
        sb.append(", brandId=").append(brandId);
        sb.append(", shoeName=").append(shoeName);
        sb.append(", shoePicture=").append(shoePicture);
        sb.append(", shoeUrl=").append(shoeUrl);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}