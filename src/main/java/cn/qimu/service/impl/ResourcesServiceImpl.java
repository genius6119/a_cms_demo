package cn.qimu.service.impl;

import cn.qimu.common.ApiStrings;
import cn.qimu.common.PageQueryBean;
import cn.qimu.common.QiniuInvoke;
import cn.qimu.common.ResourceCondition;
import cn.qimu.exception.BusinessException;
import cn.qimu.mybatis.dao.ResourcesMapper;
import cn.qimu.mybatis.model.Resources;
import cn.qimu.mybatis.model.ResourcesExample;
import cn.qimu.mybatis.model.ResourcesExample.Criteria;
import cn.qimu.service.ResourcesService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.List;

@Service
public class ResourcesServiceImpl implements ResourcesService {
	
	@Resource
	protected ResourcesMapper resourcesMapper;

	@Override
	public long saveResources(Resources resources) {
		if (resources == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
			
		return resourcesMapper.insertSelective(resources);
	}

	@Override
	public long deleteResources(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return resourcesMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public long batchDeleteResources(Resources resources) {
		if (resources == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		ResourcesExample example = createResourcesExample(resources);
		return resourcesMapper.deleteByExample(example);
	}

	@Override
	public long updateResources(Resources resources) {
		if (resources == null || resources.getId() == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}

		return resourcesMapper.updateByPrimaryKeySelective(resources);
	}
	
	@Override
	public long updateResourcesByCondtion(Resources resources, Resources conditonObject) {
		if (resources == null || conditonObject == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		ResourcesExample example = createResourcesExample(resources);
		return resourcesMapper.updateByExample(resources, example);
	}

	@Override
	public Resources getResources(Integer id) {
		if (id == null)	{
				throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
	    }
		return resourcesMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<Resources> getResources(Resources resources) {
		if (resources == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		ResourcesExample example = createResourcesExample(resources);
		return resourcesMapper.selectByExample(example);
	}

	@Override
	public List<Resources> listResourcesByPage(Resources resources) {
		if (resources == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		
		ResourcesExample example = createResourcesExample(resources);
		
		// orderBy 如果orderBy 为 null和空，那么不排序，反之按传入条件排序
		if (!StringUtils.isBlank(resources.getOrder()))
			example.setOrderByClause(resources.getOrder());
		PageHelper.startPage(resources.getCurPage(), resources.getSize(), false);
		return resourcesMapper.selectByExample(example);
	}
	
	@Override
	public List<Resources> listAllResources(Resources resources) {
		if (resources == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		ResourcesExample example = createResourcesExample(resources);
		return resourcesMapper.selectByExample(example);
	}

	@Override
	public long countResources(Resources resources) {
		if (resources == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		ResourcesExample example = createResourcesExample(resources);
		return resourcesMapper.countByExample(example);
	}
	
	@Transactional
	@Override
	public HashMap<String, Object> countNListResourcesByPage(Resources resources) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Resources> data = listResourcesByPage(resources);
		long count = countResources(resources);
		map.put("data", data);
		map.put("count", count);
		return map;
	}

	@Override
	public ResourcesExample createResourcesExample(Resources resources) {
		return null;
	}

	@Override
	public ResourcesExample createResourcesExampleByEqualCondition(Resources resources) {
		ResourcesExample example = new ResourcesExample();
		Criteria criteria = example.createCriteria();
			
		if (resources.getId() != null) {
			criteria.andIdEqualTo(resources.getId());
		}
				
		if (resources.getResourceName() != null) {
			criteria.andResourceNameEqualTo(resources.getResourceName());
		}
				
		if (resources.getResourceType() != null) {
			criteria.andResourceTypeEqualTo(resources.getResourceType());
		}
				
		if (resources.getResourceUrl() != null) {
			criteria.andResourceUrlEqualTo(resources.getResourceUrl());
		}
				
		if (resources.getResourcePage() != null) {
			criteria.andResourcePageEqualTo(resources.getResourcePage());
		}
				
		if (resources.getGroup() != null) {
			criteria.andGroupEqualTo(resources.getGroup());
		}
				
		if (resources.getIsDelete() != null) {
			criteria.andIsDeleteEqualTo(resources.getIsDelete());
		}
			
		return example;
	}

	@Override
	public List<Resources> getSamePlaceResources(String page, Integer group) {
		if (page == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return resourcesMapper.selectSamePlaceResourcesByPrimaryKey(page,group);
	}

	@Override
	public File buildFileById(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.NO_DATA_EXIST);
		}
		String resoureceUrl=resourcesMapper.selectUrlByPrimaryKey(id);
		File file=new File(resoureceUrl);
		return file;
	}

	@Override
	public PageQueryBean getAllResources(ResourceCondition condition) {
		//根据条件查询 count记录数目
		int count = resourcesMapper.countByCondition(condition);
		PageQueryBean pageResult = new PageQueryBean();
		if(count>0){
			pageResult.setTotalRows(count);
			pageResult.setCurrentPage(condition.getCurrentPage());
			pageResult.setPageSize(condition.getPageSize());
			List<Resources> list =  resourcesMapper.selectResourcesPage(condition);
			pageResult.setItems(list);
		}
		//如果有记录 才去查询分页数据 没有相关记录数目 没必要去查分页数据
		return pageResult;
	}

	@Override
	public String uploadQiniu(MultipartFile file, Integer resourceType) {
		String url=QiniuInvoke.callQiniu(file,resourceType);
		return url;
	}


}
