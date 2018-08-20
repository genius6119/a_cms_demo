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
import cn.qimu.mybatis.dao.UserMapper;
import cn.qimu.mybatis.model.User;
import cn.qimu.mybatis.model.UserExample;
import cn.qimu.mybatis.model.UserExample.Criteria;
import cn.qimu.service.UserService;
import cn.qimu.utils.UUIDUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	protected UserMapper userMapper;

	@Override
	public long saveUser(User user) {
		if (user == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
			
		return userMapper.insertSelective(user);
	}

	@Override
	public long deleteUser(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return userMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public long batchDeleteUser(User user) {
		if (user == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		UserExample example = createUserExample(user);
		return userMapper.deleteByExample(example);
	}

	@Override
	public long updateUser(User user) {
		if (user == null || user.getId() == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}

		return userMapper.updateByPrimaryKeySelective(user);
	}
	
	@Override
	public long updateUserByCondtion(User user, User conditonObject) {
		if (user == null || conditonObject == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		UserExample example = createUserExample(user);
		return userMapper.updateByExample(user, example);
	}

	@Override
	public User getUser(Integer id) {
		if (id == null)	{
				throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
	    }
		return userMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<User> getUser(User user) {
		if (user == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		UserExample example = createUserExample(user);
		return userMapper.selectByExample(example);
	}

	@Override
	public List<User> listUserByPage(User user) {
		if (user == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		
		UserExample example = createUserExample(user);
		
		// orderBy 如果orderBy 为 null和空，那么不排序，反之按传入条件排序
		if (!StringUtils.isBlank(user.getOrder()))
			example.setOrderByClause(user.getOrder());
		PageHelper.startPage(user.getCurPage(), user.getSize(), false);
		return userMapper.selectByExample(example);
	}
	
	@Override
	public List<User> listAllUser(User user) {
		if (user == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		UserExample example = createUserExample(user);
		return userMapper.selectByExample(example);
	}

	@Override
	public long countUser(User user) {
		if (user == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		UserExample example = createUserExample(user);
		return userMapper.countByExample(example);
	}
	
	@Transactional
	@Override
	public HashMap<String, Object> countNListUserByPage(User user) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<User> data = listUserByPage(user);
		long count = countUser(user);
		map.put("data", data);
		map.put("count", count);
		return map;
	}

	@Override
	public UserExample createUserExample(User user) {
		return null;
	}

	@Override
	public User findUserByUserName(String username) {
		User user=userMapper.selectByUsername(username);
		return user;
	}


	public UserExample createUserExampleByEqualCondition(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();

		if (user.getId() != null) {
			criteria.andIdEqualTo(user.getId());
		}

		if (user.getUsername() != null) {
			criteria.andUsernameEqualTo(user.getUsername());
		}

		if (user.getPassword() != null) {
			criteria.andPasswordEqualTo(user.getPassword());
		}

		if (user.getRealname() != null) {
			criteria.andRealnameEqualTo(user.getRealname());
		}

		return example;
	}
	

}
