package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.accountBLL;
import BLL.nhanvienBLL;
import DTO.nhanvien;
import Check.Tester;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class nhanvienGUI extends JFrame {

	List<nhanvien> nhanvienList = new ArrayList<nhanvien>();
	nhanvienBLL nvBLL = new nhanvienBLL();
	accountBLL aBLL = new accountBLL();

	private JTextField tfnhanvienCode;
	private JTextField tfnhanvienName;
	private JTextField tfnhanvienAddress;
	private JTextField tfnhanvienBirthday;
	private JTextField tfFind;
	DefaultTableModel model = new DefaultTableModel();
	private JPanel contentPane;
	private JTable table;
	private JComboBox cbGioiTinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nhanvienGUI frame = new nhanvienGUI();
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
	public nhanvienGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1234, 695);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 47, 1220, 47);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("DANH S??CH NH??N VI??N");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(339, 10, 334, 32);
		panel.add(lblNewLabel);

		tfFind = new JTextField();
		tfFind.setBounds(813, 10, 221, 30);
		panel.add(tfFind);
		tfFind.setColumns(10);

		JButton btnSearch = new JButton("T??m ki???m");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSearch_actionPerformed(e);
			}
		});
		btnSearch.setBounds(1033, 10, 85, 31);
		panel.add(btnSearch);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(0, 95, 493, 568);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("M?? nh??n vi??n");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(26, 34, 97, 42);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("T??n nh??n vi??n");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(26, 97, 108, 42);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("?????a ch???");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(26, 157, 97, 42);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_2 = new JLabel("Gi???i t??nh");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(26, 223, 97, 42);
		panel_1.add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_3 = new JLabel("Ng??y sinh");
		lblNewLabel_1_2_3.setForeground(Color.BLACK);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_3.setBounds(26, 294, 97, 42);
		panel_1.add(lblNewLabel_1_2_3);

		tfnhanvienCode = new JTextField();
		tfnhanvienCode.setEditable(false);
		tfnhanvienCode.setBounds(157, 34, 299, 32);
		panel_1.add(tfnhanvienCode);
		tfnhanvienCode.setColumns(10);
		tfnhanvienCode.setText(String.valueOf(nvBLL.getMaNV()));

		tfnhanvienName = new JTextField();
		tfnhanvienName.setColumns(10);
		tfnhanvienName.setBounds(157, 104, 299, 32);
		panel_1.add(tfnhanvienName);

		tfnhanvienAddress = new JTextField();
		tfnhanvienAddress.setColumns(10);
		tfnhanvienAddress.setBounds(157, 164, 299, 32);
		panel_1.add(tfnhanvienAddress);

		cbGioiTinh = new JComboBox();
		cbGioiTinh.setModel(new DefaultComboBoxModel(new String[] { "Nam", "N??? ", "Kh??c" }));
		cbGioiTinh.setBounds(157, 229, 299, 33);
		panel_1.add(cbGioiTinh);

		tfnhanvienBirthday = new JTextField();
		tfnhanvienBirthday.setColumns(10);
		tfnhanvienBirthday.setBounds(157, 301, 299, 32);
		panel_1.add(tfnhanvienBirthday);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReset_actionPerformed(e);
			}
		});
		btnReset.setBounds(26, 464, 85, 42);
		panel_1.add(btnReset);

		JButton btnRemove = new JButton("X??a");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRemove_actionPerformed(e);
			}
		});
		btnRemove.setBounds(140, 464, 85, 42);
		panel_1.add(btnRemove);

		JButton btnEdit = new JButton("S???a");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnEdit_actionPerformed(e);
			}
		});
		btnEdit.setBounds(254, 464, 85, 42);
		panel_1.add(btnEdit);

		JButton btnAdd = new JButton("Th??m");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		btnAdd.setBounds(371, 464, 85, 42);
		panel_1.add(btnAdd);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(492, 95, 728, 568);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_table_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("M?? nh??n vi??n");
		model.addColumn("T??n nh??n vi??n");
		model.addColumn("?????a ch???");
		model.addColumn("Gi???i t??nh");
		model.addColumn("Ng??y sinh");
		displayList();

		JButton btnGoBack = new JButton("Tr??? l???i");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGoBack_actionPerformed(e);
			}
		});
		btnGoBack.setBounds(0, 0, 106, 48);
		contentPane.add(btnGoBack);
	}

	private void displayList() {
		model.setRowCount(0);
		nhanvienList = nvBLL.getAllnhanvien();
		int i = 0;
		while (i < nhanvienList.size()) {
			nhanvien p = nhanvienList.get(i);
			model.addRow(new Object[] { model.getRowCount() + 1, p.getManv(), p.getTennv(), p.getDiachi(),
					p.getGioitinh(), p.getNgaysinh() });
			i++;
		}

	}

	protected void do_btnReset_actionPerformed(ActionEvent e) {
		tfnhanvienCode.setText(String.valueOf(nvBLL.getMaNV()));
		tfnhanvienName.setText("");
		tfnhanvienAddress.setText("");
		cbGioiTinh.setSelectedIndex(0);
		tfnhanvienBirthday.setText("");
		tfFind.setText("");
		displayList();
	}

	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		if (!tfnhanvienCode.getText().trim().equals("") && !tfnhanvienName.getText().trim().equals("")
				&& !tfnhanvienBirthday.getText().trim().equals("") && !tfnhanvienAddress.getText().trim().equals("")) {
			try {

				int code = Integer.parseInt(tfnhanvienCode.getText());
				String name = tfnhanvienName.getText();
				String birth = tfnhanvienBirthday.getText();
				Tester t = new Tester();
				if (!t.day(birth)) {
					JOptionPane.showMessageDialog(null, "Ng??y sinh kh??ng h???p l???");
					return;
				}
				String address = tfnhanvienAddress.getText();
				String gioitinh = cbGioiTinh.getSelectedItem().toString();
				nhanvien s = new nhanvien(code, name, address, gioitinh, birth);
				JOptionPane.showMessageDialog(null, nvBLL.addnhanvien(s));
				displayList();
				do_btnReset_actionPerformed(e);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "B???n ???? nh???p sai d??? li???u. Vui l??ng th??? l???i");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui l??ng nh???p ?????y ????? th??ng tin c???a nh??n vi??n");
		}
	}

	protected void do_btnEdit_actionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if (index >= 0 && !tfnhanvienCode.getText().trim().equals("") && !tfnhanvienName.getText().trim().equals("")
					&& !tfnhanvienBirthday.getText().trim().equals("")
					&& !tfnhanvienAddress.getText().trim().equals("")) {
				nhanvien p = new nhanvien();
				p.setManv(Integer.parseInt(tfnhanvienCode.getText()));
				p.setTennv(tfnhanvienName.getText());
				p.setDiachi(tfnhanvienAddress.getText());
				p.setGioitinh(cbGioiTinh.getSelectedItem().toString());
				p.setNgaysinh(tfnhanvienBirthday.getText());
				if (!Tester.day(p.getNgaysinh())) {
					JOptionPane.showMessageDialog(null, "Vui l??ng nh???p ????ng ?????nh d???ng c???a ng??y");
					return;
				}
				JOptionPane.showMessageDialog(null, nvBLL.editnhanvien(p));
				displayList();
				do_btnReset_actionPerformed(e);
			} else {
				JOptionPane.showMessageDialog(null, "Vui l??ng ch???n nh??n vi??n ????? s???a");
			}

		} catch (InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui l??ng nh???p ?????y ????? th??ng tin c???a nh??n vi??n");
		}
	}

	protected void do_btnRemove_actionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
		if (selectedIndex >= 0 && !tfnhanvienCode.getText().equals("")) {
			int code = Integer.parseInt(tfnhanvienCode.getText());
//            Product p = productList.get(selectedIndex);

			int option = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n x??a nh??n vi??n n??y kh??ng?", "Question",
					JOptionPane.YES_NO_OPTION);

			if (option == JOptionPane.YES_OPTION) {
				int sure = JOptionPane.showConfirmDialog(null, "B???n c?? ch???c ch???n mu???n x??a nh??n vi??n n??y kh??ng?",
						"Question", JOptionPane.YES_NO_OPTION);
				if (sure == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, nvBLL.deletenhanvien(code));
					displayList();
					do_btnReset_actionPerformed(e);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui l??ng ch???n nh??n vi??n ????? x??a");
		}
	}

	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		String nhanvienName = tfFind.getText();
		if (nhanvienName != null && nhanvienName.length() > 0) {
			nhanvienList = nvBLL.searchnhanvienByName(nhanvienName);

			if (nhanvienList.size() == 0) {
				JOptionPane.showMessageDialog(null, "Kh??ng c?? nh??n vi??n b???n c???n t??m");
				displayList();
			}

			else {
				model.setRowCount(0);
				int i = 0;
				while (i < nhanvienList.size()) {
					nhanvien p = nhanvienList.get(i);
					model.addRow(new Object[] { model.getRowCount() + 1, p.getManv(), p.getTennv(), p.getDiachi(),
							p.getGioitinh(), p.getNgaysinh() });
					i++;
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Vui l??ng nh???p t??n nh??n vi??n c???p ????? t??m ki???m");
		}
	}

	protected void do_table_mouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
		if (selectedIndex >= 0) {
			tfnhanvienCode.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
			tfnhanvienName.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
			tfnhanvienAddress.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
			cbGioiTinh.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 4)));
			tfnhanvienBirthday.setText(String.valueOf(model.getValueAt(selectedIndex, 5)));

		}
	}

	protected void do_btnGoBack_actionPerformed(ActionEvent e) {
		if (loginGUI.permission.equals("Gi??m ?????c")) {
			adminGUI p = new adminGUI();
			p.setVisible(true);
		} else if (loginGUI.permission.equals("Qu???n tr??? h??? th???ng")) {
			quantriGUI p = new quantriGUI();
			p.setVisible(true);
		} else if (loginGUI.permission.equals("B??c s??")) {
			doctorGUI p = new doctorGUI();
			p.setVisible(true);
		} else {
			employeeGUI p = new employeeGUI();
			p.setVisible(true);
			;
		}
		this.setVisible(false);
	}
}
