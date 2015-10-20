package cn.zach.thread;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		SuchThread wow = new SuchThread("much-name");
		wow.run();
		wow.sleep(1000);
		wow.setName("just another thread name");
		wow.run();
	}
}
