package view;

import java.util.Scanner;

import controller.Controller;
import model.QuestionDAO;
import model.QuestionDTO;
import model.TierDTO;
import model.User_infoDTO;

public class view_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controller cot = new Controller();

		{
			System.out.println("================넌센스 퀴즈=================  ");
			
			while (true) {
				System.out.println("[1]로그인 [2]회원가입 [5] 게임 종료");

				int choice = sc.nextInt();
				if (choice == 5) {
					System.out.println("게임을 종료합니다.");
					break;
				} else if (choice == 1) { // 로그인
					cot.login();

					while (true) {
						System.out.println("===============================");
						System.out.println("[3]게임 시작 [4]티어 조회 [5] 게임 종료");
						int controller = sc.nextInt();
						if (controller == 3) { // 게임 캐릭터 선택 or 게임시작
							// 문제 풀고 정답까지 비교 하는 메소드 호출 해줌.
							cot.solution();

						} else if (controller == 4) {// 랭킹 조회
							cot.showTier();
						} else if (controller == 5) {// 랭킹 조회
							System.out.println("게임을 완전히 종료 합니다.");
							return;
						}
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

					if (row > 0) {
						System.out.println("회원가입 성공");

					} else {
						System.out.println("오류 발생");

					}


				}

			}
		}
	}

}