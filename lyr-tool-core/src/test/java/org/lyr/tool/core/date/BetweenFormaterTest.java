package org.lyr.tool.core.date;

import org.junit.Assert;
import org.junit.Test;
import org.lyr.tool.core.date.BetweenFormater;
import org.lyr.tool.core.date.DateUtil;
import org.lyr.tool.core.date.BetweenFormater.Level;

public class BetweenFormaterTest {
	
	@Test
	public void formatTest(){
		long betweenMs = DateUtil.betweenMs(DateUtil.parse("2017-01-01 22:59:59"), DateUtil.parse("2017-01-02 23:59:58"));
		BetweenFormater formater = new BetweenFormater(betweenMs, Level.MILLSECOND, 1);
		Assert.assertEquals(formater.toString(), "1天");
	}
}
