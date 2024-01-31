package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.QuestionDAO;
import model.QuestionDTO;
import model.TierDTO;
import model.User_infoDTO;

public class Controller {
	Scanner sc = new Scanner(System.in);
    QuestionDAO qdao = new QuestionDAO();

	String answer;
	// 회원 가입 기능 메서드
	public void join_method() {
		System.out.println("회원가입 페이지");
		boolean check = true;

		while (check) {
			System.out.print("아이디 입력 해주세요. : ");
			String input_id = sc.next();
			// 아이디 중복 검사.
			if (input_id.equals("db에서 가져온 아이디 비교 할겁니다.")) {
				System.out.println("입력하신 아이디가 존재합니다. 다른아이디로 재입력 해주세요.");
				
			} else {  // db에 입력받은 아이디가 없다면 입력한 아이디를 사용할수 있습니다.
				// db에 같은 아이디가 없다면 이안에서 비밀번호 입력받아서 비밀번확인 받고 아이디와 비밀번호를 db로 보낼겁니다.

				System.out.print("비밀번호 입력해 주세요. : "); // 비밀번호 확인
				String intput_pw = sc.next();
				
				System.out.print("닉네임 입력해 주세요. : ");
				String input_userName = sc.next(); // id,pw,userName DB에저장
				
				User_infoDTO userInfo = new User_infoDTO(input_id, intput_pw, input_userName);
				// 이때 유저 정보가 담긴 객체를 DAO메서드에서 DB로 전송해준다.
				check = false;
				break;
			}
		}

	}
	
	
	
	
	// 로그인 기능 메서드
	public void login() {
		// 입력받은 id,pw를 db에서 가져온 id,pw가 동일 한지 비교하여 로그인 시켜준다.
	
		while(true) {
			System.out.println("id 입력해주세요. :");
			String input_id = sc.next();
			
			System.out.print("비밀번호 입력해 주세요. : "); 
			String intput_pw = sc.next();
			
			// 이때 db에서 id, pw 가져와야함.

			User_infoDTO user_dto =	qdao.getUserInfo(input_id); // db에서 가져온 데이터 User_infoDTO객체에 담아서 리턴해줌.
			
			if(user_dto != null) {
				if(input_id.equals(user_dto.getUser_id()) && intput_pw.equals(user_dto.getUser_pw())) {
					System.out.println("정상 로그인 되었습니다."); 
					break;
				} else if(input_id.equals(user_dto.getUser_id()) && !intput_pw.equals(user_dto.getUser_pw())) {
					System.out.println("비밀번호가 틀렸습니다. 비밀번호 다시 입려해주세요.");
				}
				
			}else {
				System.out.println("아이디또는 비밀번호가 틀렸습니다. 다시 입력해주세요.");

			
			
		}
	}
	}
	// 문제 푸는 기능 메서드
	


		// 문제 랜덤 생성 

			// 문제 푸는 메서드
			public void solution() {
				System.out.println("문제 나이도 선택해 주세요. [1]: 하, [2]: 중, [3]: 상 ");
				int choice = sc.nextInt();
				int plus = 0;
				int plus1 = 0;
				int plus2 = 0;
				int cnt = 0;
				while (cnt < 5) {
					// 문제 번호 랜덤으로 생성됨.
					Random rd = new Random();
					int num;

					// db에서 선택한 문제 가져오기.

					QuestionDTO Question = null; // db에서 가져온 문제를 담는 객체야.
					switch (choice) {
					case 1:
						num = rd.nextInt(20) + 1;
						Question = qdao.searchProblem("하", num); // db에서 사용자가 선택한 문제,정답, 점수등 이 담긴 객체를 가져온다.
						cnt++;// 문제 횟수를 세어줌 

						break;
					case 2:
						num = rd.nextInt(20) + 21;
						Question = qdao.searchProblem("중", num); // db에서 사용자가 선택한 문제,정답, 점수등 이 담긴 객체를 가져온다.
						cnt++;
						break;
					case 3:
						num = rd.nextInt(20) + 41;
						Question = qdao.searchProblem("상", num); // db에서 사용자가 선택한 문제,정답, 점수등 이 담긴 객체를 가져온다.
						cnt++;
						break;
					default:
						System.out.println("잘못 입력하셨습니다.");
						break;
					}

					System.out.println("문제 " + Question.getNumber() + "번: " + Question.getQuestion());

					System.out.print("정답을 입력해 주세요.  :");
					answer = sc.next();

					// db에서 정답 과 입력한 정답을 검사해줄꺼야.
					if (answer.equals(Question.getAnswer())) {
						System.out.println("정답입니다.");
						plus += 2;// 하 난이도가 정답일때마다 plus에 2점을 담아준다 
						plus1 += 3;// 중 3
						plus2 += 4; // 상 4
					} else {
						System.out.println("오답입니다.  정답은 : " + Question.getAnswer() + " 입니다.");
					}

				}
				if (choice == 1) {
					System.out.println("내점수는 : " + plus + "점 입니다.");
				} else if (choice == 2) {
					System.out.println("내점수는 : " + plus1 + "점 입니다.");
				} else if (choice == 3) {
					System.out.println("내점수는  " + plus2 + "점 입니다.");
				}

			}

		

	
	
	
	// 티어 show 메서드
	public void showTier(){
		ArrayList<TierDTO> tierList = qdao.tierMethod();
		
		for(TierDTO ele: tierList) {
			System.out.println(ele.getNickname()+ "은 " + ele.getTier()+ "입니다.");
		}
		
	}

}
