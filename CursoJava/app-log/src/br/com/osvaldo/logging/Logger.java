package br.com.osvaldo.logging;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	
	public static void info(String msg) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		System.out.println("[INFO] " + sdf.format(new Date())+ " " + msg);
				
	}

}
