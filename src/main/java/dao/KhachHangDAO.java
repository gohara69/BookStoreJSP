package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DonHang;
import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang>{

    private ArrayList<KhachHang> listKhachHang = new ArrayList<>();
    @Override
	public ArrayList<KhachHang> selectAll() {
		return listKhachHang;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		KhachHang KhachHang = new KhachHang();
		DataService ds = new DataService();
		Connection connection = ds.openConnection();
		if(connection != null) {
			try {
				String sql = "Select * from KhachHang where maKH = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, t.getMaKhachHang());
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					KhachHang.setMaKhachHang(rs.getInt("maKH"));
					KhachHang.setHoTen(rs.getString("tenKH"));
					KhachHang.setTenDangNhap(rs.getString("tenDN"));
					KhachHang.setMatKhau(rs.getString("matKhau"));
					KhachHang.setGioiTinh(rs.getBoolean("gioiTinh"));
					KhachHang.setDiaChi(rs.getString("diaChi"));
					KhachHang.setDiaChiNhanHang(rs.getString("diaChiNhanHang"));
					KhachHang.setDiaChiMuaHang(rs.getString("diaChiMuaHang"));
					KhachHang.setNgaySinh(rs.getDate("NgaySinh"));
					KhachHang.setSoDienThoai(rs.getString("soDienThoai"));
					KhachHang.setEmail(rs.getString("email"));
					KhachHang.setDangKyNhanEmail(rs.getBoolean("dangKyNhanEmail"));
					return KhachHang;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ds.closeConnection();
		return null;
	}

	@Override
	public int insert(KhachHang t) {
		KhachHang KhachHang = selectById(t);
		if (KhachHang == null) {
			DataService ds = new DataService();
			Connection connection = ds.openConnection();
			if(connection != null) {
				try {
					String sql = "insert into khachhang values(?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setInt(1, this.getLatestCustomerId());
					statement.setString(2, t.getHoTen());
					statement.setString(3, t.getTenDangNhap());
					statement.setString(4, t.getMatKhau()); 
					statement.setInt(5 ,t.isGioiTinh()==true?1:0);
					statement.setString(6, t.getDiaChi());
					statement.setString(7, t.getDiaChiNhanHang());
					statement.setString(8, t.getDiaChiMuaHang());
					statement.setDate(9, t.getNgaySinh());
					statement.setString(10, t.getSoDienThoai());
					statement.setString(11, t.getEmail());
					statement.setInt(12, t.isDangKyNhanEmail()==true?1:0);
					return statement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ds.closeConnection();
		}
		return 0;
	}

	@Override
	public int insertList(ArrayList<KhachHang> list) {
		int dem = 0;
		for (KhachHang KhachHang : list) {
			KhachHang s = selectById(KhachHang);
			if (s == null) {
				listKhachHang.add(s);
				dem++;
			}
		}
		return dem;
	}

	@Override
	public int delete(KhachHang t) {
		KhachHang KhachHang = selectById(t);
		if (KhachHang != null) {
			DonHangDAO donHangDAO = new DonHangDAO();
			ArrayList<DonHang> listDonHang = donHangDAO.selectAll();
			for (DonHang donHang : listDonHang) {
				if(donHang.getKhachHang().equals(KhachHang)) {
					donHang.setKhachHang(null);
					listKhachHang.remove(KhachHang);
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public int deleteList(ArrayList<KhachHang> list) {
		int dem = 0;
		for (KhachHang KhachHang : list) {
			KhachHang s = selectById(KhachHang);
			if (s != null) {
				DonHangDAO donHangDAO = new DonHangDAO();
				ArrayList<DonHang> listDonHang = donHangDAO.selectAll();
				for (DonHang donHang : listDonHang) {
					if(donHang.getKhachHang().equals(s)) {
						donHang.setKhachHang(null);
						listKhachHang.remove(s);
						dem++;
					}
				}
			}
		}
		return dem;
	}

	@Override
	public int update(KhachHang t) {
		KhachHang KhachHang = selectById(t);
		if (KhachHang != null) {
			return 1;
		}
		return 0;
	}
	
	public static boolean checkAlreadyHaveUsername(String username) {
		DataService ds = new DataService();
		Connection connection = ds.openConnection();
		if(connection != null) {
			try {
				String sql = "Select * from khachhang where tenDN = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, username);
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
		
	public int getLatestCustomerId() {
		DataService ds = new DataService();
		Connection connection = ds.openConnection();
		if(connection != null) {
			try {
				String sql = "SELECT maKH + 1 AS 'maKH' FROM khachhang ORDER BY maKH DESC LIMIT 1";
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					return rs.getInt("maKH");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public KhachHang selectByUsernamePasssword(KhachHang t) {
		KhachHang KhachHang = new KhachHang();
		DataService ds = new DataService();
		Connection connection = ds.openConnection();
		if(connection != null) {
			try {
				String sql = "SELECT * FROM khachhang WHERE tenDN = ? AND matKhau = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, t.getTenDangNhap());
				statement.setString(2, t.getMatKhau());
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					KhachHang.setMaKhachHang(rs.getInt("maKH"));
					KhachHang.setHoTen(rs.getString("tenKH"));
					KhachHang.setTenDangNhap(rs.getString("tenDN"));
					KhachHang.setMatKhau(rs.getString("matKhau"));
					KhachHang.setGioiTinh(rs.getBoolean("gioiTinh"));
					KhachHang.setDiaChi(rs.getString("diaChi"));
					KhachHang.setDiaChiNhanHang(rs.getString("diaChiNhanHang"));
					KhachHang.setDiaChiMuaHang(rs.getString("diaChiMuaHang"));
					KhachHang.setNgaySinh(rs.getDate("NgaySinh"));
					KhachHang.setSoDienThoai(rs.getString("soDienThoai"));
					KhachHang.setEmail(rs.getString("email"));
					KhachHang.setDangKyNhanEmail(rs.getBoolean("dangKyNhanEmail"));
					return KhachHang;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ds.closeConnection();
		return null;
	}
	
	public static int updatePassword(KhachHang t) {
		KhachHang KhachHang = new KhachHang();
		DataService ds = new DataService();
		Connection connection = ds.openConnection();
		if(connection != null) {
			try {
				String sql = "UPDATE khachhang SET matKhau = ? WHERE maKH = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, t.getMatKhau());
				statement.setInt(2, t.getMaKhachHang());
				return statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ds.closeConnection();
		return 0;
	}
}
