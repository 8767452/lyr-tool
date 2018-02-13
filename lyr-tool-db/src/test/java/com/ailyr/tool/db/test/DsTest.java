package org.lyr.tool.db.test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.lyr.tool.core.collection.CollUtil;
import org.lyr.tool.db.Entity;
import org.lyr.tool.db.SqlRunner;
import org.lyr.tool.db.ds.DSFactory;
import org.lyr.tool.db.ds.c3p0.C3p0DSFactory;
import org.lyr.tool.db.ds.dbcp.DbcpDSFactory;
import org.lyr.tool.db.ds.druid.DruidDSFactory;
import org.lyr.tool.db.ds.hikari.HikariDSFactory;
import org.lyr.tool.db.ds.pooled.PooledDSFactory;
import org.lyr.tool.db.ds.tomcat.TomcatDSFactory;

/**
 * 数据源单元测试
 * @author Looly
 *
 */
public class DsTest {
	
	@Test
	public void defaultDsTest() throws SQLException{
		DataSource ds = DSFactory.get();
		SqlRunner runner = SqlRunner.create(ds);
		List<Entity> all = runner.findAll("user");
		Assert.assertTrue(CollUtil.isNotEmpty(all));
	}
	
	@Test
	public void hikariDsTest() throws SQLException{
		DSFactory.setCurrentDSFactory(new HikariDSFactory());
		DataSource ds = DSFactory.get();
		SqlRunner runner = SqlRunner.create(ds);
		List<Entity> all = runner.findAll("user");
		Assert.assertTrue(CollUtil.isNotEmpty(all));
	}
	
	@Test
	public void druidDsTest() throws SQLException{
		DSFactory.setCurrentDSFactory(new DruidDSFactory());
		DataSource ds = DSFactory.get();
		
		SqlRunner runner = SqlRunner.create(ds);
		List<Entity> all = runner.findAll("user");
		Assert.assertTrue(CollUtil.isNotEmpty(all));
	}
	
	@Test
	public void tomcatDsTest() throws SQLException{
		DSFactory.setCurrentDSFactory(new TomcatDSFactory());
		DataSource ds = DSFactory.get();
		SqlRunner runner = SqlRunner.create(ds);
		List<Entity> all = runner.findAll("user");
		Assert.assertTrue(CollUtil.isNotEmpty(all));
	}
	
	@Test
	public void dbcpDsTest() throws SQLException{
		DSFactory.setCurrentDSFactory(new DbcpDSFactory());
		DataSource ds = DSFactory.get();
		SqlRunner runner = SqlRunner.create(ds);
		List<Entity> all = runner.findAll("user");
		Assert.assertTrue(CollUtil.isNotEmpty(all));
	}
	
	@Test
	public void c3p0DsTest() throws SQLException{
		DSFactory.setCurrentDSFactory(new C3p0DSFactory());
		DataSource ds = DSFactory.get();
		SqlRunner runner = SqlRunner.create(ds);
		List<Entity> all = runner.findAll("user");
		Assert.assertTrue(CollUtil.isNotEmpty(all));
	}
	
	@Test
	public void hutoolPoolTest() throws SQLException{
		DSFactory.setCurrentDSFactory(new PooledDSFactory());
		DataSource ds = DSFactory.get();
		SqlRunner runner = SqlRunner.create(ds);
		List<Entity> all = runner.findAll("user");
		Assert.assertTrue(CollUtil.isNotEmpty(all));
	}
}
