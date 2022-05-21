package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ShiftController;
import db.DataAccessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DeleteShift extends JFrame {

	private JPanel contentPane;
	private JTextField txtInsertDate;
	private JTextField txtInsertEmployeeId;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteShift frame = new DeleteShift();
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
	public DeleteShift() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtInsertDate = new JTextField();
		txtInsertDate.setText("Insert shift that want to deleted");
		txtInsertDate.setBounds(118, 76, 186, 49);
		contentPane.add(txtInsertDate);
		txtInsertDate.setColumns(10);
		
		txtInsertEmployeeId = new JTextField();
		txtInsertEmployeeId.setText("Insert Employee ID");
		txtInsertEmployeeId.setBounds(118, 135, 186, 38);
		contentPane.add(txtInsertEmployeeId);
		txtInsertEmployeeId.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete Shift");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String deletedDate = txtInsertDate.getText();
					String id = txtInsertEmployeeId.getText();
					int toId = Integer.parseInt(id);
					
					ShiftController shiftCtrl = new ShiftController();
					shiftCtrl.deleteShift(deletedDate, toId);
					JOptionPane.showMessageDialog(null, "The shift is deleted");
				} catch (DataAccessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(128, 203, 127, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Delete Shift Menu");
		lblNewLabel.setBounds(148, 22, 128, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu main = new MainMenu();
				main.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 212, 85, 21);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Bon\\Desktop\\SemesterProject\\RW.JPG"));
		lblNewLabel_1.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel_1);
	}
}
