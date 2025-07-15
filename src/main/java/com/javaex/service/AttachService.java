package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.io.OutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.vo.FileVO;



@Service
public class AttachService {
	
	//필드
	
	//생성자 //메소드 gs
	
	//메소드일반
	public String exeUpload(MultipartFile file) {
		System.out.println("AttachService.exeUpload()");
		
		//파일저장경로
		String saveDir = "C:\\javaStudy\\upload\\";
		
		
		//(1)파일정보를 추출 저장(DB)
		//오리지널 파일명
		String orgName = file.getOriginalFilename();
		System.out.println(orgName);
		
		//확장자
		String exName = orgName.substring(orgName.lastIndexOf(".")+1);
		System.out.println(exName);
		
		//저장파일명(덮어쓰기방지용)
		System.out.println(System.currentTimeMillis());
		System.out.println(UUID.randomUUID().toString());
		String saveName = System.currentTimeMillis()+UUID.randomUUID().toString()+"." + exName;
		System.out.println(saveName);
		
		//파일경로
		String filePath = saveDir+saveName;
		System.out.println(filePath);
		
		
		//파일사이즈
		long fileSize = file.getSize();
		System.out.println(fileSize);
		
		//vo에 묶는다 --> db저장
		FileVO fileVO = new FileVO(orgName, exName, saveName, filePath, fileSize);
		System.out.println(fileVO);
		
		//--> db저장
		//과제
		
		//(2)실물파일을 하드디스크에 저장
		
		try {
			byte[] fileData = file.getBytes();
			
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(fileData);
			bos.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return saveName;
		
	}
	
	
}
