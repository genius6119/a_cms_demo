package cn.qimu.mybatis.model;

import cn.qimu.common.BaseModel;
import java.io.Serializable;

public class Resources extends BaseModel implements Serializable {
    /**主键id*/
    private Integer id;
    /**资源名称*/
    private String resourceName;
    /**资源类型：默认1 图片，2 视频,3文件*/
    private Integer resourceType;
    /**资源保存地址*/
    private String resourceUrl;
    /**资源所在页面*/
    private String resourcePage;
    /**同一页面中的组别*/
    private Integer group;
    /**是否需要删除：默认0不需要，1需要*/
    private Boolean isDelete;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    public String getResourcePage() {
        return resourcePage;
    }

    public void setResourcePage(String resourcePage) {
        this.resourcePage = resourcePage == null ? null : resourcePage.trim();
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
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
        sb.append(", resourceName=").append(resourceName);
        sb.append(", resourceType=").append(resourceType);
        sb.append(", resourceUrl=").append(resourceUrl);
        sb.append(", resourcePage=").append(resourcePage);
        sb.append(", group=").append(group);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}