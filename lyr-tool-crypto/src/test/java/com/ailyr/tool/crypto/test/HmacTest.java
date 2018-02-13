package com.ailyr.tool.crypto.test;

import org.junit.Assert;
import org.junit.Test;

import com.ailyr.tool.core.io.IoUtil;
import com.ailyr.tool.core.util.CharsetUtil;
import com.ailyr.tool.crypto.SecureUtil;
import com.ailyr.tool.crypto.digest.HMac;
import com.ailyr.tool.crypto.digest.HmacAlgorithm;

/**
 * Hmac单元测试
 * @author Looly
 *
 */
public class HmacTest {
	@Test
	public void hmacTest(){
		String testStr = "test中文";
		
		byte[] key = "password".getBytes();
		HMac mac = new HMac(HmacAlgorithm.HmacMD5, key);
		
		String macHex1 = mac.digestHex(testStr);
		Assert.assertEquals("b977f4b13f93f549e06140971bded384", macHex1);
		
		String macHex2 = mac.digestHex(IoUtil.toStream(testStr, CharsetUtil.CHARSET_UTF_8));
		Assert.assertEquals("b977f4b13f93f549e06140971bded384", macHex2);
	}
	
	@Test
	public void hmacMd5Test(){
		String testStr = "test中文";
		
		HMac mac = SecureUtil.hmacMd5("password");
		
		String macHex1 = mac.digestHex(testStr);
		Assert.assertEquals("b977f4b13f93f549e06140971bded384", macHex1);
		
		String macHex2 = mac.digestHex(IoUtil.toStream(testStr, CharsetUtil.CHARSET_UTF_8));
		Assert.assertEquals("b977f4b13f93f549e06140971bded384", macHex2);
	}
	
	@Test
	public void hmacSha1Test(){
		String testStr = "test中文";
		
		HMac mac = SecureUtil.hmacSha1("password");
		
		String macHex1 = mac.digestHex(testStr);
		Assert.assertEquals("1dd68d2f119d5640f0d416e99d3f42408b88d511", macHex1);
		
		String macHex2 = mac.digestHex(IoUtil.toStream(testStr, CharsetUtil.CHARSET_UTF_8));
		Assert.assertEquals("1dd68d2f119d5640f0d416e99d3f42408b88d511", macHex2);
	}
}
