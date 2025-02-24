package controller;

import java.util.ArrayList;

public interface TimKiemInterface<T> {
	public ArrayList<T> byIDSP(String key);

	public ArrayList<T> byIDRieng(String key);

	public ArrayList<T> byTen(String key);

	public ArrayList<T> byHang(String key);

	public ArrayList<T> byTonKho(String key);

	public ArrayList<T> byGia(String key);

	public ArrayList<T> byBaoHanh(String key);

}
