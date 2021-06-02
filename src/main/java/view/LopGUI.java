package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import DAO.All_button;
import DAO.Set_view_Lop;
import DAO.ThongTinLop;

@SuppressWarnings("serial")
public class LopGUI extends JFrame {
	private ThongTinLop thongtin;
	private Set_view_Lop table;
	private All_button dk;
	private JLabel title = new JLabel("QUẢN LÝ LỚP HỌC");

	public LopGUI() {
		thongtin = new ThongTinLop();
		table = new Set_view_Lop(thongtin);
		dk = new All_button(thongtin, table, this);
		title.setFont(new Font("Arial", Font.BOLD, 50));
		setSize(1200, 500);
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(10, 0, 20, 0);
		getContentPane().add(title, gbc);
		
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridy++;
		gbc.weightx = 0.2;
		gbc.weighty = 0.33;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		getContentPane().add(thongtin, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridy++;
		getContentPane().add(dk, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx++;
		gbc.gridy = 1;
		gbc.weightx = 0.8;
		gbc.weighty = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 3;
		getContentPane().add(table, gbc);
		ImageIcon icon = new ImageIcon(this.getClass().getResource("icon/icon.png"));
		setIconImage(icon.getImage());
		setTitle("Quản lý lớp học");
		setVisible(true);
	}

}
