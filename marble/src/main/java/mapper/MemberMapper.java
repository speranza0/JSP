package mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.JdbcUtils;
import vo.JoinParam;
import vo.MemberVO;
import vo.UserParam;

/*
 * SQL 문이 들어가는 클래스
 * */
public class MemberMapper {
	Connection conn = JdbcUtils.conn;
	
	public MemberVO selectOneById(String id) {
		MemberVO member = null;
		String sql = "select * from member where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberVO(rs.getInt("idx"), rs.getString("id"), rs.getString("password"), rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public void createMember(JoinParam param) {
		String sql = "insert into member (id, password, email) value(?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, param.getId());
			pstmt.setString(2, param.getPassword());
			pstmt.setString(3, param.getEmail());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void createDiceTable(String id) {
		String sql = "insert into diceresult (id) value(?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateRes(UserParam param) {
		String sql = "update diceresult set dicesum = ?, dicecount = ? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(param.getDicesum()));
			pstmt.setInt(2, Integer.parseInt(param.getDicecount() + 1));
			pstmt.setString(3, param.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
