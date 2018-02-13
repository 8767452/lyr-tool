package com.ailyr.tool.db.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ailyr.tool.core.collection.CollectionUtil;
import com.ailyr.tool.core.lang.Console;
import com.ailyr.tool.core.thread.ThreadUtil;
import com.ailyr.tool.db.DbUtil;
import com.ailyr.tool.db.Entity;
import com.ailyr.tool.db.SqlRunner;
import com.ailyr.tool.db.handler.EntityListHandler;
import com.ailyr.tool.log.LogFactory;
import com.ailyr.tool.log.dialect.console.ConsoleLogFactory;

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
