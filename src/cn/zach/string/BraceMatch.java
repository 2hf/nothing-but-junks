package cn.zach.string;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BraceMatch {
	/*
	*�������ļ��д�С�����Ƿ�ƥ��
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
			//����ļ��Ƿ����
			if(!file.exists()) {
				System.out.println("�ļ�������");
				System.exit(1);
			}
			FileInputStream fis = null;
			//ģ��һ��ջ
			byte[] stack = new byte[1024];
			int length = 0;
			//ģ���ջ��ָ��
			int index = 0;
			int count=0;
			byte[] bs = new byte[1024];
			try {
				fis = new FileInputStream(file);
				//���ļ�δ�ﵽ��βʱ��ѭ������
				while((length=fis.read(bs)) != -1) {
					count++;
					for(int i=0; i<length; i++) {
						switch(bs[i]) {
						//�����������{�����ջ 
						//{=123
						case 123 :
							stack[index] = bs[i];
							index ++;
							continue;
						//�����д�������},ջָ�������ƶ�һ�񣬼��ջ��Ԫ���Ƿ�Ϊ�������{��
					    //���ǣ���ջ������������ ;�����ǣ�������Ų�ƥ�䣬�׳��쳣 
						//}=125
						case 125 :
							if(stack[index-1] != 123) {
								System.out.println(count);
								System.out.println("index:" + index);
								throw new Exception("�����Ų�ƥ�䣡");
							}else {
								stack[index-1] = 0;
								index --;
								continue;
							}
							
							//������������[�����ջ 
							//[=91
							case 91 :
								stack[index] = bs[i];
								index ++;
								continue;
							//��������������],ջָ�������ƶ�һ�񣬼��ջ��Ԫ���Ƿ�Ϊ��������[��
						    //���ǣ���ջ������������ ;�����ǣ��������Ų�ƥ�䣬�׳��쳣 
							//]=93
							case 93 :
								if(stack[index-1] != 91) {
									System.out.println(count);
									System.out.println("index:" + index);
									throw new Exception("�����Ų�ƥ�䣡");
								}else {
									stack[index-1] = 0;
									index --;
									continue;
								}
							
						//������С����{�����ջ (=40
						case 40 :
							stack[index] = bs[i];
							index ++;
							continue;
						//������С������},ջָ�������ƶ�һ�񣬼��ջ��Ԫ���Ƿ�Ϊ��С����(��
					    //���ǣ���ջ������������ ;�����ǣ������Ų�ƥ�䣬�׳��쳣  
					    //  )=41
						case 41 :
							if(stack[index-1] != 40) {
								System.out.println(count);
								System.out.println("index:" + index);
								throw new Exception("С���Ų�ƥ�䣡");
							}else {
								stack[index-1] = 0;
								index --;
								continue;
							}
						}
					}
				}
				
				//�ļ�������ɣ���ջ��Ϊ�գ������Ų�ƥ��
				if(index != 0) {
					System.out.println(count);
					System.out.println("index:" + index);
					throw new Exception("���Ų�ƥ�䣡");
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
