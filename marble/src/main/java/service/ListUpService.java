package service;

import java.util.ArrayList;

import mapper.MemberMapper;
import vo.UserParam;

public class ListUpService {
	MemberMapper memberMapper = new MemberMapper();
	
	public ArrayList<UserParam> userList() {
		return memberMapper.getList();
	}
}
