package entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.stereotype.Component;

@Component(value = "loginS")
public class Login extends Model<Login> {
	private String name;
	private String password;
	
	//get set方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//构造方法
	public Login() {
		super();
	}
	public Login(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	//toString
	@Override
	public String toString() {
		return "Login [name=" + name + ", password=" + password + "]";
	}
}
