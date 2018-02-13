package org.lyr.tool.db.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.lyr.tool.core.collection.CollectionUtil;
import org.lyr.tool.core.lang.Console;
import org.lyr.tool.core.thread.ThreadUtil;
import org.lyr.tool.db.DbUtil;
import org.lyr.tool.db.Entity;
import org.lyr.tool.db.SqlRunner;
import org.lyr.tool.db.handler.EntityListHandler;
import org.lyr.tool.log.LogFactory;
import org.lyr.tool.log.dialect.console.ConsoleLogFactory;

/**
 * SqlRunner线程安全测试
 * 
 * @author looly
 *
 */
@Ignore
public class ConcurentTest {
	
	private SqlRunner runner;
	
	@Before
	public void init() {
		LogFactory.setCurrentLogFactory(new ConsoleLogFactory());
		DbUtil.setShowSqlGlobal(true, false, false);
		runner = SqlRunner.create();
	}
	
	@Test
	public void findTest() {
		for(int i = 0; i < 10000; i++) {
			ThreadUtil.execute(new Runnable() {
				@Override
				public void run() {
					List<Entity> find = null;
					try {
						find = runner.find(CollectionUtil.newArrayList("name AS name2"), Entity.create("user"), new EntityListHandler());
					} catch (SQLException e) {
						e.printStackTrace();
					}
					Console.log(find);
				}
			});
		}
	}
}
