package cn.qimu.service.impl;

import cn.qimu.common.ApiStrings;
import cn.qimu.common.PageQueryBean;
import cn.qimu.common.QiniuInvoke;
import cn.qimu.common.QueryCondition;
import cn.qimu.exception.BusinessException;
import cn.qimu.mybatis.dao.PositionTypeMapper;
import cn.qimu.mybatis.model.PositionType;
import cn.qimu.mybatis.model.PositionTypeExample;
import cn.qimu.mybatis.model.PositionTypeExample.Criteria;
import cn.qimu.service.PositionTypeService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class PositionTypeServiceImpl implements PositionTypeService {
	
	@Resource
	protected PositionTypeMapper positionTypeMapper;

	@Override
	public long savePositionType(PositionType positionType) {
		if (positionType == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
			
		return positionTypeMapper.insertSelective(positionType);
	}

	@Override
	public long deletePositionType(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return positionTypeMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public long batchDeletePositionType(PositionType positionType) {
		if (positionType == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		PositionTypeExample example = createPositionTypeExample(positionType);
		return positionTypeMapper.deleteByExample(example);
	}

	@Override
	public long updatePositionType(PositionType positionType) {
		if (positionType == null || positionType.getId() == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}

		return positionTypeMapper.updateByPrimaryKeySelective(positionType);
	}
	
	@Override
	public long updatePositionTypeByCondtion(PositionType positionType, PositionType conditonObject) {
		if (positionType == null || conditonObject == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		PositionTypeExample example = createPositionTypeExample(positionType);
		return positionTypeMapper.updateByExample(positionType, example);
	}

	@Override
	public PositionType getPositionType(Integer id) {
		if (id == null)	{
				throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
	    }
		return positionTypeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<PositionType> getPositionType(PositionType positionType) {
		if (positionType == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		PositionTypeExample example = createPositionTypeExample(positionType);
		return positionTypeMapper.selectByExample(example);
	}

	@Override
	public List<PositionType> listPositionTypeByPage(PositionType positionType) {
		if (positionType == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		
		PositionTypeExample example = createPositionTypeExample(positionType);
		
		// orderBy 如果orderBy 为 null和空，那么不排序，反之按传入条件排序
		if (!StringUtils.isBlank(positionType.getOrder()))
			example.setOrderByClause(positionType.getOrder());
		PageHelper.startPage(positionType.getCurPage(), positionType.getSize(), false);
		return positionTypeMapper.selectByExample(example);
	}
	
	@Override
	public List<PositionType> listAllPositionType(PositionType positionType) {
		if (positionType == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		PositionTypeExample example = createPositionTypeExample(positionType);
		return positionTypeMapper.selectByExample(example);
	}

	@Override
	public long countPositionType(PositionType positionType) {
		if (positionType == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		PositionTypeExample example = createPositionTypeExample(positionType);
		return positionTypeMapper.countByExample(example);
	}
	
	@Transactional
	@Override
	public HashMap<String, Object> countNListPositionTypeByPage(PositionType positionType) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<PositionType> data = listPositionTypeByPage(positionType);
		long count = countPositionType(positionType);
		map.put("data", data);
		map.put("count", count);
		return map;
	}

	@Override
	public PositionTypeExample createPositionTypeExample(PositionType positionType) {
		return null;
	}

	@Override
	public PositionTypeExample createPositionTypeExampleByEqualCondition(PositionType positionType) {
		PositionTypeExample example = new PositionTypeExample();
		Criteria criteria = example.createCriteria();
			
		if (positionType.getId() != null) {
			criteria.andIdEqualTo(positionType.getId());
		}
				
		if (positionType.getPositionTypeName() != null) {
			criteria.andPositionTypeNameEqualTo(positionType.getPositionTypeName());
		}
				
		if (positionType.getPositionIcon() != null) {
			criteria.andPositionIconEqualTo(positionType.getPositionIcon());
		}
				
		if (positionType.getIsDelete() != null) {
			criteria.andIsDeleteEqualTo(positionType.getIsDelete());
		}
			
		return example;
	}

	@Override
	public PositionType getPositionTypeName(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return positionTypeMapper.selectNameByPrimaryKey(id);
	}

	@Override
	public PositionType getPositionTypeIcon(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return positionTypeMapper.selectIconByPrimaryKey(id);
	}

	@Override
	public PageQueryBean getAllType(QueryCondition condition) {
		//根据条件查询 count记录数目
		int count = positionTypeMapper.countByCondition(condition);
		PageQueryBean pageResult = new PageQueryBean();
		if(count>0){
			pageResult.setTotalRows(count);
			pageResult.setCurrentPage(condition.getCurrentPage());
			pageResult.setPageSize(condition.getPageSize());
			List<PositionType> list =  positionTypeMapper.selectTypePage(condition);
			pageResult.setItems(list);
		}
		//如果有记录 才去查询分页数据 没有相关记录数目 没必要去查分页数据
		return pageResult;
	}

	@Override
	public String uploadQiniu(MultipartFile file) {
		String url=QiniuInvoke.callQiniu(file,0);
		return url;
	}


}
