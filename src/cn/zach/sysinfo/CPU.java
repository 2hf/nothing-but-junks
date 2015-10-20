package cn.zach.sysinfo;

import java.util.ArrayList;
import java.util.List;

public class CPU {
	public static void main(String[] args){
		int DEFAULT_THREADS = Runtime.getRuntime().availableProcessors();
		System.out.println("可用核心数："+DEFAULT_THREADS);
		
		//验证toArray
		List<String> arrList = new ArrayList<String>();
		String[] array = {"a"};
		for(int i=0;i<array.length;i++){
			arrList.add(array[i]);
		}
		String[] temp = arrList.toArray(new String[0]);
		for(int i=0;i<temp.length;i++){
			System.out.println(temp[i]);
		}
		System.out.println(array.length);
		
		//Is null an instance of Object? The answer is No!
		if(null instanceof Object){
			System.out.println("null is instanceof Object");
		}else{
			System.out.println("null is not instanceof Object");
		}
	}
}
