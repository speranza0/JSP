package vo;

public class UserParam {
	private String id;
	private String dicesum;
	private String dicecount;
	
	public UserParam() {
		
	}
	
	public UserParam(String id, String dicesum, String dicecount) {
		this.id = id;
		this.dicesum = dicesum;
		this.dicecount = dicecount;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDicesum() {
		return dicesum;
	}
	public void setDicesum(String dicesum) {
		this.dicesum = dicesum;
	}
	public String getDicecount() {
		return dicecount;
	}
	public void setDicecount(String dicecount) {
		this.dicecount = dicecount;
	}
}
