package service;

import mapper.MemberMapper;
import vo.JoinParam;
import vo.MemberVO;

/*
 * Controller <-> DB의 사이에서 트랜잭션을 관리하는 클래스
 */

public class JoinService {
	MemberMapper memberMapper = new MemberMapper();
	
	public void joinProcess(JoinParam param) {
		// DB에 접속해서 회원가입 처리한다.
		memberMapper.createMember(param);
		memberMapper.createDiceTable(param.getId());
	}
}
