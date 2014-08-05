package singleton;

public class Singleton {
	/*유일한 인스턴스 저장 객체 선언*/
	private static volatile Singleton instance;
	
	private Singleton() {

	}

	/* 외부에서 사용할 함수 선언 클래스를 생성할떄 쓴다 */
	public static Singleton getInstance() {
		//DCL : double-checking locking
		if (instance == null) { // 있는지 체크 없으면 , 객체가 있다면.. synchronized코스트를 줄이기 위해서 
			synchronized (Singleton.class) { // 동기화 문제 해
				if (instance == null) { // 다시한번채크
					instance = new Singleton(); // 생성한뒤
				}
			}
		}
		return instance;// 객체를 넘긴다.
	}

	public void doSomething() {
		System.out.println("do something");
	}
}
