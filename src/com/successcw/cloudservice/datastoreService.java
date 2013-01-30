package com.successcw.cloudservice;

import java.util.Calendar;
import java.util.Date;

import com.successcw.mysql.mysqlService;

public class datastoreService implements Runnable {


	public datastoreService() {
		//super();
	}

	public void run() {
		Calendar rightNow = Calendar.getInstance();
		Date time = rightNow.getTime();
		//System.out.println(time.toString());

		airofrunning temp = new airofrunning();
		try {
			//System.out.println("update database");
			temp.updateDatabase();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		//System.out.println("put data to database：");
	}
}

