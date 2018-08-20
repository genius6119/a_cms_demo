/* Qimu Co.,Lmt. */
package cn.qimu.mybatis.dao;

import cn.qimu.mybatis.model.Shop;
import cn.qimu.mybatis.model.ShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 本文件由 mybatis-generator 自动生成
 * @author Qimu Co.,Lmt.
 */
public interface ShopMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(ShopExample example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(ShopExample example);

    /** 
     * 根据主键删除数据库的记录
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /** 
     * 新写入数据库记录
     * @param record
     */
    int insert(Shop record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(Shop record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<Shop> selectByExample(ShopExample example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param id
     */
    Shop selectByPrimaryKey(Integer id);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Shop record, @Param("example") ShopExample example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Shop record, @Param("example") ShopExample example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(Shop record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(Shop record);
}