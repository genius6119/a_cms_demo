package cn.qimu.service;

import cn.qimu.mybatis.model.User;
import cn.qimu.mybatis.model.UserExample;
import java.util.List;
import java.util.HashMap;

/**
 * 
 * @author
 * @date 2018-08-16 09:30:11
 */
public interface UserService {

	/**
	 * 保存对象，实际为向数据库 insert 数据
	 * @param user 插入的实体对象
	 */
	long saveUser(User user);
	
	/**
	 * 根据主键删除对象
	 * @param id
	 */
	long deleteUser(Integer id);
	
	/**
	 * 根据对象批量删除对象，使用 batchDelete 这个名称，而没有直接用 delete的原因是为了防止误用
	 * @param id
	 */
	long batchDeleteUser(User user);
	
	/**
	 * 根据主键更新数据，用于更新单条数据
	 * @param user
	 */
	long updateUser(User user);
	
	/**
	 * 根据条件更新数据，主要用于批量修改数据
	 * @param updateData 需要更新的数据值
	 * @param conditonObject 更新的条件值，对应的就是 sql中where条件
	 */
	long updateUserByCondtion(User updateData, User conditonObject);
	
	/**
	 * 根据主键来获取对象
	 * @param id
	 */
	User getUser(Integer id);
	
	/**
	 * 根据条件来获取对象，主要用于获取批量数据
	 * @param user
	 */
	List<User> getUser(User user);
	
	/**
	 * 分页获取数据列表数据；
	 * @param user 获取数据的 where 条件
	 */
	List<User> listUserByPage(User user);
	
	/**
	 * 获取数据列表数据
	 * @param user 获取数据的 where 条件
	 */
	List<User> listAllUser(User user);
	
	/**
	 * 获取数据总量
	 * @param user 获取数据的 where 条件
	 */
	long countUser(User user);
	
	/**
	 * 分页获取数据列表数据；并返回数据总量
	 * @param user 获取数据的 where 条件
	 */
	HashMap<String, Object> countNListUserByPage(User user);
	
	/**
	 * 根据对象来构建 MyBatis 的Example对象
	 * @param user 获取数据的 where 条件
	 */
	UserExample createUserExample(User user);

    User findUserByUserName(String username);
}
