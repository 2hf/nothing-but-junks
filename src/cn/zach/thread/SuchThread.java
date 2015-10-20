package cn.zach.thread;

public class SuchThread extends Thread{
	public SuchThread(String name) {
		super(name);
	}

	public void run(){
		System.out.println("Hi Mom! " + getName());
	}
}
