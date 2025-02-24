package model;

import java.sql.Blob;
import java.util.Objects;

public class cpu extends Products {
	private String idCpu;
	private String nameCpu;
	private String xungNhip;
	private int soNhan;
	private int soLuong;
	private String dienNangTieuThu;
	private String boNhoDem;
	private int tonKho;
	private double donGia;
	private String baoHanh;
	private Blob img;

	public cpu() {
		super();
	}
//nhap hang
	public cpu(String idSanPham, String idCpu, String nameCpu, double donGia, String baoHanh) {
		super(idSanPham);
		this.idCpu = idCpu;
		this.nameCpu = nameCpu;
		this.donGia = donGia;
		this.baoHanh = baoHanh;
	}

	public cpu(String idCpu, String nameCpu, String xungNhip, int soNhan, int soLuong, String dienNangTieuThu,
			String boNhoDem, int tonKho, double donGia) {
		super();
		this.idCpu = idCpu;
		this.nameCpu = nameCpu;
		this.xungNhip = xungNhip;
		this.soNhan = soNhan;
		this.soLuong = soLuong;
		this.dienNangTieuThu = dienNangTieuThu;
		this.boNhoDem = boNhoDem;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

//	main
	public cpu(String idSanPham, String idCpu, String nameCpu, String xungNhip, int soNhan, int soLuong,
			String dienNangTieuThu, String boNhoDem, int tonKho, double donGia, String baoHanh, Blob img) {
		super(idSanPham);
		this.idCpu = idCpu;
		this.nameCpu = nameCpu;
		this.xungNhip = xungNhip;
		this.soNhan = soNhan;
		this.soLuong = soLuong;
		this.dienNangTieuThu = dienNangTieuThu;
		this.boNhoDem = boNhoDem;
		this.tonKho = tonKho;
		this.donGia = donGia;
		this.baoHanh = baoHanh;
		this.img = img;

	}
	
// them cpu khong co ton kho
	
//	public cpu(String idSanPham, String idCpu, String nameCpu, String xungNhip, int soNhan, int soLuong,
//			String dienNangTieuThu, String boNhoDem, double donGia, String baoHanh, Blob img) {
//		super(idSanPham);
//		this.idCpu = idCpu;
//		this.nameCpu = nameCpu;
//		this.xungNhip = xungNhip;
//		this.soNhan = soNhan;
//		this.soLuong = soLuong;
//		this.dienNangTieuThu = dienNangTieuThu;
//		this.boNhoDem = boNhoDem;
//		this.donGia = donGia;
//		this.baoHanh = baoHanh;
//		this.img = img;
//	}

	public cpu(String idSanPham, String tenSanPham, int trangThai, String moTa, String idCpu, String nameCpu,
			String xungNhip, int soNhan, int soLuong, String dienNangTieuThu, String boNhoDem, int tonKho,
			double donGia) {
		super(idSanPham, tenSanPham, trangThai, moTa);
		this.idCpu = idCpu;
		this.nameCpu = nameCpu;
		this.xungNhip = xungNhip;
		this.soNhan = soNhan;
		this.soLuong = soLuong;
		this.dienNangTieuThu = dienNangTieuThu;
		this.boNhoDem = boNhoDem;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	
	public int getTonKho() {
		return tonKho;
	}

	public void setTonKho(int tonKho) {
		this.tonKho = tonKho;
	}

	public String getIdCpu() {
		return idCpu;
	}

	public void setIdCpu(String idCpu) {
		this.idCpu = idCpu;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getNameCpu() {
		return nameCpu;
	}

	public void setNameCpu(String nameCpu) {
		this.nameCpu = nameCpu;
	}

	public String getXungNhip() {
		return xungNhip;
	}

	public void setXungNhip(String xungNhip) {
		this.xungNhip = xungNhip;
	}

	public int getSoNhan() {
		return soNhan;
	}

	public void setSoNhan(int soNhan) {
		this.soNhan = soNhan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getDienNangTieuThu() {
		return dienNangTieuThu;
	}

	public void setDienNangTieuThu(String dienNangTieuThu) {
		this.dienNangTieuThu = dienNangTieuThu;
	}

	public String getBoNhoDem() {
		return boNhoDem;
	}

	public void setBoNhoDem(String boNhoDem) {
		this.boNhoDem = boNhoDem;
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
		return "cpu [idCpu=" + idCpu + ", nameCpu=" + nameCpu + ", xungNhip=" + xungNhip + ", soNhan=" + soNhan
				+ ", soLuong=" + soLuong + ", dienNangTieuThu=" + dienNangTieuThu + ", boNhoDem=" + boNhoDem
				+ ", tonKho=" + tonKho + ", donGia=" + donGia + ", baoHanh=" + baoHanh + ", img=" + img
				+ ", getIdSanPham()=" + getIdSanPham() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(baoHanh, boNhoDem, dienNangTieuThu, donGia, idCpu, img, nameCpu, soLuong,
				soNhan, tonKho, xungNhip);
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
		cpu other = (cpu) obj;
		return Objects.equals(baoHanh, other.baoHanh) && Objects.equals(boNhoDem, other.boNhoDem)
				&& Objects.equals(dienNangTieuThu, other.dienNangTieuThu)
				&& Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(idCpu, other.idCpu) && Objects.equals(img, other.img)
				&& Objects.equals(nameCpu, other.nameCpu) && soLuong == other.soLuong && soNhan == other.soNhan
				&& tonKho == other.tonKho && Objects.equals(xungNhip, other.xungNhip);
	}

}
