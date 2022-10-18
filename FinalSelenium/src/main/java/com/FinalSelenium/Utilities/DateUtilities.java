package com.FinalSelenium.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilities 
{
		
		public static String getCurrentDate() 
		{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String formattedDate = sdf.format(date);
		return formattedDate;
		}
	}


