package org.lyr.tool.core.util;

import org.junit.Ignore;
import org.junit.Test;
import org.lyr.tool.core.lang.Console;
import org.lyr.tool.core.util.RuntimeUtil;

/**
 * 命令行单元测试
 * @author looly
 *
 */
public class RuntimeUtilTest {

	@Test
	@Ignore
	public void execTest() {
		String str = RuntimeUtil.execForStr("ipconfig");
		Console.log(str);
	}

	@Test
	@Ignore
	public void execCmdTest() {
		String str = RuntimeUtil.execForStr("cmd /c dir");
		Console.log(str);
	}
}
