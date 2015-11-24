package com.oa.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.oa.model.Login;
import com.oa.model.User;
import com.oa.service.AccountService;
import com.oa.tool.ImageUploadFilter;
import com.oa.tool.JSONUtils;
import com.oa.tool.UploadException;
import com.oa.tool.UploadFilter;

@Controller("LoginController")
@RequestMapping("/user")
public class LoginController implements InterfaceLogin {

	private AccountService accountService;

	@Override
	@RequestMapping(value = "/checkVerificationCode", params = "verificationCode")
	@ResponseBody
	public Map<String, Object> checkVerificationCode(String verificationCode,
			HttpSession session) {
		String kaptchaExpected = (String) session
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if (kaptchaExpected.equalsIgnoreCase(verificationCode)) {
			modelMap.put("message", true);

		} else {

			modelMap.put("message", false);
		}
		modelMap.put("success", true);
		return modelMap;

	}

	@Override
	@RequestMapping(value = "/checkLogin", params = { "loginUserNo",
			"loginPassword", "verificationCode" })
	public void checkLogin(String loginUserNo, String loginPassword,
			String verificationCode, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		Login login = accountService.login(loginUserNo, loginPassword);

		if (login != null) {
			try {
				session.removeAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				session.setAttribute("isLogin", true);
				session.setAttribute("loginUserNo", loginUserNo);
				session.setAttribute("loginUserName", login.getLoginUserName());
				// 保存登录IP等信息
				response.sendRedirect("success");
			} catch (IOException e) {
				e.printStackTrace();
			}
			/*
			 * return new ModelAndView("success").addObject("success", true)
			 * .addObject("message", "登录成功");
			 */
		} else {
			response.setContentType("application/json");
			try {
				PrintWriter out = response.getWriter();
				out.write(JSONUtils.toJSONString(false, "用户名或密码错误"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("user logout");
		session.invalidate();
		return "/index";
		// return "redirect:/hello";
	}

	@RequestMapping(value = "/modifyPass", params = { "loginUserNo",
			"loginPassword", "newLoginPassword" })
	@ResponseBody
	public Map<String, Object> modifyEmployeePassword(String loginUserNo,
			String loginPassword, String newLoginPassword) {

		Login login = accountService.login(loginUserNo, loginPassword);

		Map<String, Object> modelMap = new HashMap<String, Object>();
		if (login != null) {
			accountService.changePassword(loginUserNo, newLoginPassword);
			modelMap.put("message", "修改密码成功");
			modelMap.put("success", true);
		} else {
			modelMap.put("message", "修改密码失败");
			modelMap.put("success", false);

		}
		return modelMap;
	}

	@RequestMapping(value = "/employeeInfo/{loginUserNo}")
	public ModelAndView employeeInfo(
			@PathVariable("loginUserNo") String loginUserNo) {
		// 包装员工基本信息
		return new ModelAndView();

	}

	@RequestMapping(value = "/employeeInfoUpdate")
	public ModelAndView employeeInfoUpdate(@ModelAttribute Login login,
			@ModelAttribute User user, BindingResult result, Model model) {
		// 更新员工基本信息
		return new ModelAndView();
	}

	@RequestMapping(value = "/employeeUploadTest")
	public ModelAndView employeeUploadTest() {

		return new ModelAndView("upload").addObject("now", new Date());

	}

	@RequestMapping(value = "/employeeUploadPic")
	public ModelAndView employeeUploadPic(
			@RequestParam("userId") String loginUserNo,
			HttpServletRequest servletRequest,
			@RequestParam MultipartFile uploadFile) throws Exception {

		if (uploadFile.isEmpty()) {
			throw new Exception("未选中任何文件");
		}
		if (uploadFile.getSize() > 10485760) {
			throw new UploadException("上传文件超过10M");
		}
		String fileName = uploadFile.getOriginalFilename();
		String suffix = UploadFilter.getSuffix(fileName);
		ImageUploadFilter.filter(suffix);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		StringBuilder newFileName = new StringBuilder(loginUserNo)
				.append(sdf.format(new Date())).append(".").append(suffix);
		try {
			File tmp = new File("D:/apache/OA");
			if (!tmp.exists()) {
				tmp.mkdir();
			}
			File file = new File("D:/apache/OA", newFileName.toString());
			uploadFile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", true);
		modelMap.put("message", fileName);
		modelMap.put("now", new Date());
		return new ModelAndView("upload", modelMap);
	}

	@RequestMapping(value = "/resourceDownload")
	public void resourceDownload(String filePathName, String fileDownloadName,
			HttpServletRequest servletRequest, HttpServletResponse response)
			throws IOException {

		String dataDirectory = "D:/apache/OA";
		byte[] buffer = new byte[1024];

		filePathName = "你好.rar";

		File file = new File(dataDirectory, filePathName);
		if (!file.exists()) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			StringBuilder builder = new StringBuilder();
			builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
			builder.append("alert(\"文件不存在，请确认\");");
			builder.append("</script>");
			out.print(builder.toString());
			out.close();
		} else {
			try (FileInputStream fis = new FileInputStream(file);
					BufferedInputStream bis = new BufferedInputStream(fis)) {
				response.setHeader(
						"Content-Disposition",
						"attachment; filename="
								+ URLEncoder.encode(filePathName.toString(),
										"UTF-8"));
				response.setContentType("application/octet-stream; charset=utf-8");
				OutputStream os = response.getOutputStream();
				int i = bis.read(buffer);
				while (i != -1) {
					os.write(buffer, 0, i);
					i = bis.read(buffer);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// @RequestMapping(value = { "/", "login" })
	@RequestMapping
	@ResponseBody
	public Map<String, Object> defaultMethod() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", true);
		modelMap.put("message", "ok");
		return modelMap;
	}

	/**
	 * @return the accountService
	 */
	public AccountService getAccountService() {
		return accountService;
	}

	/**
	 * @param accountService
	 *            the accountService to set
	 */
	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
}
