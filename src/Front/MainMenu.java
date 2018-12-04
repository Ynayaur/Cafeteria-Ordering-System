package Front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

import myCafeteriaOrderingSystem.Menu;
import myCafeteriaOrderingSystem.OrderMenu;
import myCafeteriaOrderingSystem.impleDatabaseOperations;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.Color;

public class MainMenu {

	private JFrame frame;
	private static List Mlist = new ArrayList<Menu>();
	private static List menupanelList = new ArrayList<MenuPanel>();
	private static List mealList = new ArrayList<OrderMenu>();
	private static int num;
	private static double price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
		initialize();
	}
	
	public static void TotalPrice() {
		mealList.clear();
		num = 0;
		price = 0;
		for(int i = 0; i < menupanelList.size(); i++) {
			OrderMenu Mtemp = ((MenuPanel) menupanelList.get(i)).getOrderMenu();
			int temp = Mtemp.getDishNumber();
			
			if(temp > 0) {
				//impleDatabaseOperations menuGet = new impleDatabaseOperations();
				
				mealList.add(((MenuPanel) menupanelList.get(i)).getOrderMenu());
				num = num + temp;
				
				try {
					
					for(int j = 0; j < Mlist.size(); j++) {
						if(((Menu)Mlist.get(j)).getDishID() == Mtemp.getDishID()) {
							if(((Menu)Mlist.get(j)).getIsBargain()) {
								price += temp * ((Menu)Mlist.get(j)).getBargainPrice();
							}
							
							else price += temp * ((Menu)Mlist.get(j)).getPrice();
						}
						
						
					}
					
				}
				
				catch(Exception e) {
					
				}
				
				
			}
		}
		
		OrderSubmitPanel.setLable(num, price);
		
		
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


		
		
		
		
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = null;
		//panel.add(scrollPane);
		
		
		
		try {
		
			impleDatabaseOperations menuGet = new impleDatabaseOperations();
			
			Mlist = menuGet.getMenu();
			
			for(int i = 0, j = 0; i < Mlist.size(); i++ , j++) {
				if(((Menu)Mlist.get(i)).getDeleted()) {
					continue;
				}
				
				else {
				
					
					//System.out.println("133");
					MenuPanel Mpanel = new MenuPanel((Menu)Mlist.get(i), j+1);
					//scrollPane.add(Mpanel);
					
					System.out.println("133");
					
					panel.add(Mpanel);
					
					
					menupanelList.add(Mpanel);
				}
				
			}
			
			
			
			if((Mlist.size() + 1) <= 9) {
				for(int i = Mlist.size(); i % 10 != 0; i++) {
					MenuPanel Mpanel = new MenuPanel(i+1);
					//scrollPane.add(Mpanel);
					
					panel.add(Mpanel);
				}
			}
				
				
			
			scrollPane = new JScrollPane(panel);
			
			
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
			Toolkit.getDefaultToolkit().beep();

			JOptionPane.showMessageDialog(null, e.getMessage(), "错误信息",JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		
		
		
		JPanel panel_8 = new JPanel();
		frame.getContentPane().add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
		
		JLabel label = new JLabel("\u4ECA\u65E5\u83DC\u54C1");
		panel_8.add(label);
		label.setBackground(new Color(255, 228, 196));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("华文楷体", Font.BOLD, 23));
		
//		JLabel label_1 = new JLabel("\u4ECA\u65E5\u83DC\u54C1");
//		scrollPane.setColumnHeaderView(label_1);
//		label_1.setHorizontalAlignment(SwingConstants.CENTER);
//		label_1.setFont(new Font("华文楷体", Font.BOLD, 23));
		
		
//		JLabel label = new JLabel("\u4ECA\u65E5\u83DC\u54C1");
//		label.setBackground(new Color(255, 228, 196));
//		frame.getContentPane().add(label);
//		label.setHorizontalAlignment(SwingConstants.CENTER);
//		label.setFont(new Font("华文楷体", Font.BOLD, 23));
		
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
		
		
		
		
		
		frame.getContentPane().add(scrollPane);
		
		
		OrderSubmitPanel ordersubmitpanel = new OrderSubmitPanel(frame);
		
		frame.getContentPane().add(ordersubmitpanel);
		
		
		
		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(new Color(255, 250, 205));
//		frame.getContentPane().add(panel_1);
//		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
//		
//		JLabel label_1 = new JLabel("1.");
//		label_1.setBackground(new Color(255, 228, 196));
//		label_1.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 20));
//		label_1.setHorizontalAlignment(SwingConstants.CENTER);
//		panel_1.add(label_1);
//		
//		JLabel label_2 = new JLabel("\u83DC\u54C1\u540D");
//		label_2.setFont(new Font("华文楷体", Font.BOLD, 22));
//		label_2.setHorizontalAlignment(SwingConstants.CENTER);
//		panel_1.add(label_2);
//		
//		JLabel label_3 = new JLabel("12.3");
//		label_3.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 23));
//		label_3.setHorizontalAlignment(SwingConstants.CENTER);
//		panel_1.add(label_3);
//		
////		JSplitPane splitPane1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,panel,panel_1);
////	     /*设置splitPane1的分隔线位置，0.3是相对于splitPane1的大小而定，因此这个值的范围在0.0～1.0
////	      *中。若你使用整数值来设置splitPane的分隔线位置，如第34行所示，则所定义的值以pixel为计算单位
////	      */
////	     splitPane1.setDividerLocation(0.1);
////	     /*设置JSplitPane是否可以展开或收起(如同文件总管一般)，设为true表示打开此功能。
////	      */
////	     splitPane1.setOneTouchExpandable(false);
////	     splitPane1.setDividerSize(1);//设置分隔线宽度的大小，以pixel为计算单位。
////		
//		
//		JPanel panel_2 = new JPanel();
//		frame.getContentPane().add(panel_2);
//		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
//		
//		JLabel label_4 = new JLabel("1.");
//		label_4.setHorizontalAlignment(SwingConstants.CENTER);
//		label_4.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 20));
//		panel_2.add(label_4);
//		
//		JLabel label_5 = new JLabel("\u83DC\u54C1\u540D");
//		label_5.setHorizontalAlignment(SwingConstants.CENTER);
//		label_5.setFont(new Font("华文楷体", Font.BOLD, 22));
//		panel_2.add(label_5);
//		
//		JLabel label_6 = new JLabel("12.3");
//		label_6.setHorizontalAlignment(SwingConstants.CENTER);
//		label_6.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 23));
//		panel_2.add(label_6);
//		
//		JPanel panel_3 = new JPanel();
//		panel_3.setBackground(new Color(255, 250, 205));
//		frame.getContentPane().add(panel_3);
//		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
//		
//		JLabel label_7 = new JLabel("1.");
//		label_7.setBackground(new Color(255, 245, 238));
//		label_7.setHorizontalAlignment(SwingConstants.CENTER);
//		label_7.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 20));
//		panel_3.add(label_7);
//		
//		JLabel label_8 = new JLabel("\u83DC\u54C1\u540D");
//		label_8.setHorizontalAlignment(SwingConstants.CENTER);
//		label_8.setFont(new Font("华文楷体", Font.BOLD, 22));
//		panel_3.add(label_8);
//		
//		JLabel label_9 = new JLabel("12.3");
//		label_9.setHorizontalAlignment(SwingConstants.CENTER);
//		label_9.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 23));
//		panel_3.add(label_9);
//		
//		JPanel panel_4 = new JPanel();
//		frame.getContentPane().add(panel_4);
//		panel_4.setLayout(new GridLayout(0, 3, 0, 0));
//		
//		JLabel label_10 = new JLabel("1.");
//		label_10.setHorizontalAlignment(SwingConstants.CENTER);
//		label_10.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 20));
//		panel_4.add(label_10);
//		
//		JLabel label_11 = new JLabel("\u83DC\u54C1\u540D");
//		label_11.setHorizontalAlignment(SwingConstants.CENTER);
//		label_11.setFont(new Font("华文楷体", Font.BOLD, 22));
//		panel_4.add(label_11);
//		
//		JLabel label_12 = new JLabel("12.3");
//		label_12.setHorizontalAlignment(SwingConstants.CENTER);
//		label_12.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 23));
//		panel_4.add(label_12);
//		
//		JPanel panel_5 = new JPanel();
//		panel_5.setBackground(new Color(255, 250, 205));
//		frame.getContentPane().add(panel_5);
//		panel_5.setLayout(new GridLayout(0, 3, 0, 0));
//		
//		JLabel label_13 = new JLabel("1.");
//		label_13.setHorizontalAlignment(SwingConstants.CENTER);
//		label_13.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 20));
//		panel_5.add(label_13);
//		
//		JLabel label_14 = new JLabel("\u83DC\u54C1\u540D");
//		label_14.setHorizontalAlignment(SwingConstants.CENTER);
//		label_14.setFont(new Font("华文楷体", Font.BOLD, 22));
//		panel_5.add(label_14);
//		
//		JLabel label_15 = new JLabel("12.3");
//		label_15.setHorizontalAlignment(SwingConstants.CENTER);
//		label_15.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 23));
//		panel_5.add(label_15);
	}
}
