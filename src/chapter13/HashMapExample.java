package chapter13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import java.util.Set;

public class HashMapExample {
	public static void main(String[] args) {
		// Map 컬렉션 생성
		HashMap<String,Integer> map = new HashMap<>();
		
		// 객체 저장
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95); // 키 값이 동일하면 제일 마지막에 저장한 값으로 대체됨
		System.out.println("총 Entry 수: " + map.size());
		
		// 객체 찾기
		System.out.println("홍길동: " + map.get("홍길동")); // 이름(키)로 점수(값)를 검색
		System.out.println();
		
		//객체를 하나씩 처리
		
		// 1. entrySet을 이용
		Set<Entry<String,Integer>> set = map.entrySet();
		for (Entry<String, Integer> entry : set) {
			entry.getKey();
			entry.getValue();
		}
		
		// 2. keySet을 이용하는 방법
		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			System.out.println(string);
		}
		
		// 객체 삭제
		System.out.println(); // 삭제할 땐 키값으로 삭제해야 됨
		map.remove("동장군");
		
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
}
