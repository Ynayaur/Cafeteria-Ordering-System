package Front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


//import LogicLayer.Login;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 682, 466);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(144, 134, 91, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(144, 217, 91, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		lblNewLabel.setLabelFor(textField);
		textField.setBounds(263, 137, 195, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		lblNewLabel_1.setLabelFor(passwordField);
		passwordField.setBounds(263, 220, 195, 28);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BA2\u9910\u7CFB\u7EDF\r\n");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 34));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(185, 49, 330, 49);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UID = textField.getText();
				String UPW = new String(passwordField.getPassword());
				LogicLayer.Login login = null;
				
				try {
					
					if(UID.length() == 0 || UPW.length() == 0) {
						throw new Exception("用户名或密码为空");
					}
					
					login = new LogicLayer.Login(UID, UPW);
					
					if(login.LoginAuth()) {
						if(login.getUKind() == 1) {
							//MainMenu.main(null);
						}
						
						
						
					}
				} 
				
				catch (Exception e1) {
					// TODO Auto-generated catch block
					Toolkit.getDefaultToolkit().beep();

					JOptionPane.showMessageDialog(null, e1.getMessage(), "错误信息",JOptionPane.ERROR_MESSAGE);
					
					//System.out.println(e1.getMessage());
					//e1.printStackTrace();
				}
				
			}
		});
		button.setFont(new Font("华文楷体", Font.PLAIN, 17));
		button.setBounds(144, 319, 113, 27);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.setFont(new Font("华文楷体", Font.PLAIN, 17));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button_1.setBounds(422, 319, 113, 27);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u6CE8\u518C");
		button_2.setFont(new Font("华文楷体", Font.PLAIN, 17));
		button_2.setBounds(552, 25, 72, 28);
		frame.getContentPane().add(button_2);
	}
}
