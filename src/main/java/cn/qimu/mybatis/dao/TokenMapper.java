/* Qimu Co.,Lmt. */
package cn.qimu.mybatis.dao;

import cn.qimu.mybatis.model.Token;
import cn.qimu.mybatis.model.TokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 本文件由 mybatis-generator 自动生成
 * @author Qimu Co.,Lmt.
 */
public interface TokenMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(TokenExample example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(TokenExample example);

    /** 
     * 根据主键删除数据库的记录
     * @param tokenCode
     */
    int deleteByPrimaryKey(String tokenCode);

    /** 
     * 新写入数据库记录
     * @param record
     */
    int insert(Token record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(Token record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<Token> selectByExample(TokenExample example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param tokenCode
     */
    Token selectByPrimaryKey(String tokenCode);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Token record, @Param("example") TokenExample example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Token record, @Param("example") TokenExample example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(Token record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(Token record);
}