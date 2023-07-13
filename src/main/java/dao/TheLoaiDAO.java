package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai>{
	@Override
	public ArrayList<TheLoai> selectAll() {
		ArrayList<TheLoai> listTheLoai = new ArrayList<>();
		DataService ds = new DataService();
		Connection connection = ds.openConnection();
		if(connection != null) {
			try {
				String sql = "Select * from TheLoai";
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					int maTheLoai = rs.getInt("maTL");
					String tenTheLoai = rs.getString("tenTL");
					
					TheLoai theLoai = new TheLoai(maTheLoai, tenTheLoai);
					listTheLoai.add(theLoai);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		ds.closeConnection();
		return listTheLoai;
	}

	@Override
	public TheLoai selectById(TheLoai t) {
		TheLoai theLoai = new TheLoai();
		DataService ds = new DataService();
		Connection connection = ds.openConnection();
		if(connection != null) {
			try {
				String sql = "Select * from theloai where maTL = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, t.getMaTheLoai());
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					theLoai.setMaTheLoai(rs.getInt("maTL"));
					theLoai.setTenTheLoai(rs.getString("tenTL"));
					return theLoai;
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
	public int insert(TheLoai t) {
		int ketQua = 0;
		DataService ds = new DataService();
		Connection connection = ds.openConnection();
		if(connection != null) {
			TheLoai theLoai = this.selectById(t);
			if(theLoai == null) {
				try {
					String sql = "Insert into theloai values(?,?)";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setInt(1, t.getMaTheLoai());
					statement.setString(2, t.getTenTheLoai());
					ketQua = statement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ketQua;
	}

	@Override
	public int insertList(ArrayList<TheLoai> list) {
		int ketQua = 0;
		DataService ds = new DataService();
		Connection connection = ds.openConnection();
		if(connection != null) {
			for (TheLoai theLoai : list) {
				TheLoai tLoai = this.selectById(theLoai);
				if(tLoai == null) {
					try {
						String sql = "Insert into theloai values(?,?)";
						PreparedStatement statement = connection.prepareStatement(sql);
						statement.setInt(1, theLoai.getMaTheLoai());
						statement.setString(2, theLoai.getTenTheLoai());
						statement.executeUpdate();
						ketQua++;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return ketQua;
	}

	@Override
	public int delete(TheLoai t) {
		TheLoai theLoai = this.selectById(t);
		if(theLoai != null) {
			DataService ds = new DataService();
			Connection connection = ds.openConnection();
			if(connection != null) {
				try {
					String sql = "delete from theloai where maTL = ?";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setInt(1, theLoai.getMaTheLoai());
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
	public int deleteList(ArrayList<TheLoai> list) {
		int dem = 0;
		for (TheLoai theLoai : list) {
			TheLoai tLoai = this.selectById(theLoai);
			if(tLoai != null) {
				DataService ds = new DataService();
				Connection connection = ds.openConnection();
				if(connection != null) {
					try {
						String sql = "delete from theloai where maTL = ?";
						PreparedStatement statement = connection.prepareStatement(sql);
						statement.setInt(1, theLoai.getMaTheLoai());
						statement.executeUpdate();
						dem++;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
				ds.closeConnection();
			}
		}
		return dem;
	}

	@Override
	public int update(TheLoai t) {
		TheLoai theLoai = this.selectById(t);
		if(theLoai != null) {
			DataService ds = new DataService();
			Connection connection = ds.openConnection();
			if(connection != null) {
				try {
					String sql = "update theloai set tenTL = ? where maTL = ?";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, t.getTenTheLoai());
					statement.setInt(2, t.getMaTheLoai());
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
	
}
