package com.ailyr.tool.db.test;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;

import com.ailyr.tool.core.collection.CollectionUtil;
import com.ailyr.tool.db.DbUtil;
import com.ailyr.tool.db.ds.DSFactory;
import com.ailyr.tool.db.meta.Table;

/**
 * 元数据信息单元测试
 * 
 * @author Looly
 *
 */
public class MetaTest {
	DataSource ds = DSFactory.get();

	@Test
	public void getTablesTest() {
		List<String> tables = DbUtil.getTables(ds);
		Assert.assertEquals("user", tables.get(0));
	}

	@Test
	public void getTableMetaTest() {

		Table table = DbUtil.getTableMeta(ds, "user");
		Assert.assertEquals(CollectionUtil.newHashSet("id"), table.getPkNames());
	}
}
