package model;

import java.sql.Blob;
import java.util.Objects;

public class psu extends Products {
	private String idNguon;
	private String tenNguon;
	private String hang;
	private String congSuat;
	private String chuanNguon;
	private String kieuDay;
	private String kichThuoc;
	private int tonKho;
	private double donGia;
	private String baoHanh;
	private Blob img;

	public psu() {
		super();
	}

	public psu(String idNguon, String tenNguon, String hang, String congSuat, String chuanNguon, String kieuDay,
			String kichThuoc, int tonKho, double donGia, String baoHanh, Blob img) {
		super();
		this.idNguon = idNguon;
		this.tenNguon = tenNguon;
		this.hang = hang;
		this.congSuat = congSuat;
		this.chuanNguon = chuanNguon;
		this.kieuDay = kieuDay;
		this.kichThuoc = kichThuoc;
		this.tonKho = tonKho;
		this.donGia = donGia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

	public psu(String idSanPham, String idNguon, String tenNguon, String hang, String congSuat, String chuanNguon,
			String kieuDay, String kichThuoc, int tonKho, double donGia, String baoHanh, Blob img) {
		super(idSanPham);
		this.idNguon = idNguon;
		this.tenNguon = tenNguon;
		this.hang = hang;
		this.congSuat = congSuat;
		this.chuanNguon = chuanNguon;
		this.kieuDay = kieuDay;
		this.kichThuoc = kichThuoc;
		this.tonKho = tonKho;
		this.donGia = donGia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

	public psu(String idSanPham, String tenSanPham, int trangThai, String moTa, String idNguon, String hang,
			String congSuat, String chuanNguon, String kieuDay, String kichThuoc, int tonKho, double donGia,
			String baoHanh, Blob img) {
		super(idSanPham, tenSanPham, trangThai, moTa);
		this.idNguon = idNguon;
		this.hang = hang;
		this.congSuat = congSuat;
		this.chuanNguon = chuanNguon;
		this.kieuDay = kieuDay;
		this.kichThuoc = kichThuoc;
		this.tonKho = tonKho;
		this.donGia = donGia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

	public String getIdNguon() {
		return idNguon;
	}

	public void setIdNguon(String idNguon) {
		this.idNguon = idNguon;
	}

	public String getTenNguon() {
		return tenNguon;
	}

	public void setTenNguon(String tenNguon) {
		this.tenNguon = tenNguon;
	}

	public String getHang() {
		return hang;
	}

	public void setHang(String hang) {
		this.hang = hang;
	}

	public String getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(String congSuat) {
		this.congSuat = congSuat;
	}

	public String getChuanNguon() {
		return chuanNguon;
	}

	public void setChuanNguon(String chuanNguon) {
		this.chuanNguon = chuanNguon;
	}

	public String getKieuDay() {
		return kieuDay;
	}

	public void setKieuDay(String kieuDay) {
		this.kieuDay = kieuDay;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public int getTonKho() {
		return tonKho;
	}

	public void setTonKho(int tonKho) {
		this.tonKho = tonKho;
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

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "psu [idNguon=" + idNguon + ", hang=" + hang + ", congSuat=" + congSuat + ", chuanNguon=" + chuanNguon
				+ ", kieuDay=" + kieuDay + ", kichThuoc=" + kichThuoc + ", tonKho=" + tonKho + ", donGia=" + donGia
				+ ", baoHanh=" + baoHanh + ", img=" + img + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(baoHanh, chuanNguon, congSuat, donGia, hang, idNguon, img, kichThuoc, kieuDay, tonKho);
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
		psu other = (psu) obj;
		return Objects.equals(baoHanh, other.baoHanh) && Objects.equals(chuanNguon, other.chuanNguon)
				&& Objects.equals(congSuat, other.congSuat)
				&& Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(hang, other.hang) && Objects.equals(idNguon, other.idNguon)
				&& Objects.equals(img, other.img) && Objects.equals(kichThuoc, other.kichThuoc)
				&& Objects.equals(kieuDay, other.kieuDay) && tonKho == other.tonKho;
	}

}
