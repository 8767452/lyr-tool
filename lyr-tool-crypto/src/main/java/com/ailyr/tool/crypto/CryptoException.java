package com.ailyr.tool.crypto;

import com.ailyr.tool.core.exceptions.ExceptionUtil;
import com.ailyr.tool.core.util.StrUtil;

/**
 * 加密异常
 * @author Looly
 *
 */
public class CryptoException extends RuntimeException {
	private static final long serialVersionUID = 8068509879445395353L;

	public CryptoException(Throwable e) {
		super(ExceptionUtil.getMessage(e), e);
	}

	public CryptoException(String message) {
		super(message);
	}

	public CryptoException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}

	public CryptoException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public CryptoException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
