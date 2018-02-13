package com.ailyr.tool.db.dialect.impl;

import com.ailyr.tool.db.dialect.DialectName;
import com.ailyr.tool.db.sql.Wrapper;


/**
 * Postgree方言
 * @author loolly
 *
 */
public class PostgresqlDialect extends AnsiSqlDialect{
	public PostgresqlDialect() {
		wrapper = new Wrapper('"');
	}

	@Override
	public DialectName dialectName() {
		return DialectName.POSTGREESQL;
	}
}
