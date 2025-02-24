package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {

	public static Date ChangeFrom(Date date) throws ParseException {
		SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy 00:00:00");
		String dateText = fm.format(date);
		SimpleDateFormat par = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date result = par.parse(dateText);
		return result;
	}

	public static Date ChangeTo(Date date) throws ParseException {
		SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy 23:59:59");
		String dateText = fm.format(date);
		SimpleDateFormat par = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date result = par.parse(dateText);
		return result;
	}
}
