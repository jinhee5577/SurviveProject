package model;

public class ScoreDTO {
	int score;
	String tier;

	// 생성자.
	public ScoreDTO(int score, String tier) {
		this.score = score;
		this.tier = tier;
	}

	// getter
	public int getScore() {
		return score;
	}
	
	public String getTier() {
		return tier;
	}
	
	
}
