
package controller;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dao.ChiTietPhieuNhapDAO;
import dao.ChiTietPhieuXuatDAO;
import dao.KhachHangDAO;
import dao.NhaPhanPhoiDAO;
import dao.PhieuNhapDAO;
import dao.PhieuXuatDAO;
import font.SetFont;
import model.ChiTietPhieu;
import model.PhieuNhap;
import model.PhieuXuat;

public class XuatPDF {

	DecimalFormat formatter = new DecimalFormat("###,###,###");
	SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyy hh:mm:ss aaa");
	Document document = new Document();
	FileOutputStream file;
	JFrame jf = new JFrame();
	FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);

//	public void chooseURL(String url) {
//		try {
//			document.close();
//			document = new Document();
//			file = new FileOutputStream(url);
//			PdfWriter.getInstance(document, file);
//			document.open();
//		} catch (FileNotFoundException ex) {
//			JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
//		} catch (DocumentException ex) {
//			JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
//		}
//	}

	private String getFile(String idPhieu) {
		fd.pack();
//		fd.setSize(800, 600);
		fd.validate();
		fd.setFile(idPhieu + ".pdf");
		fd.setVisible(true);
		return fd.getDirectory() + fd.getFile();
	}

	public void taoPhieuNhap(String idDonNhap) {
		String url = "";
		try {
			fd.setTitle("Xuất PDF phiếu nhập");
			fd.setLocationRelativeTo(null);
			url = getFile(idDonNhap);

			file = new FileOutputStream(url);
			document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();

			PdfPTable firstLine = new PdfPTable(2);
			firstLine.setWidths(new float[] { 60, 90 });
			firstLine.setWidthPercentage(100);

			PdfPCell cellTime = new PdfPCell(new Phrase(formatDate.format(new Date()), SetFont.fontTNR()));
			cellTime.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellTime.setBorder(0);

			PdfPCell cellCopyright = new PdfPCell(
					new Phrase("© Copyright 2023 - NGUYỄN QUỐC VIỆT - 23CE.B029", SetFont.fontTNR()));
			cellCopyright.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cellCopyright.setBorder(0);

			firstLine.addCell(cellTime);
			firstLine.addCell(cellCopyright);
			document.add(firstLine);

			document.add(new Paragraph(" "));

			PdfPTable myCompany = new PdfPTable(2);
			myCompany.setWidths(new float[] { 50, 50 });
			myCompany.setWidthPercentage(100);
			PdfPCell inf = new PdfPCell();

			Paragraph infoCongTy = new Paragraph();
			infoCongTy.add(new Phrase("\nVIEQUOC COMPUTER", SetFont.fontTNRBoldNameCompany()));
			infoCongTy.add(new Phrase("\nĐịa chỉ: DT605 - Hòa Vang - TP Đà Nẵng", SetFont.fontTNR()));
			infoCongTy.add(new Phrase("\nFacebook: facebook.com/viequoc24.08", SetFont.fontTNR()));
			infoCongTy.add(new Phrase("\nTax: 012345679", SetFont.fontTNR()));
			infoCongTy.setIndentationLeft(40);
			inf.addElement(infoCongTy);
			inf.setHorizontalAlignment(Element.ALIGN_LEFT);
			inf.setBorder(0);

			PdfPCell cellLogo = new PdfPCell();
			try {

				Image logo = Image.getInstance("src/icon/logoVie1.png");
//				logo.setAbsolutePosition(30, 30);
//				logo.setWidthPercentage(15);
//				logo.setIndentationLeft(310);
				cellLogo.addElement(logo);
				cellLogo.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cellLogo.setBorder(0);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			myCompany.addCell(inf);
			myCompany.addCell(cellLogo);

			document.add(myCompany);

//			document.add(new Paragraph(" "));
//			document.add(new Paragraph(" "));

			Paragraph title = new Paragraph(new Phrase("PHIẾU NHẬP HÀNG", SetFont.fontTNRBoldTitle()));
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);

			PhieuNhap pn = PhieuNhapDAO.getInstance().selectById(idDonNhap);
			Paragraph idPhieu = new Paragraph(new Phrase("Số hóa đơn: " + pn.getIdPhieu(), SetFont.fontTNR()));
			idPhieu.setAlignment(Element.ALIGN_CENTER);
			document.add(idPhieu);

			document.add(new Paragraph(" "));

			Paragraph info = new Paragraph();
			info.setPaddingTop(30);
			info.setIndentationLeft(40);
			info.setFont(SetFont.fontTNR());
			info.add("\nNhà phân phối: " + NhaPhanPhoiDAO.getInstance().selectById(pn.getIdNPP()).getTenNPP());
			info.add("\nĐịa chỉ: " + NhaPhanPhoiDAO.getInstance().selectById(pn.getIdNPP()).getDiaChi());
			info.add("\nEmail: " + NhaPhanPhoiDAO.getInstance().selectById(pn.getIdNPP()).getEmail());
			info.add("\nSĐT: " + NhaPhanPhoiDAO.getInstance().selectById(pn.getIdNPP()).getSdt());
			document.add(info);
			document.add(Chunk.NEWLINE);

			PdfPTable pdfTable = new PdfPTable(6);
			pdfTable.setWidths(new float[] { 10f, 35f, 15f, 15f, 20f, 20f });

			PdfPCell cell1 = new PdfPCell(new Phrase("STT", SetFont.fontTNRBold()));
			cell1.setBackgroundColor(new BaseColor(98, 181, 244));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell1);

			PdfPCell cell2 = new PdfPCell(new Phrase("Tên hàng", SetFont.fontTNRBold()));
			cell2.setBackgroundColor(new BaseColor(98, 181, 244));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell2);

			PdfPCell cell6 = new PdfPCell(new Phrase("Bảo hành", SetFont.fontTNRBold()));
			cell6.setBackgroundColor(new BaseColor(98, 181, 244));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell6);

			PdfPCell cell3 = new PdfPCell(new Phrase("Số Lượng", SetFont.fontTNRBold()));
			cell3.setBackgroundColor(new BaseColor(98, 181, 244));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell3);

			PdfPCell cell4 = new PdfPCell(new Phrase("Đơn giá", SetFont.fontTNRBold()));
			cell4.setBackgroundColor(new BaseColor(98, 181, 244));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell4);

			PdfPCell cell5 = new PdfPCell(new Phrase("Thành tiền", SetFont.fontTNRBold()));
			cell5.setBackgroundColor(new BaseColor(98, 181, 244));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell5);

			int j = 1;
			PdfPCell cellSTT;
			PdfPCell cellTenSP;
			PdfPCell cellSL;
			PdfPCell cellDonGia;
			PdfPCell cellBaoHanh;
			PdfPCell cellTongTien;

			for (ChiTietPhieu ctpn : ChiTietPhieuNhapDAO.getInstance().selectAllById(idDonNhap)) {
				cellSTT = new PdfPCell(new Phrase(j + "", SetFont.fontTNR()));
				cellSTT.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable.addCell(cellSTT);

				cellTenSP = new PdfPCell(new Phrase(ctpn.getTenSanPham(), SetFont.fontTNR()));
				pdfTable.addCell(cellTenSP);

				cellBaoHanh = new PdfPCell(new Phrase(ctpn.getBaoHanh(), SetFont.fontTNR()));
				pdfTable.addCell(cellBaoHanh);

				cellSL = new PdfPCell(new Phrase(ctpn.getSoLuong() + "", SetFont.fontTNR()));
				cellSL.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable.addCell(cellSL);

				cellDonGia = new PdfPCell(new Phrase(FormatToVND.vnd(ctpn.getDonGia()), SetFont.fontTNR()));
				cellDonGia.setHorizontalAlignment(Element.ALIGN_RIGHT);
				pdfTable.addCell(cellDonGia);

				cellTongTien = new PdfPCell(
						new Phrase(FormatToVND.vnd(ctpn.getSoLuong() * ctpn.getDonGia()), SetFont.fontTNR()));
				cellTongTien.setHorizontalAlignment(Element.ALIGN_RIGHT);
				pdfTable.addCell(cellTongTien);

				j++;
			}

			PdfPTable tableTotal = new PdfPTable(2);
			tableTotal.setWidths(new float[] { 95f, 20f });

			PdfPCell cellTongCong = new PdfPCell(new Phrase("Tổng cộng:", SetFont.fontTNRBold()));
			cellTongCong.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableTotal.addCell(cellTongCong);

			PdfPCell cellTien = new PdfPCell(
					new Phrase(String.valueOf(FormatToVND.vnd(pn.getTongTien())), SetFont.fontTNRBold()));
			cellTien.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableTotal.addCell(cellTien);

			document.add(pdfTable);
			document.add(tableTotal);

			String money = NumToViet.num2String((long) pn.getTongTien());
			String chuDau = money.substring(0, 1);
			String conLai = money.substring(1, money.length());
			money = chuDau.toUpperCase() + conLai;
			Paragraph tienBangChu = new Paragraph(new Phrase("Bằng chữ: " + money + " đồng", SetFont.fontTNRItalic()));
			tienBangChu.setIndentationLeft(50);

			document.add(tienBangChu);

			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));

			PdfPTable footer = new PdfPTable(2);
			footer.setWidths(new float[] { 50, 50 });

			PdfPCell cellEmtity = new PdfPCell(new Phrase(" "));
			cellEmtity.setBorder(0);

			Date now = new Date();
			@SuppressWarnings("deprecation")
			PdfPCell date = new PdfPCell(
					new Phrase("Đà Nẵng, ngày " + now.getDate() + " tháng " + String.valueOf(now.getMonth() + 1)
							+ " năm " + String.valueOf(now.getYear() + 1900), SetFont.fontTNR()));
			date.setHorizontalAlignment(Element.ALIGN_CENTER);
			date.setBorder(0);

			PdfPCell cellNPP = new PdfPCell(new Phrase("NHÀ PHÂN PHỐI", SetFont.fontTNRBold()));
			cellNPP.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellNPP.setBorder(0);

			PdfPCell cellNguoiLap = new PdfPCell(new Phrase("NGƯỜI LẬP PHIẾU", SetFont.fontTNRBold()));
			cellNguoiLap.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellNguoiLap.setBorder(0);

			footer.addCell(cellEmtity);
			footer.addCell(date);
			footer.addCell(cellNPP);
			footer.addCell(cellNguoiLap);

			document.add(footer);

			document.close();
			openFile(url);

		} catch (DocumentException | FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
		}
	}

	private void openFile(String file) {
		try {
			File path = new File(file);
			Desktop.getDesktop().open(path);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void taoPhieuXuat(String idDonXuat) {
		String url = "";
		try {
			fd.setTitle("Xuất PDF phiếu xuất");
			fd.setLocationRelativeTo(null);
			url = getFile(idDonXuat);

			file = new FileOutputStream(url);
			document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();

			PdfPTable firstLine = new PdfPTable(2);
			firstLine.setWidths(new float[] { 60, 90 });
			firstLine.setWidthPercentage(100);

			PdfPCell cellTime = new PdfPCell(new Phrase(formatDate.format(new Date()), SetFont.fontTNR()));
			cellTime.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellTime.setBorder(0);

			PdfPCell cellCopyright = new PdfPCell(
					new Phrase("© Copyright 2023 - NGUYỄN QUỐC VIỆT - 23CE.B029", SetFont.fontTNR()));
			cellCopyright.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cellCopyright.setBorder(0);

			firstLine.addCell(cellTime);
			firstLine.addCell(cellCopyright);
			document.add(firstLine);

			document.add(new Paragraph(" "));

			PdfPTable myCompany = new PdfPTable(2);
			myCompany.setWidths(new float[] { 50, 50 });
			myCompany.setWidthPercentage(100);
			PdfPCell inf = new PdfPCell();

			Paragraph infoCongTy = new Paragraph();
			infoCongTy.add(new Phrase("\nVIEQUOC COMPUTER", SetFont.fontTNRBoldNameCompany()));
			infoCongTy.add(new Phrase("\nĐịa chỉ: DT605 - Hòa Vang - TP Đà Nẵng", SetFont.fontTNR()));
			infoCongTy.add(new Phrase("\nFacebook: facebook.com/viequoc24.08", SetFont.fontTNR()));
			infoCongTy.add(new Phrase("\nTax: 012345679", SetFont.fontTNR()));
			infoCongTy.setIndentationLeft(40);
			inf.addElement(infoCongTy);
			inf.setHorizontalAlignment(Element.ALIGN_LEFT);
			inf.setBorder(0);

			PdfPCell cellLogo = new PdfPCell();
			try {

				Image logo = Image.getInstance("src/icon/logoVie1.png");
//				logo.setAbsolutePosition(30, 30);
//				logo.setWidthPercentage(15);
//				logo.setIndentationLeft(310);
				cellLogo.addElement(logo);
				cellLogo.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cellLogo.setBorder(0);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			myCompany.addCell(inf);
			myCompany.addCell(cellLogo);

			document.add(myCompany);

//			document.add(new Paragraph(" "));
//			document.add(new Paragraph(" "));

			Paragraph title = new Paragraph(new Phrase("HÓA ĐƠN BÁN HÀNG", SetFont.fontTNRBoldTitle()));
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);

			PhieuXuat px = PhieuXuatDAO.getInstance().selectById(idDonXuat);
			Paragraph idPhieu = new Paragraph(new Phrase("Số hóa đơn: " + px.getIdPhieu(), SetFont.fontTNR()));
			idPhieu.setAlignment(Element.ALIGN_CENTER);
			document.add(idPhieu);

			document.add(new Paragraph(" "));

			Paragraph info = new Paragraph();
			info.setPaddingTop(30);
			info.setIndentationLeft(40);
			info.setFont(SetFont.fontTNR());
			info.add("\nTên khách hàng: "
					+ KhachHangDAO.getInstance().selectById(px.getIdKhachHang()).getTenKhachHang());
			info.add("\nĐịa chỉ: " + KhachHangDAO.getInstance().selectById(px.getIdKhachHang()).getDiaChi());
			info.add("\nEmail: " + KhachHangDAO.getInstance().selectById(px.getIdKhachHang()).getEmail());
			info.add("\nSĐT: " + KhachHangDAO.getInstance().selectById(px.getIdKhachHang()).getSdt());
			document.add(info);
			document.add(Chunk.NEWLINE);

			PdfPTable pdfTable = new PdfPTable(6);
			pdfTable.setWidths(new float[] { 10f, 35f, 15f, 15f, 20f, 20f });

			PdfPCell cell1 = new PdfPCell(new Phrase("STT", SetFont.fontTNRBold()));
			cell1.setBackgroundColor(new BaseColor(98, 181, 244));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell1);

			PdfPCell cell2 = new PdfPCell(new Phrase("Tên hàng", SetFont.fontTNRBold()));
			cell2.setBackgroundColor(new BaseColor(98, 181, 244));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell2);

			PdfPCell cell6 = new PdfPCell(new Phrase("Bảo hành", SetFont.fontTNRBold()));
			cell6.setBackgroundColor(new BaseColor(98, 181, 244));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell6);

			PdfPCell cell3 = new PdfPCell(new Phrase("Số Lượng", SetFont.fontTNRBold()));
			cell3.setBackgroundColor(new BaseColor(98, 181, 244));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell3);

			PdfPCell cell4 = new PdfPCell(new Phrase("Đơn giá", SetFont.fontTNRBold()));
			cell4.setBackgroundColor(new BaseColor(98, 181, 244));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell4);

			PdfPCell cell5 = new PdfPCell(new Phrase("Thành tiền", SetFont.fontTNRBold()));
			cell5.setBackgroundColor(new BaseColor(98, 181, 244));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell5);

			int j = 1;
			PdfPCell cellSTT;
			PdfPCell cellTenSP;
			PdfPCell cellSL;
			PdfPCell cellDonGia;
			PdfPCell cellBaoHanh;
			PdfPCell cellTongTien;

			for (ChiTietPhieu ctpn : ChiTietPhieuXuatDAO.getInstance().selectAllByID(idDonXuat)) {
				cellSTT = new PdfPCell(new Phrase(j + "", SetFont.fontTNR()));
				cellSTT.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable.addCell(cellSTT);

				cellTenSP = new PdfPCell(new Phrase(ctpn.getTenSanPham(), SetFont.fontTNR()));
				pdfTable.addCell(cellTenSP);

				cellBaoHanh = new PdfPCell(new Phrase(ctpn.getBaoHanh(), SetFont.fontTNR()));
				pdfTable.addCell(cellBaoHanh);

				cellSL = new PdfPCell(new Phrase(ctpn.getSoLuong() + "", SetFont.fontTNR()));
				cellSL.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable.addCell(cellSL);

				cellDonGia = new PdfPCell(new Phrase(FormatToVND.vnd(ctpn.getDonGia()), SetFont.fontTNR()));
				cellDonGia.setHorizontalAlignment(Element.ALIGN_RIGHT);
				pdfTable.addCell(cellDonGia);

				cellTongTien = new PdfPCell(
						new Phrase(FormatToVND.vnd(ctpn.getSoLuong() * ctpn.getDonGia()), SetFont.fontTNR()));
				cellTongTien.setHorizontalAlignment(Element.ALIGN_RIGHT);
				pdfTable.addCell(cellTongTien);

				j++;
			}

			PdfPTable tableTotal = new PdfPTable(2);
			tableTotal.setWidths(new float[] { 95f, 20f });

			PdfPCell cellTongCong = new PdfPCell(new Phrase("Tổng cộng:", SetFont.fontTNRBold()));
			cellTongCong.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableTotal.addCell(cellTongCong);

			PdfPCell cellTien = new PdfPCell(
					new Phrase(String.valueOf(FormatToVND.vnd(px.getTongTien())), SetFont.fontTNRBold()));
			cellTien.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableTotal.addCell(cellTien);

			document.add(pdfTable);
			document.add(tableTotal);

			String money = NumToViet.num2String((long) px.getTongTien());
			String chuDau = money.substring(0, 1);
			String conLai = money.substring(1, money.length());
			money = chuDau.toUpperCase() + conLai;
			Paragraph tienBangChu = new Paragraph(new Phrase("Bằng chữ: " + money + " đồng", SetFont.fontTNRItalic()));
			tienBangChu.setIndentationLeft(50);

			document.add(tienBangChu);

			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));

			PdfPTable footer = new PdfPTable(2);
			footer.setWidths(new float[] { 50, 50 });

			PdfPCell cellEmtity = new PdfPCell(new Phrase(" "));
			cellEmtity.setBorder(0);

			Date now = new Date();
			@SuppressWarnings("deprecation")
			PdfPCell date = new PdfPCell(
					new Phrase("Đà Nẵng, ngày " + now.getDate() + " tháng " + String.valueOf(now.getMonth() + 1)
							+ " năm " + String.valueOf(now.getYear() + 1900), SetFont.fontTNR()));
			date.setHorizontalAlignment(Element.ALIGN_CENTER);
			date.setBorder(0);

			PdfPCell cellNPP = new PdfPCell(new Phrase("KHÁCH HÀNG", SetFont.fontTNRBold()));
			cellNPP.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellNPP.setBorder(0);

			PdfPCell cellNguoiLap = new PdfPCell(new Phrase("NGƯỜI LẬP PHIẾU", SetFont.fontTNRBold()));
			cellNguoiLap.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellNguoiLap.setBorder(0);

			footer.addCell(cellEmtity);
			footer.addCell(date);
			footer.addCell(cellNPP);
			footer.addCell(cellNguoiLap);

			document.add(footer);

			document.close();
			openFile(url);

		} catch (DocumentException | FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
		}
	}
}
