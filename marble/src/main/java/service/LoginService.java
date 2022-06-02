package service;

import mapper.MemberMapper;
import vo.MemberVO;

public class LoginService {
	MemberMapper memberMapper = new MemberMapper();
	
	public MemberVO findMemberById(String id) {
		return memberMapper.selectOneById(id);
	}
}
