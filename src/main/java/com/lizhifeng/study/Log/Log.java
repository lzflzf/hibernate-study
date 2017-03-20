package com.lizhifeng.study.Log;

import org.apache.log4j.*;

public class Log {
	
	private static Logger logger = Logger.getLogger(Log.class);
	
	public static void log(String error)
	{
		logger.error(error);
	}	
}
