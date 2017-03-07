package com.yuzu4.controller;
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
	System.out.println("check1");
	ModelAndView mv=new ModelAndView("/Home");
	
	mv.addObject("isUserClickedLogin","true");
	return mv;
}
@RequestMapping("/register")
public ModelAndView showRegistrationPage()
{
	System.out.println("check3");
	ModelAndView mv=new ModelAndView("/Home");
	
	mv.addObject("isUserClickedRegister","true");
	return mv;
}
@RequestMapping(value="/validate",method=RequestMethod.POST)
public ModelAndView validateCredentials(@RequestParam("userID")String id,@RequestParam("password") String pwd)
{
	ModelAndView mv=new ModelAndView("/Home");
	System.out.println("check4");
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
	System.out.println("check5");
	ModelAndView mv=new ModelAndView("/Home");
	
	//session.invalidate();
	session.removeAttribute("loginMessage");
	
	
	return mv;
}


}
