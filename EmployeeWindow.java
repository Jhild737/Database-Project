import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class EmployeeWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeWindow window = new EmployeeWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Employees");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitle.setBounds(183, 10, 135, 32);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblSSN = new JLabel("SSN");
		lblSSN.setHorizontalAlignment(SwingConstants.CENTER);
		lblSSN.setBounds(51, 48, 45, 13);
		frame.getContentPane().add(lblSSN);
		
		textField = new JTextField();
		textField.setBounds(25, 64, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(25, 114, 96, 19);
		frame.getContentPane().add(textField_1);
		
		JLabel lblFName = new JLabel("First Name");
		lblFName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFName.setBounds(25, 98, 96, 13);
		frame.getContentPane().add(lblFName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(25, 167, 96, 19);
		frame.getContentPane().add(textField_2);
		
		JLabel lblLName = new JLabel("Last Name");
		lblLName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLName.setBounds(25, 151, 96, 13);
		frame.getContentPane().add(lblLName);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(25, 219, 96, 19);
		frame.getContentPane().add(textField_3);
		
		JLabel lblMInit = new JLabel("Middle Initial");
		lblMInit.setHorizontalAlignment(SwingConstants.CENTER);
		lblMInit.setBounds(25, 203, 96, 13);
		frame.getContentPane().add(lblMInit);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(25, 272, 96, 19);
		frame.getContentPane().add(textField_4);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setBounds(51, 256, 45, 13);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(166, 234, 45, 13);
		frame.getContentPane().add(lblGender);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(139, 247, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBounds(139, 270, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosition.setBounds(139, 151, 103, 13);
		frame.getContentPane().add(lblPosition);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(139, 167, 103, 19);
		frame.getContentPane().add(comboBox);
	}
}
