package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;

import com.javaex.vo.UserVO;
import com.javaex.vo.GalleryVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class GalleryController {
	
	//필드
	@Autowired
	private GalleryService galleryService;
	
	//메소드일반
	//갤러리 리스트
	@RequestMapping(value="/gallery", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GalleryController.list()");
		
		//리스트
		List<GalleryVO> galleryList = galleryService.exeGalleryList();
		model.addAttribute("galleryList", galleryList);
		
		return "gallery/list";
	}
	
	// 로그인 폼 
	@RequestMapping(value = "/loginForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
	    System.out.println("GalleryController.loginForm()");
	    return "gallery/loginForm"; 
	}
	
	//로그인
	@RequestMapping(value="/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVO userVO, HttpSession session) {
		System.out.println("GalleryController.login()");
		
		UserVO authUser = galleryService.exeLogin(userVO);
		
		session.setAttribute("authUser", authUser);
		
		return "redirect:/gallery";
	}
	
	//파일업로드폼
	@RequestMapping(value="/gallery/form", method = {RequestMethod.GET, RequestMethod.POST})
	public String form() {
		System.out.println("GalleryController.form");
		
		return "gallery/list";
	}
	
	//파일 불러오기
	@RequestMapping(value="/gallery/upload", method = {RequestMethod.GET, RequestMethod.POST})
	public String upload(@RequestParam("file") MultipartFile file,
	                     @RequestParam("content") String content,
	                     HttpSession session) {
	    
	    UserVO authUser = (UserVO) session.getAttribute("authUser");

	    // 업로드 처리 호출 추가!!
	    galleryService.exeUpload(file, content, authUser);

	    return "redirect:/gallery";
	}
	
	
	
}
