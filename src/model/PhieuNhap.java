package model;

import java.sql.Timestamp;
import java.util.Objects;

public class PhieuNhap extends Phieu {

	private String idNPP;

	public PhieuNhap() {
		super();
	}

	public PhieuNhap(String idNPP) {
		super();
		this.idNPP = idNPP;
	}

	public PhieuNhap(String idPhieu, String idNPP, Timestamp thoiGianTao, String nguoiTao, double tongTien,
			int trangThai) {
		super(idPhieu, thoiGianTao, nguoiTao, tongTien, trangThai);
		this.idNPP = idNPP;
	}

	public PhieuNhap(String idPhieu, String idNPP, Timestamp thoiGianTao, String nguoiTao, double tongTien,
			int trangThai, ChiTietPhieu ctp) {
		super(idPhieu, thoiGianTao, nguoiTao, tongTien, trangThai, ctp);
		this.idNPP = idNPP;
	}

	public String getIdNPP() {
		return idNPP;
	}

	public void setIdNPP(String idNPP) {
		this.idNPP = idNPP;
	}

	@Override
	public String toString() {
		return "PhieuNhap [idNPP=" + idNPP + ", getTrangThai()=" + getTrangThai() + ", getIdPhieu()=" + getIdPhieu()
				+ ", getThoiGianTao()=" + getThoiGianTao() + ", getNguoiTao()=" + getNguoiTao() + ", getTongTien()="
				+ getTongTien() + ", getCtp()=" + getCtp() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idNPP);
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
		PhieuNhap other = (PhieuNhap) obj;
		return Objects.equals(idNPP, other.idNPP);
	}

}
