package z_homework.game;

public class Character {
	String name;
	int maxHp, maxMp, hp, mp, att, def, level, exp, nextExp;
	Item[] items;

	Character(String name, int hp, int mp, int att, int def) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.maxHp = hp;
		this.maxMp = mp;
		this.att = att;
		this.def = def;
		this.level = 1;
		this.exp = 0;
		this.nextExp = level * 100;
		this.items = new Item[10];
	}

	void showInfo() {
		System.out.println("---------- 상 태 ----------");
		System.out.println("이름 : " + name);
		System.out.println("레벨 : " + level + "(" + exp + "/" + nextExp + ")");
		System.out.println("체력 : " + hp + "/" + maxHp);
		System.out.println("마나 : " + mp + "/" + maxMp);
		System.out.println("공격 : " + att);
		System.out.println("방어 : " + def);
		System.out.println("----------------------------");
		System.out.println("---------- 아이템 ----------");

		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				System.out.println(this.items[i].itemInfo());
			}
		}

		System.out.println("----------------------------");
		System.out.println();
	}

	void attack(Monster m) {
		int damage = att - m.def;
		damage = damage <= 0 ? 1 : damage;
		m.hp = m.hp < damage ? m.hp - m.hp : m.hp - damage;
		System.out.println(name + "이(가) 공격으로 " + m.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
		System.out.println(m.name + "의 남은 HP : " + m.hp);
	}

	void getItem(Item item) {
		System.out.println(item.name + "을(를) 획득하였습니다.");
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				items[i] = item;
				break;
			}
		}
		maxHp += item.maxHp;
		maxMp += item.maxMp;
		att += item.att;
		def += item.def;
	}

	void getExp(int exp) {
		System.out.println(exp + "의 경험치를 획득하였습니다.");
		this.exp += exp;
		while(nextExp <= this.exp) {
			this.exp -= nextExp;
			levelUp();
		}
	}

	void levelUp() {
		this.level ++;
		this.maxHp += 10;
		this.maxMp += 5;
		this.att += 2;
		this.def += 2;
		this.hp = this.maxHp;
		this.mp = this.maxMp;
		this.nextExp = this.level * 100;
		System.out.println("LEVEL UP !!");
	}
}
