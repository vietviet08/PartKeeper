package controller;

import java.util.ArrayList;

import dao.cpuDAO;
import model.cpu;

public class TimKiemCPU {
	public static ArrayList<cpu> byID(String key) {
		ArrayList<cpu> list = new ArrayList<cpu>();
		ArrayList<cpu> listcpu = cpuDAO.getInstance().selectAll();
		for (cpu cpu : listcpu) {
			if (cpu.getIdSanPham().toLowerCase().contains(key.toLowerCase())) {
				list.add(cpu);
			}
		}
		return list;
	}
	
	public static ArrayList<cpu> byIDCPU(String key) {
		ArrayList<cpu> list = new ArrayList<cpu>();
		ArrayList<cpu> listcpu = cpuDAO.getInstance().selectAll();
		for (cpu cpu : listcpu) {
			if (cpu.getIdCpu().toLowerCase().contains(key.toLowerCase())) {
				list.add(cpu);
			}
		}
		return list;
	}	

	public static ArrayList<cpu> byTen(String key) {
		ArrayList<cpu> list = new ArrayList<cpu>();
		ArrayList<cpu> listcpu = cpuDAO.getInstance().selectAll();
		for (cpu cpu : listcpu) {
			if (cpu.getNameCpu().toLowerCase().contains(key.toLowerCase())) {
				list.add(cpu);
			}
		}
		return list;
	}

	public static ArrayList<cpu> byXungNhip(String key) {
		ArrayList<cpu> list = new ArrayList<cpu>();
		ArrayList<cpu> listcpu = cpuDAO.getInstance().selectAll();
		for (cpu cpu : listcpu) {
			if (cpu.getXungNhip().toLowerCase().contains(key.toLowerCase())) {
				list.add(cpu);
			}
		}
		return list;
	}

	public static ArrayList<cpu> bySoNhan(String key) {
		ArrayList<cpu> list = new ArrayList<cpu>();
		ArrayList<cpu> listcpu = cpuDAO.getInstance().selectAll();
		for (cpu cpu : listcpu) {
			if (String.valueOf(cpu.getSoNhan()).contains(key.toLowerCase())) {
				list.add(cpu);
			}
		}
		return list;
	}

	public static ArrayList<cpu> bySoLuong(String key) {
		ArrayList<cpu> list = new ArrayList<cpu>();
		ArrayList<cpu> listcpu = cpuDAO.getInstance().selectAll();
		for (cpu cpu : listcpu) {
			if (String.valueOf(cpu.getSoLuong()).contains(key.toLowerCase())) {
				list.add(cpu);
			}
		}
		return list;
	}

	public static ArrayList<cpu> byDienNang(String key) {
		ArrayList<cpu> list = new ArrayList<cpu>();
		ArrayList<cpu> listcpu = cpuDAO.getInstance().selectAll();
		for (cpu cpu : listcpu) {
			if (cpu.getDienNangTieuThu().toLowerCase().contains(key.toLowerCase())) {
				list.add(cpu);
			}
		}
		return list;
	}

	public static ArrayList<cpu> byBoNhoDem(String key) {
		ArrayList<cpu> list = new ArrayList<cpu>();
		ArrayList<cpu> listcpu = cpuDAO.getInstance().selectAll();
		for (cpu cpu : listcpu) {
			if (cpu.getBoNhoDem().toLowerCase().contains(key.toLowerCase())) {
				list.add(cpu);
			}
		}
		return list;
	}
	
	public static ArrayList<cpu> byTonKho(String key) {
		ArrayList<cpu> list = new ArrayList<cpu>();
		ArrayList<cpu> listcpu = cpuDAO.getInstance().selectAll();
		for (cpu cpu : listcpu) {
			if (String.valueOf(cpu.getTonKho()).contains(key.toLowerCase())) {
				list.add(cpu);
			}
		}
		return list;
	}

	public static ArrayList<cpu> byGia(String key) {
		ArrayList<cpu> list = new ArrayList<cpu>();
		ArrayList<cpu> listcpu = cpuDAO.getInstance().selectAll();
		for (cpu cpu : listcpu) {
			if (String.valueOf(cpu.getDonGia()).contains(key.toLowerCase())) {
				list.add(cpu);
			}
		}
		return list;
	}
}
