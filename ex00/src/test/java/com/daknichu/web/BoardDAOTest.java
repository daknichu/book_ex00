package com.daknichu.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.daknichu.domain.BoardVO;
import com.daknichu.domain.Criteria;
import com.daknichu.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Inject
	private BoardDAO dao;
	
	@Test
	public void testCreate() throws Exception {
		
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("새로운 제목을 넣습니다.");
		board.setContent("새로운 글을 넣습니다.");
		board.setWriter("daknichu");
		dao.create(board);
	}
	
	@Test
	public void testRead() throws Exception {
		
		System.out.println(dao.read(1).toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("수정된 제목 입니다.");
		board.setContent("수정된 글 입니다.");
		dao.update(board);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}
	
	@Test
	public void testListPage() throws Exception {
		
		int page = 3;
		
		List<BoardVO> list = dao.listPage(page);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
	}
	
	@Test
	public void testListCriteria() throws Exception {
		
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
	}

}
