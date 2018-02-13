package org.lyr.tool.core.text.csv;

import java.util.List;

import org.junit.Test;
import org.lyr.tool.core.io.resource.ResourceUtil;
import org.lyr.tool.core.lang.Console;
import org.lyr.tool.core.text.csv.CsvData;
import org.lyr.tool.core.text.csv.CsvReader;
import org.lyr.tool.core.text.csv.CsvRow;
import org.lyr.tool.core.util.CharsetUtil;

public class CsvReaderTest {
	@Test
	public void readTest() {
		CsvReader reader = new CsvReader();
		CsvData data = reader.read(ResourceUtil.getReader("test.csv", CharsetUtil.CHARSET_UTF_8));
		List<CsvRow> rows = data.getRows();
		for (CsvRow csvRow : rows) {
			Console.log(csvRow.get(2));
		}
	}
}
