package cn.zach.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest implements Runnable{
	private String jobName = "";
	
	public ScheduledExecutorTest(String jobName) {
		super();
		this.jobName = jobName;
	}

	@Override
	public void run() {
		System.out.println("execute " + jobName);
	}
	
	public static void main(String[] args){
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		
		//scheduleAtFiexedRateÿ��ִ��ʱ��Ϊ��һ������ʼ�����һ��ʱ����
		//��ÿ��ִ��ʱ��ΪinitialDelay, initialDelay+period, initialDelay+2*period, ��
		long initialDelay1 = 1;
		long period1 = 1;
		service.scheduleAtFixedRate(new ScheduledExecutorTest("job1"), initialDelay1, period1, TimeUnit.SECONDS);
		
		//scheduledWithFixedDelayÿ��ִ��ʱ��Ϊ��һ����������������һ��ʱ����
		//��ÿ��ִ��ʱ��ΪinitialDelay, initialDelay+executeTime+delay, initialDelay+2*executeTime+2*delay
		long initialDelay2 = 1;
		long delay2 = 1;
		service.scheduleWithFixedDelay(new ScheduledExecutorTest("job2"), initialDelay2, delay2, TimeUnit.SECONDS);
		
		//ScheduleAtFixedRate �ǻ��ڹ̶�ʱ��������������ȣ�ScheduleWithFixedDelay ȡ����ÿ������ִ�е�ʱ�䳤�̣��ǻ��ڲ��̶�ʱ��������������ȡ�
	}

}
