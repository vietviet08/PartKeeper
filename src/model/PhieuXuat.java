package model;

import java.sql.Timestamp;
import java.util.Objects;

public class PhieuXuat extends Phieu {
	private String idKhachHang;

	public PhieuXuat() {
		super();
	}

	public PhieuXuat(String idKhachHang) {
		super();
		this.idKhachHang = idKhachHang;
	}

	public PhieuXuat(String idPhieu, String idKhachHang, Timestamp thoiGianTao, String nguoiTao, double tongTien,
			int trangThai) {
		super(idPhieu, thoiGianTao, nguoiTao, tongTien, trangThai);
		this.idKhachHang = idKhachHang;
	}

	public PhieuXuat(String idPhieu, String idKhachHang, Timestamp thoiGianTao, String nguoiTao, double tongTien,
			int trangThai, ChiTietPhieu ctp) {
		super(idPhieu, thoiGianTao, nguoiTao, tongTien, trangThai, ctp);
		this.idKhachHang = idKhachHang;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	@Override
	public String toString() {
		return "PhieuXuat [idKhachHang=" + idKhachHang + ", getTrangThai()=" + getTrangThai() + ", getIdPhieu()="
				+ getIdPhieu() + ", getThoiGianTao()=" + getThoiGianTao() + ", getNguoiTao()=" + getNguoiTao()
				+ ", getTongTien()=" + getTongTien() + ", getCtp()=" + getCtp() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idKhachHang);
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
		PhieuXuat other = (PhieuXuat) obj;
		return Objects.equals(idKhachHang, other.idKhachHang);
	}

}
