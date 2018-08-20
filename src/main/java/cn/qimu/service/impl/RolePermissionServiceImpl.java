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
import cn.qimu.mybatis.dao.RolePermissionMapper;
import cn.qimu.mybatis.model.RolePermission;
import cn.qimu.mybatis.model.RolePermissionExample;
import cn.qimu.mybatis.model.RolePermissionExample.Criteria;
import cn.qimu.service.RolePermissionService;
import cn.qimu.utils.UUIDUtil;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
	
	@Resource
	protected RolePermissionMapper rolePermissionMapper;

	@Override
	public long saveRolePermission(RolePermission rolePermission) {
		if (rolePermission == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
			
		return rolePermissionMapper.insertSelective(rolePermission);
	}

	@Override
	public long deleteRolePermission(Integer roleId) {
		if (roleId == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return rolePermissionMapper.deleteByPrimaryKey(roleId);
	}
	
	@Override
	public long batchDeleteRolePermission(RolePermission rolePermission) {
		if (rolePermission == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		RolePermissionExample example = createRolePermissionExample(rolePermission);
		return rolePermissionMapper.deleteByExample(example);
	}

	@Override
	public long updateRolePermission(RolePermission rolePermission) {
		if (rolePermission == null || rolePermission.getRoleId() == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}

		return rolePermissionMapper.updateByPrimaryKeySelective(rolePermission);
	}
	
	@Override
	public long updateRolePermissionByCondtion(RolePermission rolePermission, RolePermission conditonObject) {
		if (rolePermission == null || conditonObject == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		RolePermissionExample example = createRolePermissionExample(rolePermission);
		return rolePermissionMapper.updateByExample(rolePermission, example);
	}

	@Override
	public RolePermission getRolePermission(Integer roleId) {
		if (roleId == null)	{
				throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
	    }
		return rolePermissionMapper.selectByPrimaryKey(roleId);
	}
	
	@Override
	public List<RolePermission> getRolePermission(RolePermission rolePermission) {
		if (rolePermission == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		RolePermissionExample example = createRolePermissionExample(rolePermission);
		return rolePermissionMapper.selectByExample(example);
	}

	@Override
	public List<RolePermission> listRolePermissionByPage(RolePermission rolePermission) {
		if (rolePermission == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		
		RolePermissionExample example = createRolePermissionExample(rolePermission);
		
		// orderBy 如果orderBy 为 null和空，那么不排序，反之按传入条件排序
		if (!StringUtils.isBlank(rolePermission.getOrder()))
			example.setOrderByClause(rolePermission.getOrder());
		PageHelper.startPage(rolePermission.getCurPage(), rolePermission.getSize(), false);
		return rolePermissionMapper.selectByExample(example);
	}
	
	@Override
	public List<RolePermission> listAllRolePermission(RolePermission rolePermission) {
		if (rolePermission == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		RolePermissionExample example = createRolePermissionExample(rolePermission);
		return rolePermissionMapper.selectByExample(example);
	}

	@Override
	public long countRolePermission(RolePermission rolePermission) {
		if (rolePermission == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		RolePermissionExample example = createRolePermissionExample(rolePermission);
		return rolePermissionMapper.countByExample(example);
	}
	
	@Transactional
	@Override
	public HashMap<String, Object> countNListRolePermissionByPage(RolePermission rolePermission) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<RolePermission> data = listRolePermissionByPage(rolePermission);
		long count = countRolePermission(rolePermission);
		map.put("data", data);
		map.put("count", count);
		return map;
	}
	
	@Override
	public RolePermissionExample createRolePermissionExample(RolePermission rolePermission) {
		RolePermissionExample example = new RolePermissionExample();
		Criteria criteria = example.createCriteria();
			
		if (rolePermission.getRoleId() != null) {
			criteria.andRoleIdEqualTo(rolePermission.getRoleId());
		}
				
		if (rolePermission.getPermissionId() != null) {
			criteria.andPermissionIdEqualTo(rolePermission.getPermissionId());
		}
			
		return example;
	}
	

}
