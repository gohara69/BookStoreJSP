package dao;

import java.util.ArrayList;

import model.ChiTietDonHang;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang>{
	private ArrayList<ChiTietDonHang> listChiTietDonHang = new ArrayList<>();

	@Override
	public ArrayList<ChiTietDonHang> selectAll() {
		return listChiTietDonHang;
	}

	@Override
	public ChiTietDonHang selectById(ChiTietDonHang t) {
		for (ChiTietDonHang ChiTietDonHang : listChiTietDonHang) {
			if (ChiTietDonHang.equals(t)) {
				return ChiTietDonHang;
			}
		}
		return null;
	}

	@Override
	public int insert(ChiTietDonHang t) {
		ChiTietDonHang ChiTietDonHang = selectById(t);
		if (ChiTietDonHang == null) {
			listChiTietDonHang.add(ChiTietDonHang);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertList(ArrayList<ChiTietDonHang> list) {
		int dem = 0;
		for (ChiTietDonHang ChiTietDonHang : list) {
			ChiTietDonHang s = selectById(ChiTietDonHang);
			if (s == null) {
				listChiTietDonHang.add(s);
				dem++;
			}
		}
		return dem;
	}

	@Override
	public int delete(ChiTietDonHang t) {
		ChiTietDonHang ChiTietDonHang = selectById(t);
		if (ChiTietDonHang != null) {
			listChiTietDonHang.remove(ChiTietDonHang);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteList(ArrayList<ChiTietDonHang> list) {
		int dem = 0;
		for (ChiTietDonHang ChiTietDonHang : list) {
			ChiTietDonHang s = selectById(ChiTietDonHang);
			if (s != null) {
				listChiTietDonHang.remove(s);
				dem++;
			}
		}
		return dem;
	}

	@Override
	public int update(ChiTietDonHang t) {
		ChiTietDonHang ChiTietDonHang = selectById(t);
		if (ChiTietDonHang != null) {
			return 1;
		}
		return 0;
	}
}
