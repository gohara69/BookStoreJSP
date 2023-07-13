package dao;

import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;

public class DonHangDAO implements DAOInterface<DonHang>{
	private ArrayList<DonHang> listDonHang = new ArrayList<>();

	@Override
	public ArrayList<DonHang> selectAll() {
		return listDonHang; 
	}

	@Override
	public DonHang selectById(DonHang t) {
		for (DonHang DonHang : listDonHang) {
			if (DonHang.getMaDonHang() == t.getMaDonHang()) {
				return DonHang;
			}
		}
		return null;
	}

	@Override
	public int insert(DonHang t) {
		DonHang DonHang = selectById(t);
		if (DonHang == null) {
			listDonHang.add(DonHang);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertList(ArrayList<DonHang> list) {
		int dem = 0;
		for (DonHang DonHang : list) {
			DonHang s = selectById(DonHang);
			if (s == null) {
				listDonHang.add(s);
				dem++;
			}
		}
		return dem;
	}

	@Override
	public int delete(DonHang t) {
		DonHang DonHang = selectById(t);
		if (DonHang != null) {
			ChiTietDonHangDAO ctdhDAO = new ChiTietDonHangDAO();
			ArrayList<ChiTietDonHang> listCTDH = ctdhDAO.selectAll();
			for (ChiTietDonHang ctdh : listCTDH) {
				if(ctdh.getDonHang().equals(DonHang)) {
					ctdh.setDonHang(null);
				}
			}
			listDonHang.remove(DonHang);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteList(ArrayList<DonHang> list) {
		int dem = 0;
		for (DonHang DonHang : list) {
			DonHang s = selectById(DonHang);
			if (s != null) {
				ChiTietDonHangDAO ctdhDAO = new ChiTietDonHangDAO();
				ArrayList<ChiTietDonHang> listCTDH = ctdhDAO.selectAll();
				for (ChiTietDonHang ctdh : listCTDH) {
					if(ctdh.getDonHang().equals(s)) {
						ctdh.setDonHang(null);
					}
				}
				listDonHang.remove(s);
				dem++;
			}
		}
		return dem;
	}

	@Override
	public int update(DonHang t) {
		DonHang DonHang = selectById(t);
		if (DonHang != null) {
			return 1;
		}
		return 0;
	}
}
