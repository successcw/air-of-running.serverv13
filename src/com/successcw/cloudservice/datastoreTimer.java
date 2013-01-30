package com.successcw.cloudservice;

import java.util.TimerTask;

public class datastoreTimer extends TimerTask {
	private static boolean isRunning = true;

	@Override
	public void run() {
		if (isRunning) {
			new Thread(new datastoreService()).start();
		}
	}
}
