package cn.qimu.service;

import cn.qimu.mybatis.model.Permission;
import cn.qimu.mybatis.model.PermissionExample;
import java.util.List;
import java.util.HashMap;

/**
 * 
 * @author
 * @date 2018-08-16 09:48:59
 */
public interface PermissionService {

	/**
	 * 保存对象，实际为向数据库 insert 数据
	 * @param permission 插入的实体对象
	 */
	long savePermission(Permission permission);
	
	/**
	 * 根据主键删除对象
	 * @param permissionid
	 */
	long deletePermission(Integer permissionid);
	
	/**
	 * 根据对象批量删除对象，使用 batchDelete 这个名称，而没有直接用 delete的原因是为了防止误用
	 * @param permissionid
	 */
	long batchDeletePermission(Permission permission);
	
	/**
	 * 根据主键更新数据，用于更新单条数据
	 * @param permission
	 */
	long updatePermission(Permission permission);
	
	/**
	 * 根据条件更新数据，主要用于批量修改数据
	 * @param updateData 需要更新的数据值
	 * @param conditonObject 更新的条件值，对应的就是 sql中where条件
	 */
	long updatePermissionByCondtion(Permission updateData, Permission conditonObject);
	
	/**
	 * 根据主键来获取对象
	 * @param permissionid
	 */
	Permission getPermission(Integer permissionid);
	
	/**
	 * 根据条件来获取对象，主要用于获取批量数据
	 * @param permission
	 */
	List<Permission> getPermission(Permission permission);
	
	/**
	 * 分页获取数据列表数据；
	 * @param permission 获取数据的 where 条件
	 */
	List<Permission> listPermissionByPage(Permission permission);
	
	/**
	 * 获取数据列表数据
	 * @param permission 获取数据的 where 条件
	 */
	List<Permission> listAllPermission(Permission permission);
	
	/**
	 * 获取数据总量
	 * @param permission 获取数据的 where 条件
	 */
	long countPermission(Permission permission);
	
	/**
	 * 分页获取数据列表数据；并返回数据总量
	 * @param permission 获取数据的 where 条件
	 */
	HashMap<String, Object> countNListPermissionByPage(Permission permission);
	
	/**
	 * 根据对象来构建 MyBatis 的Example对象
	 * @param permission 获取数据的 where 条件
	 */
	PermissionExample createPermissionExample(Permission permission);
	
}
