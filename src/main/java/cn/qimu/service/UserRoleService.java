package cn.qimu.service;

import cn.qimu.mybatis.model.UserRole;
import cn.qimu.mybatis.model.UserRoleExample;
import java.util.List;
import java.util.HashMap;

/**
 * 
 * @author
 * @date 2018-08-16 09:50:10
 */
public interface UserRoleService {

	/**
	 * 保存对象，实际为向数据库 insert 数据
	 * @param userRole 插入的实体对象
	 */
	long saveUserRole(UserRole userRole);
	
	/**
	 * 根据主键删除对象
	 * @param userId
	 */
	long deleteUserRole(Integer userId);
	
	/**
	 * 根据对象批量删除对象，使用 batchDelete 这个名称，而没有直接用 delete的原因是为了防止误用
	 * @param userId
	 */
	long batchDeleteUserRole(UserRole userRole);
	
	/**
	 * 根据主键更新数据，用于更新单条数据
	 * @param userRole
	 */
	long updateUserRole(UserRole userRole);
	
	/**
	 * 根据条件更新数据，主要用于批量修改数据
	 * @param updateData 需要更新的数据值
	 * @param conditonObject 更新的条件值，对应的就是 sql中where条件
	 */
	long updateUserRoleByCondtion(UserRole updateData, UserRole conditonObject);
	
	/**
	 * 根据主键来获取对象
	 * @param userId
	 */
	UserRole getUserRole(Integer userId);
	
	/**
	 * 根据条件来获取对象，主要用于获取批量数据
	 * @param userRole
	 */
	List<UserRole> getUserRole(UserRole userRole);
	
	/**
	 * 分页获取数据列表数据；
	 * @param userRole 获取数据的 where 条件
	 */
	List<UserRole> listUserRoleByPage(UserRole userRole);
	
	/**
	 * 获取数据列表数据
	 * @param userRole 获取数据的 where 条件
	 */
	List<UserRole> listAllUserRole(UserRole userRole);
	
	/**
	 * 获取数据总量
	 * @param userRole 获取数据的 where 条件
	 */
	long countUserRole(UserRole userRole);
	
	/**
	 * 分页获取数据列表数据；并返回数据总量
	 * @param userRole 获取数据的 where 条件
	 */
	HashMap<String, Object> countNListUserRoleByPage(UserRole userRole);
	
	/**
	 * 根据对象来构建 MyBatis 的Example对象
	 * @param userRole 获取数据的 where 条件
	 */
	UserRoleExample createUserRoleExample(UserRole userRole);
	
}
