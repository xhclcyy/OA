package com.oa.interceptor;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.oa.tool.SessionContainer;

@Component("SpringMVCInterceptor")
public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("in preHandle");
		// 过滤登录、退出访问
		String[] noFilters = new String[] { "/user/checkLogin",
				"/user/checkVerificationCode", "/user/logout" };
		String uri = request.getRequestURI();

		boolean beFilter = true;
		for (String s : noFilters) {
			if (uri.indexOf(s) != -1) {
				beFilter = false;
				break;
			}
		}
		SessionContainer sessionContainer = (SessionContainer) request
				.getSession().getAttribute("SessionContainer");
		boolean isLogin = (boolean) request.getSession()
				.getAttribute("isLogin");

		if (beFilter) {
			if (null == sessionContainer) {
				// ajax方式交互
				if (request.getHeader("x-requested-with") != null
						&& request.getHeader("x-requested-with")
								.equalsIgnoreCase("XMLHttpRequest"))// 如果是ajax请求响应头会有，x-requested-with；
				{
					response.setHeader("sessionstatus", "timeout");// 在响应头设置session状态
					return false;
				}
				// 未登录
				PrintWriter out = response.getWriter();
				StringBuilder builder = new StringBuilder();
				builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
				builder.append("alert(\"页面过期，请重新登录\");");
				builder.append("window.top.location.href='/user/logout';");
				builder.append("</script>");
				out.print(builder.toString());
				out.close();
				return false;
			} else {
				System.out.println("in 添加系统日志");
				// 添加系统日志
				// -----------------------------------
				// -----------------------------------
			}
		}
		Map paramsMap = request.getParameterMap();
		return super.preHandle(request, response, handler);
	}
}
