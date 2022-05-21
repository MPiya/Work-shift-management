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
import javax.swing.JTextArea;

public class CalculateHours extends JFrame {

	private JPanel contentPane;
	private JTextField txtInsertEmployeeId;
	private JTextField txtInsertDate;
	private JTextField txtInsertEndDate;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculateHours frame = new CalculateHours();
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
	public CalculateHours() throws DataAccessException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtInsertEmployeeId = new JTextField();
		txtInsertEmployeeId.setText("Insert Employee ID");
		txtInsertEmployeeId.setBounds(10, 94, 96, 19);
		contentPane.add(txtInsertEmployeeId);
		txtInsertEmployeeId.setColumns(10);
		
		txtInsertDate = new JTextField();
		txtInsertDate.setText("Insert start date");
		txtInsertDate.setBounds(10, 133, 96, 19);
		contentPane.add(txtInsertDate);
		txtInsertDate.setColumns(10);
		
		txtInsertEndDate = new JTextField();
		txtInsertEndDate.setText("Insert end date");
		txtInsertEndDate.setBounds(10, 173, 96, 19);
		contentPane.add(txtInsertEndDate);
		txtInsertEndDate.setColumns(10);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(147, 91, 330, 192);
		contentPane.add(textArea_1);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String id = txtInsertEmployeeId.getText();
			// // convert String id  to int id 
			int toId = Integer.parseInt(id);
			String date = txtInsertDate.getText();
			String endDate = txtInsertEndDate.getText();
			try {
				ShiftController shiftCtrl = new ShiftController ();
				int totalHour = shiftCtrl.calculateTotalHoursBetweenDates(toId,date,endDate);

				textArea_1.setText("Total work hours of employee id " + toId 
						+ " between dates " 
				+ "\r\n" + date + " and " + endDate+ " is " +
						totalHour + " hours");
			} catch (DataAccessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Wrong input, try again");
			}
			
			
			
			}
		});
		btnNewButton.setBounds(10, 217, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Calculate total hours between dates");
		lblNewLabel.setBounds(10, 10, 164, 73);
		contentPane.add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu main = new MainMenu();
				main.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(21, 260, 85, 21);
		contentPane.add(btnNewButton_1);
		
		
		
		
		
		
	}
}
