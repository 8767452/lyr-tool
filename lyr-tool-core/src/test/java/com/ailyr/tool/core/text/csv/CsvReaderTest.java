package com.ailyr.tool.core.text.csv;

import java.util.List;

import org.junit.Test;

import com.ailyr.tool.core.io.resource.ResourceUtil;
import com.ailyr.tool.core.lang.Console;
import com.ailyr.tool.core.text.csv.CsvData;
import com.ailyr.tool.core.text.csv.CsvReader;
import com.ailyr.tool.core.text.csv.CsvRow;
import com.ailyr.tool.core.util.CharsetUtil;

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
