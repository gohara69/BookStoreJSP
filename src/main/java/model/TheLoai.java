package model;

import java.util.Objects;

public class TheLoai {
	private int 	maTheLoai;
	private String 	tenTheLoai;
	
	public TheLoai() {}

	public TheLoai(int maTheLoai, String tenTheLoai) {
		this.maTheLoai = maTheLoai;
		this.tenTheLoai = tenTheLoai;
	}
	
	public TheLoai(int maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public int getMaTheLoai() {
		return maTheLoai;
	}

	public void setMaTheLoai(int maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTheLoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheLoai other = (TheLoai) obj;
		return maTheLoai == other.maTheLoai;
	}

	@Override
	public String toString() {
		return "TheLoai [maTheLoai=" + maTheLoai + ", tenTheLoai=" + tenTheLoai + "]";
	}
}
