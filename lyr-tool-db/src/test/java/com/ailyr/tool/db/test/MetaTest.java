package org.lyr.tool.db.test;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.lyr.tool.core.collection.CollectionUtil;
import org.lyr.tool.db.DbUtil;
import org.lyr.tool.db.ds.DSFactory;
import org.lyr.tool.db.meta.Table;

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
