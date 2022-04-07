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
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Canvas;
import javax.swing.JMenu;

public class SetShiftGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtInsert;
	private JTextField txtInsertEndTime;
	private JTextField txtInsertIdOf;
	private JTextField txtInsertLocation;

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
		
		txtInsert = new JTextField();
		txtInsert.setBounds(30, 115, 149, 29);
		contentPane.add(txtInsert);
		txtInsert.setText("Insert start time ");
		txtInsert.setColumns(10);
		
		txtInsertEndTime = new JTextField();
		txtInsertEndTime.setBounds(30, 154, 149, 29);
		contentPane.add(txtInsertEndTime);
		txtInsertEndTime.setText("Insert end time");
		txtInsertEndTime.setColumns(10);
		
		txtInsertIdOf = new JTextField();
		txtInsertIdOf.setBounds(30, 193, 149, 29);
		contentPane.add(txtInsertIdOf);
		txtInsertIdOf.setText("Insert ID of Employee");
		txtInsertIdOf.setColumns(10);
		
		JButton btnNewButton = new JButton("Set");
		btnNewButton.setBounds(60, 291, 47, 21);
		contentPane.add(btnNewButton);
		
		txtInsertLocation = new JTextField();
		txtInsertLocation.setText("Insert location");
		txtInsertLocation.setColumns(10);
		txtInsertLocation.setBounds(30, 237, 149, 29);
		contentPane.add(txtInsertLocation);
	}
}
