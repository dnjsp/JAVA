package z_homework.restaurant;
public class Menu {
	String[] menu = new String[0];
	int count = 0;

	public int showMenu() {
		if (count == 0) {
			System.out.println("등록된 메뉴가 없습니다. 메뉴를 등록해주세요.");
			return count;
		}
		System.out.print("[");
		for (int i = 0; i < count; i++) {
			if (menu[i] != null) {
				if (i > 0)
					System.out.print("\t");
				System.out.print((i + 1) + "." + menu[i]);
			}
		}
		System.out.println("]");
		return count;
	}

	public void addMenu(String item) {
		if (count == 5) {
			System.out.println("메뉴가 가득 찼습니다. 메뉴를 삭제하고 추가해주세요.");
			return;
		}
		boolean dupl = false;
		for (int i = 0; i < count; i++) {
			if (menu[i] == item)
				dupl = true;
		}
		if (!dupl) {
			String[] tmp = new String[count + 1];
			for (int i = 0; i < count; i++) {
				tmp[i] = menu[i];
			}
			tmp[count] = item;
			menu = tmp;
			count++;
			System.out.println("메뉴 [" + item + "]이(가) 추가되었습니다.");
		}
	}

	public void removeMenu(int idx) {
		String[] tmp = new String[count - 1];
		int j = 0;
		for (int i = 0; i < count; i++) {
			if (i != idx) {
				tmp[j++] = menu[i];
			} else {
				System.out.println(menu[i] + "이(가) 삭제되었습니다.");
			}
		}
		menu = tmp;
		count--;
	}

	public String getMenu(int i) {
		return menu[i];
	}
}