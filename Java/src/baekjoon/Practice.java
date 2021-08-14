package baekjoon;


//class Foo {
//	private int x;
//	public Foo(int x) {this.x = x;}
//	public void setX(int x) {this.x = x;}
//	public int getX() {return x;}
//}
//
//public class Practice {
//	static Foo fooBar(Foo foo)
//	{
//		foo = new Foo(100);
//		return foo;
//	}
//	
//	public static void main(String[] args) {
//		Foo foo = new Foo(300);
//		System.out.print(foo.getX() + "-");
//		Foo fooFoo = fooBar(foo);
//		System.out.print(foo.getX() + "-");
//		System.out.print(fooFoo.getX() + "-");
//		
//		foo = fooBar(fooFoo);
//		System.out.print(foo.getX() + "-");
//		System.out.print(fooFoo.getX());
//		
//	}
//}

class Parent {
	public Parent() {
		System.out.println("A");
	}
}
class Child extends Parent {
	public Child() {
		System.out.println("B");
	}
}

public class Practice {
	public static void main(String[] args) {
		Parent p;
		System.out.println("뭐");
		p = new Child();
		System.out.println("임마");
		System.out.println("C");
		System.out.println("stopError");
	}
}