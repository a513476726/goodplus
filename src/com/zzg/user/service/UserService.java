package com.zzg.user.service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzg.dao.UserMapper;
import com.zzg.domain.User;
import com.zzg.domain.UserExample;
import com.zzg.vo.UserPwdVo;

import mailhelper.Mail;
import mailhelper.MailUtils;
import uuid.UUIDHelper;
import yanzhengma.Verify;
@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	

	//获得#验证码#的实现类
	public void GetVerifyInterfaceService(HttpServletRequest request, HttpServletResponse response) {
		try {
			Verify.getVirify(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//注册--验证#用户名#是否存在的实现类
	public boolean ValiLoginNameInterfaceService(String loginname) {
		UserExample example =new UserExample();
		example.createCriteria().andLoginnameEqualTo(loginname);
		List<User> users = userMapper.selectByExample(example);
		if (users.size()==0) {
			//用户名已存在
			return true;
		}else {
			//用户名不存在
			return false;
		}
	}
	//注册--验证#邮箱#是否存在的实现类
	public boolean ValiEmailInterfaceService(String email) {
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(email);
		List<User> users = userMapper.selectByExample(example);
		System.out.println("--------valiEmail----");
		if (users.size()==0){
			return true;
		}else {
			return false;
		}
	}
	
	


	public boolean VerifyCodeInterfaceService(String verifyCode, HttpServletRequest request) {
		String vCode = (String) request.getSession().getAttribute("vCode");
		if (vCode.equalsIgnoreCase(verifyCode)){
			System.out.println("验证码核对成功-------------------");
				return true;
		}else{
			System.out.println("验证码核对失败-------------------");
				return false;
		}
}
	public void RegistInterfaceService(User user) throws Exception {
			user.setUid(UUIDHelper.getUUID());
			user.setStatus(false);
			user.setActivationcode(UUIDHelper.getUUID()+UUIDHelper.getUUID());
			userMapper.insert(user);
			
			//关联配置文件
			Properties prop = new Properties();
			prop.load(this.getClass().getClassLoader().getResourceAsStream("email.properties"));
			//连接邮件服务器
			String username =  prop.getProperty("username");
			String password =  prop.getProperty("password");
			String host =  prop.getProperty("host");
			Session session = MailUtils.createSession(host, username, password);
			//制作邮件
			String from = prop.getProperty("from");
			String subject=prop.getProperty("subject");
			String to = user.getEmail();
			String content= MessageFormat.format(prop.getProperty("content"), user.getActivationcode());
			
			Mail mail = new Mail(from,to,subject,content);
			//send
			MailUtils.send(session, mail);
		}
	public User loginIntefaceService(User user) {
		UserExample example = new UserExample();
		example.createCriteria().andLoginnameEqualTo(user.getLoginname())
				.andLoginpassEqualTo(user.getLoginpass());
		List<User>  users =  userMapper.selectByExample(example);
		if(users.size()==0){
			return  null;
		}
		return  users.get(0)  ;
	}
	public boolean editpwd(String uid ,UserPwdVo vo) {
		//   校验   原密码
		User  user  =userMapper.selectByPrimaryKey(uid);
		if(!user.getLoginpass().equals(vo.getLoginpass())){
			return  false ;
		}
		user.setLoginpass(vo.getNewpass());
		userMapper.updateByPrimaryKey(user);
		
		return true  ;
		
	}
}

