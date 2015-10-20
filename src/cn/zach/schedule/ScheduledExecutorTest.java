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
		
		//scheduleAtFiexedRate每次执行时间为上一次任务开始向后推一个时间间隔
		//即每次执行时间为initialDelay, initialDelay+period, initialDelay+2*period, …
		long initialDelay1 = 1;
		long period1 = 1;
		service.scheduleAtFixedRate(new ScheduledExecutorTest("job1"), initialDelay1, period1, TimeUnit.SECONDS);
		
		//scheduledWithFixedDelay每次执行时间为上一次任务结束后向后推一个时间间隔
		//即每次执行时间为initialDelay, initialDelay+executeTime+delay, initialDelay+2*executeTime+2*delay
		long initialDelay2 = 1;
		long delay2 = 1;
		service.scheduleWithFixedDelay(new ScheduledExecutorTest("job2"), initialDelay2, delay2, TimeUnit.SECONDS);
		
		//ScheduleAtFixedRate 是基于固定时间间隔进行任务调度，ScheduleWithFixedDelay 取决于每次任务执行的时间长短，是基于不固定时间间隔进行任务调度。
	}

}
