package model;

import java.sql.Blob;
import java.util.Objects;

public class ssd extends Products {
	private String idSdd;
	private String tenSsd;
	private String hang;
	private String dungLuong;
	private String loai;
	private String tocDoDoc;
	private String tocDoGhi;
	private int tonKho;
	private double gia;
	private String baoHanh;
	private Blob img;

	public ssd(String idSdd, String tenSsd, String hang, String dungLuong, String loai, String tocDoDoc,
			String tocDoGhi, int tonKho, double gia, String baoHanh, Blob img) {
		super();
		this.idSdd = idSdd;
		this.tenSsd = tenSsd;
		this.hang = hang;
		this.dungLuong = dungLuong;
		this.loai = loai;
		this.tocDoDoc = tocDoDoc;
		this.tocDoGhi = tocDoGhi;
		this.tonKho = tonKho;
		this.gia = gia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

	public ssd(String idSanPham, String idSdd, String tenSsd, String hang, String dungLuong, String loai,
			String tocDoDoc, String tocDoGhi, int tonKho, double gia, String baoHanh, Blob img) {
		super(idSanPham);
		this.idSdd = idSdd;
		this.tenSsd = tenSsd;
		this.hang = hang;
		this.dungLuong = dungLuong;
		this.loai = loai;
		this.tocDoDoc = tocDoDoc;
		this.tocDoGhi = tocDoGhi;
		this.tonKho = tonKho;
		this.gia = gia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

	public ssd(String idSanPham, String tenSanPham, int trangThai, String moTa, String idSdd, String tenSsd,
			String hang, String dungLuong, String loai, String tocDoDoc, String tocDoGhi, int tonKho, double gia,
			String baoHanh, Blob img) {
		super(idSanPham, tenSanPham, trangThai, moTa);
		this.idSdd = idSdd;
		this.tenSsd = tenSsd;
		this.hang = hang;
		this.dungLuong = dungLuong;
		this.loai = loai;
		this.tocDoDoc = tocDoDoc;
		this.tocDoGhi = tocDoGhi;
		this.tonKho = tonKho;
		this.gia = gia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

	public int getTonKho() {
		return tonKho;
	}

	public void setTonKho(int tonKho) {
		this.tonKho = tonKho;
	}

	public String getIdSdd() {
		return idSdd;
	}

	public void setIdSdd(String idSdd) {
		this.idSdd = idSdd;
	}

	public String getTenSsd() {
		return tenSsd;
	}

	public void setTenSsd(String tenSsd) {
		this.tenSsd = tenSsd;
	}

	public String getHang() {
		return hang;
	}

	public void setHang(String hang) {
		this.hang = hang;
	}

	public String getDungLuong() {
		return dungLuong;
	}

	public void setDungLuong(String dungLuong) {
		this.dungLuong = dungLuong;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getTocDoDoc() {
		return tocDoDoc;
	}

	public void setTocDoDoc(String tocDoDoc) {
		this.tocDoDoc = tocDoDoc;
	}

	public String getTocDoGhi() {
		return tocDoGhi;
	}

	public void setTocDoGhi(String tocDoGhi) {
		this.tocDoGhi = tocDoGhi;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getBaoHanh() {
		return baoHanh;
	}

	public void setBaoHanh(String baoHanh) {
		this.baoHanh = baoHanh;
	}

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "ssd [idSdd=" + idSdd + ", tenSsd=" + tenSsd + ", hang=" + hang + ", dungLuong=" + dungLuong + ", loai="
				+ loai + ", tocDoDoc=" + tocDoDoc + ", tocDoGhi=" + tocDoGhi + ", gia=" + gia + ", baoHanh=" + baoHanh
				+ ", img=" + img + ", getIdSanPham()=" + getIdSanPham() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(baoHanh, dungLuong, gia, hang, idSdd, img, loai, tenSsd, tocDoDoc, tocDoGhi);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ssd other = (ssd) obj;
		return Objects.equals(baoHanh, other.baoHanh) && Objects.equals(dungLuong, other.dungLuong)
				&& Double.doubleToLongBits(gia) == Double.doubleToLongBits(other.gia)
				&& Objects.equals(hang, other.hang) && Objects.equals(idSdd, other.idSdd)
				&& Objects.equals(img, other.img) && Objects.equals(loai, other.loai)
				&& Objects.equals(tenSsd, other.tenSsd) && Objects.equals(tocDoDoc, other.tocDoDoc)
				&& Objects.equals(tocDoGhi, other.tocDoGhi);
	}

}
