import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class SS14Printer extends Frame implements ActionListener{

	//Declaring Instances//
	Frame frame 	= new Frame();

	MenuBar menuBar = new MenuBar();

	Menu fileMenu	= new Menu("File");
	Menu helpMenu	= new Menu("Help");

	MenuItem savMenuItem  = new MenuItem("Save");
	MenuItem guidMenuItem = new MenuItem("SS14 documentation");

	Panel panel		= new Panel(new BorderLayout());
	Panel leftPanel	= new Panel(new BorderLayout());

	Panel setings	= new Panel(new GridLayout(3,10));
	Panel colors	= new Panel(new GridLayout(3,10));

	TextArea result = new TextArea("super long test");

	Button sizeButton		= new Button("Size");
	Button boldButton		= new Button("Bold");
	Button italicButton		= new Button("Italic");
	Button bolditalicButton	= new Button("Bold-Italic");
	Button monoButton		= new Button("Mono");
	
	Button redButton		= new Button();
	Button blueButton		= new Button();
	Button yellowButton		= new Button();
	Button blackButton		= new Button();

	public SS14Printer()
	{ 
		//Set Parent Instances//
		frame.add(panel);
		frame.setMenuBar(menuBar);

		menuBar.add(fileMenu);
		menuBar.add(helpMenu);

		fileMenu.add(savMenuItem);
		helpMenu.add(guidMenuItem);

		panel.add(result, BorderLayout.EAST);
		panel.add(leftPanel, BorderLayout.WEST);

		leftPanel.add(setings, BorderLayout.NORTH);
		leftPanel.add(colors, BorderLayout.SOUTH);

		setings.add(sizeButton);
		setings.add(boldButton);
		setings.add(italicButton);
		setings.add(bolditalicButton);
		setings.add(monoButton);

		colors.add(redButton);
		colors.add(blueButton);
		colors.add(yellowButton);
		colors.add(blackButton);

		//Atribute Setup//
		redButton.setBackground		(new Color(255,0,0));
		blueButton.setBackground	(new Color(0,0,255));
		yellowButton.setBackground	(new Color(255,255,0));
		blackButton.setBackground	(new Color(0,0,0));

		//Activate Buton//
		guidMenuItem.addActionListener(this);

		sizeButton.addActionListener(this);
		boldButton.addActionListener(this);
		italicButton.addActionListener(this);
		bolditalicButton.addActionListener(this);
		monoButton.addActionListener(this);

		redButton.addActionListener(this);
		blueButton.addActionListener(this);
		yellowButton.addActionListener(this);
		blackButton.addActionListener(this);



		//Set And Show Frame//
		frame.setTitle("Space Printer");
		frame.setSize(1000, 500);
		frame.setVisible(true);


		//Close Window//
		frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
				System.exit(0);}
			}
		);
	}

	public void actionPerformed(ActionEvent e)
	{
		//Menu Bar//
		if (e.getSource() == this.guidMenuItem)
		{
			try{
				Desktop.getDesktop().browse(new URI("https://wiki.spacestation14.com/wiki/Guide_to_Paperwork"));
			}
			catch (Exception error)
			{
				System.out.print("can't open URL: " + error.getMessage());
			}
		}

		//Formating//
		if (e.getSource() == this.sizeButton)
		{
			this.result.setText(this.result.getText() + "[head=1][\\head]");
		}

		if (e.getSource() == this.boldButton)
		{
			this.result.setText(this.result.getText() + "[bold][\\bold]");
		}

		if (e.getSource() == this.italicButton)
		{
			this.result.setText(this.result.getText() + "[italic][\\italic]");
		}

		if (e.getSource() == this.bolditalicButton)
		{
			this.result.setText(this.result.getText() + "[bolditalic][\\bolditalic]");
		}

		if (e.getSource() == this.monoButton)
		{
			this.result.setText(this.result.getText() + "[mono][\\mono]");
		}


		//Colors//
		if (e.getSource() == this.redButton)
		{
			this.result.setText(this.result.getText() + "[color=ff0000][\\color]");
		}

		if (e.getSource() == this.blueButton)
		{
			this.result.setText(this.result.getText() + "[color=0000ff][\\color]");
		}

		if (e.getSource() == this.yellowButton)
		{
			this.result.setText(this.result.getText() + "[color=ffff00][\\color]");
		}

		if (e.getSource() == this.blackButton)
		{
			this.result.setText(this.result.getText() + "[color=000000][\\color]");
		}
	}

	public static void main(String[] args) {new SS14Printer();}
}