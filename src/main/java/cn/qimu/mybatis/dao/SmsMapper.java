/* Qimu Co.,Lmt. */
package cn.qimu.mybatis.dao;

import cn.qimu.mybatis.model.Sms;
import cn.qimu.mybatis.model.SmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 本文件由 mybatis-generator 自动生成
 * @author Qimu Co.,Lmt.
 */
public interface SmsMapper {
    /** 
     * 根据指定的条件获取数据库记录数
     * @param example
     */
    long countByExample(SmsExample example);

    /** 
     * 根据指定的条件删除数据库符合条件的记录
     * @param example
     */
    int deleteByExample(SmsExample example);

    /** 
     * 根据主键删除数据库的记录
     * @param code
     */
    int deleteByPrimaryKey(String code);

    /** 
     * 新写入数据库记录
     * @param record
     */
    int insert(Sms record);

    /** 
     * 动态字段,写入数据库记录
     * @param record
     */
    int insertSelective(Sms record);

    /** 
     * 根据指定的条件查询符合条件的数据库记录
     * @param example
     */
    List<Sms> selectByExample(SmsExample example);

    /** 
     * 根据指定主键获取一条数据库记录
     * @param code
     */
    Sms selectByPrimaryKey(String code);

    /** 
     * 动态根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Sms record, @Param("example") SmsExample example);

    /** 
     * 根据指定的条件来更新符合条件的数据库记录
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Sms record, @Param("example") SmsExample example);

    /** 
     * 动态字段,根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKeySelective(Sms record);

    /** 
     * 根据主键来更新符合条件的数据库记录
     * @param record
     */
    int updateByPrimaryKey(Sms record);
}