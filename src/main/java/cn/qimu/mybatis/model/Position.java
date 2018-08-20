package cn.qimu.mybatis.model;

import cn.qimu.common.BaseModel;
import java.io.Serializable;

public class Position extends BaseModel implements Serializable {
    /**主键 id*/
    private Integer id;
    /**岗位类型ID*/
    private Integer positionTypeId;
    /**岗位名称*/
    private String positionName;
    /**需求人数*/
    private Integer requireNumber;
    /**要求工作经验*/
    private Integer workExperience;
    /**学历*/
    private String educationBackgroud;
    /**岗位需求*/
    private String positionRequire;
    /**岗位职责*/
    private String positionDuty;
    /**是否需要删除：默认0不需要，1需要*/
    private Boolean isDelete;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPositionTypeId() {
        return positionTypeId;
    }

    public void setPositionTypeId(Integer positionTypeId) {
        this.positionTypeId = positionTypeId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

    public Integer getRequireNumber() {
        return requireNumber;
    }

    public void setRequireNumber(Integer requireNumber) {
        this.requireNumber = requireNumber;
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }

    public String getEducationBackgroud() {
        return educationBackgroud;
    }

    public void setEducationBackgroud(String educationBackgroud) {
        this.educationBackgroud = educationBackgroud == null ? null : educationBackgroud.trim();
    }

    public String getPositionRequire() {
        return positionRequire;
    }

    public void setPositionRequire(String positionRequire) {
        this.positionRequire = positionRequire == null ? null : positionRequire.trim();
    }

    public String getPositionDuty() {
        return positionDuty;
    }

    public void setPositionDuty(String positionDuty) {
        this.positionDuty = positionDuty == null ? null : positionDuty.trim();
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
        sb.append(", positionTypeId=").append(positionTypeId);
        sb.append(", positionName=").append(positionName);
        sb.append(", requireNumber=").append(requireNumber);
        sb.append(", workExperience=").append(workExperience);
        sb.append(", educationBackgroud=").append(educationBackgroud);
        sb.append(", positionRequire=").append(positionRequire);
        sb.append(", positionDuty=").append(positionDuty);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}