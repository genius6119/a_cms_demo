package cn.qimu.mybatis.dao;

import cn.qimu.common.QueryCondition;
import cn.qimu.mybatis.model.ActivityNews;
import cn.qimu.mybatis.model.ActivityNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityNewsMapper {
    int countByExample(ActivityNewsExample example);

    int deleteByExample(ActivityNewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivityNews record);

    int insertSelective(ActivityNews record);



    List<ActivityNews> selectByExample(ActivityNewsExample example);

    ActivityNews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivityNews record, @Param("example") ActivityNewsExample example);


    int updateByExample(@Param("record") ActivityNews record, @Param("example") ActivityNewsExample example);

    int updateByPrimaryKeySelective(ActivityNews record);


    int updateByPrimaryKey(ActivityNews record);

    ActivityNews selectTitleByPrimaryKey(Integer id);

    ActivityNews selectDateByPrimaryKey(Integer id);

    ActivityNews selectArticleByPrimaryKey(Integer id);

    ActivityNews selectPictureByPrimaryKey(Integer id);

    List<ActivityNews> selectAllActivityNews();

    int countByCondition(QueryCondition condition);

    List<ActivityNews> selectActivityNewsPage(QueryCondition condition);

    void deleteOldActivityNews();
}