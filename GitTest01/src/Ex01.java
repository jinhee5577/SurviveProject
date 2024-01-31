import java.util.Scanner;

import DTO.User_infoDTO;
import controller.Controller;
import problem.Problem;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Controller cot = new Controller();
		Problem pb = new Problem();
		

		{
			System.out.println("███████╗██╗   ██╗██████╗ ██╗   ██╗██╗██╗   ██╗███████╗     ██████╗  █████╗ ███╗   ███╗███████╗\r\n"
					+ "██╔════╝██║   ██║██╔══██╗██║   ██║██║██║   ██║██╔════╝    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝\r\n"
					+ "███████╗██║   ██║██████╔╝██║   ██║██║██║   ██║█████╗      ██║  ███╗███████║██╔████╔██║█████╗  \r\n"
					+ "╚════██║██║   ██║██╔══██╗╚██╗ ██╔╝██║╚██╗ ██╔╝██╔══╝      ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  \r\n"
					+ "███████║╚██████╔╝██║  ██║ ╚████╔╝ ██║ ╚████╔╝ ███████╗    ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗\r\n"
					+ "╚══════╝ ╚═════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═══╝  ╚══════╝     ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝\r\n"
					+ "                                                                                              ");
			
			
			
			System.out.println("============ gameStory =========================================================================");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("================================================================================================");

			while (true) {
				System.out.println("방공호 에서 살아남기 ");
				System.out.println("[1]로그인 [2]회원가입 [3]게임 시작 [4]게임 설명 [5] 전체 랭킹 조회 [6] 게임 종료");

				int choice = sc.nextInt();
				if (choice == 6) {
					System.out.println("게임을 종료합니다.");
					break;
				} else if (choice == 1) { // 로그인
					cot.login(); // 로그인 기능 메서드 호출.
					
				} else if (choice == 2) { // 회원가입
					 // 회원 가입 기능 메서드를 호출해줫어.
					cot.join_method();
					System.out.println("회원가입이 완료 되었습니다.");

				} else if (choice == 3) { // 게임 캐릭터 선택 or 게임시작 
					System.out.println("게임 캐릭터 선택 : [1]진희 오. [2]정민 림. [3]인혜 나. [4]종원 오.");
					// 각 캐릭터마다 기본값을 랜덤으로 주게되면? 캐릭터를 고를 필요가 있나 ? 몰ㅋ 루 
					System.out.println("진희 오. : 체력 = ? 포만감 = ? 배고픔 = ? 보유 아이템 = ?");
					System.out.println("정민 림. : 체력 = ? 포만감 = ? 배고픔 = ? 보유 아이템 = ?");
					System.out.println("인혜 나. : 체력 = ? 포만감 = ? 배고픔 = ? 보유 아이템 = ?");
					System.out.println("종원 오. : 체력 = ? 포만감 = ? 배고픔 = ? 보유 아이템 = ?");
					System.out.println("원하는 캐릭터를 선택하세요");
					int choice2 = sc.nextInt();
					switch (choice2) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					default:
						break;
					}

				} else if (choice == 4) {// 게임 룰 설명 

					System.out.println("==========================================");
					System.out.println("게임 룰 설명입니다.");
					System.out.println("이게임은 방공호에서 살아남기입니다. 원하는 캐릭터를 골라");
					System.out.println("다양한 특성과 아이템들을 활용하여 각종 위험에서 살아남으세요! ");
					System.out.println("각종 이벤트에서 다양한 아이템을 얻어 게임에서 살아남으세요 !");
					System.out.println("캐릭터의 HP가 0이 되면 게임은 종료됩니다 ");
					System.out.println("n일간 생존 하실 경우 방공호에서 구조 되셨습니다. 축하드립니다."); // N일간 생존해서 게임이 종료 되었을 때 
					System.out.println("==========================================");

//					System.out.println("==========================================");
//					System.out.println("게임 룰 설명입니다.");
//					System.out.println("이게임은 방공호에서 살아남기입니다. 원하는 캐릭터를 골라");
//					System.out.println("다양한 특성과 아이템들을 활용하여 각종 위험에서 살아남으세요! ");
//					System.out.println("캐릭터의 HP가 0이 되면 게임은 종료됩니다 ");
//					System.out.println("각종 이벤트에서 다양한 아이템을 얻어 게임에서 살아남으세요 !");
//					System.out.println("n일간 생존 하실 경우 방공호에서 구조 되셨습니다. 축하드립니다."); // N일간 생존해서 게임이 종료 되었을 때 
//					System.out.println("==========================================");
					
					// test 호츨.
					pb.solution();
					
					
					
					

				}

			}
		}
	}

}