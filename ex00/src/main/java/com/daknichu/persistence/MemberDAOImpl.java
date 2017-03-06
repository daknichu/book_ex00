package com.daknichu.persistence;

import java.util.HashMap;
import java.util.Map;

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

	@Override
	public MemberVO readMember(String userid) throws Exception {
		return (MemberVO)sqlsession.selectOne(namespace+".selectMember", userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		return sqlsession.selectOne(namespace+".readWithPW", paramMap);
	}

}
