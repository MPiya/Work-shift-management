package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.ShiftController;
import db.DataAccessException;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Canvas;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class SetShiftGUI extends JFrame {

	private JPanel contentPane;
	private JTextField startTime;
	private JTextField endTime;
	private JTextField employee;
	private JTextField location;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetShiftGUI frame = new SetShiftGUI();
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
	public SetShiftGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("         Set shift");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setBounds(46, 65, 106, 60);
		contentPane.add(lblNewLabel);
		
		startTime = new JTextField();
		startTime.setBounds(30, 115, 149, 29);
		contentPane.add(startTime);
		startTime.setText("Insert start time ");
		startTime.setColumns(10);
		
		endTime = new JTextField();
		endTime.setBounds(30, 154, 149, 29);
		contentPane.add(endTime);
		endTime.setText("Insert end time");
		endTime.setColumns(10);
		
		employee = new JTextField();
		employee.setBounds(30, 193, 149, 29);
		contentPane.add(employee);
		employee.setText("Insert ID of Employee");
		employee.setColumns(10);
		// work fine
		JButton btnNewButton = new JButton("Set");
		btnNewButton.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				ShiftController shiftcontroller;
				String a = startTime.getText();
				String b = endTime.getText();
				String c = employee.getText();
				int toId = Integer.parseInt(c);
				try {
					shiftcontroller = new ShiftController();
					shiftcontroller.setShift(a,b,toId);

				} catch (DataAccessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

					}
		});
		btnNewButton.setBounds(60, 291, 47, 21);
		contentPane.add(btnNewButton);
		
		location = new JTextField();
		location.setText("Insert location");
		location.setColumns(10);
		location.setBounds(30, 237, 149, 29);
		contentPane.add(location);
	}
}
