package cn.qimu.service;

import cn.qimu.common.PageQueryBean;
import cn.qimu.common.QueryCondition;
import cn.qimu.mybatis.model.PositionType;
import cn.qimu.mybatis.model.PositionTypeExample;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author zwx
 * @date 2018-07-25 10:15:05
 */
public interface PositionTypeService {

	/**
	 * 保存对象，实际为向数据库 insert 数据
	 * @param positionType 插入的实体对象
	 */
	long savePositionType(PositionType positionType);
	
	/**
	 * 根据主键删除对象
	 * @param id
	 */
	long deletePositionType(Integer id);
	
	/**
	 * 根据对象批量删除对象，使用 batchDelete 这个名称，而没有直接用 delete的原因是为了防止误用
	 * @param id
	 */
	long batchDeletePositionType(PositionType positionType);
	
	/**
	 * 根据主键更新数据，用于更新单条数据
	 * @param positionType
	 */
	long updatePositionType(PositionType positionType);
	
	/**
	 * 根据条件更新数据，主要用于批量修改数据
	 * @param updateData 需要更新的数据值
	 * @param conditonObject 更新的条件值，对应的就是 sql中where条件
	 */
	long updatePositionTypeByCondtion(PositionType updateData, PositionType conditonObject);
	
	/**
	 * 根据主键来获取对象
	 * @param id
	 */
	PositionType getPositionType(Integer id);
	
	/**
	 * 根据条件来获取对象，主要用于获取批量数据
	 * @param positionType
	 */
	List<PositionType> getPositionType(PositionType positionType);
	
	/**
	 * 分页获取数据列表数据；
	 * @param positionType 获取数据的 where 条件
	 */
	List<PositionType> listPositionTypeByPage(PositionType positionType);
	
	/**
	 * 获取数据列表数据
	 * @param positionType 获取数据的 where 条件
	 */
	List<PositionType> listAllPositionType(PositionType positionType);
	
	/**
	 * 获取数据总量
	 * @param positionType 获取数据的 where 条件
	 */
	long countPositionType(PositionType positionType);
	
	/**
	 * 分页获取数据列表数据；并返回数据总量
	 * @param positionType 获取数据的 where 条件
	 */
	HashMap<String, Object> countNListPositionTypeByPage(PositionType positionType);
	
	/**
	 * 根据对象来构建 MyBatis 的Example对象
	 * @param positionType 获取数据的 where 条件
	 */
	PositionTypeExample createPositionTypeExample(PositionType positionType);

	PositionTypeExample createPositionTypeExampleByEqualCondition(PositionType positionType);

    PositionType getPositionTypeName(Integer id);

	PositionType getPositionTypeIcon(Integer id);


    PageQueryBean getAllType(QueryCondition condition);

    String uploadQiniu(MultipartFile file);
}
