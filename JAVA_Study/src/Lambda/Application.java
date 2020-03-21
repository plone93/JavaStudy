package Lambda;

/*
 * 람다익스프레스는
 * java8, jdk1.8이상에서 작동한다
 * 람다는 functional interface만 가능하다
 * functional interface : 인터페이스에 메서드가 1개만 있는것
 * */

interface Say{
	int something(int a, String b); //functional interface
}

class Person {
	public void greeting(Say line) {
		int num = line.something(3, "Hello");
		System.out.println("Number is " + num);
	}
}
public class Application {

	public static void main(String[] args) {
		Person rin = new Person();
		rin.greeting(new Say() {
			@Override
			public int something(int a, String b) {
				System.out.println("My name is Rin");
				System.out.println("Nice to meet you");
				System.out.println("parameter value is " + a+", "+b);
				return 8;
			}
		});
		
		/*
		 * 같은 클래스내 오버로딩이 되서 메서드명은 같지만 인자특성(int, String)이 다른경우 인자특성을 명시해줘야함
		 * 오버로딩이란 메서드명은 같지만 받는 인자값이나 수가 다른경우를 말한다
		 * (a,b) -> {}
		 * (int a, String b) -> {}
		 * 
		 * 인자값이 1개 일경우 괄호를 생략할 수 있다
		 * (a) ->{}
		 * a -> {}
		 * */
		System.out.println("----------------------");
		rin.greeting((int a, String b) -> { // (a, b) -> {}
			System.out.println("This is Rin!");
			System.out.println("Thank you Lambda");
			System.out.println("parameter value is " + a+", "+b);
			return 7;
		});
	}

}
