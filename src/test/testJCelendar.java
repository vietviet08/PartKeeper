package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.plaf.JCalendarTheme;

public class testJCelendar extends JFrame {

	private JPanel contentPane;
	private JCalendar celendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testJCelendar frame = new testJCelendar();
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
	public testJCelendar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		celendar = new JCalendar();
		celendar.setBounds(33, 27, 351, 197);

		JDateChooser choose = new JDateChooser();
		choose.setBounds(445, 251, 185, 27);
		contentPane.add(choose);
		
		JCalendarTheme skin = new JCalendarTheme();
		
		contentPane.add(celendar);
		
	}

}
