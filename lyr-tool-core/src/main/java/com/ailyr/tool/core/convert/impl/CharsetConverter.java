package org.lyr.tool.core.convert.impl;

import java.nio.charset.Charset;

import org.lyr.tool.core.convert.AbstractConverter;
import org.lyr.tool.core.util.CharsetUtil;

/**
 * 编码对象转换器
 * @author Looly
 *
 */
public class CharsetConverter extends AbstractConverter<Charset>{

	@Override
	protected Charset convertInternal(Object value) {
		return CharsetUtil.charset(convertToStr(value));
	}

}
