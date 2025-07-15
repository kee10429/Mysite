package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.GuestbookRepository;
import com.javaex.vo.GuestbookVO;

@Service
public class GuestbookService {

	//필드
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	//-전체방명록 리스트 가져오기
	public List<GuestbookVO> exeGetGuestbookList() {
		System.out.println("GuestbookService.exeGetGuestbookList()");
		
		List<GuestbookVO> guestbookList = guestbookRepository.guestbookSelect();
		
		return guestbookList;
	}
	
	
	//-방명록 저장하기
	public int exeGuestbookAdd(GuestbookVO guestbookVO) {
		System.out.println("GuestbookService.exeGuestbookAdd()");
		
		//dao를 통해서 일한다
		//GuestbookDAO guestbookDAO =  new GuestbookDAO();
		int count = guestbookRepository.guestbookInsert(guestbookVO);
		
		return count;
	}
	
	//-방명록 삭제하기
	public int exeGuestbookRemove(GuestbookVO guestbookVO) {
		System.out.println("GuestbookService.exeGuestbookRemove()");
		
		//dao를 통해서 일한다
		//GuestbookDAO guestbookDAO = new GuestbookDAO();
		int count = guestbookRepository.guestbookDelete(guestbookVO);
		
		return count;
	}
	
	
	// --방명록 저장하고, 저장된 글 1개 가져오기
	public GuestbookVO exeGuestbookAddkey(GuestbookVO guestbookVO) {
	    System.out.println("GuestbookService.exeGuestbookAddkey");

	    guestbookRepository.guestbookInsertKey(guestbookVO); // 저장 및 키 설정됨
	    System.out.println("방금 저장된 no: " + guestbookVO.getNo());

	    GuestbookVO gVO = guestbookRepository.guestbookSelectOne(guestbookVO.getNo());

	    return gVO;
	}
	
	
	
	
	
	
}