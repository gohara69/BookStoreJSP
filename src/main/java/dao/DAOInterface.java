package dao;

import java.util.ArrayList;

public interface DAOInterface<T> {
	public ArrayList<T> selectAll();
	public T selectById(T t);
	public int insert(T t);
	public int insertList(ArrayList<T> list);
	public int delete(T t);
	public int deleteList(ArrayList<T> list);
	public int update(T t);
}
