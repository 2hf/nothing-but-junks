package cn.zach.string;

public class replaceString {
	private static String replaceServerAddrByRealAddr(String serv, String addr) {
		//serv  = http://10.2.12.76:9999/param/zcgl
		int endIndex = serv.substring(7).indexOf(":");
		String tails = serv.substring(7+endIndex);
		return "http://".concat(addr).concat(tails);
	}
	public static void main(String[] args){
		String serv = "http://10.2.12.76:9999/param/zcgl/";
		String addr = "test";
		System.out.println(replaceServerAddrByRealAddr(serv, addr));
	}

}
