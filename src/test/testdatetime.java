package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.ConvertDate;

public class testdatetime {
	public static void main(String[] args) throws InterruptedException {
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(new ClockPane());
//		frame.pack();
//		frame.setVisible(true);


		while(true) {
			
			Thread.sleep(1000);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			System.out.println(sdf.format(timestamp));
		}
		
		

	}
}

class ClockPane extends JPanel {

	private JLabel clock = new JLabel();

	public ClockPane() {
		setLayout(new BorderLayout());
		tickTock();
		add(clock);
		Timer timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tickTock();
			}
		});
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.setInitialDelay(0);
		timer.start();
	}

	public void tickTock() {
		clock.setText(DateFormat.getDateTimeInstance().format(new Date()));
	}

}
