package cn.qimu.service;

import cn.qimu.common.PageQueryBean;
import cn.qimu.common.QueryCondition;
import cn.qimu.mybatis.model.Brand;
import cn.qimu.mybatis.model.BrandExample;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author zwx
 * @date 2018-07-25 10:09:49
 */
public interface BrandService {

	/**
	 * 保存对象，实际为向数据库 insert 数据
	 * @param brand 插入的实体对象
	 */
	long saveBrand(Brand brand);
	
	/**
	 * 根据主键删除对象
	 * @param id
	 */
	long deleteBrand(Integer id);
	
	/**
	 * 根据对象批量删除对象，使用 batchDelete 这个名称，而没有直接用 delete的原因是为了防止误用
	 * @param id
	 */
	long batchDeleteBrand(Brand brand);
	
	/**
	 * 根据主键更新数据，用于更新单条数据
	 * @param brand
	 */
	long updateBrand(Brand brand);
	
	/**
	 * 根据条件更新数据，主要用于批量修改数据
	 * @param updateData 需要更新的数据值
	 * @param conditonObject 更新的条件值，对应的就是 sql中where条件
	 */
	long updateBrandByCondtion(Brand updateData, Brand conditonObject);
	
	/**
	 * 根据主键来获取对象
	 * @param id
	 */
	Brand getBrand(Integer id);

	
	/**
	 * 根据条件来获取对象，主要用于获取批量数据
	 * @param brand
	 */
	List<Brand> getBrand(Brand brand);
	
	/**
	 * 分页获取数据列表数据；
	 * @param brand 获取数据的 where 条件
	 */
	List<Brand> listBrandByPage(Brand brand);
	
	/**
	 * 获取数据列表数据
	 * @param brand 获取数据的 where 条件
	 */
	List<Brand> listAllBrand(Brand brand);
	
	/**
	 * 获取数据总量
	 * @param brand 获取数据的 where 条件
	 */
	long countBrand(Brand brand);
	
	/**
	 * 分页获取数据列表数据；并返回数据总量
	 * @param brand 获取数据的 where 条件
	 */
	HashMap<String, Object> countNListBrandByPage(Brand brand);
	
	/**
	 * 根据对象来构建 MyBatis 的Example对象
	 * @param brand 获取数据的 where 条件
	 */
	BrandExample createBrandExample(Brand brand);

	BrandExample createBrandExampleByEqualCondition(Brand brand);

    Brand getBrandName(Integer id);

	Brand getBrandDescribe(Integer id);

	Brand getBrandIcon(Integer id);

    PageQueryBean getAllBrand(QueryCondition condition);

    String uploadQiniu(MultipartFile file);
}
