package model;

public class TierDTO {
	private String nickname ;
	private String tier;
	
	
	//생성자
	public TierDTO(String nickname, String tier) {
		
		this.nickname = nickname;
		this.tier = tier;
	}
	
	// getrer
	public String getNickname() {
		return nickname;
	}
	public String getTier() {
		return tier;
	}
	
	
}
