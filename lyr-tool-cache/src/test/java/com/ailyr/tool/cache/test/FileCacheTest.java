package com.ailyr.tool.cache.test;

import org.junit.Assert;
import org.junit.Test;

import com.ailyr.tool.cache.file.LFUFileCache;

/**
 * 文件缓存单元测试
 * @author looly
 *
 */
public class FileCacheTest {
	@Test
	public void lfuFileCacheTest() {
		LFUFileCache cache = new LFUFileCache(1000, 500, 2000);
		Assert.assertNotNull(cache);
	}
}
