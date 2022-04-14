package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.DataAccessException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Set Shift");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetShiftGUI shiftGui;
				try {
					shiftGui = new SetShiftGUI();
					shiftGui.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
		});
		btnNewButton.setBounds(10, 112, 117, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Calculate Shift");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculateHours calHour;
				try {
					calHour = new CalculateHours();
					calHour.setVisible(true);
				} catch (DataAccessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(147, 115, 112, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete Shift");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteShift shift = new DeleteShift();
				shift.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(279, 112, 112, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Employee menu");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmployeeMenu main = new EmployeeMenu();
				main.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(123, 10, 162, 54);
		contentPane.add(btnNewButton_3);
	}

}
