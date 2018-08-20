package cn.qimu.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

public class PropertyConfigurer extends PropertyPlaceholderConfigurer {
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		PropertiesUtil.setProperties(props);
		super.processProperties(beanFactoryToProcess, props);
	}
}
