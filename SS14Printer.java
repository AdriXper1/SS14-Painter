import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SS14Printer {
	public static void main(String[] args) {

		//Declaring Instances//
		Frame frame 	= new Frame();

		Panel panel		= new Panel(new BorderLayout());
		Panel leftPanel	= new Panel(new BorderLayout());

		Panel setings	= new Panel(new GridLayout(3,10));
		Panel colors	= new Panel(new GridLayout(3,10));

		TextArea result = new TextArea("super long test");

		Button bold		= new Button("Bold");
		
		Button red		= new Button();
		Button blue		= new Button();
		Button yellow	= new Button();
		Button black	= new Button();
		 
		//Set Parent Instances//
		frame.add(panel);

		panel.add(result, BorderLayout.EAST);
		panel.add(leftPanel, BorderLayout.WEST);

		leftPanel.add(setings, BorderLayout.NORTH);
		leftPanel.add(colors, BorderLayout.SOUTH);

		setings.add(bold);

		colors.add(red);
		colors.add(blue);
		colors.add(yellow);
		colors.add(black);

		//Atribute Setup//

		red.setBackground(new Color(255,0,0));
		blue.setBackground(new Color(0,0,255));
		yellow.setBackground(new Color(255,255,0));
		black.setBackground(new Color(0,0,0));


		//Set And Show Frame//
		frame.setTitle("Space Printer");
		frame.setSize(1000, 500);
		frame.setVisible(true);


		frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
				System.exit(0);}
			}
		);
	}
}