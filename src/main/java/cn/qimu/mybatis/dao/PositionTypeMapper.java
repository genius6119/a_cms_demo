package cn.qimu.mybatis.dao;

import cn.qimu.common.QueryCondition;
import cn.qimu.mybatis.model.Position;
import cn.qimu.mybatis.model.PositionType;
import cn.qimu.mybatis.model.PositionTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionTypeMapper {
    int countByExample(PositionTypeExample example);

    int deleteByExample(PositionTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PositionType record);

    int insertSelective(PositionType record);

    List<PositionType> selectByExample(PositionTypeExample example);

    PositionType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PositionType record, @Param("example") PositionTypeExample example);

    int updateByExample(@Param("record") PositionType record, @Param("example") PositionTypeExample example);

    int updateByPrimaryKeySelective(PositionType record);

    int updateByPrimaryKey(PositionType record);

    PositionType selectNameByPrimaryKey(Integer id);

    PositionType selectIconByPrimaryKey(Integer id);


    int countByCondition(QueryCondition condition);

    List<PositionType> selectTypePage(QueryCondition condition);
}