package DAO;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bean.GiangVien;
import bean.Lop;
import view.LopGUI;



@SuppressWarnings("serial")
public class All_button extends JPanel implements ActionListener {
	private JButton btnThem = new JButton("Thêm");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnXoa = new JButton("Xóa");
	private JButton btnLuu = new JButton("Lưu");
	private JButton btnHuy = new JButton("Hủy");
	private JButton btnThoat = new JButton("Thoát");
	private final ThongTinLop tt;
	private final Set_view_Lop tb;
	private final LopGUI lop;
	private boolean them = false;

	public All_button(ThongTinLop _tt, Set_view_Lop _tb, LopGUI l) {
		tt = _tt;
		tb = _tb;
		lop = l;
		setup();
		GanDL();
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 5, 0, 5);
		add(btnThem, gbc);
		gbc.gridx++;
		add(btnSua, gbc);
		gbc.gridx++;
		add(btnXoa, gbc);
		gbc.gridx++;
		add(btnLuu, gbc);
		gbc.gridx++;
		add(btnHuy, gbc);
		gbc.gridx++;
		add(btnThoat, gbc);
		DKKBT();
	}

	private void setup() {
		btnThem.setFont(new Font("Arial", Font.BOLD, 24));
		btnThem.setBackground(new Color(9, 132, 227));
		btnThem.setBorderPainted(false);
		btnThem.setFocusable(false);
		btnThem.setForeground(Color.white);
		btnThem.addActionListener(this);
		Icon icon = new ImageIcon(this.getClass().getResource("iconButton/add.png"));
		btnThem.setIcon(icon);

		btnHuy.setFont(new Font("Arial", Font.BOLD, 24));
		btnHuy.setBackground(new Color(9, 132, 227));
		btnHuy.setBorderPainted(false);
		btnHuy.setFocusable(false);
		btnHuy.setForeground(Color.white);
		btnHuy.addActionListener(this);
		icon = new ImageIcon(this.getClass().getResource("iconButton/huy.png"));
		btnHuy.setIcon(icon);

		btnSua.setFont(new Font("Arial", Font.BOLD, 24));
		btnSua.setBackground(new Color(9, 132, 227));
		btnSua.setBorderPainted(false);
		btnSua.setFocusable(false);
		btnSua.setForeground(Color.white);
		btnSua.addActionListener(this);
		icon = new ImageIcon(this.getClass().getResource("iconButton/sua.png"));
		btnSua.setIcon(icon);

		btnXoa.setFont(new Font("Arial", Font.BOLD, 24));
		btnXoa.setBackground(new Color(9, 132, 227));
		btnXoa.setBorderPainted(false);
		btnXoa.setFocusable(false);
		btnXoa.setForeground(Color.white);
		btnXoa.addActionListener(this);
		icon = new ImageIcon(this.getClass().getResource("iconButton/xoa.png"));
		btnXoa.setIcon(icon);

		btnLuu.setFont(new Font("Arial", Font.BOLD, 24));
		btnLuu.setBackground(new Color(9, 132, 227));
		btnLuu.setBorderPainted(false);
		btnLuu.setFocusable(false);
		btnLuu.setForeground(Color.white);
		btnLuu.addActionListener(this);
		icon = new ImageIcon(this.getClass().getResource("iconButton/luu.png"));
		btnLuu.setIcon(icon);

		btnThoat.setFont(new Font("Arial", Font.BOLD, 24));
		btnThoat.setBackground(new Color(9, 132, 227));
		btnThoat.setBorderPainted(false);
		btnThoat.setFocusable(false);
		btnThoat.setForeground(Color.white);
		btnThoat.addActionListener(this);
		icon = new ImageIcon(this.getClass().getResource("iconButton/close.png"));
		btnThoat.setIcon(icon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JButton) {
			JButton b = (JButton) e.getSource();
			switch (b.getText()) {
			case "Hủy":
				DKKBT();
				GanDL();
				them = false;
				break;
			case "Thêm":
				them = true;
				DKKT();
				break;
			case "Lưu":
				Luu();
				them = false;
				break;
			case "Xóa":
				Xoa();
				break;
			case "Sửa":
				DKKS();
				break;
			case "Thoát":
				lop.dispose();
				break;
			default:
				break;
			}
		}
	}

	private void GanDL() {
		int r = tb.getTable().getSelectedRow();
		tt.txtMaLop.setText(tb.getTable().getValueAt(r, 0).toString());
		tt.txtTenLop.setText(tb.getTable().getValueAt(r, 2).toString());
		String ma = tb.getTable().getValueAt(r, 1).toString();
		GiangVienDAO gvdao = new GiangVienDAO();
		ArrayList<GiangVien> list = gvdao.getGiangVien();
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getMa().compareTo(ma) == 0)
				index = i;
		}
		tt.cboGiangVien.setSelectedIndex(index);
		tt.txtSiSo.setText(tb.getTable().getValueAt(r, 3).toString());
	}

	private void DKKBT() {
		tt.DKKBT();
		tb.DKKBT();
		btnLuu.setEnabled(false);
		btnHuy.setEnabled(false);
		btnThem.setEnabled(true);
		btnSua.setEnabled(true);
		btnXoa.setEnabled(true);
		btnThoat.setEnabled(true);
	}

	private void DKKT() {
		DKKS();
		tt.DKKT();
	}

	private void DKKS() {
		tb.DKKT();
		tt.DKKS();
		btnLuu.setEnabled(true);
		btnHuy.setEnabled(true);
		btnThem.setEnabled(false);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		btnThoat.setEnabled(false);
	}

	private void Luu() {
		if (check()) {
			int row = tb.getTable().getSelectedRow();
			if (them) {
				GiangVien gv = (GiangVien) tt.cboGiangVien.getSelectedItem();
				Lop l = new Lop(tt.txtMaLop.getText(), gv.getMa(), tt.txtTenLop.getText(), Integer.parseInt(tt.txtSiSo.getText()));
				LopDAO ctrl = new LopDAO();
				int r = ctrl.ThemLop(l);
				Set_table_Lop model = new Set_table_Lop();
				tb.getTable().setModel(model);
				tb.getTable().changeSelection(row, 0, false, false);
				if (r == -1)
					JOptionPane.showMessageDialog(null, "không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "thành công", "OK", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				GiangVien gv = (GiangVien) tt.cboGiangVien.getSelectedItem();
				Lop l = new Lop(tt.txtMaLop.getText(), gv.getMa(), tt.txtTenLop.getText(), Integer.parseInt(tt.txtSiSo.getText()));
				LopDAO ctrl = new LopDAO();
				int r = ctrl.SuaLop(l);
				tb.getTable().setModel(new Set_table_Lop());
				tb.getTable().changeSelection(row, 0, false, false);
				if (r == -1)
					JOptionPane.showMessageDialog(null, "không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "thành công", "OK", JOptionPane.INFORMATION_MESSAGE);
			}
			DKKBT();
			GanDL();
		}
	};

	private void Xoa() {
		int result = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "thông báo", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null);
		if (result == JOptionPane.YES_OPTION) {
			GiangVien gv = (GiangVien) tt.cboGiangVien.getSelectedItem();
			Lop l = new Lop(tt.txtMaLop.getText(), gv.getMa(), tt.txtTenLop.getText(),
					Integer.parseInt(tt.txtSiSo.getText()));
			LopDAO ctrl = new LopDAO();
			int r = ctrl.XoaLop(l);
			Set_table_Lop model = new Set_table_Lop();
			tb.getTable().setModel(model);
			tb.getTable().changeSelection(0, 0, false, false);
			if (r == -1)
				JOptionPane.showMessageDialog(null, "Không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "thành công", "OK", JOptionPane.INFORMATION_MESSAGE);

		}
		else {
			JOptionPane.showMessageDialog(null, "Cảnh báo", "thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
		DKKBT();
		GanDL();
	}
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	private boolean check() {
		if (tt.txtMaLop.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nhập mã số", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (tt.txtTenLop.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nhập tên", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (tt.txtSiSo.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nhập số", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(!isNumeric(tt.txtSiSo.getText())) {
			JOptionPane.showMessageDialog(null, "Nhập số", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
