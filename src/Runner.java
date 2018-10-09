
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Runner {
	
	static String op;
	static String first;
	static String second;
	static String result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		
		GridLayout grid = new GridLayout(4,4);
		Frame outer = new Frame("calc");
		outer.setVisible(true);
		outer.setSize(300,400);
		Panel numPanel = new Panel();
		Panel txtPanel = new Panel();
		numPanel.setVisible(true);
		numPanel.setLayout(grid);
		txtPanel.setVisible(true);
		outer.add(numPanel,BorderLayout.CENTER);
		outer.add(txtPanel,BorderLayout.NORTH);
		
//		numPanel.setSize(200,400);
		numPanel.setVisible(true);
		Button b1,b2,b3,b4,b5,b6;
		Button n1,n2,n3,n4,n5,n6,n7,n8,n9,n0;
		TextField t1;
		
		b1 = new Button("+");
		b2 = new Button("-");
		b3 = new Button("*");
		b4 = new Button("/");
		b6 = new Button("C");
		b5 = new Button("=");
		n1 = new Button("1");
		n2 = new Button("2");
		n3 = new Button("3");
		n4 = new Button("4");
		n5 = new Button("5");
		n6 = new Button("6");
		n7 = new Button("7");
		n8 = new Button("8");
		n9 = new Button("9");
		n0 = new Button("0");
		t1 = new TextField();
		t1.setColumns(20);
		
		Button[] numbers = {n1,n2,n3,n4,n5,n6,n7,n8,n9,n0};
		Button[] operations = {b1,b2,b3,b4,b6,b5};
		
		txtPanel.add(t1);
		for(Button b:numbers) {
			numPanel.add(b);
			b.setBackground(Color.PINK);
		}
		for(Button b:operations) {
			numPanel.add(b);
			b.setBackground(Color.GREEN);
		}
		
		for(Button b:numbers) {
			b.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t1.setText(t1.getText() +b.getLabel());
					}});
		}
		
		for(Button b:operations) {
			b.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(b.getLabel().equals("C")) {
							first = "";
							second = "";
							t1.setText("");
							return;
						}
						if(b.getLabel().equals("=")) {
							second = t1.getText();
							double f;
							double s;
							double r;
							
							f = Double.parseDouble(first);
							s = Double.parseDouble(second);
							if(op.equals("+") ) {
								r = f+s;
								t1.setText(Double.toString(r));
								return;
							}
							if(op.equals("*") ) {
								r = f*s;
								t1.setText(Double.toString(r));
								return;
							}
							if(op.equals("-") ) {
								r = f-s;
								t1.setText(Double.toString(r));
								return;
							}
							if(op.equals("/") ) {
								r = f/s;
								t1.setText(Double.toString(r));
								return;
							}
						}
						op = b.getLabel();
						second = first;
						first = t1.getText();
						t1.setText("");
					}});
		}
		
	}	
	
}