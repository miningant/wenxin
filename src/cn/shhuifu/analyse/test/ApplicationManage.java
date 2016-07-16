package cn.shhuifu.analyse.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationManage {
	private static ApplicationContext applicationContext = null;
	static final String[] path={"classpath:cn/shhuifu/analyse/cfg/spring/applicationContext.xml"};
	static {
		applicationContext = new FileSystemXmlApplicationContext(path);
	}
    
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
}
