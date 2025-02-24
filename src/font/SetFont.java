package font;

import java.awt.Font;
import java.io.File;

import com.itextpdf.text.pdf.BaseFont;

public class SetFont {

//	public static Font font;
//	public static Font font_1;
//	public static Font font1;
//	public static Font font2;

	
	public static Font fontDetails_1() {
		Font f1 = null;
		try {
			File fontStyle = new File("src/font/Roboto-Light.ttf");
			f1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(13f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f1;
	}
	
	public static Font fontDetails() {
		Font f1 = null;
		try {
			File fontStyle = new File("src/font/Roboto-Light.ttf");
			f1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(11f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f1;
	}
	
	public static Font fontDetails1() {
		Font f1 = null;
		try {
			File fontStyle = new File("src/font/Roboto-Light.ttf");
			f1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(16f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f1;
	}

	public static Font fontThongKe() {
		Font f1 = null;
		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			f1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(20f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f1;
	}
	
	public static Font fontThongKe1() {
		Font f1 = null;
		try {
			File fontStyle = new File("src/font/Roboto-Light.ttf");
			f1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(26f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f1;
	}
	
	public static Font font() {
		Font f1 = null;
		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			f1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(11f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f1;
	}

	public static Font font1_ () {
		Font f1 = null;
		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			f1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(14f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f1;

	}

	public static Font font1() {
		Font f1 = null;
		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			f1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(16f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f1;
	}

	public static Font font2() {
		Font f1 = null;
		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			f1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(22f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f1;
	}

	public static Font fontTitle() {
		Font f = null;
		try {
			File fontStyle1 = new File("src/font/Oswald-Medium.ttf");
			f = Font.createFont(Font.TRUETYPE_FONT, fontStyle1).deriveFont(20f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f;
	}

	public static Font fontCategory() {
		Font f = null;
		try {
			File fontStyle1 = new File("src/font/Roboto-Light.ttf");
			f = Font.createFont(Font.TRUETYPE_FONT, fontStyle1).deriveFont(16f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f;
	}
	
	public static Font fontCategoryPr() {
		Font f = null;
		try {
			File fontStyle1 = new File("src/font/Roboto-Light.ttf");
			f = Font.createFont(Font.TRUETYPE_FONT, fontStyle1).deriveFont(12.5f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f;
	}

	public static Font fontHeaderTable() {
		Font f = null;
		try {
			File fontStyle1 = new File("src/font/Roboto-Bold.ttf");
			f = Font.createFont(Font.TRUETYPE_FONT, fontStyle1).deriveFont(12f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f;
	}

	public static com.itextpdf.text.Font fontTNR() {
		com.itextpdf.text.Font f = null;
		try {
			f = new com.itextpdf.text.Font(
					BaseFont.createFont("src/font/SVN-Times-New-Roman.ttf", BaseFont.IDENTITY_H, true), 12);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f;
	}

	public static com.itextpdf.text.Font fontTNRBoldTitle() {
		com.itextpdf.text.Font f = null;
		try {
			f = new com.itextpdf.text.Font(
					BaseFont.createFont("src/font/SVN-Times-New-Roman-Bold.ttf", BaseFont.IDENTITY_H, true), 18);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f;
	}
	
	public static com.itextpdf.text.Font fontTNRBoldNameCompany() {
		com.itextpdf.text.Font f = null;
		try {
			f = new com.itextpdf.text.Font(
					BaseFont.createFont("src/font/SVN-Times-New-Roman-Bold.ttf", BaseFont.IDENTITY_H, true), 20);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f;
	}

	public static com.itextpdf.text.Font fontTNRBold() {
		com.itextpdf.text.Font f = null;
		try {
			f = new com.itextpdf.text.Font(
					BaseFont.createFont("src/font/SVN-Times-New-Roman-Bold.ttf", BaseFont.IDENTITY_H, true), 12);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f;
	}

	public static com.itextpdf.text.Font fontTNRItalic() {
		com.itextpdf.text.Font f = null;
		try {
			f = new com.itextpdf.text.Font(
					BaseFont.createFont("src/font/SVN-Times-New-Roman-Italic.ttf", BaseFont.IDENTITY_H, true), 10);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f;
	}
}
