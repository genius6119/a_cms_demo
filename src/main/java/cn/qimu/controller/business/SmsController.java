package cn.qimu.controller.business;

import cn.qimu.mybatis.model.Sms;
import com.mysql.jdbc.Connection;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 主要用于测试批量插入数据
 * @author cjp
 *
 */
@Controller
@RequestMapping(value = "/sms")
public class SmsController{
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 *  mybatis 批量插入方式
	 * @param code
	 * @return
	 * @author jianping.chen
	 */
	@RequestMapping(value = "/addBatchByMybatis", method = {RequestMethod.POST})
	@ResponseBody
	public int addBatchByMybatis(String code){
		/*SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
		SmsMapper mapper = openSession.getMapper(SmsMapper.class);
		int size = 1000;	// 批量插入1000条数据
		int batch = 100;	// 每次插入100条
		List<Sms> dataList = getDataList(size);
		long startTime = System.currentTimeMillis();
		try {
			for (int i = 0; i < size; i++) {
				mapper.insert(dataList.get(i));
				if(i % batch == 0 || i == (size - 1)) {
					System.out.println("comit with i ========================= " + i);
					openSession.commit();
					openSession.clearCache();
				}
			}
		} catch (Exception e) {
			if (openSession != null)
				openSession.rollback();
		} finally {
			openSession.close();
		}
		
		long endTime = System.currentTimeMillis();
		
		return (int)((endTime - startTime) / 1000);*/
		return 1;
	}
	
	@RequestMapping(value = "/addBatchByJDBC", method = {RequestMethod.POST})
	@ResponseBody
	public int addBatchByJDBC(String code) throws SQLException{
		
		/*Connection connection = null;
		int size = 1000;	// 批量插入1000条数据
		int batch = 100;	// 每次插入100条
		List<Sms> dataList = getDataList(size);
		long startTime = 0;
		int nbr = 0;
		try {
			connection = getConn();
			connection.setAutoCommit(false);
			startTime = System.currentTimeMillis();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO sms (code,mobile,bussness_type,sms_status) VALUES ( ?, ?,?,? ) ");
			for (int i = 0; i < size; i++) {
				Sms record = dataList.get(i);
				statement.setString(1, record.getCode());
				statement.setString(2, record.getMobile());
				statement.setShort(3, record.getBussnessType());
				statement.setShort(4, record.getSmsStatus());
				statement.addBatch();
				nbr++;
				if (nbr % batch == 0 || nbr == (size - 1)) {
					System.out.println("comit with i ========================= " + i);
					statement.executeBatch();
					connection.commit();
				}
			}
		} catch (Exception e) {
			if (connection != null)
				connection.rollback();
		} finally {
			connection.close();
		}
		
		long endTime = System.currentTimeMillis();
		
		return (int)((endTime - startTime) / 1000);*/
		return 1;
	}
	
	/**
	 * 
	 * @param size
	 * @return
	 * @author jianping.chen
	 */
	public static List<Sms> getDataList(int size){
        List<Sms> data = new ArrayList<>();
        for (int i = 0; i < size; i++){
            Sms record = new Sms();
            record.setCode(UUID.randomUUID().toString());
			record.setBussnessType((short)1);
			record.setMobile("111111");
			record.setSmsStatus((short) 1);
            data.add(record);
        }
        return data;
    }
	
	/**
	 * 使用JDBC批量插入，仅作为测试使用，正式使用时应建立DBUtil类
	 * @return
	 * @author jianping.chen
	 */
	public static Connection getConn(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://www.suanzi.cn:3306/qimu_test?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
        String user = "qimu";
        String password = "123456";
        try{
            Class.forName(driver);
            Connection conn = (Connection) DriverManager.getConnection(url, user, password);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
