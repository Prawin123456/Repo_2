package com_tutorial_ninja;

import java.util.Date;

public class Utility {
	
public static String generateEmailWithTimeStamp() {
		
		Date date=new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "prawin.123"+timeStamp+"@gmail.com";

}
}