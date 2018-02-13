package com.ailyr.tool.json;

import com.ailyr.tool.core.util.StrUtil;

/**
 * JSON异常
 *
 * @author looly
 * @since 3.0.2
 */
public class JSONException extends RuntimeException {
	private static final long serialVersionUID = 0;

	public JSONException(final String message) {
		super(message);
	}

	public JSONException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public JSONException(final Throwable cause) {
		super(cause.getMessage(), cause);
	}

	public JSONException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
