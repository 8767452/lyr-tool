package com.ailyr.tool.core.convert.impl;

import com.ailyr.tool.core.convert.AbstractConverter;
import com.ailyr.tool.core.convert.ConverterRegistry;
import com.ailyr.tool.core.util.ArrayUtil;

/**
 * byte 类型数组转换器
 * @author Looly
 *
 */
public class ByteArrayConverter extends AbstractConverter<byte[]>{
	
	@Override
	protected byte[] convertInternal(Object value) {
		final Byte[] result = ConverterRegistry.getInstance().convert(Byte[].class, value);
		return ArrayUtil.unWrap(result);
	}

}
