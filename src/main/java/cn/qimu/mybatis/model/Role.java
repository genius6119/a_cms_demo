package cn.qimu.mybatis.model;

import cn.qimu.common.BaseModel;
import java.io.Serializable;

public class Role extends BaseModel implements Serializable {
    private Integer roleid;

    private String role;

    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleid=").append(roleid);
        sb.append(", role=").append(role);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}