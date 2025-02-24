package model;

import java.sql.Blob;
import java.util.Objects;

public class Case extends Products {
	private String idCase;
	private String tenCase;
	private String hangCase;
	private String loaiCase;
	private String chatLieu;
	private String kichThuocMainboard;
	private int tonKho;
	private double gia;
	private String baoHanh;
	private Blob img;

	public Case(String idCase, String tenCase, String hangCase, String loaiCase, String chatLieu,
			String kichThuocMainboard, int tonKho, double gia, String baoHanh, Blob img) {
		super();
		this.idCase = idCase;
		this.tenCase = tenCase;
		this.hangCase = hangCase;
		this.loaiCase = loaiCase;
		this.chatLieu = chatLieu;
		this.kichThuocMainboard = kichThuocMainboard;
		this.tonKho = tonKho;
		this.gia = gia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

	public Case(String idSanPham, String idCase, String tenCase, String hangCase, String loaiCase, String chatLieu,
			String kichThuocMainboard, int tonKho, double gia, String baoHanh, Blob img) {
		super(idSanPham);
		this.idCase = idCase;
		this.tenCase = tenCase;
		this.hangCase = hangCase;
		this.loaiCase = loaiCase;
		this.chatLieu = chatLieu;
		this.kichThuocMainboard = kichThuocMainboard;
		this.tonKho = tonKho;
		this.gia = gia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

	public Case(String idSanPham, String tenSanPham, int trangThai, String moTa, String idCase, String tenCase,
			String hangCase, String loaiCase, String chatLieu, String kichThuocMainboard, int tonKho, double gia,
			String baoHanh, Blob img) {
		super(idSanPham, tenSanPham, trangThai, moTa);
		this.idCase = idCase;
		this.tenCase = tenCase;
		this.hangCase = hangCase;
		this.loaiCase = loaiCase;
		this.chatLieu = chatLieu;
		this.kichThuocMainboard = kichThuocMainboard;
		this.tonKho = tonKho;
		this.gia = gia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

	public Case(String idSanPham, String idCase, String tenCase, double gia, String baoHanh) {
		super(idSanPham);
		this.idCase = idCase;
		this.tenCase = tenCase;
		this.gia = gia;
		this.baoHanh = baoHanh;
	}

	public String getIdCase() {
		return idCase;
	}

	public void setIdCase(String idCase) {
		this.idCase = idCase;
	}

	public String getTenCase() {
		return tenCase;
	}

	public void setTenCase(String tenCase) {
		this.tenCase = tenCase;
	}

	public String getHangCase() {
		return hangCase;
	}

	public void setHangCase(String hangCase) {
		this.hangCase = hangCase;
	}

	public String getLoaiCase() {
		return loaiCase;
	}

	public void setLoaiCase(String loaiCase) {
		this.loaiCase = loaiCase;
	}

	public String getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}

	public String getKichThuocMainboard() {
		return kichThuocMainboard;
	}

	public void setKichThuocMainboard(String kichThuocMainboard) {
		this.kichThuocMainboard = kichThuocMainboard;
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
		return "Case [idCase=" + idCase + ", tenCase=" + tenCase + ", hangCase=" + hangCase + ", loaiCase=" + loaiCase
				+ ", chatLieu=" + chatLieu + ", kichThuocMainboard=" + kichThuocMainboard + ", tonKho=" + tonKho
				+ ", gia=" + gia + ", baoHanh=" + baoHanh + ", img=" + img + ", getIdSanPham()=" + getIdSanPham() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(baoHanh, chatLieu, gia, hangCase, idCase, img, kichThuocMainboard,
				loaiCase, tenCase, tonKho);
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
		Case other = (Case) obj;
		return Objects.equals(baoHanh, other.baoHanh) && Objects.equals(chatLieu, other.chatLieu)
				&& Double.doubleToLongBits(gia) == Double.doubleToLongBits(other.gia)
				&& Objects.equals(hangCase, other.hangCase) && Objects.equals(idCase, other.idCase)
				&& Objects.equals(img, other.img) && Objects.equals(kichThuocMainboard, other.kichThuocMainboard)
				&& Objects.equals(loaiCase, other.loaiCase) && Objects.equals(tenCase, other.tenCase)
				&& tonKho == other.tonKho;
	}

}
