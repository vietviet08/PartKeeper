package controller;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenIMG {
	public static String openIMG(JLabel labelIMG, String insert) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		fileChooser.addChoosableFileFilter(
				new FileNameExtensionFilter("*.IMAGE", "webp", "jpg", "jpeg", "gif", "png"));
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectFile = fileChooser.getSelectedFile();
			ImageIcon ii = new ImageIcon(selectFile.getAbsolutePath());
			Image i = ii.getImage();
			i = i.getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(), Image.SCALE_SMOOTH);
			labelIMG.setText("");
			labelIMG.setIcon(new ImageIcon(i));
			insert = selectFile.getAbsolutePath();
		} else
			JOptionPane.showMessageDialog(null, "Lỗi file!");
		return insert;
	}
}
