package model;

import java.util.Objects;

public class screen extends Products {
	private String idManHinh;
	private String hangManhinh;
	private String tanSoQuet;
	private String tamNen;
	private String kichThuoc;
	private String kieuManHinh;
	private String doPhanGiai;
	private int tonKho;
	private double donGia;

	public screen() {
		super();
	}

	public screen(String idManHinh, String hangManhinh, String tanSoQuet, String tamNen, String kichThuoc,
			String kieuManHinh, String doPhanGiai, int tonKho, double donGia) {
		super();
		this.idManHinh = idManHinh;
		this.hangManhinh = hangManhinh;
		this.tanSoQuet = tanSoQuet;
		this.tamNen = tamNen;
		this.kichThuoc = kichThuoc;
		this.kieuManHinh = kieuManHinh;
		this.doPhanGiai = doPhanGiai;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public screen(String idSanPham, String idManHinh, String hangManhinh, String tanSoQuet, String tamNen,
			String kichThuoc, String kieuManHinh, String doPhanGiai, int tonKho, double donGia) {
		super(idSanPham);
		this.idManHinh = idManHinh;
		this.hangManhinh = hangManhinh;
		this.tanSoQuet = tanSoQuet;
		this.tamNen = tamNen;
		this.kichThuoc = kichThuoc;
		this.kieuManHinh = kieuManHinh;
		this.doPhanGiai = doPhanGiai;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public screen(String idSanPham, String tenSanPham, int trangThai, String moTa, String idManHinh,
			String hangManhinh, String tanSoQuet, String tamNen, String kichThuoc, String kieuManHinh,
			String doPhanGiai, int tonKho, double donGia) {
		super(idSanPham, tenSanPham, trangThai, moTa);
		this.idManHinh = idManHinh;
		this.hangManhinh = hangManhinh;
		this.tanSoQuet = tanSoQuet;
		this.tamNen = tamNen;
		this.kichThuoc = kichThuoc;
		this.kieuManHinh = kieuManHinh;
		this.doPhanGiai = doPhanGiai;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getHangManhinh() {
		return hangManhinh;
	}

	public void setHangManhinh(String hangManhinh) {
		this.hangManhinh = hangManhinh;
	}

	public String getTanSoQuet() {
		return tanSoQuet;
	}

	public void setTanSoQuet(String tanSoQuet) {
		this.tanSoQuet = tanSoQuet;
	}

	public String getTamNen() {
		return tamNen;
	}

	public void setTamNen(String tamNen) {
		this.tamNen = tamNen;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public String getKieuManHinh() {
		return kieuManHinh;
	}

	public void setKieuManHinh(String kieuManHinh) {
		this.kieuManHinh = kieuManHinh;
	}

	public String getDoPhanGiai() {
		return doPhanGiai;
	}

	public void setDoPhanGiai(String doPhanGiai) {
		this.doPhanGiai = doPhanGiai;
	}

	public String getIdManHinh() {
		return idManHinh;
	}

	public void setIdManHinh(String idManHinh) {
		this.idManHinh = idManHinh;
	}

	public int getTonKho() {
		return tonKho;
	}

	public void setTonKho(int tonKho) {
		this.tonKho = tonKho;
	}

	@Override
	public String toString() {
		return "manhinh [idManHinh=" + idManHinh + ", hangManhinh=" + hangManhinh + ", tanSoQuet=" + tanSoQuet
				+ ", tamNen=" + tamNen + ", kichThuoc=" + kichThuoc + ", kieuManHinh=" + kieuManHinh + ", doPhanGiai="
				+ doPhanGiai + ", tonKho=" + tonKho + ", donGia=" + donGia + ", getIdSanPham()=" + getIdSanPham() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(doPhanGiai, donGia, hangManhinh, idManHinh, kichThuoc, kieuManHinh,
				tamNen, tanSoQuet, tonKho);
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
		screen other = (screen) obj;
		return Objects.equals(doPhanGiai, other.doPhanGiai)
				&& Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(hangManhinh, other.hangManhinh) && Objects.equals(idManHinh, other.idManHinh)
				&& Objects.equals(kichThuoc, other.kichThuoc) && Objects.equals(kieuManHinh, other.kieuManHinh)
				&& Objects.equals(tamNen, other.tamNen) && Objects.equals(tanSoQuet, other.tanSoQuet)
				&& tonKho == other.tonKho;
	}

}
