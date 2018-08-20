package cn.qimu.mybatis.dao;

import cn.qimu.common.ResourceCondition;
import cn.qimu.mybatis.model.Resources;
import cn.qimu.mybatis.model.ResourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourcesMapper {
    int countByExample(ResourcesExample example);

    int deleteByExample(ResourcesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Resources record);

    int insertSelective(Resources record);

    List<Resources> selectByExample(ResourcesExample example);

    Resources selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Resources record, @Param("example") ResourcesExample example);

    int updateByExample(@Param("record") Resources record, @Param("example") ResourcesExample example);

    int updateByPrimaryKeySelective(Resources record);

    int updateByPrimaryKey(Resources record);

    List<Resources> selectSamePlaceResourcesByPrimaryKey(String page, Integer group);

    String selectUrlByPrimaryKey(Integer id);

    int countByCondition(ResourceCondition condition);

    List<Resources> selectResourcesPage(ResourceCondition condition);
}