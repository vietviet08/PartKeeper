package controller;

import java.util.ArrayList;

import dao.caseDAO;
import dao.cpuDAO;
import dao.hddDAO;
import dao.mainDAO;
import dao.psuDAO;
import dao.ramDAO;
import dao.ssdDAO;
import dao.vgaDAO;
import model.Case;
import model.cpu;
import model.hdd;
import model.mainboard;
import model.psu;
import model.ram;
import model.ssd;
import model.vga;

public class TimKiemNhapHang {
	public static ArrayList<cpu> byCPU(String key) {
		ArrayList<cpu> list = new ArrayList<cpu>();
		ArrayList<cpu> cpus = cpuDAO.getInstance().selectAll();
		for (cpu cpu : cpus) {
			if (cpu.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| cpu.getIdCpu().toLowerCase().contains(key.toLowerCase())
					|| cpu.getNameCpu().toLowerCase().contains(key.toLowerCase())
					|| cpu.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(cpu.getTonKho()).contains(key) || String.valueOf(cpu.getDonGia()).contains(key))
				list.add(cpu);
		}
		return list;
	}

	public static ArrayList<ram> byRAM(String key) {
		ArrayList<ram> list = new ArrayList<ram>();
		ArrayList<ram> rams = ramDAO.getInstance().selectAll();
		for (ram ram : rams) {
			if (ram.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| ram.getIdRam().toLowerCase().contains(key.toLowerCase())
					|| ram.getTenRam().toLowerCase().contains(key.toLowerCase())
					|| ram.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(ram.getTonkho()).contains(key) || String.valueOf(ram.getDonGia()).contains(key))
				list.add(ram);
		}
		return list;
	}

	public static ArrayList<vga> byVGA(String key) {
		ArrayList<vga> list = new ArrayList<vga>();
		ArrayList<vga> vgas = vgaDAO.getInstance().selectAll();
		for (vga vga : vgas) {
			if (vga.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| vga.getIdVga().toLowerCase().contains(key.toLowerCase())
					|| vga.getTenVGA().toLowerCase().contains(key.toLowerCase())
					|| vga.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(vga.getTonKho()).contains(key) || String.valueOf(vga.getDonGia()).contains(key))
				list.add(vga);
		}
		return list;
	}

	public static ArrayList<mainboard> byMainboard(String key) {
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		ArrayList<mainboard> mainboards = mainDAO.getInstance().selectAll();
		for (mainboard mainboard : mainboards) {
			if (mainboard.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| mainboard.getIdMainboard().toLowerCase().contains(key.toLowerCase())
					|| mainboard.getTenMain().toLowerCase().contains(key.toLowerCase())
					|| mainboard.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(mainboard.getTonKho()).contains(key)
					|| String.valueOf(mainboard.getDonGia()).contains(key))
				list.add(mainboard);
		}
		return list;
	}

	public static ArrayList<Case> byCase(String key) {
		ArrayList<Case> list = new ArrayList<Case>();
		ArrayList<Case> Cases = caseDAO.getInstance().selectAll();
		for (Case Case : Cases) {
			if (Case.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| Case.getIdCase().toLowerCase().contains(key.toLowerCase())
					|| Case.getTenCase().toLowerCase().contains(key.toLowerCase())
					|| Case.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(Case.getTonKho()).contains(key) || String.valueOf(Case.getGia()).contains(key))
				list.add(Case);
		}
		return list;
	}

	public static ArrayList<psu> byNguon(String key) {
		ArrayList<psu> list = new ArrayList<psu>();
		ArrayList<psu> psus = psuDAO.getInstance().selectAll();
		for (psu psu : psus) {
			if (psu.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| psu.getIdNguon().toLowerCase().contains(key.toLowerCase())
					|| psu.getTenNguon().toLowerCase().contains(key.toLowerCase())
					|| psu.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(psu.getTonKho()).contains(key) || String.valueOf(psu.getDonGia()).contains(key))
				list.add(psu);
		}
		return list;
	}

	public static ArrayList<ssd> bySSD(String key) {
		ArrayList<ssd> list = new ArrayList<ssd>();
		ArrayList<ssd> ssds = ssdDAO.getInstance().selectAll();
		for (ssd ssd : ssds) {
			if (ssd.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| ssd.getIdSdd().toLowerCase().contains(key.toLowerCase())
					|| ssd.getTenSsd().toLowerCase().contains(key.toLowerCase())
					|| ssd.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(ssd.getTonKho()).contains(key) || String.valueOf(ssd.getGia()).contains(key))
				list.add(ssd);
		}
		return list;
	}

	public static ArrayList<hdd> byHDD(String key) {
		ArrayList<hdd> list = new ArrayList<hdd>();
		ArrayList<hdd> hdds = hddDAO.getInstance().selectAll();
		for (hdd hdd : hdds) {
			if (hdd.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| hdd.getIdhHdd().toLowerCase().contains(key.toLowerCase())
					|| hdd.getTenHdd().toLowerCase().contains(key.toLowerCase())
					|| hdd.getBaoHanh().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(hdd.getTonKho()).contains(key) || String.valueOf(hdd.getGia()).contains(key))
				list.add(hdd);
		}
		return list;
	}

}
