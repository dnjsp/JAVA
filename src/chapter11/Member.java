package chapter11;

import java.util.Objects;

public class Member {
	public String name;
	
	public Member(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Member))
			return false;
		Member other = (Member) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Member [name=" + name + "]";
	} // 재정의를 해주지 않으면 주소값이 나오기때문에 재정의 해주는 게 좋음
}
