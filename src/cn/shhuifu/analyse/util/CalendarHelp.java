package cn.shhuifu.analyse.util;

import java.util.Calendar;
import java.util.Date;

public class CalendarHelp {
	public static boolean timeCheck(String timestamp,int interval) {
		//初始日期
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new Date());
		//要判断的日期
        Long c2 = Long.parseLong(timestamp);
        
        if(c1.getTimeInMillis()-c2 <= (60*1000*interval)){
        	return true;
        }else{
        	return false;
        }
	}

}
