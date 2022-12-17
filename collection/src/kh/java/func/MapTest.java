package kh.java.func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MapTest {

	public void mapTest1() {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("hi"); // 리스트 제일 뒤에 "hi"값 추가(0)
		list.add("hello"); // 리스트 제일 뒤에 "hello"값 추가(1)
		list.add("안녕"); // ~... (2)
		
		System.out.println(list.get(1));
		
		
		
		//key타입으로 정수, value타입으로 String을 준 거임
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "hi");
		map.put(1, "hello");
		map.put(2, "bye");
		map.put(1, "중복ㅋ"); //<--만약 이렇게 key가 겹치는 경우에는 나중에 입력된 데이터로 덮어쓰기 된다.
		
		System.out.println(map.get(1)); //<--지금은 마치 인덱스 번호같아 보이지만... .get()에 key값을 넣어주면 value을 되돌려줍니당.
		
	}//mapTest1
	
	
	public void mapTest2() {
		
		// "내가 저장하고 싶은 것"을 value로 잡아야 함, key는 값을 다루기 위한 용도일 뿐임.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("one", "하나");
		map.put("two", "둘~");
		map.put("three", "셋!");
		System.out.println(map.get("two"));
		
		System.out.println(map); //<--얘도 toString이 구현되어 있어서 이렇게 출력가능하다고 한다.(그치만 딱히 공부용 외에 쓸일은...?)
		
		map.put("two", "변경~");
		System.out.println(map);
		
		map.put("test", "하나");
		System.out.println(map);
		System.out.println(map.get("three"));
		System.out.println(map.get("aaa")); //null이 리턴됩니다
		
		
		System.out.println(map.containsKey("test")); //<--해당 HashMap에 매개변수로 전달한 key가 있는지 리턴해줌(T/F)
		System.out.println(map.containsKey("aaa"));
		
		System.out.println("============================");
		//map에 있는 모든 데이터를 사용하고 싶을 경우 ...(모든 key가 필요한 경우)
		Set<String> set = map.keySet(); //<-- map이 가지고 있는 모든 key들을 Set자료형으로 가져옴
		for(String key :set) {
			System.out.println(key+" : "+map.get(key));
		}
		
		map.remove("test"); //<--해당 key값을 가지고 있는 데이터를 삭제
		for(String key :set) {
			System.out.println(key+" : "+map.get(key));
		}
		
		
		//map의 데이터를 수정하려면 : .put을 이용해서 덮어쓰기한다. 만약 key도 변경하고 싶다면 .remove-->.put(삭제하고 새로넣기) 한다. 어차피 map은 순서가 중요한 애가 아니다!
		map.put("one", "일^^");
		for(String key :set) {
			System.out.println(key+" : "+map.get(key));
		}
		
		map.remove("one");
		map.put("일^^","one");
		System.out.println(map);
		
	}//mapTest2
	
	
	
}//MapTest
