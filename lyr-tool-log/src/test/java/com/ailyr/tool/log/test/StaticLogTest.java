package com.ailyr.tool.log.test;

import org.junit.Test;

import com.ailyr.tool.log.StaticLog;

public class StaticLogTest {
	@Test
	public void test() {
		StaticLog.debug("This is static {} log", "debug");
		StaticLog.info("This is static {} log", "info");
	}
}
