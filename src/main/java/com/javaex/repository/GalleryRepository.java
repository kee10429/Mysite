package com.javaex.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVO;
import com.javaex.vo.UserVO;

@Repository
public class GalleryRepository {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//메소드일반
	//로그인 (정보 가져오기 id pw) 
	public UserVO userSelectOneByIdPw(UserVO userVO) {
		
		UserVO authUser = sqlSession.selectOne("user.selectOneByIdPw", userVO);
		
		return authUser;
	}
	
	//사진가져오기
	public List<GalleryVO> gallerySelectAll(){
	    return sqlSession.selectList("gallery.selectAll");
	}
	
	//저장로직
	public int insertGallery(GalleryVO galleryVO) {
	    return sqlSession.insert("gallery.insertGallery", galleryVO);
	}
}
