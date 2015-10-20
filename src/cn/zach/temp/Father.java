package cn.zach.temp;

//tricky extends interview question
public class Father {

	public void print(){
		test('a');
	}
	public void test(int a){
		System.out.println("2 Father test(int)");
	}
}
class Son extends Father{
	public void test(char a){
		System.out.println("3 Son test(char)");
	}
	
	public void test(int a){
		System.out.println("4 Son test(int)");
	}
	
	public static void main(String[] args) {
		new Son().print();
	}

}
