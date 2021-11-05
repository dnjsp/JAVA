package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
문제) 이름, 주소, 전화번호를 멤버로 갖는 PHONE클래스를 만들고
 	   MAP을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 	   (MAP의 구조는 KEY값으로 '이름'을 사용하고 VALUE값으로는 'PHONE클래스의 인스턴스'로 한다.)
	   
	   HashMap<String, Phone> 변수명;  	   

 	   아래 메뉴 및 예시에 맞는 기능을 구현하시오.
 	   => 삭제, 검색은 '이름'을 입력받아서 처리한다.
 	   
 	   - 추가 조건)
 	   1) '6. 전화번호 저장' 메뉴를 추가하고 해당 기능을 구현한다.
 	      (저장파일명은 'phoneData.dat'로 한다.)
 	   2) 프로그램을 시작할 때 저장된 파일이 있으면 그 데이터를 읽어와 Map에 셋팅한다.
 	   3) 프로그램을 종료할 때 Map의 데이터가 변경되거나 추가 또는 삭제되었으면 저장 후 종료되도록 한다.
 	   
실행 예시)
	   1. 전화번호 등록
	   2. 전화번호 수정
	   3. 전화번호 삭제
	   4. 전화번호 검색
	   5. 전화번호 전체 출력
	   6. 전화번호 저장
	   0. 프로그램 종료
----------------------------------------------------
번호입력 >> 1
0
새롭게 등록할 전화번호 정보를 입력하세요.
이 름 >> 홍길동
전화번호 >> 010-1234-5678
주 소 >> 대전시 중구 대흥동

'홍길동' 전화번호 등록 완료!!

	   1. 전화번호 등록
	   2. 전화번호 수정
	   3. 전화번호 삭제
	   4. 전화번호 검색
	   5. 전화번호 전체 출력
	   6. 전화번호 저장
	   0. 프로그램 종료
----------------------------------------------------
번호입력 >> 1

새롭게 등록할 전화번호 정보를 입력하세요.
이 름 >> 홍길동

'홍길동'은 이미 등록된 사람입니다.

	   1. 전화번호 등록
	   2. 전화번호 수정
	   3. 전화번호 삭제
	   4. 전화번호 검색
	   5. 전화번호 전체 출력
	   6. 전화번호 저장
	   0. 프로그램 종료
----------------------------------------------------
번호입력 >> 5

----------------------------------------------------
번호	이름	   전화번호	             주소
----------------------------------------------------
1	   홍길동	 010-1234-5678	  대전시 중구 대흥동
----------------------------------------------------
출력 완료

	   1. 전화번호 등록
	   2. 전화번호 수정
	   3. 전화번호 삭제
	   4. 전화번호 검색
	   5. 전화번호 전체 출력
	   6. 전화번호 저장
	   0. 프로그램 종료
----------------------------------------------------
번호입력 >> 0

프로그램을 종료합니다.

*/	

import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

// 생성자
public class PhoneBookTest {
	Scanner scanner = new Scanner(System.in);
	HashMap<String, Phone> map = new HashMap<String, Phone>();
	private String fileName = "d:/d_other/phoneData.dat";
	
	// 데이터의 변경 여부를 나타내는 변수 선언
	// 이 변수 값이 true이면 데이터가 변경된 것으로 한다.
	private boolean dataChange;
	
	public PhoneBookTest() {
		// 저장된 파일을 읽어와서 Map에 셋팅한다.
		map = load();
		
		if (map == null) {  // 파일이 없거나 잘못되었을 때...
			map = new HashMap<String, Phone>();
		}
		scanner = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		new PhoneBookTest().start();
	}
	
	public void start() {
		while (true) {
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("6. 전화번호 저장");
			System.out.println("0. 프로그램 종료");
			System.out.println("----------------------------------------------------");
			System.out.print("번호입력 >> ");
			int input = scanner.nextInt();
			System.out.println();
			
			switch (input) {
			case 1: insert(); break;
			case 2: edit(); break;
			case 3: delete(); break;
			case 4: search(); break;
			case 5: print(); break;
			case 6: save(); break;
			case 0: 
				if (dataChange == true) {  // 데이터가 변경되었으면...
					System.out.println("변경된 데이터를 저장합니다.");
					save();
				}
				exit();
			default: 
				System.out.println("잘못 입력하였습니다.");
				System.out.println("다시 입력하세요.\n");
				break;
			}
		}
	}
	
