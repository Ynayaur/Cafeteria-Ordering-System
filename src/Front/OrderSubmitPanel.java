package Front;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OrderSubmitPanel extends JPanel {
	static JLabel label_1;
	static JLabel label_2;
	public OrderSubmitPanel(){
		super();
		set();
		
	}
	
	public void set() {
		setBackground(new Color(176, 224, 230));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		label_1 = new JLabel("共 " + 0 + "件");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_1);
		
		
		
		label_2 = new JLabel("共计：￥" + 0.00);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_2);
		
		JButton btnNewButton_1 = new JButton("\u63D0\u4EA4\u8BA2\u5355");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNewButton);
	}
	
	
	static public void setLable(int n, double t) {
		label_1.setText("共：" + n + "件");
		label_2.setText("共计：￥" + t + "");
	}
	


}
