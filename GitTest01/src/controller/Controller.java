package controller;

import java.util.Scanner;

import model.User_infoDTO;

public class Controller {
	Scanner sc = new Scanner(System.in);

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
			if(input_id.equals("db_id") && intput_pw.equals("d_pw")) {	// db에서 가져온 id와 pw가 동일 할경우 로그인 시켜줌.
				System.out.println("정상 로그인 되었습니다.");
				break;
			} else if(!input_id.equals("db_id") && intput_pw.equals("d_pw")) {
				System.out.println("아이디가 틀렸습니다. 아이디 다시 입려해주세요.");
			} else if(input_id.equals("db_id") && !intput_pw.equals("d_pw")) {
				System.out.println("비밀번호가 틀렸습니다. 비밀번호 다시 입려해주세요.");
			}
			
		}
	}
	

}
