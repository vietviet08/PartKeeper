package view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import font.SetFont;

public class TrangChuForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelLogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChuForm frame = new TrangChuForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TrangChuForm() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 1170, 730);
		getContentPane().setLayout(null);
		labelLogo = new JLabel("");
		labelLogo.setBounds(0, 0, 300, 300);
		ImageIcon ii = new ImageIcon(TrangChuForm.class.getResource("/icon/viequoc computer..png"));
		Image i = ii.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_SMOOTH);
		ii = new ImageIcon(i);
		labelLogo.setIcon(ii);
		getContentPane().add(labelLogo);

		JTextArea txtrChngTiL = new JTextArea();
		txtrChngTiL.setEditable(false);
		txtrChngTiL.setText(
				"Chúng tôi là một công ty chuyên cung cấp và phân phối linh kiện máy tính hàng đầu, cam kết mang đến cho khách hàng những sản phẩm chất lượng và dịch vụ xuất sắc. Với nhiều năm kinh nghiệm trong ngành, chúng tôi tự hào là đối tác tin cậy của nhiều doanh nghiệp, tổ chức và cá nhân có nhu cầu về việc nâng cấp, sửa chữa hoặc xây dựng hệ thống máy tính.\r\n\r\nDanh mục sản phẩm của chúng tôi bao gồm mọi linh kiện từ các thương hiệu nổi tiếng trên thị trường, đảm bảo đáp ứng đầy đủ nhu cầu đa dạng của khách hàng. Chất lượng sản phẩm luôn được đặt lên hàng đầu, từ ổ cứng SSD, bộ nhớ RAM, bo mạch chủ đến các linh kiện nhỏ như chuột, bàn phím.\r\n\r\nChúng tôi không chỉ cung cấp sản phẩm, mà còn mang đến dịch vụ tư vấn chuyên nghiệp từ đội ngũ nhân viên có kinh nghiệm. Đối với chúng tôi, sự hài lòng của khách hàng là ưu tiên hàng đầu. Hãy đến với chúng tôi để trải nghiệm sự thuận tiện, đa dạng và đẳng cấp trong việc mua sắm linh kiện máy tính.\r\n\r\nNgoài việc cung cấp linh kiện máy tính chất lượng, chúng tôi còn hỗ trợ khách hàng trong việc lựa chọn sản phẩm phù hợp với nhu cầu cụ thể của họ. Đội ngũ kỹ thuật viên và nhân viên tư vấn của chúng tôi sẵn sàng giải đáp mọi thắc mắc, đồng thời tư vấn về cách kết hợp linh kiện để tối ưu hóa hiệu suất hệ thống.\r\n\r\nChúng tôi tự tin với việc cung cấp giải pháp toàn diện, từ linh kiện máy tính cho desktop và laptop đến các sản phẩm và phụ kiện khác như màn hình, loa, và các thiết bị ngoại vi khác. Điều này giúp khách hàng của chúng tôi dễ dàng tìm thấy mọi thứ mà họ cần để xây dựng hoặc nâng cấp hệ thống máy tính của mình một cách linh hoạt.\r\n\r\nChất lượng dịch vụ của chúng tôi không chỉ xuất phát từ chất lượng sản phẩm, mà còn từ sự chuyên nghiệp và tận tâm trong mọi khía cạnh. Chúng tôi cam kết đáp ứng nhanh chóng mọi yêu cầu và đảm bảo rằng mọi giao dịch với chúng tôi đều diễn ra một cách suôn sẻ.\r\n\r\nHãy đến với chúng tôi để trải nghiệm không gian mua sắm linh kiện máy tính đẳng cấp, nơi mà sự đa dạng, chất lượng và dịch vụ chuyên nghiệp hứa hẹn sẽ làm hài lòng mọi khách hàng.");
		txtrChngTiL.setBounds(310, 11, 842, 459);
		txtrChngTiL.setWrapStyleWord(true);
		txtrChngTiL.setOpaque(false);
		txtrChngTiL.setLineWrap(true);
		txtrChngTiL.setFont(SetFont.fontDetails_1());
		getContentPane().add(txtrChngTiL);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openWebpage("https://www.facebook.com/viequoc24.08/");
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(TrangChuForm.class.getResource("/icon/icons8-facebook-24.png")));
		lblNewLabel.setBounds(73, 311, 30, 30);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openWebpage("https://www.instagram.com/viequoc_/");
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(TrangChuForm.class.getResource("/icon/icons8-instagram-24.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(113, 311, 30, 30);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openWebpage(" https://zalo.me/0935526710");
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(TrangChuForm.class.getResource("/icon/icons8-zalo-24.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(153, 311, 30, 30);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openWebpage("https://github.com/vietviet08");
			}
		});
		lblNewLabel_2_1.setIcon(new ImageIcon(TrangChuForm.class.getResource("/icon/icons8-github-24.png")));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(193, 311, 30, 30);
		getContentPane().add(lblNewLabel_2_1);

	}

//	public static boolean openWebpage(URI uri) {
//		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
//		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
//			try {
//				desktop.browse(uri);
//				return true;
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return false;
//	}
//
//	public static boolean openWebpage(URL url) {
//		try {
//			return openWebpage(url.toURI());
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

	@SuppressWarnings("deprecation")
	public static void openWebpage(String urlString) {
		try {
			Desktop.getDesktop().browse(new URL(urlString).toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
