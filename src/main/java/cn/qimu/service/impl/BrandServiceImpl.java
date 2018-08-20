package cn.qimu.service.impl;

import cn.qimu.common.*;
import cn.qimu.exception.BusinessException;
import cn.qimu.mybatis.dao.BrandMapper;
import cn.qimu.mybatis.model.ActivityNews;
import cn.qimu.mybatis.model.Brand;
import cn.qimu.mybatis.model.BrandExample;
import cn.qimu.mybatis.model.BrandExample.Criteria;
import cn.qimu.service.BrandService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import cn.qimu.common.QiniuInvoke;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Resource
	protected BrandMapper brandMapper;

	@Override
	public long saveBrand(Brand brand) {
		if (brand == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
			
		return brandMapper.insertSelective(brand);
	}

	@Override
	public long deleteBrand(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return brandMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public long batchDeleteBrand(Brand brand) {
		if (brand == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		BrandExample example = createBrandExample(brand);
		return brandMapper.deleteByExample(example);
	}

	@Override
	public long updateBrand(Brand brand) {
		if (brand == null || brand.getId() == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}

		return brandMapper.updateByPrimaryKeySelective(brand);
	}
	
	@Override
	public long updateBrandByCondtion(Brand brand, Brand conditonObject) {
		if (brand == null || conditonObject == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		BrandExample example = createBrandExample(brand);
		return brandMapper.updateByExample(brand, example);
	}

	@Override
	public Brand getBrand(Integer id) {
		if (id == null)	{
				throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
	    }
		return brandMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<Brand> getBrand(Brand brand) {
		if (brand == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		BrandExample example = createBrandExample(brand);
		return brandMapper.selectByExample(example);
	}

	@Override
	public List<Brand> listBrandByPage(Brand brand) {
		if (brand == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		
		BrandExample example = createBrandExample(brand);
		
		// orderBy 如果orderBy 为 null和空，那么不排序，反之按传入条件排序
		if (!StringUtils.isBlank(brand.getOrder()))
			example.setOrderByClause(brand.getOrder());
		PageHelper.startPage(brand.getCurPage(), brand.getSize(), false);
		return brandMapper.selectByExample(example);
	}
	
	@Override
	public List<Brand> listAllBrand(Brand brand) {
		if (brand == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		BrandExample example = createBrandExample(brand);
		return brandMapper.selectByExample(example);
	}

	@Override
	public long countBrand(Brand brand) {
		if (brand == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		BrandExample example = createBrandExample(brand);
		return brandMapper.countByExample(example);
	}
	
	@Transactional
	@Override
	public HashMap<String, Object> countNListBrandByPage(Brand brand) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Brand> data = listBrandByPage(brand);
		long count = countBrand(brand);
		map.put("data", data);
		map.put("count", count);
		return map;
	}

	@Override
	public BrandExample createBrandExample(Brand brand) {
		return null;
	}

	@Override
	public BrandExample createBrandExampleByEqualCondition(Brand brand) {
		BrandExample example = new BrandExample();
		Criteria criteria = example.createCriteria();
			
		if (brand.getId() != null) {
			criteria.andIdEqualTo(brand.getId());
		}
				
		if (brand.getBrand() != null) {
			criteria.andBrandEqualTo(brand.getBrand());
		}
				
		if (brand.getDescribe() != null) {
			criteria.andDescribeEqualTo(brand.getDescribe());
		}
				
		if (brand.getIconUrl() != null) {
			criteria.andIconUrlEqualTo(brand.getIconUrl());
		}
				
		if (brand.getIsDelete() != null) {
			criteria.andIsDeleteEqualTo(brand.getIsDelete());
		}
			
		return example;
	}

	@Override
	public Brand getBrandName(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return brandMapper.selectNameByPrimaryKey(id);
	}

	@Override
	public Brand getBrandDescribe(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return brandMapper.selectDescribeByPrimaryKey(id);
	}

	@Override
	public Brand getBrandIcon(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return brandMapper.selectIconByPrimaryKey(id);
	}

	@Override
	public PageQueryBean getAllBrand(QueryCondition condition) {
		//根据条件查询 count记录数目
		int count = brandMapper.countByCondition(condition);
		PageQueryBean pageResult = new PageQueryBean();
		if(count>0){
			pageResult.setTotalRows(count);
			pageResult.setCurrentPage(condition.getCurrentPage());
			pageResult.setPageSize(condition.getPageSize());
			List<?> list =  brandMapper.selectBrandPage(condition);
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
