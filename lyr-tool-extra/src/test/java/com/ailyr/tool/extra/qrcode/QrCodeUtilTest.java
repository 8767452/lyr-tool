package com.ailyr.tool.extra.qrcode;

import org.junit.Ignore;
import org.junit.Test;

import com.ailyr.tool.core.io.FileUtil;
import com.ailyr.tool.core.lang.Console;
import com.ailyr.tool.extra.qrcode.QrCodeUtil;

/**
 * 二维码工具类单元测试
 * 
 * @author looly
 *
 */
public class QrCodeUtilTest {

	@Test
	@Ignore
	public void generateTest() {
		QrCodeUtil.generate("http://hutool.cn/", 300, 300, FileUtil.file("d:/qrcode.jpg"));
	}

	@Test
	@Ignore
	public void decodeTest() {
		String decode = QrCodeUtil.decode(FileUtil.file("d:/qrcode.jpg"));
		Console.log(decode);
	}
}
