package questionDTO;

public class QuestionDTO {
	String question;
	int number;
	
	// 생성자
	public QuestionDTO(String question, int number) {
		super();
		this.question = question;
		this.number = number;
	}
	
	// getter
	public String getQuestion() {
		return question;
	}
	
	public int getNumber() {
		return number;
	}
	
	
}
