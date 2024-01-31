package model;

public class User_infoDTO {
  String user_id;
  String user_pw;
  String user_nickname;
  int sumScore = 0;   // 합산 점수  초기값 = 0
  int[] solveCount = {0, 0, 0};  
  // 문제 푼 횟수를 담는 배열. [0]번인덱스 '하'문제푼 횟수, [1]번 인덱스 '중'문제푼 횟수, [2]상 문제푼 횟수. 입니다. 초기값은 다 0 이다.
  
	public User_infoDTO(String user_id, String user_pw, String user_nickname) {
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_nickname = user_nickname;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public String getUser_name() {
		return user_nickname;
	}
	  
	
  

}
