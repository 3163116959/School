package service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import entity.Login;
import mapper.LoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "loginService")
public class LoginService {

	//登陆
		//public int selectusers(Login login);
	@Resource(name="loginS")
	private Login loginS;
	public void setLoginS(Login loginS) {
		this.loginS = loginS;
	}

	@Resource(name = "loginMapper")
	private LoginMapper loginMapper;
	public void setLoginMapper(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}

	public  int selectusers(Login login){

		QueryWrapper<Login> wrapper = new QueryWrapper<>();
		wrapper.eq("name",login.getName())
				.eq("password",login.getPassword());

		//Integer count = login.selectCount(wrapper);
		Integer count = loginS.selectCount(wrapper);
		return count;
	}
		
		//注册
		//public int addusers(Login login);
	public  int addusers(Login login){
		//boolean insert = loginS.insert(login);
		// loginS.insert
		int count = loginMapper.insert(login);
		return count;
	}
}
