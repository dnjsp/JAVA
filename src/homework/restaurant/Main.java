package z_homework.restaurant;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Order[] tOrder = new Order[0];
		Menu menu = new Menu();
		mainWhile: while (true) {
			System.out.println("======================== 영업 관리 ========================");
			System.out.println("1.주문받기\t2.메뉴관리\t3.오늘판매\t0.영업종료");
			System.out.println("===========================================================");
			System.out.print("번호를 입력해 주세요 >> ");
			switch (sc.nextInt()) {
			case 1:
				if (menu.count == 0) {
					System.out.println("등록된 메뉴가 없습니다.");
					break;
				}
				Order order = new Order();
				orderWhile: while (true) {
					System.out.println("------------------------ 메 뉴 판 ------------------------");
					menu.showMenu();
					System.out.println("----------------------------------------------------------");
					System.out.print("번호를 입력해 주세요 (0:완료) >> ");
					int input = sc.nextInt();
					if (input == 0) {
						break orderWhile;
					} else {
						order.addOrder(menu.getMenu(input - 1));
					}
				}
				if (order.count > 0) {
					System.out.println();
					System.out.println("---------------------- 주문한 메뉴 ----------------------");
					order.showOrder();
					System.out.println("---------------------------------------------------------");
					Order[] tmp = new Order[tOrder.length + 1];
					for (int i = 0; i < tOrder.length; i++) {
						tmp[i] = tOrder[i];
					}
					tmp[tOrder.length - 1] = order;
					tOrder = tmp;
				} else {
					System.out.println("주문을 취소합니다.");
				}
				break;
			case 2:
				menuWhile: while (true) {
					System.out.println("------------------------ 메뉴 관리 ------------------------");
					System.out.println("1.현재메뉴\t2.메뉴추가\t3.메뉴삭제\t0.메뉴나가기");
					System.out.println("-----------------------------------------------------------");
					System.out.print("번호를 입력해 주세요 >> ");
					switch (sc.nextInt()) {
					case 1:
						menu.showMenu();
						break;
					case 2:
						System.out.print("추가할 메뉴를 입력해 주세요 >> ");
						menu.addMenu(sc.next());
						break;
					case 3:
						if (menu.showMenu() > 0) {
							System.out.print("삭제할 메뉴 번호를 입력해 주세요 >> ");
							menu.removeMenu(sc.nextInt() - 1);
							menu.showMenu();
						}
						break;

					default:
					case 0:
						System.out.println("영업관리 화면으로 이동합니다..");
						System.out.println();
						break menuWhile;
					}
					System.out.println();
				}
				break;
			case 3:
				if (tOrder.length == 0) {
					System.out.println("오늘은 판매가 없습니다...");
					break;
				}
				System.out.println("---------------------- 오늘판매 ----------------------");
				for (int i = 0; i < tOrder.length; i++) {
					tOrder[i].showOrder();
				}
				System.out.println("------------------------------------------------------");

				break;
			default:
			case 0:
				System.out.println("영업을 종료합니다.");
				break mainWhile;
			}
			System.out.println();
		}
		sc.close();
	}

}