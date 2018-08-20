package cn.qimu.common;

import javax.persistence.criteria.CriteriaBuilder;

public class PositionCondition extends PageQueryBean {
    private Integer typeId;

    private String positionName;

    private Integer reqNumber;

    private Integer workExp;

    private String eduBack;

    private Byte isDelete;

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getReqNumber() {
        return reqNumber;
    }

    public void setReqNumber(Integer reqNumber) {
        this.reqNumber = reqNumber;
    }

    public Integer getWorkExp() {
        return workExp;
    }

    public void setWorkExp(Integer workExp) {
        this.workExp = workExp;
    }

    public String getEduBack() {
        return eduBack;
    }

    public void setEduBack(String eduBack) {
        this.eduBack = eduBack;
    }
}
