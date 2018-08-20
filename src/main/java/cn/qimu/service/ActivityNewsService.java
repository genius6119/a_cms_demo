package cn.qimu.service;

import cn.qimu.common.PageQueryBean;
import cn.qimu.common.QueryCondition;
import cn.qimu.mybatis.model.ActivityNews;
import cn.qimu.mybatis.model.ActivityNewsExample;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author
 * @date 2018-07-26 11:48:55
 */
public interface ActivityNewsService {

	/**
	 * 保存对象，实际为向数据库 insert 数据
	 * @param activityNews 插入的实体对象
	 */
	long saveActivityNews(ActivityNews activityNews);
	
	/**
	 * 根据主键删除对象
	 * @param id
	 */
	long deleteActivityNews(Integer id);
	
	/**
	 * 根据对象批量删除对象，使用 batchDelete 这个名称，而没有直接用 delete的原因是为了防止误用
	 * @param id
	 */
	long batchDeleteActivityNews(ActivityNews activityNews);
	
	/**
	 * 根据主键更新数据，用于更新单条数据
	 * @param activityNews
	 */
	long updateActivityNews(ActivityNews activityNews);
	
	/**
	 * 根据条件更新数据，主要用于批量修改数据
	 * @param updateData 需要更新的数据值
	 * @param conditonObject 更新的条件值，对应的就是 sql中where条件
	 */
	long updateActivityNewsByCondtion(ActivityNews updateData, ActivityNews conditonObject);
	
	/**
	 * 根据主键来获取对象
	 * @param id
	 */
	ActivityNews getActivityNews(Integer id);
	
	/**
	 * 根据条件来获取对象，主要用于获取批量数据
	 * @param activityNews
	 */
	List<ActivityNews> getActivityNews(ActivityNews activityNews);
	
	/**
	 * 分页获取数据列表数据；
	 * @param activityNews 获取数据的 where 条件
	 */
	List<ActivityNews> listActivityNewsByPage(ActivityNews activityNews);
	
	/**
	 * 获取数据列表数据
	 * @param activityNews 获取数据的 where 条件
	 */
	List<ActivityNews> listAllActivityNews(ActivityNews activityNews);
	
	/**
	 * 获取数据总量
	 * @param activityNews 获取数据的 where 条件
	 */
	long countActivityNews(ActivityNews activityNews);
	
	/**
	 * 分页获取数据列表数据；并返回数据总量
	 * @param activityNews 获取数据的 where 条件
	 */
	HashMap<String, Object> countNListActivityNewsByPage(ActivityNews activityNews);
	
	/**
	 * 根据对象来构建 MyBatis 的Example对象
	 * @param activityNews 获取数据的 where 条件
	 */
	ActivityNewsExample createActivityNewsExample(ActivityNews activityNews);

	ActivityNewsExample createActivityNewsExampleByEqualCondition(ActivityNews activityNews);

	ActivityNews getActivityNewsTitle(Integer id);

	ActivityNews getActivityNewsDate(Integer id);

	ActivityNews getActivityNewsArticle(Integer id);

	ActivityNews getActivityNewsPicture(Integer id);

    PageQueryBean getAllActivityNews(QueryCondition queryCondition);

	void deleteOldActivityNews();

    String uploadQiniu(MultipartFile file);
}
