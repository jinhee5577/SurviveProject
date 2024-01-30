import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		
		System.out.println("============ gameStory ===============");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("======================================");

		while (true) {
			System.out.println("방공호 에서 살아남기 ");
			System.out.println("[1]회원가입 [2]게임시작 [3]전체랭킹조회 [4]게임설명 [5]게임종료");

			int choice = sc.nextInt();
			if (choice == 5) {
				System.out.println("게임을 종료합니다.");
				break;
			} else if (choice == 1) {
				System.out.println("회원가입 페이지");
				System.out.print("아이디 입력 : ");
				String input_id = sc.next();
				System.out.print("비밀번호 입력 : ");
				int intput_pw = sc.nextInt();
				System.out.print("닉네임 입력 : ");
				String input_userName = sc.next(); // id,pw,userName DB에저장

				System.out.println("회원가입이 완료 되었습니다.");

			} else if (choice == 2) {
				System.out.println("게임 캐릭터 선택 : [1]진희 오. [2]정민 림. [3]인혜 나. [4]종원 오.");
				System.out.println("진희 오. : 체력 = ? 포만감 = ? 배고픔 = ? 보유 아이템 = ?");
				System.out.println("정민 림. : 체력 = ? 포만감 = ? 배고픔 = ? 보유 아이템 = ?");
				System.out.println("인혜 나. : 체력 = ? 포만감 = ? 배고픔 = ? 보유 아이템 = ?");
				System.out.println("종원 오. : 체력 = ? 포만감 = ? 배고픔 = ? 보유 아이템 = ?");
				System.out.println("원하는 캐릭터를 선택하세요");
				int choice2 = sc.nextInt();
				while (true) {
					if (choice2 == 1) {

					} else if (choice2 == 2) {

					} else if (choice2 == 3) {

					} else if (choice2 == 4) {

					}
				}

			} else if (choice == 3) {

			} else if (choice == 4) {
				System.out.println("==========================================");
				System.out.println("게임 설명입니다.");
				System.out.println("이게임은 방공호에서 살아남기입니다. 원하는 캐릭터를 골라");
				System.out.println("다양한 특성과 아이템들을 활용하여 각종 위험에서 살아남으세요! ");
				System.out.println("==========================================");
			}

		}
	
	
	}

}