	public void insert() {
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이 름 >> ");
		String name = scanner.next();
		if (map.containsKey(name)) {
			System.out.println("'" + name + "' 는(은) 이미 등록된 사람입니다.\n");
			return; 
		}
		System.out.print("전화번호 >> ");
		String tel = scanner.next();
		System.out.print("주 소 >> ");
		String addr = scanner.next();
		
		map.put(name, new Phone(name, addr, tel));
		System.out.println("'" + name + "' 전화번호 등록 완료!!\n");
		dataChange = true;
	}
	
	public void edit() {
		System.out.println("수정할 전화번호 정보를 입력하세요.");
		System.out.print("이 름 >> ");
		String name = scanner.next();
		if (!map.containsKey(name)) {
			System.out.println("'" + name + "' 는(은) 등록되지 않은 사람입니다.\n");
			return;
		}
		System.out.print("전화번호 >> ");
		String tel = scanner.next();
		System.out.print("주 소 >> ");
		String addr = scanner.next();
		
		map.put(name, new Phone(name, addr, tel));
		System.out.println("'" + name + "' 전화번호 수정 완료!!\n");
		dataChange = true;
	}
	
	public void delete() {
		System.out.println("삭제할 전화번호 정보를 입력하세요.");
		System.out.print("이 름 >> ");
		String name = scanner.next();
		if (!map.containsKey(name)) {
			System.out.println("'" + name + "' 는(은) 등록되지 않은 사람입니다.\n");
			return;
		}
		map.remove(name);
		System.out.println("'" + name + "' 전화번호 삭제 완료!!\n");			
		dataChange = true;
	}
	
	public void search() {
		System.out.println("검색할 전화번호 정보를 입력하세요.");
		System.out.print("이 름 >> ");
		String name = scanner.next();
		if (!map.containsKey(name)) {
			System.out.println("'" + name + "' 는(은) 등록되지 않은 사람입니다.\n");
			return;
		}
		System.out.println(map.get(name));
	}
	
	public void print() {
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		int cnt = 1;
		
		System.out.println("----------------------------------------------------");
		System.out.println("번호	이름	   전화번호	      주소");
		System.out.println("----------------------------------------------------");
		
		if (keySet.size() == 0) {
			System.out.println("     등록된 전화번호 정보가 하나도 없습니다.");
		} else {
			while (it.hasNext()) {
				String key = it.next();
				Phone value = map.get(key);
				System.out.printf(" %d   %s  %s  %s\n",cnt++,value.getName(),value.getTel(),value.getAddr());
			}
		}
		System.out.println("----------------------------------------------------");
		System.out.println("출력 완료\n");
		
//		map.forEach((key,value)->{
//		System.out.print(key + value);

	}
	
	// 전화번호 정보가 저장된 파일을 읽어오는 메서드
	@SuppressWarnings("unchecked")
	private HashMap<String, Phone> load() {
		HashMap<String, Phone> pMap = null;	 // 읽어온 데이터가 저장될 변수
		
		File file = new File(fileName);
		if (!file.exists()) {  // 저장된 파일이 없으면...
			return null;
		}
		
		ObjectInputStream ois = null;
		try {
			// 객체 입력용 스트림 객체 생성
			ois = new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream(file)
					)
				);
				pMap = (HashMap<String, Phone>) ois.readObject();
			
		} catch (IOException e) {
			return null;
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			return null;
			// e.printStackTrace();
		} finally {
			// 사용했던 스트림 객체 닫기
			if (ois != null) try { ois.close(); } catch (IOException e) {}
		}
		return pMap;
	}
	
	// 전화번호 정보를 파일로 저장하는 메서드
	private void save() {
		ObjectOutputStream oos = null;
		try {
			// 객체 출력용 스트림 객체 생성
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(fileName)
					)
				);
			
			// Map객체를 파일로 저장한다.
			oos.writeObject(map);
			
			System.out.println("저장이 완료되었습니다.\n");
			dataChange = false;
			
		} catch (IOException e) {
			System.out.println("파일 저장 실패 : " + e.getMessage() + "\n");
		} finally {
			// 사용했던 스트림 객체 닫기
			if (oos != null) try { oos.close();	} catch (IOException e) {
		}
	}
}
	
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}	
}

class Phone implements Serializable {
	private static final long serialVersionUID = -5422429127921791343L;
	
	private String name;
	private String addr;
	private String tel;
	
	public Phone(String name, String addr, String tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "이름 : " + name + ", 전화번호 : " + tel + ", 주소 : " + addr + "\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Phone other = (Phone) obj;
		return Objects.equals(addr, other.addr) && Objects.equals(name, other.name) && Objects.equals(tel, other.tel);
	}
}
