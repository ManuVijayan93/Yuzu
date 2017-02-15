package com.yuzu4.controller;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
@Controller
public class HomeController {
	@Autowired
	private HttpSession session;
@RequestMapping("/")
public ModelAndView showHomePage()
{
System.out.println("check");
	ModelAndView mv=new ModelAndView("/Home");
	mv.addObject("msg","Welcome to Yuzu");
	
	return mv;
}
@RequestMapping("/login")

public ModelAndView showLoginPage()
{
	ModelAndView mv=new ModelAndView("/Login");
	
	mv.addObject("isUserClickedLogin","true");
	return mv;
}
@RequestMapping("/register")
public ModelAndView showRegistrationPage()
{
	ModelAndView mv=new ModelAndView("/Register");
	
	mv.addObject("isUserClickedRegister","true");
	return mv;
}
@RequestMapping(value="/validate",method=RequestMethod.POST)
public ModelAndView validateCredentials(@RequestParam("userID")String id,@RequestParam("password") String pwd)
{
	ModelAndView mv=new ModelAndView("/Home");
	
if(id.equals("MANU VIJAYAN")&&pwd.equals("ssvmanuv"))
{
	mv.addObject("successMessage","Valid Credentials");
	session.setAttribute("loginMessage","Welcome:"+id);
}
else
{
	mv.addObject("errorMessage","InValid Credentials....Please Try Again");
}
	return mv;
}
@RequestMapping("/logout")
public ModelAndView logout()
{
	ModelAndView mv=new ModelAndView("/Home");
	
	//session.invalidate();
	session.removeAttribute("loginMessage");
	
	
	return mv;
}


}
