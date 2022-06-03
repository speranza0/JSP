package vo;

public class UserParam {
	private String id;
	private int dicesum;
	private int dicecount;
	private int roundnum;
	private float avg;
	
	public UserParam() {
		
	}
	
	public UserParam(String id, int dicesum, int dicecount, int roundnum) {
		this.id = id;
		this.dicesum = dicesum;
		this.dicecount = dicecount;
		this.roundnum = roundnum;
		this.avg = dicesum / (float)dicecount;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDicesum() {
		return dicesum;
	}
	public void setDicesum(int dicesum) {
		this.dicesum = dicesum;
	}
	public int getDicecount() {
		return dicecount;
	}
	public void setDicecount(int dicecount) {
		this.dicecount = dicecount;
	}
	public int getRoundnum() {
		return roundnum;
	}
	public void setRoundnum(int roundnum) {
		this.roundnum = roundnum;
	}
	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}
}
