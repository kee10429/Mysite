package com.javaex.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	//필드
	//서비스 연결
	@Autowired
	private UserService userService;
	
	//메소드일반
	//--회원가입폼
	@RequestMapping(value="/user/joinform", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController.joinForm()");
		
		return "user/joinForm";
	}
	
	// -- 회원가입
	@RequestMapping(value="/user/join", method = {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVO userVO) {
		System.out.println("UserController.join");
		
		//서비스 작성 후 작성할 곳
		try {
			userService.exeJoin(userVO);
			return "user/joinok";
			
			
		} catch (Exception e) {
			return "redirect:http://localhost:8888/user/joinform";
		}
		
	}
	
	// --로그인 폼
	@RequestMapping(value="/user/loginform", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController.loginForm()");
		
		return "user/loginForm";
	}
	
	// -- 로그인
	@RequestMapping(value="/user/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVO userVO, HttpSession session) {
		System.out.println("UserController.login");
		
		UserVO authUser = userService.exeLogin(userVO);
		System.out.println(authUser);
		
		//세션에 로그인 확인용 값을 넣어준다
		session.setAttribute("authUser", authUser);
		
		return "redirect:/";
		
	}
	
	//-- 로그아웃
	@RequestMapping(value="/user/logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UserController.logout()");
		
		//세션의 확인용 값을 지운다
		//session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}
	
	
}
