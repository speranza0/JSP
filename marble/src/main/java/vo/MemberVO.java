package vo;

public class MemberVO {
	private int idx;
	private String id;
	private String password;
	private String email;
	
	public MemberVO(int idx, String id, String password, String email) {
		this.idx = idx;
		this.id = id;
		this.password = password;
		this.email = email;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
