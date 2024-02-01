package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.QuestionDAO;
import model.QuestionDTO;
import model.ScoreDTO;
import model.TierDTO;
import model.User_infoDTO;

public class Controller {
	Scanner sc = new Scanner(System.in);

	QuestionDAO qdao = new QuestionDAO(); // QuestionDAO 객체 생성
	String nowUserID; // 현재 로그인한 유저 id담는 필드.
	int sumScore;
	String answer;
	User_infoDTO user_dto;

	// 외부에서 nowUserID 접근.
	public String getnNowUserID() {
		return nowUserID;
	}

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

			} else { // db에 입력받은 아이디가 없다면 입력한 아이디를 사용할수 있습니다.
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

		while (true) {
			System.out.println("id 입력해주세요. :");
			String input_id = sc.next();

			System.out.print("비밀번호 입력해 주세요. : ");
			String intput_pw = sc.next();

			// 이때 db에서 id, pw 가져와야함.

			user_dto = qdao.getUserInfo(input_id); // db에서 가져온 데이터 User_infoDTO객체에 담아서 리턴해줌.

			if (user_dto != null) {
				if (input_id.equals(user_dto.getUser_id()) && intput_pw.equals(user_dto.getUser_pw())) {
					System.out.println("정상 로그인 되었습니다.");
					nowUserID = user_dto.getUser_id(); // 이때 현재 로그인한 유저의 id가 할당 된다.
					sumScore = user_dto.getSumScore();
					break;

				} else if (input_id.equals(user_dto.getUser_id()) && !intput_pw.equals(user_dto.getUser_pw())) {
					System.out.println("비밀번호가 틀렸습니다. 비밀번호 다시 입려해주세요.");

				}

			} else {
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
				break;
			case 2:
				num = rd.nextInt(20) + 21;
				Question = qdao.searchProblem("중", num); // db에서 사용자가 선택한 문제,정답, 점수등 이 담긴 객체를 가져온다.
				break;
			case 3:
				num = rd.nextInt(20) + 41;
				Question = qdao.searchProblem("상", num); // db에서 사용자가 선택한 문제,정답, 점수등 이 담긴 객체를 가져온다.
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}

			cnt++;// 문제 횟수를 세어줌
			System.out.println("문제 " + Question.getNumber() + "번: " + Question.getQuestion());

			System.out.print("정답을 입력해 주세요.  :");
			answer = sc.next();

			// db에서 정답 과 입력한 정답을 검사해줄꺼야.
			if (answer.equals(Question.getAnswer())) {
				System.out.println("                                   .''.       \r\n"
						+ "       .''.      .        *''*    :_\\/_:     . \r\n"
						+ "      :_\\/_:   _\\(/_  .:.*_\\/_*   : /\\ :  .'.:.'.\r\n"
						+ "  .''.: /\\ :   ./)\\   ':'* /\\ * :  '..'.  -=:o:=-\r\n"
						+ " :_\\/_:'.:::.    ' *''*    * '.\\'/.' _\\(/_'.':'.'\r\n"
						+ " : /\\ : :::::     *_\\/_*     -= o =-  /)\\    '  *\r\n"
						+ "  '..'  ':::'     * /\\ *     .'/.\\'.   '\r\n" + "      *            *..*         :\r\n"
						+ "       *\r\n" + "        *");
				System.out.println("╭ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝╮\r\n" + "                    정답입니다!"
						+ "\r\n" + "╰ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ╯\r\n" + "O\r\n" + "°\r\n"
						+ "/}__/}\r\n" + "( • ▼•)\r\n" + "");

				plus += 2;// 하 난이도가 정답일때마다 plus에 2점을 담아준다
				plus1 += 3;// 중 3
				plus2 += 4; // 상 4

			} else {
				System.out.println("╭ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝╮\r\n" + "           오답입니다.      정답은 : "
						+ Question.getAnswer() + "입니다." + "\r\n" + "╰ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ╯\r\n"
						+ "O\r\n" + "°\r\n" + "/}__/}\r\n" + "( • ▼•)\r\n" + "");

			}

		}

		// qdao.getUserInfo(nowUserID);
		if (choice == 1) {
			System.out.println("내점수는 : " + plus + "점 입니다.");
			ScoreDTO score_dto = qdao.getScore(nowUserID); // 유저의 기존 score점수가 담긴 객체를 뱉음.
			sumScore = plus + score_dto.getScore(); // db에서 가져온 점수와 현재 합산 수를 더했다.
			System.out.println("현재 합산 점수는: " + sumScore);

			// 다시 합산된 점수를 sql로 보내서 db점수를 갈아치움.
			int row2 = qdao.scoreUpdate(nowUserID, sumScore);
			if (row2 > 0) {
				System.out.println("정상 합산 되었습니다.");
			} else {
				System.out.println("합산이 실패 했습니다.");
			}

		} else if (choice == 2) {
			System.out.println("내점수는 : " + plus1 + "점 입니다.");
			ScoreDTO score_dto = qdao.getScore(nowUserID); // 유저의 기존 score점수가 담긴 객체를 뱉음.
			sumScore = plus1 + score_dto.getScore(); // db에서 가져온 점수와 현재 합산 수를 더했다.
			System.out.println("현재 합산 점수는: " + sumScore);

			// 다시 합산된 점수를 sql로 보내서 db점수를 갈아치움.
			int row2 = qdao.scoreUpdate(nowUserID, sumScore);
			if (row2 > 0) {
				System.out.println("정상 합산 되었습니다.");
			} else {
				System.out.println("합산이 실패 했습니다.");
			}
		} else if (choice == 3) {
			System.out.println("내점수는  " + plus2 + "점 입니다.");
			ScoreDTO score_dto = qdao.getScore(nowUserID); // 유저의 기존 score점수가 담긴 객체를 뱉음.
			sumScore = plus2 + score_dto.getScore(); // db에서 가져온 점수와 현재 합산 수를 더했다.
			System.out.println("현재 합산 점수는: " + sumScore);

			// 다시 합산된 점수를 sql로 보내서 db점수를 갈아치움.
			int row2 = qdao.scoreUpdate(nowUserID, sumScore);
			if (row2 > 0) {
				System.out.println("정상 합산 되었습니다.");
			} else {
				System.out.println("합산이 실패 했습니다.");
			}
		}

	}
	
	

	// 티어 show 메서드
	public void showTier() {
		TierUpgrade(nowUserID, sumScore); // 합산 점수 별로 티어 승급 해줌.
		ArrayList<TierDTO> tierList = qdao.tierMethod();
		System.out.println();
		System.out.println("=========전체 회원 티어============");

		int cn = 1;
		for (TierDTO ele : tierList) {
			System.out.println(cn + "위 : " + ele.getNickname() + "은(는)[ " + ele.getTier() + " ]등급입니다.");
			cn++;
		}

	}

	// tier업그레이드 메서드
	public void TierUpgrade(String user_id, int sumScore) {

		if (sumScore <= 20) {
			int row = qdao.tierUpgrade(nowUserID, "브론즈");
			if (row > 0) {
				System.out.println(user_dto.getUser_name() + "님 [브론즈]승급 성공");
			} else {
				System.out.println("브론즈 실패");
			}
		} else if (sumScore <= 35) {
			int row = qdao.tierUpgrade(nowUserID, "실버");
			if (row > 0) {
				System.out.println(user_dto.getUser_name() + "님 [실버]승급 성공");
			} else {
				System.out.println("실버 실패");
			}
		} else if (sumScore <= 50) {
			int row = qdao.tierUpgrade(nowUserID, "골드");
			if (row > 0) {
				System.out.println(user_dto.getUser_name() + "님 [골드]승급 성공");
			} else {
				System.out.println("골드 실패");
			}

		} else if (sumScore <= 65) {
			int row = qdao.tierUpgrade(nowUserID, "다이아몬드");
			if (row > 0) {
				System.out.println(user_dto.getUser_name() + "님 [다이아몬드]승급 성공");
			} else {
				System.out.println("다이 실패");
			}
		} else {
			int row = qdao.tierUpgrade(nowUserID, "챌린저");
			if (row > 0) {
				System.out.println(user_dto.getUser_name() + "님 [챌린저]승급 성공");
			} else {
				System.out.println("챌 실패");
			}
		}

	}

}
