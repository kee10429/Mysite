package com.javaex.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVO;

@Repository
public class BoardRepository {

	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//메소드일반
	//--전체리스트 가져오기(게시판리스트)
	public List<BoardVO> boardSelectList() {
		System.out.println("BoardRepository.boardSelectList()");
		
		List<BoardVO> boardList = sqlSession.selectList("board.selectList");
		
		return boardList;
	}
	
	//글쓰기
	public int boardInsert(BoardVO boardVO) {
		
		int count = sqlSession.insert("boardInsert", boardVO);
		
		return count;
	}
	
	//읽기
	public BoardVO boardSelectByNo(BoardVO boardVO) {
		
		BoardVO authVO = sqlSession.selectOne("board.selectOnebyNo", boardVO);
		
		return authVO;
	}
	
	
}