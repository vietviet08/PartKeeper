package model;

import java.util.Objects;

public class mouse extends Products {
	private String idChuot;

	private String hangChuot;
	private int soNut;
	private String kieuKetNoi;
	private String denLED;
	private String mauSac;
	private String doPhanGiai;
	private String kichCo;
	private String trongLuong;
	private int tonKho;
	private double donGia;

	public mouse() {
		super();
	}

	public mouse(String idChuot, String hangChuot, int soNut, String kieuKetNoi, String denLED, String mauSac,
			String doPhanGiai, String kichCo, String trongLuong, int tonKho, double donGia) {
		super();
		this.idChuot = idChuot;
		this.hangChuot = hangChuot;
		this.soNut = soNut;
		this.kieuKetNoi = kieuKetNoi;
		this.denLED = denLED;
		this.mauSac = mauSac;
		this.doPhanGiai = doPhanGiai;
		this.kichCo = kichCo;
		this.trongLuong = trongLuong;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public mouse(String idSanPham, String idChuot, String hangChuot, int soNut, String kieuKetNoi, String denLED,
			String mauSac, String doPhanGiai, String kichCo, String trongLuong, int tonKho, double donGia) {
		super(idSanPham);
		this.idChuot = idChuot;
		this.hangChuot = hangChuot;
		this.soNut = soNut;
		this.kieuKetNoi = kieuKetNoi;
		this.denLED = denLED;
		this.mauSac = mauSac;
		this.doPhanGiai = doPhanGiai;
		this.kichCo = kichCo;
		this.trongLuong = trongLuong;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public mouse(String idSanPham, String tenSanPham, int trangThai, String moTa, String idChuot, String hangChuot,
			int soNut, String kieuKetNoi, String denLED, String mauSac, String doPhanGiai, String kichCo,
			String trongLuong, int tonKho, double donGia) {
		super(idSanPham, tenSanPham, trangThai, moTa);
		this.idChuot = idChuot;
		this.hangChuot = hangChuot;
		this.soNut = soNut;
		this.kieuKetNoi = kieuKetNoi;
		this.denLED = denLED;
		this.mauSac = mauSac;
		this.doPhanGiai = doPhanGiai;
		this.kichCo = kichCo;
		this.trongLuong = trongLuong;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getHangChuot() {
		return hangChuot;
	}

	public void setHangChuot(String hangChuot) {
		this.hangChuot = hangChuot;
	}

	public int getSoNut() {
		return soNut;
	}

	public void setSoNut(int soNut) {
		this.soNut = soNut;
	}

	public String getKieuKetNoi() {
		return kieuKetNoi;
	}

	public void setKieuKetNoi(String kieuKetNoi) {
		this.kieuKetNoi = kieuKetNoi;
	}

	public String getDenLED() {
		return denLED;
	}

	public void setDenLED(String denLED) {
		this.denLED = denLED;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public String getDoPhanGiai() {
		return doPhanGiai;
	}

	public void setDoPhanGiai(String doPhanGiai) {
		this.doPhanGiai = doPhanGiai;
	}

	public String getKichCo() {
		return kichCo;
	}

	public void setKichCo(String kichCo) {
		this.kichCo = kichCo;
	}

	public String getTrongLuong() {
		return trongLuong;
	}

	public void setTrongLuong(String trongLuong) {
		this.trongLuong = trongLuong;
	}

	public String getIdChuot() {
		return idChuot;
	}

	public void setIdChuot(String idChuot) {
		this.idChuot = idChuot;
	}

	public int getTonKho() {
		return tonKho;
	}

	public void setTonKho(int tonKho) {
		this.tonKho = tonKho;
	}

	@Override
	public String toString() {
		return "chuot [idChuot=" + idChuot + ", hangChuot=" + hangChuot + ", soNut=" + soNut + ", kieuKetNoi="
				+ kieuKetNoi + ", denLED=" + denLED + ", mauSac=" + mauSac + ", doPhanGiai=" + doPhanGiai + ", kichCo="
				+ kichCo + ", trongLuong=" + trongLuong + ", tonKho=" + tonKho + ", donGia=" + donGia
				+ ", getIdSanPham()=" + getIdSanPham() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(denLED, doPhanGiai, donGia, hangChuot, idChuot, kichCo, kieuKetNoi,
				mauSac, soNut, tonKho, trongLuong);
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
		mouse other = (mouse) obj;
		return Objects.equals(denLED, other.denLED) && Objects.equals(doPhanGiai, other.doPhanGiai)
				&& Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(hangChuot, other.hangChuot) && Objects.equals(idChuot, other.idChuot)
				&& Objects.equals(kichCo, other.kichCo) && Objects.equals(kieuKetNoi, other.kieuKetNoi)
				&& Objects.equals(mauSac, other.mauSac) && soNut == other.soNut && tonKho == other.tonKho
				&& Objects.equals(trongLuong, other.trongLuong);
	}

}
