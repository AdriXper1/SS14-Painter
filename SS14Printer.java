import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import javax.swing.JTextPane;

public class SS14Printer extends Frame implements ActionListener, TextListener, ItemListener{

	//Declaring Instances//
	Frame frame 	= new Frame();

	MenuBar menuBar = new MenuBar();

	Menu fileMenu	= new Menu("File");
	Menu helpMenu	= new Menu("Help");

	MenuItem savMenuItem  = new MenuItem("Save");
	MenuItem guidMenuItem = new MenuItem("SS14 documentation");

	Panel panel		 = new Panel(new GridLayout(1,3));
	Panel leftPanel	 = new Panel(new BorderLayout());

	Panel setings	 = new Panel(new GridLayout(3,10));
	Panel colors	 = new Panel(new GridLayout(3,10));

	TextArea text    = new TextArea("super long test");
	JTextPane result = new JTextPane();

	Checkbox size1Checkbox		= new Checkbox("Size1");
	Checkbox size2Checkbox		= new Checkbox("Size2");
	Checkbox size3Checkbox		= new Checkbox("Size3");
	Checkbox boldCheckbox		= new Checkbox("Bold");
	Checkbox italicCheckbox		= new Checkbox("Italic");
	Checkbox bolditalicCheckbox	= new Checkbox("Bold-Italic");
	Checkbox monoCheckbox		= new Checkbox("Mono");
	
	Button redButton		= new Button();
	Button blueButton		= new Button();
	Button yellowButton		= new Button();
	Button blackButton		= new Button();

	Label  label			= new Label();

	public SS14Printer()
	{ 
		//Set Parent Instances//
		frame.add(panel);
		frame.setMenuBar(menuBar);

		menuBar.add(fileMenu);
		menuBar.add(helpMenu);

		fileMenu.add(savMenuItem);
		helpMenu.add(guidMenuItem);

		panel.add(leftPanel);
		panel.add(text);
		panel.add(result);

		leftPanel.add(setings, BorderLayout.NORTH);
		leftPanel.add(colors, BorderLayout.SOUTH);

		setings.add(size1Checkbox);
		setings.add(size2Checkbox);
		setings.add(size3Checkbox);
		setings.add(boldCheckbox);
		setings.add(italicCheckbox);
		setings.add(bolditalicCheckbox);
		setings.add(monoCheckbox);

		colors.add(redButton);
		colors.add(blueButton);
		colors.add(yellowButton);
		colors.add(blackButton);

		//Atribute Setup//
		redButton.setBackground		(new Color(255,0,0));
		blueButton.setBackground	(new Color(0,0,255));
		yellowButton.setBackground	(new Color(255,255,0));
		blackButton.setBackground	(new Color(0,0,0));

		result.setContentType("text/html");

		//Activate Buton//
		guidMenuItem.addActionListener(this);

		size1Checkbox.addItemListener(this);
		size2Checkbox.addItemListener(this);
		size3Checkbox.addItemListener(this);
		boldCheckbox.addItemListener(this);
		italicCheckbox.addItemListener(this);
		bolditalicCheckbox.addItemListener(this);
		monoCheckbox.addItemListener(this);

		redButton.addActionListener(this);
		blueButton.addActionListener(this);
		yellowButton.addActionListener(this);
		blackButton.addActionListener(this);

		text.addTextListener(this);



		//Set And Show Frame//
		frame.setTitle("Space Printer");
		frame.setLocation(0, 0);
		frame.setSize(1000,500);
		frame.setExtendedState(MAXIMIZED_BOTH);
		frame.setVisible(true);


		//Close Window//
		frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
				System.exit(0);}
			}
		);
	}

	public void itemStateChanged(ItemEvent e)
	{
		//Formating//
		if (e.getSource() == this.size1Checkbox)
		{
			if (this.size1Checkbox.getState())
				this.text.setText(this.text.getText() + "[head=1]");
			else
				this.text.setText(this.text.getText() + "[/head]");
		}

		if (e.getSource() == this.size2Checkbox)
		{
			if (this.size2Checkbox.getState())
				this.text.setText(this.text.getText() + "[head=2]");
			else
				this.text.setText(this.text.getText() + "[/head]");
		}

		if (e.getSource() == this.size3Checkbox)
		{
			if (this.size3Checkbox.getState())
				this.text.setText(this.text.getText() + "[head=3]");
			else
				this.text.setText(this.text.getText() + "[/head]");
		}

		if (e.getSource() == this.boldCheckbox)
		{
			if (this.boldCheckbox.getState())
				this.text.setText(this.text.getText() + "[bold]");
			else
				this.text.setText(this.text.getText() + "[/bold]");
		}

		if (e.getSource() == this.italicCheckbox)
		{
			if (this.italicCheckbox.getState())
				this.text.setText(this.text.getText() + "[italic]");
			else
				this.text.setText(this.text.getText() + "[/italic]");
		}

		if (e.getSource() == this.bolditalicCheckbox)
		{
			if (this.bolditalicCheckbox.getState())
				this.text.setText(this.text.getText() + "[bolditalic]");
			else
				this.text.setText(this.text.getText() + "[/bolditalic]");
		}

		if (e.getSource() == this.monoCheckbox)
		{
			if (this.monoCheckbox.getState())
				this.text.setText(this.text.getText() + "[mono]");
			else
				this.text.setText(this.text.getText() + "[/mono]");
		}
		this.text.setCaretPosition(this.text.getText().length());
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

		//Colors//
		if (e.getSource() == this.redButton)
		{
			this.text.setText(this.text.getText() + "[color=ff0000]");
		}

		if (e.getSource() == this.blueButton)
		{
			this.text.setText(this.text.getText() + "[color=0000ff]");
		}

		if (e.getSource() == this.yellowButton)
		{
			this.text.setText(this.text.getText() + "[color=ffff00]");
		}

		if (e.getSource() == this.blackButton)
		{
			this.text.setText(this.text.getText() + "[color=000000]");
		}
		this.text.setCaretPosition(this.text.getText().length());
	}

	public void textValueChanged(TextEvent e)
	{
		if (e.getSource() == this.text)
		{
			this.result.setText(Decoder(this.text.getText()));
			this.text.requestFocus();
		}
	}


	public String Decoder(String text)
	{
		String toReturn = "<html>";

		toReturn += this.text.getText();

		toReturn += "</html>";
		return toReturn
			.replace("[head=1]", "<span style=\"font-size:28pt; font-weight:bold;\">")
			.replace("[head=2]", "<span style=\"font-size:20pt; font-weight:bold;\">")
			.replace("[head=3]", "<span style=\"font-size:17pt; font-weight:bold;\">")
			.replace("[/head]", "</span>")
			.replace("[bold]", "<b>")
			.replace("[/bold]", "</b>")
			.replace("[italic]", "<i>")
			.replace("[/italic]", "</i>")
			.replace("[bolditalic]", "<b><i>")
			.replace("[/bolditalic]", "</i></b>");
			//left color, mono
	}

	public static void main(String[] args) {new SS14Printer();}
}