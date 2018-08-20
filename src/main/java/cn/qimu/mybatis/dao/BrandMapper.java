package cn.qimu.mybatis.dao;

import cn.qimu.common.QueryCondition;
import cn.qimu.mybatis.model.ActivityNews;
import cn.qimu.mybatis.model.Brand;
import cn.qimu.mybatis.model.BrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandMapper {
    int countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Brand record);

    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    Brand selectNameByPrimaryKey(Integer id);

    Brand selectDescribeByPrimaryKey(Integer id);

    Brand selectIconByPrimaryKey(Integer id);

    int countByCondition(QueryCondition condition);

    List<?> selectBrandPage(QueryCondition condition);
}