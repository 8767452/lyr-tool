package org.lyr.tool.core.convert.impl;

import org.lyr.tool.core.convert.AbstractConverter;
import org.lyr.tool.core.util.ClassUtil;

/**
 * 类转换器<br>
 * 将类名转换为类
 * @author Looly
 *
 */
public class ClassConverter extends AbstractConverter<Class<?>>{
	
	@Override
	protected Class<?> convertInternal(Object value) {
		String valueStr = convertToStr(value);
		try {
			return ClassUtil.getClassLoader().loadClass(valueStr);
		} catch (Exception e) {
			// Ignore Exception
		}
		return null;
	}

}
