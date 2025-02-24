package controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoadIMGURL {
	private static ImageIcon urlInput(String stringURL) {
		ImageIcon ii = null;
		try {
			@SuppressWarnings("deprecation")
			URL url = new URL(stringURL);
			BufferedImage bi = ImageIO.read(url);
			ii = new ImageIcon(bi);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Lỗi: " + e);
		}
		return ii;
	}

	public static String setIMG(JTextField tfLink, JLabel labelIMG, String insert) {
		String url = tfLink.getText();
		ImageIcon ii = urlInput(url);
		Image i = ii.getImage().getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(), Image.SCALE_SMOOTH);
		ii = new ImageIcon(i);
		labelIMG.setIcon(ii);
		return insert = "";
	}

	public static String loadIMGFromDirecory(JLabel labelIMG, String insert) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.IMAGE", "webp", "jpg", "jpeg", "gif", "png"));
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectFile = fileChooser.getSelectedFile();
			ImageIcon ii = new ImageIcon(selectFile.getAbsolutePath());
			Image i = ii.getImage();
			i = i.getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(), Image.SCALE_SMOOTH);
			labelIMG.setText("");
			labelIMG.setIcon(new ImageIcon(i));
			return insert = selectFile.getAbsolutePath();
		} else {
			JOptionPane.showMessageDialog(null, "Lỗi file!");
			return null;
		}
	}

}
