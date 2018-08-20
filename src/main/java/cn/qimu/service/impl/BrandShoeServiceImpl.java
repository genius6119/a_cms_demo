package cn.qimu.service.impl;

import cn.qimu.common.ApiStrings;
import cn.qimu.common.PageQueryBean;
import cn.qimu.common.QiniuInvoke;
import cn.qimu.common.QueryCondition;
import cn.qimu.exception.BusinessException;
import cn.qimu.mybatis.dao.BrandShoeMapper;
import cn.qimu.mybatis.model.ActivityNews;
import cn.qimu.mybatis.model.BrandShoe;
import cn.qimu.mybatis.model.BrandShoeExample;
import cn.qimu.mybatis.model.BrandShoeExample.Criteria;
import cn.qimu.service.BrandShoeService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class BrandShoeServiceImpl implements BrandShoeService {
	
	@Resource
	protected BrandShoeMapper brandShoeMapper;

	@Override
	public long saveBrandShoe(BrandShoe brandShoe) {
		if (brandShoe == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
			
		return brandShoeMapper.insertSelective(brandShoe);
	}

	@Override
	public long deleteBrandShoe(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return brandShoeMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public long batchDeleteBrandShoe(BrandShoe brandShoe) {
		if (brandShoe == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		BrandShoeExample example = createBrandShoeExample(brandShoe);
		return brandShoeMapper.deleteByExample(example);
	}

	@Override
	public long updateBrandShoe(BrandShoe brandShoe) {
		if (brandShoe == null || brandShoe.getId() == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}

		return brandShoeMapper.updateByPrimaryKeySelective(brandShoe);
	}
	
	@Override
	public long updateBrandShoeByCondtion(BrandShoe brandShoe, BrandShoe conditonObject) {
		if (brandShoe == null || conditonObject == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		BrandShoeExample example = createBrandShoeExample(brandShoe);
		return brandShoeMapper.updateByExample(brandShoe, example);
	}

	@Override
	public BrandShoe getBrandShoe(Integer id) {
		if (id == null)	{
				throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
	    }
		return brandShoeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<BrandShoe> getBrandShoe(BrandShoe brandShoe) {
		if (brandShoe == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		BrandShoeExample example = createBrandShoeExample(brandShoe);
		return brandShoeMapper.selectByExample(example);
	}

	@Override
	public List<BrandShoe> listBrandShoeByPage(BrandShoe brandShoe) {
		if (brandShoe == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		
		BrandShoeExample example = createBrandShoeExample(brandShoe);
		
		// orderBy 如果orderBy 为 null和空，那么不排序，反之按传入条件排序
		if (!StringUtils.isBlank(brandShoe.getOrder()))
			example.setOrderByClause(brandShoe.getOrder());
		PageHelper.startPage(brandShoe.getCurPage(), brandShoe.getSize(), false);
		return brandShoeMapper.selectByExample(example);
	}
	
	@Override
	public List<BrandShoe> listAllBrandShoe(BrandShoe brandShoe) {
		if (brandShoe == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		BrandShoeExample example = createBrandShoeExample(brandShoe);
		return brandShoeMapper.selectByExample(example);
	}

	@Override
	public long countBrandShoe(BrandShoe brandShoe) {
		if (brandShoe == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		BrandShoeExample example = createBrandShoeExample(brandShoe);
		return brandShoeMapper.countByExample(example);
	}
	
	@Transactional
	@Override
	public HashMap<String, Object> countNListBrandShoeByPage(BrandShoe brandShoe) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<BrandShoe> data = listBrandShoeByPage(brandShoe);
		long count = countBrandShoe(brandShoe);
		map.put("data", data);
		map.put("count", count);
		return map;
	}

	@Override
	public BrandShoeExample createBrandShoeExample(BrandShoe brandShoe) {
		return null;
	}

	@Override
	public BrandShoeExample createBrandShoeExampleByEqualCondition(BrandShoe brandShoe) {
		BrandShoeExample example = new BrandShoeExample();
		Criteria criteria = example.createCriteria();
			
		if (brandShoe.getId() != null) {
			criteria.andIdEqualTo(brandShoe.getId());
		}
				
		if (brandShoe.getBrandId() != null) {
			criteria.andBrandIdEqualTo(brandShoe.getBrandId());
		}
				
		if (brandShoe.getShoeName() != null) {
			criteria.andShoeNameEqualTo(brandShoe.getShoeName());
		}
				
		if (brandShoe.getShoePicture() != null) {
			criteria.andShoePictureEqualTo(brandShoe.getShoePicture());
		}
				
		if (brandShoe.getShoeUrl() != null) {
			criteria.andShoeUrlEqualTo(brandShoe.getShoeUrl());
		}
				
		if (brandShoe.getIsDelete() != null) {
			criteria.andIsDeleteEqualTo(brandShoe.getIsDelete());
		}
			
		return example;
	}

	@Override
	public BrandShoe getShoeBrandId(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return brandShoeMapper.selectBrandIdByPrimaryKey(id);
	}

	@Override
	public BrandShoe getBrandShoeName(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return brandShoeMapper.selectShoeNameByPrimaryKey(id);
	}

	@Override
	public BrandShoe getBrandShoePicture(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return brandShoeMapper.selectShoePictureByPrimaryKey(id);
	}

	@Override
	public BrandShoe getBrandShoeShop(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return brandShoeMapper.selectShoeShopByPrimaryKey(id);
	}

	@Override
	public PageQueryBean getAllBrand(QueryCondition condition) {
		//根据条件查询 count记录数目
		int count = brandShoeMapper.countByCondition(condition);
		PageQueryBean pageResult = new PageQueryBean();
		if(count>0){
			pageResult.setTotalRows(count);
			pageResult.setCurrentPage(condition.getCurrentPage());
			pageResult.setPageSize(condition.getPageSize());
			List<?> list =  brandShoeMapper.selectBrandShoePage(condition);
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
