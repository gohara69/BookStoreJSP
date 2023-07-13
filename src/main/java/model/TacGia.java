package model;

import java.sql.Date;

public class TacGia {
	private int    maTacGia;
	private String hoTen;
	private Date   ngaySinh;
	private String tieuSu;
	
	public TacGia() {}

	public TacGia(int maTacGia, String hoTen, Date ngaySinh, String tieuSu) {
		this.maTacGia = maTacGia;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.tieuSu = tieuSu;
	}

	public int getMaTacGia() {
		return maTacGia;
	}

	public void setMaTacGia(int maTacGia) {
		this.maTacGia = maTacGia;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getTieuSu() {
		return tieuSu;
	}

	public void setTieuSu(String tieuSu) {
		this.tieuSu = tieuSu;
	}
}
