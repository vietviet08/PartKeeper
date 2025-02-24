package model;

import java.util.Objects;

public class NhaPhanPhoi {
	private String idNPP;
	private String tenNPP;
	private String diaChi;
	private String email;
	private int sdt;

	public NhaPhanPhoi() {
		super();
	}

//
	public NhaPhanPhoi(String idNPP) {
		super();
		this.idNPP = idNPP;
	}

	public NhaPhanPhoi(String idNPP, String tenNPP, String diaChi, String email, int sdt) {
		super();
		this.idNPP = idNPP;
		this.tenNPP = tenNPP;
		this.diaChi = diaChi;
		this.email = email;
		this.sdt = sdt;
	}

	public String getIdNPP() {
		return idNPP;
	}

	public void setIdNPP(String idNPP) {
		this.idNPP = idNPP;
	}

	public String getTenNPP() {
		return tenNPP;
	}

	public void setTenNPP(String tenNPP) {
		this.tenNPP = tenNPP;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	@Override
	public String toString() {
		return "NhaPhanPhoi [idNPP=" + idNPP + ", tenNPP=" + tenNPP + ", diaChi=" + diaChi + ", email=" + email
				+ ", sdt=" + sdt + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaChi, email, idNPP, sdt, tenNPP);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaPhanPhoi other = (NhaPhanPhoi) obj;
		return Objects.equals(diaChi, other.diaChi) && Objects.equals(email, other.email)
				&& Objects.equals(idNPP, other.idNPP) && sdt == other.sdt && Objects.equals(tenNPP, other.tenNPP);
	}

}
