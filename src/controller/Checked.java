package controller;

import javax.swing.JOptionPane;

public class Checked {
	public static String checkedAdd(int check, String insert) {
		if (check > 0) {
			JOptionPane.showMessageDialog(null, "Thêm thành công!");
			return insert = "";
		} else {
			JOptionPane.showMessageDialog(null, "Thêm không thành công!");
			return insert = "";
		}
	}
	
	public static String checkedUpdate(int check, String insert) {
		if (check > 0) {
			JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
			return insert = "";
		} else {
			JOptionPane.showMessageDialog(null, "Cập nhật không thành công!");
			return insert = "";
		}
	}
	
}
