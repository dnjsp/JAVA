package z_homework;

public class Digitalclock {

	public static void main(String[] args) {
		System.out.println("24시간 및 일수를 표시하는 디지털 시계를 만들자. (최초 [0일 00:00:00] 으로 설정)");
		System.out.println();
		System.out.println("1. 123456초가 지난 후 시계를 표시하라.");
		System.out.println("2. 위 1. 결과에서 654321초가 지난 후 시계를 표시하라.");
		System.out.println("3. 위 2. 결과에서 234567초 전 시계를 표시하라.");
		System.out.println();

		int d = 0, h = 0, m = 0, s = 0;

		System.out.print("현재 시간 : ");
		System.out.println(d + "일 0" + h + ":0" + m + ":0" + s);

		System.out.println();

		System.out.println("(123456초 이후)");

		int t = 123456;

		s = t % 60;
		t /= 60;
		m = t % 60;
		t /= 60;
		h = t % 24;
		t /= 24;
		d = t;

		System.out.print(d + "일 ");

		if (h < 10) {
			System.out.print("0" + h);
		} else {
			System.out.print(h);
		}

		System.out.print(":");

		if (m < 10) {
			System.out.print("0" + m);
		} else {
			System.out.print(m);
		}

		System.out.print(":");

		if (s < 10) {
			System.out.print("0" + s);
		} else {
			System.out.println(s);
		}

		System.out.println();

		System.out.println("(654321초 이후)");

		t = 654321;

		s += t % 60;
		if (s > 59) {
			m += s / 60;
			s %= 60;
		}

		t /= 60;
		m += t % 60;
		if (m > 59) {
			h += m / 60;
			m %= 60;
		}

		t /= 60;
		h += t % 24;
		if (h > 23) {
			d += h / 24;
			h %= 24;
		}

		t /= 24;
		d += t;

		System.out.println(d + "일 " + h + ":" + m + ":" + s);

		System.out.println();

		System.out.println("(234567초 이전)");

		t = 234567;

		s -= t % 60;
		if (s < 0) {
			m--;
			s += 60;
		}
		t /= 60;
		m -= t % 60;
		if (m < 0) {
			h--;
			m += 60;
		}
		t /= 60;
		h -= t % 24;
		if (h < 0) {
			d--;
			h += 24;
		}
		t /= 24;
		d -= t;

		System.out.println(d + "일 " + h + ":" + m + ":" + s);
		
		System.out.println();

		System.out.println("(234567초 이전)");

		t = 234567;
		int cur_t = (d * 24 * 60 * 60) + (h * 60 * 60) + (m * 60) + s;
		cur_t -= t;

		s = cur_t % 60;
		cur_t /= 60;
		m = cur_t % 60;
		cur_t /= 60;
		h = cur_t % 24;
		cur_t /= 24;
		d = cur_t;

		System.out.println(d + "일 " + h + ":" + m + ":" + s);
	}

}
