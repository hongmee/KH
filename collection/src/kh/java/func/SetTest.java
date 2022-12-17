package kh.java.func;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SetTest {

	public void setTest1() {
		
		//set은 중복체크하는데 용이하지만, 인덱스를 통해서 관리하는게 아니기 때문에 꺼내서 사용하는게 불편하다.
		//set은 그래서 아예 .get()이라는 메소드도 없다. 
		HashSet<Integer> set = new HashSet<Integer>();
		System.out.println(set.size());
		
		// .add() : 매개변수로 전달한 값을 일단 추가 시도하고, 추가 성공/실패 여부를 boolean값으로 리턴해줌.
		boolean result1 = set.add(100); //return값이 boolean ==> 중복된 데이터를 못 넣음. add를 한다고 반드시 값이 들어간다는 보장이 없음. 들어간게 성공이면 T리턴, 아니면 F리턴.
		System.out.println(result1);
		boolean result2 = set.add(200);
		System.out.println(result2);
		boolean result3 = set.add(100);
		System.out.println(result3);
		System.out.println(set.size());
		
		set.add(30);
		set.add(10);
		set.add(40);
		System.out.println(set);
		
		set.remove(100); //<--인덱스 번호가 아니라 지우고싶은 값을 적어준다!!!!!
		System.out.println(set);
		
		//set은 데이터를 인덱스번호로 관리하지 않습니다, 하나씩 꺼내서 쓰는방법은.....
		//(1)foreach를 사용하기 : 내부에 있는 데이터에 한번씩 다 접근해줌쓰
		for(Integer i : set) {
			System.out.print(i+"♡ ");
		}
		System.out.println("\n========================");
		//(2)ArrayList를 활용하기 : set에있는 내용물을 ArrayList로 옮겨줄수 있다
		ArrayList<Integer> list = new ArrayList<Integer>(set); //<--set이 Integer타입이니까 ArrayList도 Integer타입이어야 함
		System.out.println(list.get(2));
		System.out.println("==========================");
		//(3)반복자(iterrator) : 가장 어려운 방법.. 걍 이런게 있다 알아만 두고 foreach쓰는게 맘편하다고 함
		Iterator<Integer> iter = set.iterator(); //StringTokenizer랑 비슷한 애임. set의 데이터를 마치 토큰처럼 가지고 있게 됨. 사실상 foreach문의 동작원리
		while(iter.hasNext()) { //<--hasNext() : 값이 남아있으면 T, 아니면 F
			System.out.println(iter.next()); // <--.next() : 값 한개를 꺼내온다
		}
		
	}//setTest1
	
	
	public void lotto() {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> lotto = new HashSet<Integer>();
		while(lotto.size()<6) {
			System.out.print("숫자를 입력하세요(1~45) : ");
			int num = sc.nextInt();
			if(1<=num && num<=45) {
				boolean result = lotto.add(num);
				if(result == false) {
					System.out.println("중복된 숫자입니다.");
				}
				
			}else {
				System.out.println("1~45 범위의 숫자를 입력하시라구요");
			}
		}//입력 받는 while문
		
		ArrayList<Integer> userNum = new ArrayList<Integer>(lotto);
		Collections.sort(userNum);
		System.out.println(userNum);
	}//lotto
	
	
	
}//SetTest
