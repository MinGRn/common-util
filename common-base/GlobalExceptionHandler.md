```java
import com.mingrn.base.constants.Constant;
import com.mingrn.base.exception.NotLoginException;
import com.mingrn.base.result.ResponseMsgUtil;
import com.mingrn.base.result.Result;
import com.mingrn.rl.datashow.utils.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 */
@RestController
@RequestMapping
@ControllerAdvice
public class GlobalExceptionHandler extends AbstractErrorController {
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	public GlobalExceptionHandler(ErrorAttributes errorAttributes) {
		super(errorAttributes);
	}

	@Value("${server.error.path:${error.path:/error}}")
	private static String errorPath = "/error";

	/**
	 * 500错误.
	 */
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public Result<String> serverError(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
		LOGGER.error("!!! request uri:{} from {} server exception:{}", request.getRequestURI(), RequestUtil.getIpAddress(request), e);
		return ResponseMsgUtil.exception();
	}

	/**
	 * 404的拦截.
	 *
	 * @param request
	 * @param response
	 * @param ex
	 * @return
	 * @throws Exception
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoHandlerFoundException.class)
	public Result<String> notFound(HttpServletRequest request, HttpServletResponse response, Exception ex) throws Exception {
		LOGGER.error("!!! request uri:{} from {} not found exception:{}", request.getRequestURI(), RequestUtil.getIpAddress(request), ex);
		return ResponseMsgUtil.builderResponse(Constant.RESULT_CODE_NO_EXISTS, "请求的资源不存在!", null);
	}

	/**
	 * 未登录
	 *
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = NotLoginException.class)
	public Result<String> notLoginExceptionHandler(HttpServletRequest request, Exception ex) {
		LOGGER.error("!!! request uri:{} from {} not found exception:{}", RequestUtil.getIpAddress(request), ex);
		return ResponseMsgUtil.builderResponse(Constant.RESULT_CODE_NOT_LOGIN, ex.getMessage(), null);
	}

	/**
	 * 重写/error请求
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "${server.error.path:${error.path:/error}}")
	public Result<String> handleErrors(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpStatus status = getStatus(request);
		if (status == HttpStatus.NOT_FOUND) {
			return notFound(request, response, null);
		}
		return ResponseMsgUtil.exception();
	}


	@Override
	public String getErrorPath() {
		return errorPath;
	}
}
```