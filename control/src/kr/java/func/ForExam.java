package kr.java.func;

public class ForExam {

	// 중첩 for문을 이용한 구구단 전체 출력
	public void gugudan1() {
		
		for(int i=2;i<=9;i++) {
			System.out.println(i+"단");
			for(int j=0;j<9;j++) {
				System.out.printf("%d X %d = %d | ",i,(j+1),2*(j+1));
			}
			System.out.println();
		}
		
	}
	
	
	public void gugudan2() {
		
		for(int j=1;j<=9;j++) {
			for(int i=2;i<=9;i++) { 
				System.out.printf("%d * %d = %d | ",i,j,i*j);
			}
			System.out.println();
		}// <-- 닫는 괄호를 만나면 다시 증감식으로 돌아간다!!!!!!!
	}
	
	
	public void star1() {
		System.out.println("Q1.");
		
		for(int i=0;i<5;i++) {
			System.out.print("*");
		}
	}
	
	
	public void star2() {
		System.out.println("\nQ2.");
		
		for(int i=0;i<5;i++) {
			System.out.print("*");
			System.out.println();
		}
	}
	
	public void star3() {
		System.out.println("\nQ3.");
		
		for(int j=0;j<5;j++) {
			for(int i=0;i<5;i++) {
				System.out.print("*");
			}
			System.out.println();
		}	
	}
	
	public void star4() {
		System.out.println("\nQ4.");
		
		for(int i=1;i<=5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	public void star5() {
		System.out.println("\nQ5.");
		
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	
	public void star6() {
		System.out.println("\nQ6.");

	/*	for(int i=0;i<5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print(j+i);
			}
			System.out.println();
		}	
	*/
	
		for(int j=1;j<=5;j++) { 
			for(int i=0;i<5;i++) { 
				System.out.print(j+i); 
			}
			System.out.println();
		}
	}
	
	public void star7() {
		System.out.println("\nQ7.");

		for(int j=1;j<=5;j++) {
			for(int i=6;i<=10;i++) {
				System.out.print(i-j);
			}
			System.out.println();
		}
	}
	
	
	public void star8() {
		System.out.println("\nQ8.");
		
	/*	for(int i=4;i>=0;i--) {
            for(int j=i;j<5;j++) {
               System.out.print("*");
         }
         System.out.println();
      }
	*/
		
	/*	for(int j=1;j<=5;j++) {
			for(int i=1;i<=j;i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	*/	
	}
	
	public void star9() {
		System.out.println("\nQ9.");
		
		for(int j=5;j>=1;j--) {
			for(int i=1;i<=j;i++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
	
	public void star10() {
		System.out.println("\nQ10.");

	

		
	}
	
	
}
