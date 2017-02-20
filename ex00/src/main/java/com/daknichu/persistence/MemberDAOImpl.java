package com.daknichu.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.daknichu.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlsession;
	
	private static final String namespace 
		= "com.daknichu.mapper.MemberMapper";

	@Override
	public String getTime() {
		return sqlsession.selectOne(namespace+".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlsession.insert(namespace+".insertMember", vo);
	}

}
