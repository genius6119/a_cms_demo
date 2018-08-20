package cn.qimu.mybatis.dao;

import cn.qimu.mybatis.model.RolePermission;
import cn.qimu.mybatis.model.RolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper {
    int countByExample(RolePermissionExample example);

    int deleteByExample(RolePermissionExample example);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> selectByExample(RolePermissionExample example);

    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    long deleteByPrimaryKey(Integer roleId);

    long updateByPrimaryKeySelective(RolePermission rolePermission);

    RolePermission selectByPrimaryKey(Integer roleId);
}