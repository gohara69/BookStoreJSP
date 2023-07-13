package dao;

import java.util.ArrayList;

import model.ChiTietDonHang;
import model.Sach;

public class SachDAO implements DAOInterface<Sach> {
	private ArrayList<Sach> listSach = new ArrayList<>();

	@Override
	public ArrayList<Sach> selectAll() {
		return listSach;
	}

	@Override
	public Sach selectById(Sach t) {
		for (Sach Sach : listSach) {
			if (Sach.getMaSach() == t.getMaSach()) {
				return Sach;
			}
		}
		return null;
	}

	@Override
	public int insert(Sach t) {
		Sach sach = selectById(t);
		if (sach == null) {
			listSach.add(sach);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertList(ArrayList<Sach> list) {
		int dem = 0;
		for (Sach sach : list) {
			Sach s = selectById(sach);
			if (s == null) {
				listSach.add(s);
				dem++;
			}
		}
		return dem;
	}

	@Override
	public int delete(Sach t) {
		Sach sach = selectById(t);
		if (sach != null) {
			ChiTietDonHangDAO ctdhDAO = new ChiTietDonHangDAO();
			ArrayList<ChiTietDonHang> listCTDH = ctdhDAO.selectAll();
			for (ChiTietDonHang ctdh : listCTDH) {
				if(ctdh.getSach().equals(sach)) {
					ctdh.setSach(null);
				}
			}
			listSach.remove(sach);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteList(ArrayList<Sach> list) {
		int dem = 0;
		for (Sach sach : list) {
			Sach s = selectById(sach);
			if (s != null) {
				ChiTietDonHangDAO ctdhDAO = new ChiTietDonHangDAO();
				ArrayList<ChiTietDonHang> listCTDH = ctdhDAO.selectAll();
				for (ChiTietDonHang ctdh : listCTDH) {
					if(ctdh.getSach().equals(s)) {
						ctdh.setSach(null);
					}
				}
				listSach.remove(s);
				dem++;
			}
		}
		return dem;
	}

	@Override
	public int update(Sach t) {
		Sach sach = selectById(t);
		if (sach != null) {
			sach.setGiaBan(t.getGiaBan());
			sach.setGiaGoc(t.getGiaGoc());
			sach.setGiaNhap(t.getGiaNhap());
			sach.setMoTa(t.getMoTa());
			sach.setNamXuatBan(t.getNamXuatBan());
			sach.setNgonNgu(t.getNgonNgu());
			sach.setSoLuong(t.getSoLuong());
			sach.setTacGia(t.getTacGia());
			sach.setTenSach(t.getTenSach());
			sach.setTheLoai(t.getTheLoai());
			return 1;
		}
		return 0;
	}
}
