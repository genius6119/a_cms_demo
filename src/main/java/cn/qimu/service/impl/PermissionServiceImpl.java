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
import cn.qimu.mybatis.dao.PermissionMapper;
import cn.qimu.mybatis.model.Permission;
import cn.qimu.mybatis.model.PermissionExample;
import cn.qimu.mybatis.model.PermissionExample.Criteria;
import cn.qimu.service.PermissionService;
import cn.qimu.utils.UUIDUtil;

@Service
public class PermissionServiceImpl implements PermissionService {
	
	@Resource
	protected PermissionMapper permissionMapper;

	@Override
	public long savePermission(Permission permission) {
		if (permission == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
			
		return permissionMapper.insertSelective(permission);
	}

	@Override
	public long deletePermission(Integer permissionid) {
		if (permissionid == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return permissionMapper.deleteByPrimaryKey(permissionid);
	}
	
	@Override
	public long batchDeletePermission(Permission permission) {
		if (permission == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		PermissionExample example = createPermissionExample(permission);
		return permissionMapper.deleteByExample(example);
	}

	@Override
	public long updatePermission(Permission permission) {
		if (permission == null || permission.getPermissionid() == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}

		return permissionMapper.updateByPrimaryKeySelective(permission);
	}
	
	@Override
	public long updatePermissionByCondtion(Permission permission, Permission conditonObject) {
		if (permission == null || conditonObject == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		PermissionExample example = createPermissionExample(permission);
		return permissionMapper.updateByExample(permission, example);
	}

	@Override
	public Permission getPermission(Integer permissionid) {
		if (permissionid == null)	{
				throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
	    }
		return permissionMapper.selectByPrimaryKey(permissionid);
	}
	
	@Override
	public List<Permission> getPermission(Permission permission) {
		if (permission == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		PermissionExample example = createPermissionExample(permission);
		return permissionMapper.selectByExample(example);
	}

	@Override
	public List<Permission> listPermissionByPage(Permission permission) {
		if (permission == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		
		PermissionExample example = createPermissionExample(permission);
		
		// orderBy 如果orderBy 为 null和空，那么不排序，反之按传入条件排序
		if (!StringUtils.isBlank(permission.getOrder()))
			example.setOrderByClause(permission.getOrder());
		PageHelper.startPage(permission.getCurPage(), permission.getSize(), false);
		return permissionMapper.selectByExample(example);
	}
	
	@Override
	public List<Permission> listAllPermission(Permission permission) {
		if (permission == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		PermissionExample example = createPermissionExample(permission);
		return permissionMapper.selectByExample(example);
	}

	@Override
	public long countPermission(Permission permission) {
		if (permission == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		PermissionExample example = createPermissionExample(permission);
		return permissionMapper.countByExample(example);
	}
	
	@Transactional
	@Override
	public HashMap<String, Object> countNListPermissionByPage(Permission permission) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Permission> data = listPermissionByPage(permission);
		long count = countPermission(permission);
		map.put("data", data);
		map.put("count", count);
		return map;
	}
	
	@Override
	public PermissionExample createPermissionExample(Permission permission) {
		PermissionExample example = new PermissionExample();
		Criteria criteria = example.createCriteria();
			
		if (permission.getPermissionid() != null) {
			criteria.andPermissionidEqualTo(permission.getPermissionid());
		}
				
		if (permission.getPermission() != null) {
			criteria.andPermissionEqualTo(permission.getPermission());
		}
				
		if (permission.getDescription() != null) {
			criteria.andDescriptionEqualTo(permission.getDescription());
		}
			
		return example;
	}
	

}
