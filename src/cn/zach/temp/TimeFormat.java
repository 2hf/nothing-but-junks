package cn.zach.temp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {
	public static void main(String[] args){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long time1 = 0,time2 = 0;
		try {
			time1 = df.parse("2015-08-05 09:50:14").getTime();
			time2 = df.parse("2015-08-05 12:50:10").getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long diff = (time2-time1)/1000;
		long hour = diff/(60*60);
		System.out.println(hour);
		System.out.println("helloword".equals(null));
	}
}
