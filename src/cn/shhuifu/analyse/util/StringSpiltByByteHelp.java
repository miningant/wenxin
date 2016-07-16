package cn.shhuifu.analyse.util;

public class StringSpiltByByteHelp {
	public static String subString(String str, int len) {
		byte[] b = str.getBytes();

		if (len == 1) {// 当只取1位时
			if (b[0] < 0)
				return new String(b, 0, 2);
			else
				return new String(b, 0, len);
		} else {
			int count = 0;
			for(int i=len-1;i>=0;i--){
				if(b[i] < 0){
					count++;
				}else{
					break;
				}
			}
			if(count%2!=0){
				return new String(b, 0, len-1);
			}
		}
		return new String(b, 0, len);
	}
}
