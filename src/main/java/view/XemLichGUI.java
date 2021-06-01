package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mindfusion.scheduling.Calendar;

@SuppressWarnings("serial")
public class XemLichGUI extends JFrame {
	Calendar calendar = new Calendar();
//	JLabel title = new JLabel("Xem lịch");
	public XemLichGUI() {
		khoiTaoFrame();
	}
	private void khoiTaoFrame() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		getContentPane().add(calendar, gbc);
		setBounds(300, 100, 1200, 800);
		ImageIcon icon = new ImageIcon(getClass().getResource("icon/icon.png"));
		setIconImage(icon.getImage());
		setTitle("Xem lịch");
		setVisible(true);
	}
}
