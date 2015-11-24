package com.oa.interceptor;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.oa.tool.SessionTimeoutException;

/**
 * @description: 处理session超时的拦截器 会话控制拦截器
 * 
 */
public class SessionTimeoutInterceptor implements HandlerInterceptor {

	public String[] allowUrls;// 还没发现可以直接配置不拦截的资源，所以在代码里面来排除

	private ResourceBundleMessageSource _res;

	public void setAllowUrls(String[] allowUrls) {
		this.allowUrls = allowUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("in SessionTimeoutInterceptor");
		String requestUrl = request.getRequestURI().replace(
				request.getContextPath(), "");
		if (null != allowUrls && allowUrls.length >= 1)
			for (String url : allowUrls) {
				if (requestUrl.contains(url)) {
					return true;
				}
			}

		boolean isLogin = (boolean) request.getSession()
				.getAttribute("isLogin");
		if (isLogin) {
			return true; // 返回true，则这个方面调用后会接着调用postHandle(), afterCompletion()
		} else {
			/**
			 * 如果无法忍受每次都抛出异常时，可以使用此方法进行页面跳转
			 */
			// PrintWriter out = response.getWriter();
			// out.println("{\"statusCode\":\"301\", \"message\":\""+this.getMessage(request,"msg.session.invalid")+"\"}");
			// String page = request.getContextPath() +
			// "/views/admin/ajaxDone.jsp?statusCode=301&message="+this.getMessage(request,"msg.session.invalid");
			// response.sendRedirect(page);
			// return false;
			// 未登录 跳转到登录页面
			throw new SessionTimeoutException();// 返回到配置文件中定义的路径
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	protected String getMessage(HttpServletRequest request, String code,
			Object... args) {
		// HttpServletRequest request =
		// ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		LocaleResolver localeResolver = RequestContextUtils
				.getLocaleResolver(request);
		Locale locale = localeResolver.resolveLocale(request);

		return new ResourceBundleMessageSource().getMessage(code, args, locale);
	}

	/**
	 * @return the _res
	 */
	public ResourceBundleMessageSource get_res() {
		return _res;
	}

	/**
	 * @param _res
	 *            the _res to set
	 */

	public void set_res(ResourceBundleMessageSource _res) {
		this._res = _res;
	}

}
