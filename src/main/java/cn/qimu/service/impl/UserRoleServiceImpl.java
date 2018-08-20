package cn.qimu.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import cn.qimu.common.ApiStrings;
import cn.qimu.exception.BusinessException;
import cn.qimu.mybatis.dao.UserRoleMapper;
import cn.qimu.mybatis.model.UserRole;
import cn.qimu.mybatis.model.UserRoleExample;
import cn.qimu.mybatis.model.UserRoleExample.Criteria;
import cn.qimu.service.UserRoleService;
import cn.qimu.utils.UUIDUtil;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Resource
	protected UserRoleMapper userRoleMapper;

	@Override
	public long saveUserRole(UserRole userRole) {
		if (userRole == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
			
		return userRoleMapper.insertSelective(userRole);
	}

	@Override
	public long deleteUserRole(Integer userId) {
		if (userId == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return userRoleMapper.deleteByPrimaryKey(userId);
	}
	
	@Override
	public long batchDeleteUserRole(UserRole userRole) {
		if (userRole == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		UserRoleExample example = createUserRoleExample(userRole);
		return userRoleMapper.deleteByExample(example);
	}

	@Override
	public long updateUserRole(UserRole userRole) {
		if (userRole == null || userRole.getUserId() == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}

		return userRoleMapper.updateByPrimaryKeySelective(userRole);
	}
	
	@Override
	public long updateUserRoleByCondtion(UserRole userRole, UserRole conditonObject) {
		if (userRole == null || conditonObject == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		UserRoleExample example = createUserRoleExample(userRole);
		return userRoleMapper.updateByExample(userRole, example);
	}

	@Override
	public UserRole getUserRole(Integer userId) {
		if (userId == null)	{
				throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
	    }
		return userRoleMapper.selectByPrimaryKey(userId);
	}
	
	@Override
	public List<UserRole> getUserRole(UserRole userRole) {
		if (userRole == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		UserRoleExample example = createUserRoleExample(userRole);
		return userRoleMapper.selectByExample(example);
	}

	@Override
	public List<UserRole> listUserRoleByPage(UserRole userRole) {
		if (userRole == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		
		UserRoleExample example = createUserRoleExample(userRole);
		
		// orderBy 如果orderBy 为 null和空，那么不排序，反之按传入条件排序
		if (!StringUtils.isBlank(userRole.getOrder()))
			example.setOrderByClause(userRole.getOrder());
		PageHelper.startPage(userRole.getCurPage(), userRole.getSize(), false);
		return userRoleMapper.selectByExample(example);
	}
	
	@Override
	public List<UserRole> listAllUserRole(UserRole userRole) {
		if (userRole == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		UserRoleExample example = createUserRoleExample(userRole);
		return userRoleMapper.selectByExample(example);
	}

	@Override
	public long countUserRole(UserRole userRole) {
		if (userRole == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		UserRoleExample example = createUserRoleExample(userRole);
		return userRoleMapper.countByExample(example);
	}
	
	@Transactional
	@Override
	public HashMap<String, Object> countNListUserRoleByPage(UserRole userRole) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<UserRole> data = listUserRoleByPage(userRole);
		long count = countUserRole(userRole);
		map.put("data", data);
		map.put("count", count);
		return map;
	}
	
	@Override
	public UserRoleExample createUserRoleExample(UserRole userRole) {
		UserRoleExample example = new UserRoleExample();
		Criteria criteria = example.createCriteria();
			
		if (userRole.getUserId() != null) {
			criteria.andUserIdEqualTo(userRole.getUserId());
		}
				
		if (userRole.getRoleId() != null) {
			criteria.andRoleIdEqualTo(userRole.getRoleId());
		}
			
		return example;
	}
	

}
