package cn.zach.callback;

public class Caller {
	public void call(MyInterface intf){
		System.out.println("this is call method");
		intf.onComplete();
	}
}
