package cn.qimu.service;

import cn.qimu.common.PageQueryBean;
import cn.qimu.common.PositionCondition;
import cn.qimu.mybatis.model.Position;
import cn.qimu.mybatis.model.PositionExample;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author zwx
 * @date 2018-07-25 10:12:25
 */
public interface PositionService {

	/**
	 * 保存对象，实际为向数据库 insert 数据
	 * @param position 插入的实体对象
	 */
	long savePosition(Position position);
	
	/**
	 * 根据主键删除对象
	 * @param id
	 */
	long deletePosition(Integer id);
	
	/**
	 * 根据对象批量删除对象，使用 batchDelete 这个名称，而没有直接用 delete的原因是为了防止误用
	 * @param id
	 */
	long batchDeletePosition(Position position);
	
	/**
	 * 根据主键更新数据，用于更新单条数据
	 * @param position
	 */
	long updatePosition(Position position);
	
	/**
	 * 根据条件更新数据，主要用于批量修改数据
	 * @param updateData 需要更新的数据值
	 * @param conditonObject 更新的条件值，对应的就是 sql中where条件
	 */
	long updatePositionByCondtion(Position updateData, Position conditonObject);
	
	/**
	 * 根据主键来获取对象
	 * @param id
	 */
	Position getPosition(Integer id);



    /**
	 * 根据条件来获取对象，主要用于获取批量数据
	 * @param position
	 */
	List<Position> getPosition(Position position);
	
	/**
	 * 分页获取数据列表数据；
	 * @param position 获取数据的 where 条件
	 */
	List<Position> listPositionByPage(Position position);
	
	/**
	 * 获取数据列表数据
	 * @param position 获取数据的 where 条件
	 */
	List<Position> listAllPosition(Position position);
	
	/**
	 * 获取数据总量
	 * @param position 获取数据的 where 条件
	 */
	long countPosition(Position position);
	
	/**
	 * 分页获取数据列表数据；并返回数据总量
	 * @param position 获取数据的 where 条件
	 */
	HashMap<String, Object> countNListPositionByPage(Position position);
	
	/**
	 * 根据对象来构建 MyBatis 的Example对象
	 * @param position 获取数据的 where 条件
	 */
	PositionExample createPositionExample(Position position);

	PositionExample createPositionExampleByEqualCondition(Position position);

	List<Position> getSameTypePosition(Integer id);

	Position getPositionName(Integer id);

	Position getPositionNum(Integer id);

	Position getPositionWorkExperience(Integer id);

	Position getPositionRequire(Integer id);

	Position getPositionEduBackground(Integer id);

	Position getPositionDuty(Integer id);

    PageQueryBean getAllPosition(PositionCondition condition);
}
