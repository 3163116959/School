package controller;

import entity.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.LoginService;

import javax.annotation.Resource;

@Controller
public class LoginController {
	//控制器依赖service
	@Resource(name = "loginService")
	private LoginService loginService;
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	//登陆
	@RequestMapping("testLogin")
	public String selectusers(Login login) {
//		Login login=new Login(name,password);
		int result = loginService.selectusers(login);
		if(result==1) {
//			return "success";
			return "redirect:/testqueryAll "; 
		}else {
			return "login";
		}
	}
	
	//注册
	@RequestMapping("testRegist")
	public String addLogin(Login login) {
		//注册前先查询一下，是不是已经有这个id了
		int resultSelect = loginService.selectusers(login);
		if(resultSelect==1) {
			return "false";
		}else {
			loginService.addusers(login);
			return "login";
		}
	}
	
}
