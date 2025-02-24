package dao;

import java.util.ArrayList;

import model.screen;

public class screenDAO implements DAOInterface<screen>{
	public static screenDAO getInstance() {
		return new screenDAO();
	}

	@Override
	public int insert(screen t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(screen t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(screen t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<screen> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public screen selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}
}
