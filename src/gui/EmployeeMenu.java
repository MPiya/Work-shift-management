package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.EmployeeController;
import db.DBConnection;
import db.DataAccessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.Label;

public class EmployeeMenu extends JFrame {
	
	private static final String selectAllE =" select * from Employee";
	private PreparedStatement selectAll;
	private JPanel contentPane;
	private JTextField txtInsertFirstName;
	private JTextField txtInsertLastName;
	private JTextField txtInsertAddress;
	private JTextField txtInsertPhoneNumber;
	private JTextField txtInsertEmployeeId;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtInsertAddress_1;
	private JTextField txtInsertP;
	private JTextField txtInsertEmployeeId_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeMenu frame = new EmployeeMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public EmployeeMenu() throws SQLException {
		
		selectAll = DBConnection.getInstance().getConnection().prepareStatement(selectAllE); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 637, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtInsertFirstName = new JTextField();
		txtInsertFirstName.setText("Insert first name");
		txtInsertFirstName.setBounds(10, 58, 96, 19);
		contentPane.add(txtInsertFirstName);
		txtInsertFirstName.setColumns(10);
		
		txtInsertLastName = new JTextField();
		txtInsertLastName.setText("Insert last name");
		txtInsertLastName.setBounds(10, 95, 96, 19);
		contentPane.add(txtInsertLastName);
		txtInsertLastName.setColumns(10);
		
		txtInsertAddress = new JTextField();
		txtInsertAddress.setText("Insert address");
		txtInsertAddress.setBounds(10, 131, 96, 19);
		contentPane.add(txtInsertAddress);
		txtInsertAddress.setColumns(10);
		
		txtInsertPhoneNumber = new JTextField();
		txtInsertPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		txtInsertPhoneNumber.setText("Insert phone number");
		txtInsertPhoneNumber.setBounds(10, 171, 119, 19);
		contentPane.add(txtInsertPhoneNumber);
		txtInsertPhoneNumber.setColumns(9);
		
		JButton btnNewButton = new JButton("Create Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String firstN=txtInsertFirstName.getText();
			String lastN=txtInsertLastName.getText();
			String address=txtInsertAddress.getText();
			String phoneN=txtInsertPhoneNumber.getText();
			
			EmployeeController employeeCtrl;
			try {
				employeeCtrl = new EmployeeController();
				employeeCtrl.createEmployeeinDB(firstN, lastN, address, phoneN);
			} catch (DataAccessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			
			
			}
		});
		btnNewButton.setBounds(10, 211, 133, 30);
		contentPane.add(btnNewButton);
		
		txtInsertEmployeeId = new JTextField();
		txtInsertEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
		txtInsertEmployeeId.setText("Insert Id");
		txtInsertEmployeeId.setBounds(369, 58, 85, 47);
		contentPane.add(txtInsertEmployeeId);
		txtInsertEmployeeId.setColumns(10);
		
		btnNewButton_1 = new JButton("Delete Employee");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				String delete = txtInsertEmployeeId.getText();
				int toIDdelete =Integer.parseInt(delete);
				EmployeeController deleteEm;
				try {
					deleteEm = new EmployeeController();
					deleteEm.deleteEmployee(toIDdelete);

					JOptionPane.showMessageDialog(null, "The customer is deleted ");
				} catch (DataAccessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(351, 127, 138, 26);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Create Employee");
		lblNewLabel.setBounds(10, 24, 133, 24);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Delete Employee");
		lblNewLabel_1.setBounds(375, 18, 130, 36);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Employee Menu");
		lblNewLabel_2.setBounds(188, -13, 96, 47);
		contentPane.add(lblNewLabel_2);
		
		txtInsertAddress_1 = new JTextField();
		txtInsertAddress_1.setText("Insert address");
		txtInsertAddress_1.setBounds(173, 58, 132, 39);
		contentPane.add(txtInsertAddress_1);
		txtInsertAddress_1.setColumns(10);
		
		txtInsertP = new JTextField();
		txtInsertP.setText("Insert phone number");
		txtInsertP.setBounds(174, 107, 131, 34);
		contentPane.add(txtInsertP);
		txtInsertP.setColumns(10);
		
		txtInsertEmployeeId_1 = new JTextField();
		txtInsertEmployeeId_1.setText("Insert Employee ID");
		txtInsertEmployeeId_1.setBounds(174, 151, 131, 41);
		contentPane.add(txtInsertEmployeeId_1);
		txtInsertEmployeeId_1.setColumns(10);
		
		btnNewButton_2 = new JButton("Change");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String address1 = txtInsertAddress_1.getText();
				String phoneP= txtInsertP.getText();
				String emID =  txtInsertEmployeeId_1.getText();
				int emploID = Integer.parseInt(emID);
				EmployeeController emp;
				try {
					emp = new 	EmployeeController();
					emp.updatePhoneAndAddress(address1, phoneP, emploID);
					JOptionPane.showMessageDialog(null," The customer is changed");
				} catch (DataAccessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_2.setBounds(173, 213, 125, 26);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_3 = new JLabel("Change address & phone number");
		lblNewLabel_3.setBounds(156, 23, 236, 26);
		contentPane.add(lblNewLabel_3);
		
		btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu main = new MainMenu();
				main.setVisible(true);
			}
			
		});
		btnNewButton_3.setBounds(10, 565, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(20, 251, 469, 291);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_4 = new JButton("Displey Employee");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = selectAll.executeQuery();
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model= (DefaultTableModel) table.getModel();
					int column = rsmd.getColumnCount();
					String[] colName = new String[column];
					//setRowCount is to make sure the records are not duplicated. 
					model.setRowCount(0);
					for( int i = 0; i < column; i++) {
						colName[i]=rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
						
						String a, b,c,d,f;
						while(rs.next()) {
							a = rs.getString(1);
							b = rs.getString(2);
							c = rs.getString(3);
							d = rs.getString(4);
							f = rs.getString(5);
							String[] row = {a,b,c,d,f};
							model.addRow(row);
									}
					} }
				
				
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Wrong input, try again");
				}
			}
		});
		btnNewButton_4.setBounds(108, 565, 134, 21);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Bon\\Desktop\\SemesterProject\\pexels-andreea-ch-1166644.jpg"));
		lblNewLabel_4.setBounds(0, 0, 623, 626);
		contentPane.add(lblNewLabel_4);
	}
}

