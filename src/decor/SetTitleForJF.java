package decor;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

public class SetTitleForJF {
	public static void setTitle(JInternalFrame jif, String res) {
		ImageIcon icon = new ImageIcon(SetTitleForJF.class.getResource(res));
		jif.setFrameIcon(icon);
		jif.setTitle("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
	}
}
