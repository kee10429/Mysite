package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVO;

@Controller
public class BoardController {

	//필드
	@Autowired
	private BoardService boardService;
	
	//메소드일반
	
	//--게시판 전체 리스트
	@RequestMapping(value="/board/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("BoardController.list()");
		
		List<BoardVO> boardList = boardService.exeList();
		System.out.println(boardList);
		
		model.addAttribute("boardList", boardList);
		
		return "board/list";
	}
	
	//-- 글쓰기 폼
	@RequestMapping(value="/board/writeform", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		System.out.println("BoardController.writeform");
		
		return "board/writeForm";
	}
	
	//-- 글쓰기 
	@RequestMapping(value="/board/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute BoardVO boardVO) {
		System.out.println("BoardController.write");
		
		boardService.exeWrite(boardVO);
		
		return "redirect:/board/list";
	}
	
	// -- 보기 폼
	@RequestMapping(value="/board/read", method= {RequestMethod.GET, RequestMethod.POST})
	public String read(UserVO userVO) {
		System.out.println("BoardController.read");
		
		return "";
	}
	
	
	
	
	
}