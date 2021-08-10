package z_homework.game;

public class Item {
	String name;
	int maxHp, maxMp, att, def;
	
	Item(String name, int maxHp, int maxMp, int att, int def){
		this.name = name;
		this.maxHp = maxHp;
		this.maxMp = maxMp;
		this.att = att;
		this.def = def;
	}
	String itemInfo() {
		String info = name + " : ";
		if (0 < maxHp) info += "체력 + " + maxHp;
		if (0 < maxMp) info += "마나 + " + maxMp;
		if (0 < att) info += "공격 + " + att;
		if (0 < def) info += "방어 + " + def;
		return info;
	}

}
