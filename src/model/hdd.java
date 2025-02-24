package model;

import java.sql.Blob;
import java.util.Objects;

public class hdd extends Products {
	private String idhHdd;
	private String tenHdd;
	private String hang;
	private String dungLuong;
	private String boNhoDem;
	private String tocDoVongQuay;
	private int tonKho;
	private double gia;
	private String baoHanh;
	private Blob img;

	public hdd(String idhHdd, String tenHdd, String hang, String dungLuong, String boNhoDem, String tocDoVongQuay,
			int tonKho, double gia, String baoHanh, Blob img) {
		super();
		this.idhHdd = idhHdd;
		this.tenHdd = tenHdd;
		this.hang = hang;
		this.dungLuong = dungLuong;
		this.boNhoDem = boNhoDem;
		this.tocDoVongQuay = tocDoVongQuay;
		this.tonKho = tonKho;
		this.gia = gia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

	public hdd(String idSanPham, String idhHdd, String tenHdd, String hang, String dungLuong, String boNhoDem,
			String tocDoVongQuay, int tonKho, double gia, String baoHanh, Blob img) {
		super(idSanPham);
		this.idhHdd = idhHdd;
		this.tenHdd = tenHdd;
		this.hang = hang;
		this.dungLuong = dungLuong;
		this.boNhoDem = boNhoDem;
		this.tocDoVongQuay = tocDoVongQuay;
		this.tonKho = tonKho;
		this.gia = gia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

	public hdd(String idSanPham, String tenSanPham, int trangThai, String moTa, String idhHdd, String tenHdd,
			String hang, String dungLuong, String boNhoDem, String tocDoVongQuay, int tonKho, double gia,
			String baoHanh, Blob img) {
		super(idSanPham, tenSanPham, trangThai, moTa);
		this.idhHdd = idhHdd;
		this.tenHdd = tenHdd;
		this.hang = hang;
		this.dungLuong = dungLuong;
		this.boNhoDem = boNhoDem;
		this.tocDoVongQuay = tocDoVongQuay;
		this.tonKho = tonKho;
		this.gia = gia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

	public String getIdhHdd() {
		return idhHdd;
	}

	public void setIdhHdd(String idhHdd) {
		this.idhHdd = idhHdd;
	}

	public String getTenHdd() {
		return tenHdd;
	}

	public void setTenHdd(String tenHdd) {
		this.tenHdd = tenHdd;
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

	public String getBoNhoDem() {
		return boNhoDem;
	}

	public void setBoNhoDem(String boNhoDem) {
		this.boNhoDem = boNhoDem;
	}

	public String getTocDoVongQuay() {
		return tocDoVongQuay;
	}

	public void setTocDoVongQuay(String tocDoVongQuay) {
		this.tocDoVongQuay = tocDoVongQuay;
	}

	public int getTonKho() {
		return tonKho;
	}

	public void setTonKho(int tonKho) {
		this.tonKho = tonKho;
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
		return "hdd [idhHdd=" + idhHdd + ", tenHdd=" + tenHdd + ", hang=" + hang + ", dungLuong=" + dungLuong
				+ ", boNhoDem=" + boNhoDem + ", tocDoVongQuay=" + tocDoVongQuay + ", tonKho=" + tonKho + ", gia=" + gia
				+ ", baoHanh=" + baoHanh + ", img=" + img + ", getIdSanPham()=" + getIdSanPham() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(baoHanh, boNhoDem, dungLuong, gia, hang, idhHdd, img, tenHdd, tocDoVongQuay, tonKho);
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
		hdd other = (hdd) obj;
		return Objects.equals(baoHanh, other.baoHanh) && Objects.equals(boNhoDem, other.boNhoDem)
				&& Objects.equals(dungLuong, other.dungLuong)
				&& Double.doubleToLongBits(gia) == Double.doubleToLongBits(other.gia)
				&& Objects.equals(hang, other.hang) && Objects.equals(idhHdd, other.idhHdd)
				&& Objects.equals(img, other.img) && Objects.equals(tenHdd, other.tenHdd)
				&& Objects.equals(tocDoVongQuay, other.tocDoVongQuay) && tonKho == other.tonKho;
	}

}
