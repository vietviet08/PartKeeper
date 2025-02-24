package controller;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatToVND {
	public static String vnd(double soTien) {
		@SuppressWarnings("deprecation")
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		return currencyVN.format(soTien);
	}
}
