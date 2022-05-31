package vo;

public class MemberVO {
	private int idx;
	private String id;
	private String password;
	private String name;
	private boolean vip;
	
	public MemberVO(int idx, String id, String password, String name, boolean vip) {
		this.idx = idx;
		this.id = id;
		this.password = password;
		this.name = name;
		this.vip = vip;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}
	
}
