package com.ailyr.tool.extra.mail;

import org.junit.Assert;
import org.junit.Test;

import com.ailyr.tool.extra.mail.GlobalMailAccount;
import com.ailyr.tool.extra.mail.MailAccount;

/**
 * 默认邮件帐户设置测试
 * @author looly
 *
 */
public class MailAccountTest {
	
	@Test
	public void parseSettingTest() {
		MailAccount account = GlobalMailAccount.INSTANCE.getAccount();
		Assert.assertNotNull(account.getCharset());
	}
}
