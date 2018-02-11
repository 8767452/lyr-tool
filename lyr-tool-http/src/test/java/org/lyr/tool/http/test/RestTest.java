package org.lyr.tool.http.test;

import org.junit.Ignore;
import org.junit.Test;
import org.lyr.tool.core.lang.Console;
import org.lyr.tool.http.HttpRequest;
import org.lyr.tool.json.JSONUtil;

public class RestTest {
	
	@Test
	@Ignore
	public void postTest() {
		HttpRequest request = HttpRequest.post("http://localhost:8090/rest/restTest/")
				.body(JSONUtil.createObj().put("aaa", "aaaValue").put("键2", "值2"));
		Console.log(request.execute().body());
	}
}
