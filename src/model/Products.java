package model;

import java.util.Objects;

public class Products {
	private String idSanPham;
	private String tenSanPham;
	private int trangThai;
	private String moTa;

	public Products() {
		super();
	}

//
	public Products(String idSanPham) {
		super();
		this.idSanPham = idSanPham;
	}

//
	public Products(String idSanPham, String tenSanPham, int trangThai, String moTa) {
		super();
		this.idSanPham = idSanPham;
		this.tenSanPham = tenSanPham;
		this.trangThai = trangThai;
		this.moTa = moTa;
	}

	public String getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public String toString() {
		return "Products [idSanPham=" + idSanPham + ", tenSanPham=" + tenSanPham + ", trangThai=" + trangThai
				+ ", moTa=" + moTa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSanPham, moTa, tenSanPham, trangThai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return Objects.equals(idSanPham, other.idSanPham) && Objects.equals(moTa, other.moTa)
				&& Objects.equals(tenSanPham, other.tenSanPham) && trangThai == other.trangThai;
	}

}
