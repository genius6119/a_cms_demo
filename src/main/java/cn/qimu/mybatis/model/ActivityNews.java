package cn.qimu.mybatis.model;

import cn.qimu.common.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class ActivityNews extends BaseModel implements Serializable {
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date activityDate;

    private String title;

    private String activityPictureUrl;

    private Boolean isDelete;

    private String article;

    private String detailsHtml;

    private static final long serialVersionUID = 1L;

    public String getDetailsHtml() {
        return detailsHtml;
    }

    public void setDetailsHtml(String detailsHtml) {
        this.detailsHtml = detailsHtml;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getActivityDate() {
        return activityDate;
    }


    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getActivityPictureUrl() {
        return activityPictureUrl;
    }

    public void setActivityPictureUrl(String activityPictureUrl) {
        this.activityPictureUrl = activityPictureUrl == null ? null : activityPictureUrl.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article == null ? null : article.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activityDate=").append(activityDate);
        sb.append(", title=").append(title);
        sb.append(", activityPictureUrl=").append(activityPictureUrl);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", article=").append(article);
        sb.append("]");
        return sb.toString();
    }
}