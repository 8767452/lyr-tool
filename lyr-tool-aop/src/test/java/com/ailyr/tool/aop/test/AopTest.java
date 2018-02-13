package com.ailyr.tool.aop.test;

import org.junit.Assert;
import org.junit.Test;

import com.ailyr.tool.aop.ProxyUtil;
import com.ailyr.tool.aop.aspects.TimeIntervalAspect;

/**
 * AOP模块单元测试
 * @author Looly
 *
 */
public class AopTest {
	
	@Test
	public void aopTest(){
		Animal cat = ProxyUtil.proxy(new Cat(), TimeIntervalAspect.class);
		String result = cat.eat();
		Assert.assertEquals("猫吃鱼", result);
	}
	
	static interface Animal{
		String eat();
	}
	
	static class Cat implements Animal{

		@Override
		public String eat() {
			return "猫吃鱼";
		}
		
	}
}
