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
import cn.qimu.mybatis.dao.RoleMapper;
import cn.qimu.mybatis.model.Role;
import cn.qimu.mybatis.model.RoleExample;
import cn.qimu.mybatis.model.RoleExample.Criteria;
import cn.qimu.service.RoleService;
import cn.qimu.utils.UUIDUtil;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource
	protected RoleMapper roleMapper;

	@Override
	public long saveRole(Role role) {
		if (role == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
			
		return roleMapper.insertSelective(role);
	}

	@Override
	public long deleteRole(Integer roleid) {
		if (roleid == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return roleMapper.deleteByPrimaryKey(roleid);
	}
	
	@Override
	public long batchDeleteRole(Role role) {
		if (role == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		RoleExample example = createRoleExample(role);
		return roleMapper.deleteByExample(example);
	}

	@Override
	public long updateRole(Role role) {
		if (role == null || role.getRoleid() == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}

		return roleMapper.updateByPrimaryKeySelective(role);
	}
	
	@Override
	public long updateRoleByCondtion(Role role, Role conditonObject) {
		if (role == null || conditonObject == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		RoleExample example = createRoleExample(role);
		return roleMapper.updateByExample(role, example);
	}

	@Override
	public Role getRole(Integer roleid) {
		if (roleid == null)	{
				throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
	    }
		return roleMapper.selectByPrimaryKey(roleid);
	}
	
	@Override
	public List<Role> getRole(Role role) {
		if (role == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		RoleExample example = createRoleExample(role);
		return roleMapper.selectByExample(example);
	}

	@Override
	public List<Role> listRoleByPage(Role role) {
		if (role == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		
		RoleExample example = createRoleExample(role);
		
		// orderBy 如果orderBy 为 null和空，那么不排序，反之按传入条件排序
		if (!StringUtils.isBlank(role.getOrder()))
			example.setOrderByClause(role.getOrder());
		PageHelper.startPage(role.getCurPage(), role.getSize(), false);
		return roleMapper.selectByExample(example);
	}
	
	@Override
	public List<Role> listAllRole(Role role) {
		if (role == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		RoleExample example = createRoleExample(role);
		return roleMapper.selectByExample(example);
	}

	@Override
	public long countRole(Role role) {
		if (role == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		RoleExample example = createRoleExample(role);
		return roleMapper.countByExample(example);
	}
	
	@Transactional
	@Override
	public HashMap<String, Object> countNListRoleByPage(Role role) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Role> data = listRoleByPage(role);
		long count = countRole(role);
		map.put("data", data);
		map.put("count", count);
		return map;
	}
	
	@Override
	public RoleExample createRoleExample(Role role) {
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
			
		if (role.getRoleid() != null) {
			criteria.andRoleidEqualTo(role.getRoleid());
		}
				
		if (role.getRole() != null) {
			criteria.andRoleEqualTo(role.getRole());
		}
				
		if (role.getDescription() != null) {
			criteria.andDescriptionEqualTo(role.getDescription());
		}
			
		return example;
	}
	

}
