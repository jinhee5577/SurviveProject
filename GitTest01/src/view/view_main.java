package view;
import java.util.Scanner;

import controller.Controller;
import model.QuestionDAO;
import model.User_infoDTO;

public class view_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controller cot = new Controller();
		
		

		{
				System.out.println("================넌센스 퀴즈=================  ");
				System.out.println("[1]로그인 [2]회원가입 [3]게임 시작 [4]랭킹 조회 [5] 게임 종료");
				while (true) {
           
				int choice = sc.nextInt();
				if (choice == 5) {
					System.out.println("게임을 종료합니다.");
					break;
				} else if (choice == 1) { // 로그인
				
					cot.login();
					
					
				} else if (choice == 2) { // 회원가입
					System.out.print("ID 입력: ");
					String inputID = sc.next();
					System.out.print("PW 입력: ");
					String inputPw = sc.next();
					System.out.print("닉네임 입력: ");
					String inputNickname = sc.next();
					
					
					
					// 회원 가입 기능 메서드를 호출해줫어.
					QuestionDAO qdao = new QuestionDAO();
					int row = qdao.join(inputID, inputPw, inputNickname);
				
					
					if(row>0) {
						System.out.println("회원가입 성공");
					}else {
						System.out.println("회원가입 실패");
					}
					
					

				} else if (choice == 3) { // 게임 캐릭터 선택 or 게임시작
					// 문제 풀고 정답까지 비교 하는 메소드 호출 해줌.
					cot.solution();

				} else if (choice == 4) {// 랭킹 조회 
					cot.showTier();



				
					
					
					
					

				}

			}
		}
	}

}