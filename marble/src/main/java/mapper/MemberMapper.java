package mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public UserParam selectResById(String id) {
		UserParam user = null;
		String sql = "select * from diceresult where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new UserParam(rs.getString("id"), rs.getInt("dicesum"), rs.getInt("dicecount"), rs.getInt("roundnum"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public ArrayList<UserParam> getList() {
		String sql = "select * from diceresult order by dicesum desc";
		ArrayList<UserParam> list = new ArrayList<UserParam>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				int dicesum = rs.getInt("dicesum");
				int dicecount = rs.getInt("dicecount");
				int roundnum = rs.getInt("roundnum");
				
				UserParam paramList = new UserParam(id, dicesum, dicecount, roundnum);
				list.add(paramList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
