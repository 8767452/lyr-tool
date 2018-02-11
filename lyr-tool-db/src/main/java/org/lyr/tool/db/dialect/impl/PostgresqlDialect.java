package org.lyr.tool.db.dialect.impl;

import org.lyr.tool.db.dialect.DialectName;
import org.lyr.tool.db.sql.Wrapper;


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
