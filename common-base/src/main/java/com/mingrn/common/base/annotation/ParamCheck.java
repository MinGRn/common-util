package com.mingrn.common.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 参数不能为空注解,作用于方法参数上。配合ParamCheckAop使用
 * <pre>若某个参数加上该注解以后,值为空时,则会抛出{@link com.mingrn.common.base.exception.ParamIsNullException}异常,
 * 该异常会在{@link com.mingrn.exception.GlobalExceptionHandler #requestMissingServletRequest}中被捕获,或见
 * GlobalExceptionHandler.md
 * 然后将错误信息统一返回到前台</pre>
 * <pre>该注解与{@link org.springframework.web.bind.annotation.RequestParam}区别在于,RequestParam只校验值是否为null,
 * 而本注解还校验空字符串,即str=''</pre>
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamCheck {
	/**
	 * 是否非空,默认不能为空
	 */
	boolean notNull() default true;
}
