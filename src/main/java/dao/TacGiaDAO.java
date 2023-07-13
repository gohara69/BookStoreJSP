package dao;

import java.util.ArrayList;

import model.Sach;
import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia>{

	private ArrayList<TacGia> listTacGia = new ArrayList<>();
	
	@Override
	public ArrayList<TacGia> selectAll() {
		return listTacGia;
	}

	@Override
	public TacGia selectById(TacGia t) {
		for (TacGia TacGia : listTacGia) {
			if(TacGia.getMaTacGia() == t.getMaTacGia()) {
				return TacGia;
			}
		}
		return null;
	}

	@Override
	public int insert(TacGia t) {
		TacGia TacGia = selectById(t);
		if(TacGia == null) {
			listTacGia.add(TacGia);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertList(ArrayList<TacGia> list) {
		int dem = 0;
		for (TacGia TacGia : list) {
			TacGia tLoai = selectById(TacGia);
			if(tLoai == null) {
				listTacGia.add(tLoai);
				dem++;
			}
		}
		return dem;
	}

	@Override
	public int delete(TacGia t) {
		TacGia TacGia = selectById(t);
		if(TacGia != null) {
			SachDAO sachDAO = new SachDAO();
			ArrayList<Sach> listSach = sachDAO.selectAll();
			for (Sach sach : listSach) {
				if(sach.getTacGia().getMaTacGia() == TacGia.getMaTacGia()) {
					sach.setTacGia(null);
				}
			}
			listTacGia.remove(TacGia);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteList(ArrayList<TacGia> list) {
		int dem = 0;
		for (TacGia TacGia : list) {
			TacGia tgia = selectById(TacGia);
			if(tgia != null) {
				SachDAO sachDAO = new SachDAO();
				ArrayList<Sach> listSach = sachDAO.selectAll();
				for (Sach sach : listSach) {
					if(sach.getTacGia().getMaTacGia() == tgia.getMaTacGia()) {
						sach.setTacGia(null);
					}
				}
				listTacGia.remove(TacGia);
				dem++;
			}
		}
		return dem;
	}

	@Override
	public int update(TacGia t) {
		TacGia tGia = selectById(t);
		if(tGia != null) {
			tGia.setHoTen(t.getHoTen());
			tGia.setNgaySinh(t.getNgaySinh());
			tGia.setTieuSu(t.getTieuSu());
			return 1;
		}
		return 0;
	}
	
}
