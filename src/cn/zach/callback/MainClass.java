package cn.zach.callback;

public class MainClass {
	public static void main(String[] args){
		System.out.println("this is main method");
		Caller caller = new Caller();
		caller.call(new MyInterface() {
			@Override
			public void onComplete() {
				System.out.println("this is onComplete method");
			}
		});
	}
	
}
