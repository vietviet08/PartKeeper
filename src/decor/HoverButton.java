package decor;

import java.awt.Color;

import javax.swing.JButton;

import color.SetColor;

public class HoverButton {

	public static void hoverOK(JButton btn, boolean enter) {
		if (enter) {
			btn.setForeground(SetColor.whiteFont);
			btn.setBackground(SetColor.green);
			return;
		} else {
			btn.setForeground(Color.black);
			btn.setBackground(Color.white);
		}
	}

	public static void hoverCancel(JButton btn, boolean enter) {
		if (enter) {
			btn.setForeground(SetColor.whiteFont);
			btn.setBackground(SetColor.redB);
			return;
		} else {
			btn.setForeground(Color.black);
			btn.setBackground(Color.white);
		}
	}

}
