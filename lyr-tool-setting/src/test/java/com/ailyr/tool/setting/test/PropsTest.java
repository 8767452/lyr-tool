package com.ailyr.tool.setting.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ailyr.tool.log.LogFactory;
import com.ailyr.tool.log.dialect.console.ConsoleLogFactory;
import com.ailyr.tool.setting.dialect.Props;

/**
 * Setting单元测试
 * @author Looly
 *
 */
public class PropsTest {
	
	@Before
	public void init(){
		LogFactory.setCurrentLogFactory(ConsoleLogFactory.class);
	}
	
	@Test
	public void propTest(){
		Props props = new Props("test.properties");
		String user = props.getProperty("user");
		Assert.assertEquals(user, "root");
		
		String driver = props.getStr("driver");
		Assert.assertEquals(driver, "com.mysql.jdbc.Driver");
	}
	
	@Test
	@Ignore
	public void propTestForAbsPAth(){
		Props props = new Props("d:/test.properties");
		String user = props.getProperty("user");
		Assert.assertEquals(user, "root");
		
		String driver = props.getStr("driver");
		Assert.assertEquals(driver, "com.mysql.jdbc.Driver");
	}
}
