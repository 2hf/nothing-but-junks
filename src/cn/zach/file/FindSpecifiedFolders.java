package cn.zach.file;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.print.attribute.HashAttributeSet;

public class FindSpecifiedFolders {
	private static String srcPath = "E:/srcFiles";
	private String targetPath = "E:/targetFiles";
	private static List<String> itemNameList = new ArrayList<String>();
	private static List<String> itemTypeList = new ArrayList<String>();
	
//	public static void main(String[] args){
//		File dir = new File(srcPath);
//		File files[] = dir.listFiles();
//		for(int i=0; i< files.length; i++){
//			if(files[i].isDirectory()){
//				itemNameList.add(files[i].getName());
//				continue;
////				getItemInfoByFileName(files[i]);
//				
//			}
//		}
//		System.out.println("item folders >>>");
//		for(String name: itemNameList){
//			System.out.println(name);
//			
//			File detailDir = new File(srcPath+"/"+name);
//			File[] detailFiles = detailDir.listFiles();
//			for(int i=0; i<detailFiles.length;i++){
//				itemTypeList.add(detailFiles[i].getName());
//				System.out.println("---"+detailFiles[i].getName());
//			}
//		}
//	}
//
//	private static void getItemInfoByFileName(File file) {
//		String itemName = file.getName();
//		String absolutePath = file.getAbsolutePath();
//		String parentPath = file.getParent();
//		File tmp = file.getAbsoluteFile();
//		System.out.println(absolutePath+"\n"+parentPath+"\n"+itemName);
//		System.out.println(tmp.getAbsolutePath()+"\n"+tmp.getName());
//	}
	private static ArrayList<String> filelist = new ArrayList<String>(); 
	private static List<String> fileNameList = new ArrayList<String>();
	private static Map<String,String> map = new HashMap<String, String>();
    
    public static void main(String[] args) {
        String src = "E:\\srcFiles\\";
        if(!src.substring(src.length()-1).equals("\\")){
        	src.concat("\\");
        }
        long a = System.currentTimeMillis();
        refreshFileList(src);
        System.out.println(System.currentTimeMillis() - a);
        
        for(String file: filelist){
        	String substr = file.substring(src.length());
        	System.out.println(substr);
        	
        	
        	String[] info = substr.split("\\\\");
        	map.put("xmbh", info[0]);
        	map.put("filetype", info[1]);
        	map.put("filename", info[2]);
        	
        	for(Entry e:map.entrySet()){
        		System.out.println(e.getKey()+"<->"+e.getValue());
        	}
//        	for(int i=0;i<info.length; i++){
//        		System.out.println("--"+info[i]);
//        	}
        	
        	
//        	//分离出项目编号、项目类型
//        	
//        	String xmbh = substr.substring(1, substr.indexOf("\\", 2));
//        	System.out.println("--"+xmbh);
//        	map.put("xmbh", xmbh);
//        	
//        	String fileTypeSubstr = substr.substring(xmbh.length()+2);
//        	String fileType = fileTypeSubstr.substring(0, fileTypeSubstr.indexOf("\\",1));
////        	System.out.println("---"+fileTypeSubstr);
//        	System.out.println("-------"+fileType);
//        	
//        	String fileName = substr.substring(substr.lastIndexOf("\\")+1);
//        	System.out.println("------------"+fileName);
        }
        
        for(String name: fileNameList){
        	System.out.println(">>"+name);
        }
    }
    public static void refreshFileList(String strPath) { 
        File dir = new File(strPath); 
        File[] files = dir.listFiles(); 
        
        if (files == null) 
            return; 
        for (int i = 0; i < files.length; i++) { 
            if (files[i].isDirectory()) { 
                refreshFileList(files[i].getAbsolutePath()); 
            } else { 
                String strFileName = files[i].getAbsolutePath();
                System.out.println("---"+strFileName);
                filelist.add(files[i].getAbsolutePath());   
                fileNameList.add(files[i].getName());
            } 
        } 
    }
}
