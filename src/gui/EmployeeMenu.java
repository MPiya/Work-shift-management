package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EmployeeController;
import db.DataAccessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EmployeeMenu extends JFrame {

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
	 */
	public EmployeeMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 398);
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
		txtInsertPhoneNumber.setText("Insert phone number");
		txtInsertPhoneNumber.setBounds(10, 171, 111, 19);
		contentPane.add(txtInsertPhoneNumber);
		txtInsertPhoneNumber.setColumns(10);
		
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
		btnNewButton.setBounds(10, 211, 111, 26);
		contentPane.add(btnNewButton);
		
		txtInsertEmployeeId = new JTextField();
		txtInsertEmployeeId.setText("Insert Employee ID that want to be deleted ");
		txtInsertEmployeeId.setBounds(289, 68, 177, 74);
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
		btnNewButton_1.setBounds(281, 211, 138, 26);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Create Employee");
		lblNewLabel.setBounds(10, 24, 96, 24);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Delete Employee");
		lblNewLabel_1.setBounds(303, 18, 83, 36);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Employee Menu");
		lblNewLabel_2.setBounds(146, -12, 96, 47);
		contentPane.add(lblNewLabel_2);
		
		txtInsertAddress_1 = new JTextField();
		txtInsertAddress_1.setText("Insert address");
		txtInsertAddress_1.setBounds(146, 58, 132, 19);
		contentPane.add(txtInsertAddress_1);
		txtInsertAddress_1.setColumns(10);
		
		txtInsertP = new JTextField();
		txtInsertP.setText("Insert phone number");
		txtInsertP.setBounds(146, 87, 131, 34);
		contentPane.add(txtInsertP);
		txtInsertP.setColumns(10);
		
		txtInsertEmployeeId_1 = new JTextField();
		txtInsertEmployeeId_1.setText("Insert Employee ID");
		txtInsertEmployeeId_1.setBounds(146, 131, 131, 41);
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
		btnNewButton_2.setBounds(131, 211, 125, 26);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_3 = new JLabel("Change address and phone number");
		lblNewLabel_3.setBounds(108, 23, 169, 26);
		contentPane.add(lblNewLabel_3);
		
		btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu main = new MainMenu();
				main.setVisible(true);
			}
			
		});
		btnNewButton_3.setBounds(10, 266, 85, 21);
		contentPane.add(btnNewButton_3);
	}
}
