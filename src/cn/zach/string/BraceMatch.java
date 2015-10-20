package cn.zach.string;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BraceMatch {
	/*
	*检测给定文件中大小括号是否匹配
	*/

		public static void main(String[] args) {
			File file = new File("D:\\tmp.txt");
			try {
				BraceMatch.checkBracesByStack(file);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void checkBracesByStack(File file) throws Exception {
			//检查文件是否存在
			if(!file.exists()) {
				System.out.println("文件不存在");
				System.exit(1);
			}
			FileInputStream fis = null;
			//模拟一个栈
			byte[] stack = new byte[1024];
			int length = 0;
			//模拟的栈的指针
			int index = 0;
			int count=0;
			byte[] bs = new byte[1024];
			try {
				fis = new FileInputStream(file);
				//当文件未达到结尾时，循环遍历
				while((length=fis.read(bs)) != -1) {
					count++;
					for(int i=0; i<length; i++) {
						switch(bs[i]) {
						//若是左大括号{，则进栈 
						//{=123
						case 123 :
							stack[index] = bs[i];
							index ++;
							continue;
						//若是有大右括号},栈指针向下移动一格，检查栈顶元素是否为左大括号{。
					    //若是，出栈，并继续遍历 ;若不是，则大括号不匹配，抛出异常 
						//}=125
						case 125 :
							if(stack[index-1] != 123) {
								System.out.println(count);
								System.out.println("index:" + index);
								throw new Exception("大括号不匹配！");
							}else {
								stack[index-1] = 0;
								index --;
								continue;
							}
							
							//若是左中括号[，则进栈 
							//[=91
							case 91 :
								stack[index] = bs[i];
								index ++;
								continue;
							//若是有中右括号],栈指针向下移动一格，检查栈顶元素是否为左中括号[。
						    //若是，出栈，并继续遍历 ;若不是，则中括号不匹配，抛出异常 
							//]=93
							case 93 :
								if(stack[index-1] != 91) {
									System.out.println(count);
									System.out.println("index:" + index);
									throw new Exception("中括号不匹配！");
								}else {
									stack[index-1] = 0;
									index --;
									continue;
								}
							
						//若是左小括号{，则进栈 (=40
						case 40 :
							stack[index] = bs[i];
							index ++;
							continue;
						//若是有小右括号},栈指针向下移动一格，检查栈顶元素是否为左小括号(。
					    //若是，出栈，并继续遍历 ;若不是，则括号不匹配，抛出异常  
					    //  )=41
						case 41 :
							if(stack[index-1] != 40) {
								System.out.println(count);
								System.out.println("index:" + index);
								throw new Exception("小括号不匹配！");
							}else {
								stack[index-1] = 0;
								index --;
								continue;
							}
						}
					}
				}
				
				//文件遍历完成，若栈不为空，则括号不匹配
				if(index != 0) {
					System.out.println(count);
					System.out.println("index:" + index);
					throw new Exception("括号不匹配！");
				}
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(fis != null) {
					fis.close();
				}
			}
		}
		
}
