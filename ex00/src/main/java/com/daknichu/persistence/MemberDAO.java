package com.daknichu.persistence;

import com.daknichu.domain.MemberVO;

public interface MemberDAO {

	public String getTime();
	
	public void insertMember(MemberVO vo);
}
