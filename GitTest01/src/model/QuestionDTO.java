package model;

public class QuestionDTO {
	String question;
	String answer;
	int number;
	
	// 생성자
	public QuestionDTO(String question, int number, String answer) {
		this.question = question;
		this.answer = answer;
		this.number = number;
		
	}
	
	// getter
	public String getQuestion() {
		return question;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	
}
