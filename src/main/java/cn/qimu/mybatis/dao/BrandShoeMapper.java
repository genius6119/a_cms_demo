package cn.qimu.mybatis.dao;

import cn.qimu.common.QueryCondition;
import cn.qimu.mybatis.model.ActivityNews;
import cn.qimu.mybatis.model.BrandShoe;
import cn.qimu.mybatis.model.BrandShoeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandShoeMapper {
    int countByExample(BrandShoeExample example);

    int deleteByExample(BrandShoeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BrandShoe record);

    int insertSelective(BrandShoe record);

    List<BrandShoe> selectByExample(BrandShoeExample example);

    BrandShoe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BrandShoe record, @Param("example") BrandShoeExample example);

    int updateByExample(@Param("record") BrandShoe record, @Param("example") BrandShoeExample example);

    int updateByPrimaryKeySelective(BrandShoe record);

    int updateByPrimaryKey(BrandShoe record);

    BrandShoe selectBrandIdByPrimaryKey(Integer id);

    BrandShoe selectShoeNameByPrimaryKey(Integer id);

    BrandShoe selectShoePictureByPrimaryKey(Integer id);

    BrandShoe selectShoeShopByPrimaryKey(Integer id);

    int countByCondition(QueryCondition condition);

    List<?> selectBrandShoePage(QueryCondition condition);
}