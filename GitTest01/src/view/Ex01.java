package view;
import java.util.Scanner;

import controller.Controller;
import controller.Problem;
import model.QuestionDAO;
import model.User_infoDTO;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controller cot = new Controller();
		Problem pb = new Problem();
		

		{
			                                                                                    
			
			
			


				System.out.println("================넌센스 퀴즈=================  ");
				System.out.println("[1]로그인 [2]회원가입 [3]게임 시작 [4]랭킹 조회 [5] 게임 종료");
				while (true) {
           
				int choice = sc.nextInt();
				if (choice == 5) {
					System.out.println("게임을 종료합니다.");
					break;
				} else if (choice == 1) { // 로그인
					System.out.println("id 입력해주세요. :");
					String input_id = sc.next();
					
					System.out.print("비밀번호 입력해 주세요. : "); 
					String intput_pw = sc.next();
					
					// 이때 db에서 id, pw 가져와야함.
					if(input_id.equals("db_id") && intput_pw.equals("d_pw")) {	// db에서 가져온 id와 pw가 동일 할경우 로그인 시켜줌.
						System.out.println("정상 로그인 되었습니다.");
						break;
					} else if(!input_id.equals("db_id") && intput_pw.equals("d_pw")) {
						System.out.println("아이디가 틀렸습니다. 아이디 다시 입려해주세요.");
					} else if(input_id.equals("db_id") && !intput_pw.equals("d_pw")) {
						System.out.println("비밀번호가 틀렸습니다. 비밀번호 다시 입려해주세요.");
					}
						
					
					
				} else if (choice == 2) { // 회원가입
					 // 회원 가입 기능 메서드를 호출해줫어.
					System.out.print("ID 입력: ");
					String inputID = sc.next();
					System.out.print("PW 입력: ");
					String inputPw = sc.next();
					System.out.print("닉네임 입력: ");
					String inputNickname = sc.next();
					
					
					
					QuestionDAO qdao = new QuestionDAO();
					int row = qdao.join(inputID, inputPw, inputNickname);
				
					
					if(row>0) {
						System.out.println("회원가입 성공");
					}else {
						System.out.println("오류 발생");
					}
					
					

				} else if (choice == 3) { // 게임 캐릭터 선택 or 게임시작
					// 문제 풀고 정답까지 비교 하는 메소드 호출 해줌.
					cot.solution_();

				} else if (choice == 4) {// 랭킹 조회 
					cot.showTier();



				
					
					
					
					

				}

			}
		}
	}

}