package view;

import java.util.Scanner;

import controller.Controller;
import controller.Problem;
import model.User_infoDTO;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controller cot = new Controller();
		Problem pb = new Problem();

		System.out.println("================넌센스 퀴즈=================  ");
		System.out.println("[1]로그인 [2]회원가입 [3]게임 시작 [4]랭킹 조회 [5] 게임 종료");
		
		while (true) {
			int choice = sc.nextInt();
			
			if (choice == 5) {
				System.out.println("게임을 종료합니다.");
				break;
			} else if (choice == 1) { // 로그인
				cot.login(); // 로그인 기능 메서드 호출.

			} else if (choice == 2) { // 회원가입
				// 회원 가입 기능 메서드를 호출해줫어.
				cot.join_method();
				System.out.println("회원가입이 완료 되었습니다.");

			} else if (choice == 3) { // 게임 캐릭터 선택 or 게임시작
				// 문제 풀고 정답까지 비교 하는 메소드 호출 해줌.
				// 문제를 원하는 횟수만큼 풀고 종료되게구현함. 
				pb.solution();

			} else if (choice == 4) {// 랭킹 조회

			}
			
		}
		
		
		

	}

}