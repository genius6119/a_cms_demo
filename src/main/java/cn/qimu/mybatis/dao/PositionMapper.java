package cn.qimu.mybatis.dao;

import cn.qimu.common.PositionCondition;
import cn.qimu.mybatis.model.Position;
import cn.qimu.mybatis.model.PositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionMapper {
    int countByExample(PositionExample example);

    int deleteByExample(PositionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectByExample(PositionExample example);

    Position selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByExample(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> selectSameTypePositionByPrimaryKey(Integer id);

    Position selectPositionWorkExpByPrimaryKey(Integer id);

    Position selectPositionNumByPrimaryKey(Integer id);

    Position selectPositionNameByPrimaryKey(Integer id);

    Position selectPositionRequireByPrimaryKey(Integer id);

    Position selectPositionEduBackgroundByPrimaryKey(Integer id);

    Position selectPositionDutyByPrimaryKey(Integer id);

    int countByCondition(PositionCondition condition);

    List<Position> selectPositionPage(PositionCondition condition);
}