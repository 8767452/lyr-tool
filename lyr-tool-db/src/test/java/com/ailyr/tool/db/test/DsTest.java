package com.ailyr.tool.db.test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;

import com.ailyr.tool.core.collection.CollUtil;
import com.ailyr.tool.db.Entity;
import com.ailyr.tool.db.SqlRunner;
import com.ailyr.tool.db.ds.DSFactory;
import com.ailyr.tool.db.ds.c3p0.C3p0DSFactory;
import com.ailyr.tool.db.ds.dbcp.DbcpDSFactory;
import com.ailyr.tool.db.ds.druid.DruidDSFactory;
import com.ailyr.tool.db.ds.hikari.HikariDSFactory;
import com.ailyr.tool.db.ds.pooled.PooledDSFactory;
import com.ailyr.tool.db.ds.tomcat.TomcatDSFactory;

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
