package cn.qimu.service;

import cn.qimu.common.PageQueryBean;
import cn.qimu.common.QueryCondition;
import cn.qimu.mybatis.model.BrandShoe;
import cn.qimu.mybatis.model.BrandShoeExample;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author zwx
 * @date 2018-07-25 10:11:01
 */
public interface BrandShoeService {

	/**
	 * 保存对象，实际为向数据库 insert 数据
	 * @param brandShoe 插入的实体对象
	 */
	long saveBrandShoe(BrandShoe brandShoe);
	
	/**
	 * 根据主键删除对象
	 * @param id
	 */
	long deleteBrandShoe(Integer id);
	
	/**
	 * 根据对象批量删除对象，使用 batchDelete 这个名称，而没有直接用 delete的原因是为了防止误用
	 * @param id
	 */
	long batchDeleteBrandShoe(BrandShoe brandShoe);
	
	/**
	 * 根据主键更新数据，用于更新单条数据
	 * @param brandShoe
	 */
	long updateBrandShoe(BrandShoe brandShoe);
	
	/**
	 * 根据条件更新数据，主要用于批量修改数据
	 * @param updateData 需要更新的数据值
	 * @param conditonObject 更新的条件值，对应的就是 sql中where条件
	 */
	long updateBrandShoeByCondtion(BrandShoe updateData, BrandShoe conditonObject);
	
	/**
	 * 根据主键来获取对象
	 * @param id
	 */
	BrandShoe getBrandShoe(Integer id);
	
	/**
	 * 根据条件来获取对象，主要用于获取批量数据
	 * @param brandShoe
	 */
	List<BrandShoe> getBrandShoe(BrandShoe brandShoe);
	
	/**
	 * 分页获取数据列表数据；
	 * @param brandShoe 获取数据的 where 条件
	 */
	List<BrandShoe> listBrandShoeByPage(BrandShoe brandShoe);
	
	/**
	 * 获取数据列表数据
	 * @param brandShoe 获取数据的 where 条件
	 */
	List<BrandShoe> listAllBrandShoe(BrandShoe brandShoe);
	
	/**
	 * 获取数据总量
	 * @param brandShoe 获取数据的 where 条件
	 */
	long countBrandShoe(BrandShoe brandShoe);
	
	/**
	 * 分页获取数据列表数据；并返回数据总量
	 * @param brandShoe 获取数据的 where 条件
	 */
	HashMap<String, Object> countNListBrandShoeByPage(BrandShoe brandShoe);
	
	/**
	 * 根据对象来构建 MyBatis 的Example对象
	 * @param brandShoe 获取数据的 where 条件
	 */
	BrandShoeExample createBrandShoeExample(BrandShoe brandShoe);

	BrandShoeExample createBrandShoeExampleByEqualCondition(BrandShoe brandShoe);

    BrandShoe getShoeBrandId(Integer id);

	BrandShoe getBrandShoeName(Integer id);

	BrandShoe getBrandShoePicture(Integer id);

	BrandShoe getBrandShoeShop(Integer id);

    PageQueryBean getAllBrand(QueryCondition condition);

    String uploadQiniu(MultipartFile file);
}
