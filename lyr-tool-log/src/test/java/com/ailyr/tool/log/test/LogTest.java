package com.ailyr.tool.log.test;

import org.junit.Test;

import com.ailyr.tool.log.Log;
import com.ailyr.tool.log.LogFactory;
import com.ailyr.tool.log.level.Level;

/**
 * 日志门面单元测试
 * @author Looly
 *
 */
public class LogTest {
	
	@Test
	public void logTest(){
		Log log = LogFactory.get();
		// 自动选择日志实现
		log.debug("This is {} log", Level.DEBUG);
		log.info("This is {} log", Level.INFO);
		log.warn("This is {} log", Level.WARN);
		
//		Exception e = new Exception("test Exception");
//		log.error(e, "This is {} log", Level.ERROR);
	}
}
