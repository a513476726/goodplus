package com.zzg.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzg.domain.User;
import com.zzg.user.service.UserService;
import com.zzg.vo.UserPwdVo;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	//验证码的显示功能
	@RequestMapping(value="/getverify")
	public void getVerify(HttpServletRequest request , HttpServletResponse response) {
		//跳转业务层
		userService.GetVerifyInterfaceService(request,response);
	}
	
	//验证验证码
	@RequestMapping(value="/verifyCode")
	public @ResponseBody boolean verifyCode(HttpServletRequest request,String verifyCode){
		//跳转业务层
		return  userService.VerifyCodeInterfaceService(verifyCode,request);
	}

	//注册页面--验证用户名
	@RequestMapping(value="/valiloginname")
	public @ResponseBody boolean valiLoginname(String loginname){
		//跳转业务层
		return userService.ValiLoginNameInterfaceService(loginname);
	}
	
	//注册页面--验证邮箱
	@RequestMapping(value="/valiEmail")
	public @ResponseBody boolean valiEmail(String email){
		//跳转业务层
		System.out.println("------valiEmail");
		return  userService.ValiEmailInterfaceService(email);
	}
	//提交注册信息
	@RequestMapping(value="/regist")
	public String regist(User user,Model model) throws Exception{
			userService.RegistInterfaceService(user); 
			model.addAttribute("code","success");
			model.addAttribute("msg","注册成功,请到邮件界面激活!");
			return "jsps/msg";
	}
	
	@RequestMapping(value="/login")
	public String login(User user,HttpSession session,Model model){
		User  u =userService.loginIntefaceService(user);
		System.out.println("777777777777"+u+"7777777777777777");
		if(u==null){
			model.addAttribute("msg", "用户名或者密码错误");
			model.addAttribute("error_user", user);
			return  "jsps/user/login";
		}else {
			if(!u.getStatus()){
				model.addAttribute("msg", "当前账户为激活，请到邮箱中激活");
				model.addAttribute("error_user", user);
				return   "jsps/user/login";
			}else{
				/*model.addAttribute("user", u);*/
				session.setAttribute("user", u);
				return   "redirect:jsps/main.jsp";
			}
		}
	}
	// 用户退出  
		@RequestMapping(value="/exit" ,method = RequestMethod.GET)
		public  String  exit(HttpSession session)  {
			
			session.invalidate();
			return  "redirect:/index.jsp";
		}
		// 用户的   修改密码
			@RequestMapping(value="/editpwd/{uid}" ,method = RequestMethod.PUT)
			public  String  editpwd(@PathVariable String  uid , UserPwdVo  vo,Model  model,HttpSession  session)  {
				
				System.out.println(vo);
				
				boolean  res  = userService.editpwd(uid,vo);
				if(res){
					model.addAttribute("msg", "密码修改成功！");
					model.addAttribute("code", "success");
					session.invalidate();
					return   "/jsps/msg";
				}
				model.addAttribute("msg", "密码修改失败！");
				model.addAttribute("code", "error");
				
				
				return   "/jsps/msg";
			}
}
