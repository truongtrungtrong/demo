package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Giao diện trang chủ của chương trình
 * @author Trần Văn Hòa
 */
@SuppressWarnings("serial")
public class AppGUI extends JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenu mnuQuanLy, mnuChucNang, mnuTienIch;
	private JMenuItem mnuLop, mnuGiangVien, mnuPhong, mnuTaiKhoan, mnuDangKy, mnuHuyDangKy, mnuDangXuat, mnuDoiMatKhau;
	/**
	 * Hàm khởi tạo giao diện chính của ứng dụng
	 * @author Trần Văn Hòa
	 */
	public AppGUI() {
		khoiTaoFrame();
	}
	/**
	 * Hàm khởi tạo Frame
	 * @author Trần Văn Hòa
	 */
	private void khoiTaoFrame() {
		khoiTaoMenuBar();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(menuBar, BorderLayout.NORTH);
		setSize(800, 500);
		setVisible(true);
	}
	/**
	 * Hàm khởi tạo thanh menu bar
	 * @author Trần Văn Hòa
	 */
	private void khoiTaoMenuBar() {
		mnuLop = new JMenuItem("Lớp");
		mnuLop.addActionListener(this);
		mnuGiangVien = new JMenuItem("Giảng viên");
		mnuGiangVien.addActionListener(this);
		mnuPhong = new JMenuItem("Phòng");
		mnuPhong.addActionListener(this);
		mnuDangKy = new JMenuItem("Đăng ký");
		mnuDangKy.addActionListener(this);
		mnuHuyDangKy = new JMenuItem("Hủy đăng ký");
		mnuHuyDangKy.addActionListener(this);
		mnuDangXuat = new JMenuItem("Đăng xuất");
		mnuDangXuat.addActionListener(this);
		mnuDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		mnuDoiMatKhau.addActionListener(this);
		mnuTaiKhoan = new JMenuItem("Tài khoản");
		mnuTaiKhoan.addActionListener(this);
		
		mnuQuanLy = new JMenu("Quản lý");
		mnuChucNang = new JMenu("Chức năng");
		mnuTienIch = new JMenu("Tiện ích");
		
		mnuQuanLy.add(mnuPhong);
		mnuQuanLy.add(mnuLop);
		mnuQuanLy.add(mnuGiangVien);
		mnuQuanLy.add(mnuTaiKhoan);
		mnuQuanLy.setFont(new Font("Arial", Font.BOLD, 20));
		mnuQuanLy.setForeground(Color.WHITE);
		
		mnuChucNang.add(mnuDangKy);
		mnuChucNang.add(mnuHuyDangKy);
		mnuChucNang.setFont(new Font("Arial", Font.BOLD, 20));
		mnuChucNang.setForeground(Color.WHITE);
		
		mnuTienIch.add(mnuDangXuat);
		mnuTienIch.add(mnuDoiMatKhau);
		mnuTienIch.setFont(new Font("Arial", Font.BOLD, 20));
		mnuTienIch.setForeground(Color.WHITE);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(30, 55, 153));
		
		menuBar.add(mnuQuanLy);
		menuBar.add(mnuChucNang);
		menuBar.add(mnuTienIch);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(1);
	}

}
