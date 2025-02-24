package model;

import java.sql.Timestamp;
import java.util.Objects;

public class Phieu {
	private String idPhieu;
	private Timestamp thoiGianTao;
	private String nguoiTao;
	private double tongTien;
	private int trangThai;
	private ChiTietPhieu ctp;

	public Phieu() {
		super();
	}

	

	public Phieu(String idPhieu, Timestamp thoiGianTao, String nguoiTao, double tongTien, int trangThai,
			ChiTietPhieu ctp) {
		super();
		this.idPhieu = idPhieu;
		this.thoiGianTao = thoiGianTao;
		this.nguoiTao = nguoiTao;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
		this.ctp = ctp;
	}
	
	


	public Phieu(String idPhieu, Timestamp thoiGianTao, String nguoiTao, double tongTien, int trangThai) {
		super();
		this.idPhieu = idPhieu;
		this.thoiGianTao = thoiGianTao;
		this.nguoiTao = nguoiTao;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
	}



	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public String getIdPhieu() {
		return idPhieu;
	}

	public void setIdPhieu(String idPhieu) {
		this.idPhieu = idPhieu;
	}

	public Timestamp getThoiGianTao() {
		return thoiGianTao;
	}

	public void setThoiGianTao(Timestamp thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}

	public String getNguoiTao() {
		return nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public ChiTietPhieu getCtp() {
		return ctp;
	}

	public void setCtp(ChiTietPhieu ctp) {
		this.ctp = ctp;
	}

	@Override
	public String toString() {
		return "Phieu [idPhieu=" + idPhieu + ", thoiGianTao=" + thoiGianTao + ", nguoiTao=" + nguoiTao + ", tongTien="
				+ tongTien + ", ctp=" + ctp + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ctp, idPhieu, nguoiTao, thoiGianTao, tongTien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phieu other = (Phieu) obj;
		return Objects.equals(ctp, other.ctp) && Objects.equals(idPhieu, other.idPhieu)
				&& Objects.equals(nguoiTao, other.nguoiTao) && Objects.equals(thoiGianTao, other.thoiGianTao)
				&& Double.doubleToLongBits(tongTien) == Double.doubleToLongBits(other.tongTien);
	}

}
