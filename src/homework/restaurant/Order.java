package z_homework.restaurant;
public class Order {
	String[] order = { "", "", "", "", "" };
	int count = 0;

	public void addOrder(String menu) {
		if (count == 5) {
			System.out.println("1회 주문은 최대 5개까지 가능합니다.");
			return;
		}
		order[count] = menu;
		count++;
	}

	public void showOrder() {
		System.out.print("[");
		for (int i = 0; i < count; i++) {
			if (!order[i].equals("")) {
				if (i > 0)
					System.out.print("\t");
				System.out.print(order[i]);
			}
		}
		System.out.println("]");
	}
}