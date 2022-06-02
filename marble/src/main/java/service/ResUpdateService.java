package service;

import mapper.MemberMapper;
import vo.UserParam;

public class ResUpdateService {
	MemberMapper memberMapper = new MemberMapper();
	
	public void userResUpdate(UserParam param) {
		memberMapper.updateRes(param);
	}
}
