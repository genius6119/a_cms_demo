package cn.qimu.mybatis.model;

import cn.qimu.common.BaseModel;
import java.io.Serializable;

public class PositionType extends BaseModel implements Serializable {
    /**主键 id*/
    private Integer id;
    /**岗位类型名称*/
    private String positionTypeName;
    /**岗位类型的类别：默认0校招；1社招；2品牌合伙人*/
    private Integer positionTypeClassify;
    /**岗位类型被选中时的图标*/
    private String positionSelectIcon;
    /**岗位类型默认图标*/
    private String positionIcon;
    /**是否需要删除：默认0不需要，1需要*/
    private Boolean isDelete;

    private static final long serialVersionUID = 1L;


    public Integer getPositionTypeClassify() {
        return positionTypeClassify;
    }

    public void setPositionTypeClassify(Integer positionTypeClassify) {
        this.positionTypeClassify = positionTypeClassify;
    }

    public String getPositionSelectIcon() {
        return positionSelectIcon;
    }

    public void setPositionSelectIcon(String positionSelectIcon) {
        this.positionSelectIcon = positionSelectIcon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionTypeName() {
        return positionTypeName;
    }

    public void setPositionTypeName(String positionTypeName) {
        this.positionTypeName = positionTypeName == null ? null : positionTypeName.trim();
    }

    public String getPositionIcon() {
        return positionIcon;
    }

    public void setPositionIcon(String positionIcon) {
        this.positionIcon = positionIcon == null ? null : positionIcon.trim();
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
        sb.append(", positionTypeName=").append(positionTypeName);
        sb.append(", positionIcon=").append(positionIcon);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}