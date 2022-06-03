package service;

import mapper.MemberMapper;
import vo.UserParam;

public class ResUpdateService {
	MemberMapper memberMapper = new MemberMapper();
	
	public UserParam userResUpdate(String id) {
		return memberMapper.selectResById(id);
	}
}
