package test;

import java.awt.FileDialog;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;

public class testPDF {
	public static void main(String[] args) throws FileNotFoundException {
//		String path = "D:\\test\\testpdf.pdf";
//		Document document = new Document();
//		try {
//			PdfWriter.getInstance(document, new FileOutputStream(path));
//			
//			document.open();
//			
//			document.add(new Paragraph("Hello xin chào!!! Tui là Việt nè kiki"));
//			
//			document.close();
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String path="D:\\test\\invoice.pdf";
//		PdfWriter pdfWriter=new PdfWriter(new FileOutputStream(path));
		PdfDocument pdfDocument=new PdfDocument(new PdfWriter(path));
		pdfDocument.setDefaultPageSize(PageSize.A4);
		Document document=new Document(pdfDocument);
		document.add(new Paragraph("test"));
		document.close();
	}
}
