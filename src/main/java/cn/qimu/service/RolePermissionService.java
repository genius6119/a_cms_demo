package cn.qimu.service;

import cn.qimu.mybatis.model.RolePermission;
import cn.qimu.mybatis.model.RolePermissionExample;
import java.util.List;
import java.util.HashMap;

/**
 * 
 * @author
 * @date 2018-08-16 09:51:21
 */
public interface RolePermissionService {

	/**
	 * 保存对象，实际为向数据库 insert 数据
	 * @param rolePermission 插入的实体对象
	 */
	long saveRolePermission(RolePermission rolePermission);
	
	/**
	 * 根据主键删除对象
	 * @param roleId
	 */
	long deleteRolePermission(Integer roleId);
	
	/**
	 * 根据对象批量删除对象，使用 batchDelete 这个名称，而没有直接用 delete的原因是为了防止误用
	 * @param roleId
	 */
	long batchDeleteRolePermission(RolePermission rolePermission);
	
	/**
	 * 根据主键更新数据，用于更新单条数据
	 * @param rolePermission
	 */
	long updateRolePermission(RolePermission rolePermission);
	
	/**
	 * 根据条件更新数据，主要用于批量修改数据
	 * @param updateData 需要更新的数据值
	 * @param conditonObject 更新的条件值，对应的就是 sql中where条件
	 */
	long updateRolePermissionByCondtion(RolePermission updateData, RolePermission conditonObject);
	
	/**
	 * 根据主键来获取对象
	 * @param roleId
	 */
	RolePermission getRolePermission(Integer roleId);
	
	/**
	 * 根据条件来获取对象，主要用于获取批量数据
	 * @param rolePermission
	 */
	List<RolePermission> getRolePermission(RolePermission rolePermission);
	
	/**
	 * 分页获取数据列表数据；
	 * @param rolePermission 获取数据的 where 条件
	 */
	List<RolePermission> listRolePermissionByPage(RolePermission rolePermission);
	
	/**
	 * 获取数据列表数据
	 * @param rolePermission 获取数据的 where 条件
	 */
	List<RolePermission> listAllRolePermission(RolePermission rolePermission);
	
	/**
	 * 获取数据总量
	 * @param rolePermission 获取数据的 where 条件
	 */
	long countRolePermission(RolePermission rolePermission);
	
	/**
	 * 分页获取数据列表数据；并返回数据总量
	 * @param rolePermission 获取数据的 where 条件
	 */
	HashMap<String, Object> countNListRolePermissionByPage(RolePermission rolePermission);
	
	/**
	 * 根据对象来构建 MyBatis 的Example对象
	 * @param rolePermission 获取数据的 where 条件
	 */
	RolePermissionExample createRolePermissionExample(RolePermission rolePermission);
	
}
