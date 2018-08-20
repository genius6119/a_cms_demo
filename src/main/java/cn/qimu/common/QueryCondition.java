package cn.qimu.common;

/**
 * Create By Zhang on 2017/11/14
 */
public class QueryCondition extends PageQueryBean{


    private String startDate ;

    private String endDate ;

    private String rangeDate;

    private Byte isDelete;

    private String title;

    private String brand;

    private Integer brandId;

    private String brandShoe;

    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandShoe() {
        return brandShoe;
    }

    public void setBrandShoe(String brandShoe) {
        this.brandShoe = brandShoe;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getRangeDate() { return rangeDate; }

    public void setRangeDate(String rangeDate) {
        this.rangeDate = rangeDate;
    }

    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
