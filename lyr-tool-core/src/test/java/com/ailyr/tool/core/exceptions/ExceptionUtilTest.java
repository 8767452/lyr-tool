package com.ailyr.tool.core.exceptions;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.ailyr.tool.core.exceptions.ExceptionUtil;
import com.ailyr.tool.core.io.IORuntimeException;

/**
 * 异常工具单元测试
 * @author looly
 *
 */
public class ExceptionUtilTest {
	
	@Test
	public void wrapTest() {
		IORuntimeException e = ExceptionUtil.wrap(new IOException(), IORuntimeException.class);
		Assert.assertNotNull(e);
	}
}
