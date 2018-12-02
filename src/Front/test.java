package Front;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import myCafeteriaOrderingSystem.Menu;
import myCafeteriaOrderingSystem.impleDatabaseOperations;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 499);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel_8 = new JPanel();
		frame.getContentPane().add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
		
		JLabel label = new JLabel("\u4ECA\u65E5\u83DC\u54C1");
		panel_8.add(label);
		label.setBackground(new Color(255, 228, 196));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("华文楷体", Font.BOLD, 23));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 250, 205));
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel label_21 = new JLabel("\u5E8F\u53F7");
		label_21.setFont(new Font("华文楷体", Font.BOLD, 22));
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(label_21);
		
		JLabel label_22 = new JLabel("\u83DC\u540D");
		label_22.setFont(new Font("华文楷体", Font.BOLD, 22));
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(label_22);
		
		JLabel label_23 = new JLabel("\u5B9A\u4EF7");
		label_23.setFont(new Font("华文楷体", Font.BOLD, 22));
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(label_23);
		
		JLabel label_24 = new JLabel("\u4ECA\u65E5\u7279\u4EF7");
		label_24.setFont(new Font("华文楷体", Font.BOLD, 22));
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(label_24);
		
		JLabel label_25 = new JLabel("\u8BA2\u9910\u6570\u91CF");
		label_25.setFont(new Font("华文楷体", Font.BOLD, 22));
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(label_25);
		
	
		
		
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		
		
		JPanel panel_1 = new JPanel();
		//panel_1.setBackground(new Color(255, 228, 196));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel label_1 = new JLabel("1.");
		label_1.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 20));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u83DC\u54C1\u540D");
		label_2.setFont(new Font("华文楷体", Font.BOLD, 22));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("12.30");
		label_3.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 23));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_3);
		
		JLabel label_16 = new JLabel("");
		panel_1.add(label_16);
		
		
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 18));
		
		
		spinner.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
		//spinner.setBackground(new Color(255, 228, 196));
		//spinner.setForeground(new Color(255, 228, 196));
		
		panel_1.add(spinner);
		
		
		
		
		
       
		
		
		

		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 205));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel label_4 = new JLabel("1.");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 20));
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("\u83DC\u54C1\u540D");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("华文楷体", Font.BOLD, 22));
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("12.3");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 23));
		panel_2.add(label_6);
		
		JLabel label_17 = new JLabel("");
		panel_2.add(label_17);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setForeground(new Color(255, 51, 0));
		spinner_1.setBackground(new Color(204, 0, 255));
		spinner_1.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 18));
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
		panel_2.add(spinner_1);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel label_7 = new JLabel("1.");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 20));
		panel_3.add(label_7);
		
		JLabel label_8 = new JLabel("\u83DC\u54C1\u540D");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("华文楷体", Font.BOLD, 22));
		panel_3.add(label_8);
		
		JLabel label_9 = new JLabel("12.3");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 23));
		panel_3.add(label_9);
		
		JLabel label_18 = new JLabel("");
		panel_3.add(label_18);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 18));
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
		panel_3.add(spinner_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 250, 205));
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel label_10 = new JLabel("1.");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 20));
		panel_4.add(label_10);
		
		JLabel label_11 = new JLabel("\u83DC\u54C1\u540D");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("华文楷体", Font.BOLD, 22));
		panel_4.add(label_11);
		
		JLabel label_12 = new JLabel("12.3");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 23));
		panel_4.add(label_12);
		
		JLabel label_19 = new JLabel("");
		panel_4.add(label_19);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 18));
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
		panel_4.add(spinner_3);
		
		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel label_13 = new JLabel("1.");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 20));
		panel_5.add(label_13);
		
		JLabel label_14 = new JLabel("\u83DC\u54C1\u540D");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setFont(new Font("华文楷体", Font.BOLD, 22));
		panel_5.add(label_14);
		
		JLabel label_15 = new JLabel("12.3");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 23));
		panel_5.add(label_15);
		
		JLabel label_20 = new JLabel("");
		panel_5.add(label_20);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 18));
		spinner_4.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
		panel_5.add(spinner_4);
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(176, 224, 230));
		frame.getContentPane().add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label_26 = new JLabel("\u603B\u8BA1\uFF1A");
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(label_26);
		
		JLabel label_27 = new JLabel("\u603B\u4EF7");
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(label_27);
		
		JButton btnNewButton_1 = new JButton("\u63D0\u4EA4\u8BA2\u5355");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_7.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_7.add(btnNewButton);
		
		
		 spinner.addChangeListener(new ChangeListener() {
		        @Override
		        public void stateChanged(ChangeEvent e) {
		            JSpinner spinner = (JSpinner) e.getSource();
		            int value = (int)spinner.getValue();
		            
		        }
		    });
		 
		 spinner_1.addChangeListener(new ChangeListener() {
		        @Override
		        public void stateChanged(ChangeEvent e) {
		            JSpinner spinner = (JSpinner) e.getSource();
		            int value = (int)spinner.getValue();
		            
		        }
		    });
		 
		 spinner_2.addChangeListener(new ChangeListener() {
		        @Override
		        public void stateChanged(ChangeEvent e) {
		            JSpinner spinner = (JSpinner) e.getSource();
		            int value = (int)spinner.getValue();
		            
		        }
		    });
		 
		 spinner_3.addChangeListener(new ChangeListener() {
		        @Override
		        public void stateChanged(ChangeEvent e) {
		            JSpinner spinner = (JSpinner) e.getSource();
		            int value = (int)spinner.getValue();
		            
		        }
		    });
		 
		 spinner_4.addChangeListener(new ChangeListener() {
		        @Override
		        public void stateChanged(ChangeEvent e) {
		            JSpinner spinner = (JSpinner) e.getSource();
		            int value = (int)spinner.getValue();
		            
		        }
		    });
		
		
	}

}
