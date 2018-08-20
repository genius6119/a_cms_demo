package cn.qimu.service;

import cn.qimu.mybatis.model.Role;
import cn.qimu.mybatis.model.RoleExample;
import java.util.List;
import java.util.HashMap;

/**
 * 
 * @author
 * @date 2018-08-16 09:47:47
 */
public interface RoleService {

	/**
	 * 保存对象，实际为向数据库 insert 数据
	 * @param role 插入的实体对象
	 */
	long saveRole(Role role);
	
	/**
	 * 根据主键删除对象
	 * @param roleid
	 */
	long deleteRole(Integer roleid);
	
	/**
	 * 根据对象批量删除对象，使用 batchDelete 这个名称，而没有直接用 delete的原因是为了防止误用
	 * @param roleid
	 */
	long batchDeleteRole(Role role);
	
	/**
	 * 根据主键更新数据，用于更新单条数据
	 * @param role
	 */
	long updateRole(Role role);
	
	/**
	 * 根据条件更新数据，主要用于批量修改数据
	 * @param updateData 需要更新的数据值
	 * @param conditonObject 更新的条件值，对应的就是 sql中where条件
	 */
	long updateRoleByCondtion(Role updateData, Role conditonObject);
	
	/**
	 * 根据主键来获取对象
	 * @param roleid
	 */
	Role getRole(Integer roleid);
	
	/**
	 * 根据条件来获取对象，主要用于获取批量数据
	 * @param role
	 */
	List<Role> getRole(Role role);
	
	/**
	 * 分页获取数据列表数据；
	 * @param role 获取数据的 where 条件
	 */
	List<Role> listRoleByPage(Role role);
	
	/**
	 * 获取数据列表数据
	 * @param role 获取数据的 where 条件
	 */
	List<Role> listAllRole(Role role);
	
	/**
	 * 获取数据总量
	 * @param role 获取数据的 where 条件
	 */
	long countRole(Role role);
	
	/**
	 * 分页获取数据列表数据；并返回数据总量
	 * @param role 获取数据的 where 条件
	 */
	HashMap<String, Object> countNListRoleByPage(Role role);
	
	/**
	 * 根据对象来构建 MyBatis 的Example对象
	 * @param role 获取数据的 where 条件
	 */
	RoleExample createRoleExample(Role role);
	
}
