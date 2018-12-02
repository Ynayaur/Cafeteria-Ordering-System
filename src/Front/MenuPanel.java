package Front;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import myCafeteriaOrderingSystem.Menu;
import myCafeteriaOrderingSystem.OrderMenu;

public class MenuPanel extends JPanel{
	OrderMenu ordermenu;
	public MenuPanel(int i) {
		super();
		defultSet(i);
		ordermenu = null;
		
	}
	
	public MenuPanel(Menu m, int i) {
		super();
		set(m, i);
		ordermenu = new OrderMenu(m.getDishID(), 0);
	}
	
	public OrderMenu getOrderMenu() {
		return ordermenu;
	}
	
	
	private void setNum(int n) {
		ordermenu.setDishNumber(n);
	}
	
	
	private void defultSet(int i) {
		if(i % 2 == 0) {
			setBackground(new Color(255, 250, 205));
		}
		setLayout(new GridLayout(0, 5, 0, 0));
		
		
		JLabel label_1 = new JLabel(" ");
		label_1.setBackground(new Color(255, 228, 196));
		label_1.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 20));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_1);
		
		JLabel label_2 = new JLabel(" ");
		label_2.setFont(new Font("华文楷体", Font.BOLD, 22));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_2);
		
		JLabel label_3 = new JLabel(" ");
		label_3.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 23));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_3);
		
		JLabel label_4 = new JLabel(" ");
		label_2.setFont(new Font("华文楷体", Font.BOLD, 22));
		add(label_4);
		
	}
	
	private void set(Menu m, int i) {
		if(i % 2 == 0) {
			setBackground(new Color(255, 250, 205));
		}
		setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel label_1 = new JLabel(""+i+".");
		label_1.setBackground(new Color(255, 228, 196));
		label_1.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 20));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_1);
		
		
		JLabel label_2 = new JLabel(m.getDishName());
		label_2.setFont(new Font("华文楷体", Font.BOLD, 22));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_2);
		
		JLabel label_3 = new JLabel(" ");
		
		if(m.getIsBargain()) {
			label_3.setText(""+m.getBargainPrice());
		}
		
		
		
		else {
			label_3.setText(""+m.getPrice());
		}
		
		
		label_3.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 23));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_3);
		
		
		JLabel label_4 = new JLabel("");
		if(m.getIsBargain()) {
			label_4.setText("今日特价");
		}
		
		else {
			label_4.setText("");
		}
		
		label_4.setFont(new Font("华文楷体", Font.BOLD, 22));
		add(label_4);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 18));
		spinner.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
		
		add(spinner);
		
		
		
		 spinner.addChangeListener(new ChangeListener() {
		        @Override
		        public void stateChanged(ChangeEvent e) {
		            JSpinner spinner = (JSpinner) e.getSource();
		            int value = (int)spinner.getValue();
		            setNum(value);
		            MainMenu.TotalPrice();
		        }
		    });
		
		
		
		
		
		
		
		
		
		
		
	
	}

}
