package cn.qimu.mybatis.model;

import cn.qimu.common.BaseModel;
import java.io.Serializable;

public class Permission extends BaseModel implements Serializable {
    private Integer permissionid;

    private String permission;

    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
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
        sb.append(", permissionid=").append(permissionid);
        sb.append(", permission=").append(permission);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}