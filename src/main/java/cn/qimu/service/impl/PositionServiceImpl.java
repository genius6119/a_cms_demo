package cn.qimu.service.impl;

import cn.qimu.common.ApiStrings;
import cn.qimu.common.PageQueryBean;
import cn.qimu.common.PositionCondition;
import cn.qimu.exception.BusinessException;
import cn.qimu.mybatis.dao.PositionMapper;
import cn.qimu.mybatis.model.Position;
import cn.qimu.mybatis.model.PositionExample;
import cn.qimu.mybatis.model.PositionExample.Criteria;
import cn.qimu.service.PositionService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
	
	@Resource
	protected PositionMapper positionMapper;

	@Override
	public long savePosition(Position position) {
		if (position == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
			
		return positionMapper.insertSelective(position);
	}

	@Override
	public long deletePosition(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return positionMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public long batchDeletePosition(Position position) {
		if (position == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		PositionExample example = createPositionExample(position);
		return positionMapper.deleteByExample(example);
	}

	@Override
	public long updatePosition(Position position) {
		if (position == null || position.getId() == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}

		return positionMapper.updateByPrimaryKeySelective(position);
	}
	
	@Override
	public long updatePositionByCondtion(Position position, Position conditonObject) {
		if (position == null || conditonObject == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		PositionExample example = createPositionExample(position);
		return positionMapper.updateByExample(position, example);
	}

	@Override
	public Position getPosition(Integer id) {
		if (id == null)	{
				throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
	    }
		return positionMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Position> getSameTypePosition(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return positionMapper.selectSameTypePositionByPrimaryKey(id);
	}

	@Override
	public Position getPositionName(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return positionMapper.selectPositionNameByPrimaryKey(id);
	}

	@Override
	public Position getPositionNum(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return positionMapper.selectPositionNumByPrimaryKey(id);
	}

	@Override
	public Position getPositionWorkExperience(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return positionMapper.selectPositionWorkExpByPrimaryKey(id);
	}

	@Override
	public Position getPositionRequire(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return positionMapper.selectPositionRequireByPrimaryKey(id);
	}

	@Override
	public Position getPositionEduBackground(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return positionMapper.selectPositionEduBackgroundByPrimaryKey(id);
	}

	@Override
	public Position getPositionDuty(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return positionMapper.selectPositionDutyByPrimaryKey(id);
	}

	@Override
	public PageQueryBean getAllPosition(PositionCondition condition) {
		//根据条件查询 count记录数目
		int count = positionMapper.countByCondition(condition);
		PageQueryBean pageResult = new PageQueryBean();
		if(count>0){
			pageResult.setTotalRows(count);
			pageResult.setCurrentPage(condition.getCurrentPage());
			pageResult.setPageSize(condition.getPageSize());
			List<Position> list =  positionMapper.selectPositionPage(condition);
			pageResult.setItems(list);
		}
		//如果有记录 才去查询分页数据 没有相关记录数目 没必要去查分页数据
		return pageResult;
	}

	@Override
	public List<Position> getPosition(Position position) {
		if (position == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		PositionExample example = createPositionExample(position);
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> listPositionByPage(Position position) {
		if (position == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		
		PositionExample example = createPositionExample(position);
		
		// orderBy 如果orderBy 为 null和空，那么不排序，反之按传入条件排序
		if (!StringUtils.isBlank(position.getOrder()))
			example.setOrderByClause(position.getOrder());
		PageHelper.startPage(position.getCurPage(), position.getSize(), false);
		return positionMapper.selectByExample(example);
	}
	
	@Override
	public List<Position> listAllPosition(Position position) {
		if (position == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		PositionExample example = createPositionExample(position);
		return positionMapper.selectByExample(example);
	}

	@Override
	public long countPosition(Position position) {
		if (position == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		PositionExample example = createPositionExample(position);
		return positionMapper.countByExample(example);
	}
	
	@Transactional
	@Override
	public HashMap<String, Object> countNListPositionByPage(Position position) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Position> data = listPositionByPage(position);
		long count = countPosition(position);
		map.put("data", data);
		map.put("count", count);
		return map;
	}

	@Override
	public PositionExample createPositionExample(Position position) {
		return null;
	}

	@Override
	public PositionExample createPositionExampleByEqualCondition(Position position) {
		PositionExample example = new PositionExample();
		Criteria criteria = example.createCriteria();
			
		if (position.getId() != null) {
			criteria.andIdEqualTo(position.getId());
		}
				
		if (position.getPositionTypeId() != null) {
			criteria.andPositionTypeIdEqualTo(position.getPositionTypeId());
		}
				
		if (position.getPositionName() != null) {
			criteria.andPositionNameEqualTo(position.getPositionName());
		}
				
		if (position.getRequireNumber() != null) {
			criteria.andRequireNumberEqualTo(position.getRequireNumber());
		}
				
		if (position.getWorkExperience() != null) {
			criteria.andWorkExperienceEqualTo(position.getWorkExperience());
		}
				
		if (position.getEducationBackgroud() != null) {
			criteria.andEducationBackgroudEqualTo(position.getEducationBackgroud());
		}
				
		if (position.getPositionRequire() != null) {
			criteria.andPositionRequireEqualTo(position.getPositionRequire());
		}
				
		if (position.getPositionDuty() != null) {
			criteria.andPositionDutyEqualTo(position.getPositionDuty());
		}
				
		if (position.getIsDelete() != null) {
			criteria.andIsDeleteEqualTo(position.getIsDelete());
		}
			
		return example;
	}
	

}
