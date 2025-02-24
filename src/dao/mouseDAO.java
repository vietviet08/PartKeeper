package dao;

import java.util.ArrayList;

import model.mouse;

public class mouseDAO implements DAOInterface<mouse>{
	public static mouseDAO getInstance() {
		return new mouseDAO();
	}

	@Override
	public int insert(mouse t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(mouse t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(mouse t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<mouse> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public mouse selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
