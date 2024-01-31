package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.QuestionDAO;
import model.QuestionDTO;
import model.User_infoDTO;

public class Problem {
	Scanner sc = new Scanner(System.in);
	QuestionDAO pdao = new QuestionDAO();

	String answer;

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
				Question = pdao.searchProblem("하", num); // db에서 사용자가 선택한 문제,정답, 점수등 이 담긴 객체를 가져온다.
				cnt++;
			
				break;
			case 2:
				num = rd.nextInt(20) + 21;
				Question = pdao.searchProblem("중", num); // db에서 사용자가 선택한 문제,정답, 점수등 이 담긴 객체를 가져온다.
				cnt++;
				break;
			case 3:
				num = rd.nextInt(20) + 41;
				Question = pdao.searchProblem("상", num); // db에서 사용자가 선택한 문제,정답, 점수등 이 담긴 객체를 가져온다.
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
				plus += 2;
				plus1 += 3;
				plus2 += 4;
			} else {
				System.out.println("오답입니다.  정답은 : " + Question.getAnswer() + " 입니다.");
			}
             
			
		}
	if(choice == 1	) {
		System.out.println("내점수는 : " + plus +"점 입니다.");
	}else if(choice == 2) {
		System.out.println("내점수는 : " + plus1 +"점 입니다.");
	}else if(choice == 3) {
		System.out.println("내점수는  " + plus2 +"점 입니다.");
	}

	}

}
