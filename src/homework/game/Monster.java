package z_homework.game;

public class Monster {
	String name;
	int maxHp, maxMp, hp, mp, att, def, exp;
	Item[] items;
	
	Monster(String name, int hp, int mp, int att, int def, int exp, Item[] items) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.maxHp = hp;
		this.maxMp = mp;
		this.att = att;
		this.def = def;
		this.exp = exp;
		this.items = items;
	}
	
	void attack(Character c) {
		int damage = att - c.def;
		damage = damage <= 0 ? 1 :  damage;
		c.hp = c.hp < damage ? c.hp - c.hp : c.hp - damage;
		System.out.println(name + "이(가) 공격으로 " + c.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
		System.out.println(c.name + "의 남은 HP : " + c.hp);
	}
	
	Item itemDrop() {
		return items[(int)(Math.random() * items.length)];
		
	}
}
