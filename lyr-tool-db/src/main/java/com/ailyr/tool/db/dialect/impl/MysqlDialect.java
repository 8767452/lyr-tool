package com.ailyr.tool.db.dialect.impl;

import com.ailyr.tool.db.Page;
import com.ailyr.tool.db.dialect.DialectName;
import com.ailyr.tool.db.sql.SqlBuilder;
import com.ailyr.tool.db.sql.Wrapper;

/**
 * MySQL方言
 * @author loolly
 *
 */
public class MysqlDialect extends AnsiSqlDialect{
	
	public MysqlDialect() {
		wrapper = new Wrapper('`');
	}

	@Override
	protected SqlBuilder wrapPageSql(SqlBuilder find, Page page) {
		return find.append(" LIMIT ").append(page.getStartPosition()).append(", ").append(page.getPageSize());
	}
	
	@Override
	public DialectName dialectName() {
		return DialectName.MYSQL;
	}
}
