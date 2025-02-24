package model;

import java.util.Objects;

public class ChiTietPhieu extends Products {
//	private int stt;
	private String idPhieu;
//	private String idSanPham;
	private String idRieng;
	private String tenSanPham;
	private int soLuong;
	private double donGia;
	private String baoHanh;

	public ChiTietPhieu() {
		super();
	}

	public ChiTietPhieu(String idPhieu, String idSanPham, String idRieng, String tenSanPham, int soLuong, double donGia,
			String baoHanh) {
		super(idSanPham);
		this.idPhieu = idPhieu;
//		this.idSanPham = idSanPham;
		this.idRieng = idRieng;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.baoHanh = baoHanh;
	}

	public ChiTietPhieu(String idSanPham, String idRieng, String tenSanPham, int soLuong, double donGia,
			String baoHanh) {
		super(idSanPham);
//		this.idSanPham = idSanPham;
		this.idRieng = idRieng;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.baoHanh = baoHanh;
	}

	public String getIdRieng() {
		return idRieng;
	}

	public void setIdRieng(String idRieng) {
		this.idRieng = idRieng;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getIdPhieu() {
		return idPhieu;
	}

	public void setIdPhieu(String idPhieu) {
		this.idPhieu = idPhieu;
	}

//	public String getIdSanPham() {
//		return idSanPham;
//	}
//
//	public void setIdSanPham(String idSanPham) {
//		this.idSanPham = idSanPham;
//	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getBaoHanh() {
		return baoHanh;
	}

	public void setBaoHanh(String baoHanh) {
		this.baoHanh = baoHanh;
	}

	@Override
	public String toString() {
		return "ChiTietPhieu [idPhieu=" + idPhieu + ", idRieng=" + idRieng + ", tenSanPham=" + tenSanPham + ", soLuong="
				+ soLuong + ", donGia=" + donGia + ", baoHanh=" + baoHanh + ", getIdSanPham()=" + getIdSanPham() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(baoHanh, donGia, idPhieu, idRieng, soLuong, tenSanPham);
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
		ChiTietPhieu other = (ChiTietPhieu) obj;
		return Objects.equals(baoHanh, other.baoHanh)
				&& Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(idPhieu, other.idPhieu) && Objects.equals(idRieng, other.idRieng)
				&& soLuong == other.soLuong && Objects.equals(tenSanPham, other.tenSanPham);
	}

//	@Override
//	public String toString() {
//		return "ChiTietPhieu [idPhieu=" + idPhieu + ", idSanPham=" + idSanPham + ", idRieng=" + idRieng
//				+ ", tenSanPham=" + tenSanPham + ", soLuong=" + soLuong + ", donGia=" + donGia + ", baoHanh=" + baoHanh
//				+ "]";
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(baoHanh, donGia, idPhieu, idRieng, idSanPham, soLuong, tenSanPham);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ChiTietPhieu other = (ChiTietPhieu) obj;
//		return Objects.equals(baoHanh, other.baoHanh)
//				&& Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
//				&& Objects.equals(idPhieu, other.idPhieu) && Objects.equals(idRieng, other.idRieng)
//				&& Objects.equals(idSanPham, other.idSanPham) && soLuong == other.soLuong
//				&& Objects.equals(tenSanPham, other.tenSanPham);
//	}

}
