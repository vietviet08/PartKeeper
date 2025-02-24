package model;

import java.sql.Blob;
import java.util.Objects;

public class mainboard extends Products {
	private String idMainboard;
	private String tenMain;
	private String tenHang;
	private String kichThuoc;
	private String hoTroCPU;
	private String hoTroRAM;
	private int tonKho;
	private double donGia;
	private String baoHanh;
	private Blob img;

	public mainboard() {
		super();
	}

	public mainboard(String idMainboard, String tenMain, String tenHang, String kichThuoc, String hoTroCPU,
			String hoTroRAM, int tonKho, double donGia, String baoHanh, Blob img) {
		super();
		this.idMainboard = idMainboard;
		this.tenMain = tenMain;
		this.tenHang = tenHang;
		this.kichThuoc = kichThuoc;
		this.hoTroCPU = hoTroCPU;
		this.hoTroRAM = hoTroRAM;
		this.tonKho = tonKho;
		this.donGia = donGia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

//main
	public mainboard(String idSanPham, String idMainboard, String tenMain, String tenHang, String hoTroCPU,
			String hoTroRAM, String kichThuoc, int tonKho, double donGia, String baoHanh, Blob img) {
		super(idSanPham);
		this.idMainboard = idMainboard;
		this.tenMain = tenMain;
		this.tenHang = tenHang;
		this.kichThuoc = kichThuoc;
		this.hoTroCPU = hoTroCPU;
		this.hoTroRAM = hoTroRAM;
		this.tonKho = tonKho;
		this.donGia = donGia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

//nhap hang
	public mainboard(String idSanPham, String idMainboard, String tenMain, double donGia, String baoHanh) {
		super(idSanPham);
		this.idMainboard = idMainboard;
		this.tenMain = tenMain;
		this.donGia = donGia;
		this.baoHanh = baoHanh;
	}

	public mainboard(String idSanPham, String tenSanPham, int trangThai, String moTa, String idMainboard,
			String tenMain, String tenHang, String kichThuoc, String hoTroCPU, String hoTroRAM, int tonKho,
			double donGia, String baoHanh, Blob img) {
		super(idSanPham, tenSanPham, trangThai, moTa);
		this.idMainboard = idMainboard;
		this.tenMain = tenMain;
		this.tenHang = tenHang;
		this.kichThuoc = kichThuoc;
		this.hoTroCPU = hoTroCPU;
		this.hoTroRAM = hoTroRAM;
		this.tonKho = tonKho;
		this.donGia = donGia;
		this.baoHanh = baoHanh;
		this.img = img;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getTenMain() {
		return tenMain;
	}

	public void setTenMain(String tenMain) {
		this.tenMain = tenMain;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public String getIdMainboard() {
		return idMainboard;
	}

	public void setIdMainboard(String idMainboard) {
		this.idMainboard = idMainboard;
	}

	public int getTonKho() {
		return tonKho;
	}

	public void setTonKho(int tonKho) {
		this.tonKho = tonKho;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public String getHoTroCPU() {
		return hoTroCPU;
	}

	public void setHoTroCPU(String hoTroCPU) {
		this.hoTroCPU = hoTroCPU;
	}

	public String getHoTroRAM() {
		return hoTroRAM;
	}

	public void setHoTroRAM(String hoTroRAM) {
		this.hoTroRAM = hoTroRAM;
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
		return "mainboard [idMainboard=" + idMainboard + ", tenMain=" + tenMain + ", tenHang=" + tenHang
				+ ", kichThuoc=" + kichThuoc + ", hoTroCPU=" + hoTroCPU + ", hoTroRAM=" + hoTroRAM + ", tonKho="
				+ tonKho + ", donGia=" + donGia + ", baoHanh=" + baoHanh + ", img=" + img + ", getIdSanPham()="
				+ getIdSanPham() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(baoHanh, donGia, hoTroCPU, hoTroRAM, idMainboard, img, kichThuoc,
				tenHang, tenMain, tonKho);
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
		mainboard other = (mainboard) obj;
		return Objects.equals(baoHanh, other.baoHanh)
				&& Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(hoTroCPU, other.hoTroCPU) && Objects.equals(hoTroRAM, other.hoTroRAM)
				&& Objects.equals(idMainboard, other.idMainboard) && Objects.equals(img, other.img)
				&& Objects.equals(kichThuoc, other.kichThuoc) && Objects.equals(tenHang, other.tenHang)
				&& Objects.equals(tenMain, other.tenMain) && tonKho == other.tonKho;
	}

}
