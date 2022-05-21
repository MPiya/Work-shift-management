package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import db.DBConnection;

public class SetShiftGUI  extends JFrame {
	private static final String selectAllQ = "select Employee.FirstName, Employee.LastName, Shift.StartTime, Shift.Endtime, SHIFT.Totalhour,Employee.EmployeeID\r\n"
			+ "FROM Shift\r\n"
			+ "INNER JOIN Employee ON SHIFT.EmployeeID = Employee.EmployeeID";
	private PreparedStatement selectAll ;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField startTime;
	private JTextField endTime;
	private JTextField employee;
	private JTextField location;
	private JTable tblData;
	private JButton Shift;
	private JScrollPane scrollPane_1;

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
	public SetShiftGUI() throws SQLException {
		selectAll = DBConnection.getInstance().getConnection().prepareStatement(selectAllQ); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Shift Menu");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setBounds(65, 61, 133, 60);
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
		JButton btnNewButton = new JButton("Set shift");
		btnNewButton.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				ShiftController shiftcontroller;
				String a = startTime.getText();
				String b = endTime.getText();
				String c = employee.getText();
				int toId = Integer.parseInt(c);
				try {
					// format is yyyy-mm-dd hh:mm e.g. 2020-02-05 10:00
					shiftcontroller = new ShiftController();
					shiftcontroller.setShift(a,b,toId);

				} catch (DataAccessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Wrong input, try again");
				}
				

					}
		});
		btnNewButton.setBounds(60, 291, 92, 29);
		contentPane.add(btnNewButton);
		
		location = new JTextField();
		location.setText("Insert location");
		location.setColumns(10);
		location.setBounds(30, 237, 149, 29);
		contentPane.add(location);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu main = new MainMenu();
				main.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 389, 97, 21);
		contentPane.add(btnNewButton_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(239, 36, 566, 404);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setColumnHeaderView(scrollPane);
		
		tblData = new JTable();
		scrollPane.setViewportView(tblData);
		
		JButton btnNewButton_1_1 = new JButton("Back");
		btnNewButton_1_1.setBounds(22, 389, 85, 21);
		contentPane.add(btnNewButton_1_1);
		
		Shift = new JButton("Display");
		Shift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					ResultSet rs = selectAll.executeQuery();
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model= (DefaultTableModel) tblData.getModel();
					int column = rsmd.getColumnCount();
					String[] colName = new String[column];
					// setRowCount(0) is to reset the row, so when someone click the Display button, it wont show the same record over again.
					model.setRowCount(0);
					for( int i = 0; i < column; i++) {
						colName[i]=rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
						
						String a, b,c,d,f,g;
						while(rs.next()) {
							a = rs.getString(1);
							b = rs.getString(2);
							c = rs.getString(3);
							d = rs.getString(4);
							f = rs.getString(5);
							g = rs.getString(6);
							String[] row = {a,b,c,d,f,g};
							model.addRow(row);
									}
					} }
				
				
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Shift.setBounds(113, 389, 85, 21);
		contentPane.add(Shift);
		
		JLabel lblNewLabel_1 = new JLabel("Record");
		lblNewLabel_1.setBounds(471, 10, 45, 13);
		contentPane.add(lblNewLabel_1);
	}
}
