package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.javaex.controller.AttachController;
import com.javaex.repository.GalleryRepository;
import com.javaex.vo.FileVO;
import com.javaex.vo.GalleryVO;
import com.javaex.vo.UserVO;



@Service
public class GalleryService {

    private final AttachController attachController;
	
	//필드
	@Autowired
	private GalleryRepository galleryRepository;

    GalleryService(AttachController attachController) {
        this.attachController = attachController;
    }
	
	//메소드일반
	
	//로그인
	public UserVO exeLogin(UserVO userVO) {
		System.out.println("GalleryService.exeLogin");
		
		UserVO authUser = galleryRepository.userSelectOneByIdPw(userVO);
		
		return authUser;
		
	}
	
	//갤러리 리스트 조회
	public List<GalleryVO> exeGalleryList() {
	    return galleryRepository.gallerySelectAll();
	}
	
	//업로드
	public void exeUpload(MultipartFile file, String content, UserVO authUser) {
	    System.out.println("GalleryService.exeUpload()");

	    String saveDir = "C:\\javaStudy\\upload\\";
	    String orgName = file.getOriginalFilename();

	    String exName = orgName.substring(orgName.lastIndexOf(".") + 1);
	    String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + "." + exName;
	    String filePath = saveDir + saveName;
	    long fileSize = file.getSize();

	    FileVO fileVO = new FileVO(orgName, exName, saveName, filePath, fileSize);

	    // 하드디스크 저장
	    try {
	        byte[] fileData = file.getBytes();
	        OutputStream os = new FileOutputStream(filePath);
	        BufferedOutputStream bos = new BufferedOutputStream(os);
	        bos.write(fileData);
	        bos.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // GalleryVO에 파일정보 및 유저, 글내용 설정 후 DB 저장
	    GalleryVO galleryVO = new GalleryVO();
	    galleryVO.setUserNo(authUser.getNo());
	    galleryVO.setName(authUser.getName());
	    galleryVO.setContent(content);
	    galleryVO.setFilePath(filePath);
	    galleryVO.setOrgName(orgName);
	    galleryVO.setSaveName(saveName);
	    galleryVO.setFileSize((int) fileSize);

	    galleryRepository.insertGallery(galleryVO);
	}
	
	
	
}
