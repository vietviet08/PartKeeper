package model;

import java.util.Objects;

public class keyboard extends Products {
	private String idBanPhim;
	private String hangBanPhim;
	private String ketNoi;
	private String kieuSwitch;
	private String denLED;
	private String loaiBanPhim;
	private String keyCap;
	private String trongLuong;
	private int tonKho;
	private double donGia;

	public keyboard() {
		super();
	}

	public keyboard(String idBanPhim, String hangBanPhim, String ketNoi, String kieuSwitch, String denLED,
			String loaiBanPhim, String keyCap, String trongLuong, int tonKho, double donGia) {
		super();
		this.idBanPhim = idBanPhim;
		this.hangBanPhim = hangBanPhim;
		this.ketNoi = ketNoi;
		this.kieuSwitch = kieuSwitch;
		this.denLED = denLED;
		this.loaiBanPhim = loaiBanPhim;
		this.keyCap = keyCap;
		this.trongLuong = trongLuong;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public keyboard(String idSanPham, String idBanPhim, String hangBanPhim, String ketNoi, String kieuSwitch,
			String denLED, String loaiBanPhim, String keyCap, String trongLuong, int tonKho, double donGia) {
		super(idSanPham);
		this.idBanPhim = idBanPhim;
		this.hangBanPhim = hangBanPhim;
		this.ketNoi = ketNoi;
		this.kieuSwitch = kieuSwitch;
		this.denLED = denLED;
		this.loaiBanPhim = loaiBanPhim;
		this.keyCap = keyCap;
		this.trongLuong = trongLuong;
		this.tonKho = tonKho;
		this.donGia = donGia;
	}

	public keyboard(String idSanPham, String tenSanPham, int trangThai, String moTa, String idBanPhim,
			String hangBanPhim, String ketNoi, String kieuSwitch, String denLED, String loaiBanPhim, String keyCap,
			String trongLuong, int tonKho, double donGia) {
		super(idSanPham, tenSanPham, trangThai, moTa);
		this.idBanPhim = idBanPhim;
		this.hangBanPhim = hangBanPhim;
		this.ketNoi = ketNoi;
		this.kieuSwitch = kieuSwitch;
		this.denLED = denLED;
		this.loaiBanPhim = loaiBanPhim;
		this.keyCap = keyCap;
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

	public String getHangBanPhim() {
		return hangBanPhim;
	}

	public void setHangBanPhim(String hangBanPhim) {
		this.hangBanPhim = hangBanPhim;
	}

	public String getKetNoi() {
		return ketNoi;
	}

	public void setKetNoi(String ketNoi) {
		this.ketNoi = ketNoi;
	}

	public String getKieuSwitch() {
		return kieuSwitch;
	}

	public void setKieuSwitch(String kieuSwitch) {
		this.kieuSwitch = kieuSwitch;
	}

	public String getDenLED() {
		return denLED;
	}

	public void setDenLED(String denLED) {
		this.denLED = denLED;
	}

	public String getLoaiBanPhim() {
		return loaiBanPhim;
	}

	public void setLoaiBanPhim(String loaiBanPhim) {
		this.loaiBanPhim = loaiBanPhim;
	}

	public String getKeyCap() {
		return keyCap;
	}

	public void setKeyCap(String keyCap) {
		this.keyCap = keyCap;
	}

	public String getTrongLuong() {
		return trongLuong;
	}

	public void setTrongLuong(String trongLuong) {
		this.trongLuong = trongLuong;
	}

	public String getIdBanPhim() {
		return idBanPhim;
	}

	public void setIdBanPhim(String idBanPhim) {
		this.idBanPhim = idBanPhim;
	}

	public int getTonKho() {
		return tonKho;
	}

	public void setTonKho(int tonKho) {
		this.tonKho = tonKho;
	}

	@Override
	public String toString() {
		return "banphim [idBanPhim=" + idBanPhim + ", hangBanPhim=" + hangBanPhim + ", ketNoi=" + ketNoi
				+ ", kieuSwitch=" + kieuSwitch + ", denLED=" + denLED + ", loaiBanPhim=" + loaiBanPhim + ", keyCap="
				+ keyCap + ", trongLuong=" + trongLuong + ", tonKho=" + tonKho + ", donGia=" + donGia
				+ ", getIdSanPham()=" + getIdSanPham() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(denLED, donGia, hangBanPhim, idBanPhim, ketNoi, keyCap, kieuSwitch,
				loaiBanPhim, tonKho, trongLuong);
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
		keyboard other = (keyboard) obj;
		return Objects.equals(denLED, other.denLED)
				&& Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(hangBanPhim, other.hangBanPhim) && Objects.equals(idBanPhim, other.idBanPhim)
				&& Objects.equals(ketNoi, other.ketNoi) && Objects.equals(keyCap, other.keyCap)
				&& Objects.equals(kieuSwitch, other.kieuSwitch) && Objects.equals(loaiBanPhim, other.loaiBanPhim)
				&& tonKho == other.tonKho && Objects.equals(trongLuong, other.trongLuong);
	}

}
