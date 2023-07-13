package model;

public class ChiTietDonHang {
	private int 	maChiTietDonHang;
	private DonHang donHang;
	private Sach 	sach;
	private int 	soLuong;
	private double 	giaBia;
	private double 	giamGia;
	private double 	giaBan;
	private double 	thueVAT;
	private double 	tongThanhTien;
	public ChiTietDonHang() {}
	
	public ChiTietDonHang(int maChiTietDonHang, DonHang donHang, Sach sach, int soLuong, double giaBia, double giamGia,
			double giaBan, double thueVAT, double tongThanhTien) {
		this.maChiTietDonHang = maChiTietDonHang;
		this.donHang = donHang;
		this.sach = sach;
		this.soLuong = soLuong;
		this.giaBia = giaBia;
		this.giamGia = giamGia;
		this.giaBan = giaBan;
		this.thueVAT = thueVAT;
		this.tongThanhTien = tongThanhTien;
	}

	public int getMaChiTietDonHang() {
		return maChiTietDonHang;
	}

	public void setMaChiTietDonHang(int maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBia() {
		return giaBia;
	}

	public void setGiaBia(double giaBia) {
		this.giaBia = giaBia;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public double getThueVAT() {
		return thueVAT;
	}

	public void setThueVAT(double thueVAT) {
		this.thueVAT = thueVAT;
	}

	public double getTongThanhTien() {
		return tongThanhTien;
	}

	public void setTongThanhTien(double tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDonHang other = (ChiTietDonHang) obj;
		return maChiTietDonHang == other.maChiTietDonHang;
	}
}
