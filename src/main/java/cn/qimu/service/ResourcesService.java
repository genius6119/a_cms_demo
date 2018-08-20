package cn.qimu.service;

import cn.qimu.common.PageQueryBean;
import cn.qimu.common.ResourceCondition;
import cn.qimu.mybatis.model.Resources;
import cn.qimu.mybatis.model.ResourcesExample;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author zwx
 * @date 2018-07-25 10:02:41
 */
public interface ResourcesService {



	/**
	 * 保存对象，实际为向数据库 insert 数据
	 * @param resources 插入的实体对象
	 */
	long saveResources(Resources resources);
	
	/**
	 * 根据主键删除对象
	 * @param id
	 */
	long deleteResources(Integer id);
	
	/**
	 * 根据对象批量删除对象，使用 batchDelete 这个名称，而没有直接用 delete的原因是为了防止误用
	 * @param
	 */
	long batchDeleteResources(Resources resources);
	
	/**
	 * 根据主键更新数据，用于更新单条数据
	 * @param resources
	 */
	long updateResources(Resources resources);
	
	/**
	 * 根据条件更新数据，主要用于批量修改数据
	 * @param updateData 需要更新的数据值
	 * @param conditonObject 更新的条件值，对应的就是 sql中where条件
	 */
	long updateResourcesByCondtion(Resources updateData, Resources conditonObject);
	
	/**
	 * 根据主键来获取对象
	 * @param id
	 */
	Resources getResources(Integer id);
	
	/**
	 * 根据条件来获取对象，主要用于获取批量数据
	 * @param resources
	 */
	List<Resources> getResources(Resources resources);
	
	/**
	 * 分页获取数据列表数据；
	 * @param resources 获取数据的 where 条件
	 */
	List<Resources> listResourcesByPage(Resources resources);
	
	/**
	 * 获取数据列表数据
	 * @param resources 获取数据的 where 条件
	 */
	List<Resources> listAllResources(Resources resources);
	
	/**
	 * 获取数据总量
	 * @param resources 获取数据的 where 条件
	 */
	long countResources(Resources resources);
	
	/**
	 * 分页获取数据列表数据；并返回数据总量
	 * @param resources 获取数据的 where 条件
	 */
	HashMap<String, Object> countNListResourcesByPage(Resources resources);
	
	/**
	 * 根据对象来构建 MyBatis 的Example对象
	 * @param resources 获取数据的 where 条件
	 */
	ResourcesExample createResourcesExample(Resources resources);

	ResourcesExample createResourcesExampleByEqualCondition(Resources resources);

	List<Resources> getSamePlaceResources(String page, Integer group);

	/**文件下载*/
	File buildFileById(Integer id);


	PageQueryBean getAllResources(ResourceCondition condition);

    String uploadQiniu(MultipartFile file, Integer resourceType);
}
