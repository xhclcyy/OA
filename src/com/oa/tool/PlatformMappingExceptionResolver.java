package com.oa.tool;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * 
 * @author LCore
 * 
 *         平台异常信息跳转、解析
 * 
 */
public class PlatformMappingExceptionResolver extends
		SimpleMappingExceptionResolver {
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {

		String viewName = determineViewName(ex, request);
		// vm方式返回
		if (viewName != null) {
			if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
					.getHeader("X-Requested-With") != null && request
					.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
				// 非异步方式返回
				Integer statusCode = determineStatusCode(request, viewName);
				if (statusCode != null) {
					applyStatusCodeIfPossible(request, response, statusCode);
				}
				// 跳转到提示页面
				return getModelAndView(viewName, ex, request);
			} else {
				// 异步方式返回
				try {
					PrintWriter writer = response.getWriter();
					writer.write(ex.getMessage());
					response.setStatus(404, ex.getMessage());
					// 将异常栈信息记录到日志中
					logger.error(getTrace(ex));
					writer.flush();
				} catch (Exception e) {

					e.printStackTrace();
				}
				// 不进行页面跳转
				return null;

			}
		} else {
			return null;
		}
	}

	public static String getTrace(Throwable t) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		t.printStackTrace(writer);
		StringBuffer buffer = stringWriter.getBuffer();
		return buffer.toString();
	}
}
