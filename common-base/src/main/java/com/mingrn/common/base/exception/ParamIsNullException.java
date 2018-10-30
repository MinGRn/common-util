package com.mingrn.common.base.exception;

/**
 * 之所以自定义该异常，而不用{@link org.springframework.web.bind.MissingServletRequestParameterException},
 * 原因在于，MissingServletRequestParameterException为Checked异常,在动态代理过程中，
 * 很容易引发{@link java.lang.reflect.UndeclaredThrowableException}异常
 *
 * @author MinGRn
 */
public class ParamIsNullException extends ServiceException {
	private final String parameterName;
	private final String parameterType;

	public ParamIsNullException(String parameterName, String parameterType) {
		super("");
		this.parameterName = parameterName;
		this.parameterType = parameterType;
	}

	@Override
	public String getMessage() {
		return "Required " + this.parameterType + " parameter \'" + this.parameterName + "\' must be not null !";
	}

	public final String getParameterName() {
		return this.parameterName;
	}

	public final String getParameterType() {
		return this.parameterType;
	}
}
