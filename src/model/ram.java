package model;

import java.sql.Blob;
import java.util.Objects;

public class ram extends Products {
	private String idRam;
	private String tenRam;
	private String loai;
	private String dungLuong;
	private String bus;
	private int tonkho;
	private double donGia;
	private String baoHanh;
	private Blob img;

	public ram() {
		super();
	}

	public ram(String idSanPham, String idRam, String tenRam, double donGia, String baoHanh) {
		super(idSanPham);
		this.idRam = idRam;
		this.tenRam = tenRam;
		this.donGia = donGia;
		this.baoHanh = baoHanh;
	}

	public ram(String idRam, String tenRam, String loai, String dungLuong, String bus, int tonkho, double donGia) {
		super();
		this.idRam = idRam;
		this.tenRam = tenRam;
		this.loai = loai;
		this.dungLuong = dungLuong;
		this.bus = bus;
		this.tonkho = tonkho;
		this.donGia = donGia;
	}

	public ram(String idSanPham, String idRam, String tenRam, String loai, String dungLuong, String bus, int tonkho,
			double donGia, String baoHanh, Blob img) {
		super(idSanPham);
		this.idRam = idRam;
		this.tenRam = tenRam;
		this.loai = loai;
		this.dungLuong = dungLuong;
		this.bus = bus;
		this.tonkho = tonkho;
		this.donGia = donGia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

	public ram(String idSanPham, String tenSanPham, int trangThai, String moTa, String idRam, String tenRam,
			String loai, String dungLuong, String bus, int tonkho, double donGia) {
		super(idSanPham, tenSanPham, trangThai, moTa);
		this.idRam = idRam;
		this.tenRam = tenRam;
		this.loai = loai;
		this.dungLuong = dungLuong;
		this.bus = bus;
		this.tonkho = tonkho;
		this.donGia = donGia;
	}

	public String getIdRam() {
		return idRam;
	}

	public void setIdRam(String idRam) {
		this.idRam = idRam;
	}

	public int getTonkho() {
		return tonkho;
	}

	public void setTonkho(int tonkho) {
		this.tonkho = tonkho;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getTenRam() {
		return tenRam;
	}

	public void setTenRam(String tenRam) {
		this.tenRam = tenRam;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getDungLuong() {
		return dungLuong;
	}

	public void setDungLuong(String dungLuong) {
		this.dungLuong = dungLuong;
	}

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
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
		return "ram [idRam=" + idRam + ", tenRam=" + tenRam + ", loai=" + loai + ", dungLuong=" + dungLuong + ", bus="
				+ bus + ", tonkho=" + tonkho + ", donGia=" + donGia + ", baoHanh=" + baoHanh + ", img=" + img
				+ ", getIdSanPham()=" + getIdSanPham() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(baoHanh, bus, donGia, dungLuong, idRam, img, loai, tenRam, tonkho);
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
		ram other = (ram) obj;
		return Objects.equals(baoHanh, other.baoHanh) && Objects.equals(bus, other.bus)
				&& Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(dungLuong, other.dungLuong) && Objects.equals(idRam, other.idRam)
				&& Objects.equals(img, other.img) && Objects.equals(loai, other.loai)
				&& Objects.equals(tenRam, other.tenRam) && tonkho == other.tonkho;
	}

}
