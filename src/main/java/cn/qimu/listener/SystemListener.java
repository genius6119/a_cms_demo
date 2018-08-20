package cn.qimu.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author  作者 tom
 * @date 创建时间：2017年9月15日 上午11:50:12
 * @version 1.0
 */
public class SystemListener implements ServletContextListener{

	private static final Logger log = LoggerFactory.getLogger(SystemListener.class);
	
	/*
	 * application init
	 * 应用程序初始化调用此方法
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.error(this.getClass() + "contextInitialized start");
		
		//some method...
		
		log.error(this.getClass() + "contextInitialized end");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
