import java.awt.*;
import java.awt.event.*;
import java.net.URI;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class SS14Printer extends Frame implements ActionListener, TextListener, ItemListener{

	//Declaring Instances//
	Frame frame 	= new Frame();

	MenuBar menuBar = new MenuBar();

	Menu fileMenu	= new Menu("File");
		MenuItem savMenuItem  = new MenuItem("Save");

	Menu blockMenu  = new Menu("Add Block");
		MenuItem upperHalfBlock							= new MenuItem("▀ : Upper half block");
		MenuItem lowerOneEighthBlock					= new MenuItem("▁ : Lower one eighth block");
		MenuItem lowerOneQuarterBlock					= new MenuItem("▂ : Lower one quarter block");
		MenuItem lowerThreeEighthsBlock					= new MenuItem("▃ : Lower three eighths block");
		MenuItem lowerHalfBlock							= new MenuItem("▄ : Lower half block");
		MenuItem lowerFiveEighthsBlock					= new MenuItem("▅ : Lower five eighths block");
		MenuItem lowerThreeQuartersBlock				= new MenuItem("▆ : Lower three quarters block");
		MenuItem lowerSevenEighthsBlock					= new MenuItem("▇ : Lower seven eighths block");
		MenuItem fullBlock								= new MenuItem("█ : Full block");

		MenuItem leftSevenEighthsBlock					= new MenuItem("▉ : Left seven eighths block");
		MenuItem leftThreeQuartersBlock					= new MenuItem("▊ : Left three quarters block");
		MenuItem leftFiveEighthsBlock 					= new MenuItem("▋ : Left five eighths block");
		MenuItem leftHalfBlock							= new MenuItem("▌ : Left half block");
		MenuItem leftThreeEighthsBlock					= new MenuItem("▍ : Left three eighths block");
		MenuItem leftOneQuarterBlock					= new MenuItem("▎ : Left one quarter block");
		MenuItem leftOneEighthBlock						= new MenuItem("▏ : Left one eighth block");
		MenuItem rightHalfBlock							= new MenuItem("▐ : Right half block");

		MenuItem lightShade								= new MenuItem("░ : Light shade");
		MenuItem mediumShade							= new MenuItem("▒ : Medium shade");
		MenuItem darkShade								= new MenuItem("▓ : Dark shade");

		MenuItem upperOneEighthBlock					= new MenuItem("▔ : Upper one eighth block");
		MenuItem rightOneEighthBlock					= new MenuItem("▕ : Right one eighth block");

		MenuItem quadrantLowerLeft						= new MenuItem("▖ : Quadrant lower left");
		MenuItem quadrantLowerRight						= new MenuItem("▗ : Quadrant lower right");
		MenuItem quadrantUpperLeft						= new MenuItem("▘ : Quadrant upper left");
		MenuItem quadrantUpperLeftLowerLeftLowerRight	= new MenuItem("▙ : Quadrant upper left and lower left and lower right");
		MenuItem quadrantUpperLeftLowerRight			= new MenuItem("▚ : Quadrant upper left and lower right");
		MenuItem quadrantUpperLeftUpperRightLowerLeft	= new MenuItem("▛ : Quadrant upper left and upper right and lower left");
		MenuItem quadrantUpperLeftUpperRightLowerRight	= new MenuItem("▜ : Quadrant upper left and upper right and lower right");
		MenuItem quadrantUpperRight						= new MenuItem("▝ : Quadrant upper right");
		MenuItem quadrantUpperRightLowerLeft			= new MenuItem("▞ : Quadrant upper right and lower left");
		MenuItem quadrantUpperRightLowerLeftLowerRight	= new MenuItem("▟ : Quadrant upper right and lower left and lower right");



	Menu helpMenu	= new Menu("Help");
		MenuItem guidMenuItem = new MenuItem("SS14 documentation");

	Panel panel		 = new Panel(new GridLayout(1,2));
	Panel leftPanel  = new Panel(new BorderLayout());

	Panel setings	 = new Panel(new GridLayout(3,10));
	Panel colors	 = new Panel(new GridLayout(3,10));

	TextArea text    = new TextArea("super long test");
	JTextPane result = new JTextPane();
	JScrollPane jsp  = new JScrollPane(result);

	Checkbox size1Checkbox		= new Checkbox("Size1");
	Checkbox size2Checkbox		= new Checkbox("Size2");
	Checkbox size3Checkbox		= new Checkbox("Size3");
	Checkbox boldCheckbox		= new Checkbox("Bold");
	Checkbox italicCheckbox		= new Checkbox("Italic");
	Checkbox bolditalicCheckbox	= new Checkbox("Bold-Italic");
	Checkbox monoCheckbox		= new Checkbox("Mono");

	Button   bulletButton		= new Button("Bullet");
	
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
			fileMenu.add(savMenuItem);
		
		menuBar.add(blockMenu);
			blockMenu.add(upperHalfBlock);
			blockMenu.add(lowerOneEighthBlock);
			blockMenu.add(lowerOneQuarterBlock);
			blockMenu.add(lowerThreeEighthsBlock);
			blockMenu.add(lowerHalfBlock);
			blockMenu.add(lowerFiveEighthsBlock);
			blockMenu.add(lowerThreeQuartersBlock);
			blockMenu.add(lowerSevenEighthsBlock);
			blockMenu.add(fullBlock);

			blockMenu.add(leftSevenEighthsBlock);
			blockMenu.add(leftThreeQuartersBlock);
			blockMenu.add(leftFiveEighthsBlock);
			blockMenu.add(leftHalfBlock);
			blockMenu.add(leftThreeEighthsBlock);
			blockMenu.add(leftOneQuarterBlock);
			blockMenu.add(leftOneEighthBlock);
			blockMenu.add(rightHalfBlock);

			blockMenu.add(lightShade);
			blockMenu.add(mediumShade);
			blockMenu.add(darkShade);

			blockMenu.add(upperOneEighthBlock);
			blockMenu.add(rightOneEighthBlock);

			blockMenu.add(quadrantLowerLeft);
			blockMenu.add(quadrantLowerRight);
			blockMenu.add(quadrantUpperLeft);
			blockMenu.add(quadrantUpperLeftLowerLeftLowerRight);
			blockMenu.add(quadrantUpperLeftLowerRight);
			blockMenu.add(quadrantUpperLeftUpperRightLowerLeft);
			blockMenu.add(quadrantUpperLeftUpperRightLowerRight);
			blockMenu.add(quadrantUpperRight);
			blockMenu.add(quadrantUpperRightLowerLeft);
			blockMenu.add(quadrantUpperRightLowerLeftLowerRight);



		menuBar.add(helpMenu);
			helpMenu.add(guidMenuItem);

		panel.add(leftPanel);
		panel.add(text);
		panel.add(jsp);

		leftPanel.add(setings, BorderLayout.NORTH);
		leftPanel.add(colors, BorderLayout.SOUTH);

		setings.add(size1Checkbox);
		setings.add(size2Checkbox);
		setings.add(size3Checkbox);
		setings.add(boldCheckbox);
		setings.add(italicCheckbox);
		setings.add(bolditalicCheckbox);
		setings.add(monoCheckbox);

		setings.add(bulletButton);

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
		result.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
		result.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		result.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		result.setText(this.text.getText());


		//Activate Buton//
		upperHalfBlock.addActionListener(this);
		lowerOneEighthBlock.addActionListener(this);
		lowerOneQuarterBlock.addActionListener(this);
		lowerThreeEighthsBlock.addActionListener(this);
		lowerHalfBlock.addActionListener(this);
		lowerFiveEighthsBlock.addActionListener(this);
		lowerThreeQuartersBlock.addActionListener(this);
		lowerSevenEighthsBlock.addActionListener(this);
		fullBlock.addActionListener(this);

		leftSevenEighthsBlock.addActionListener(this);
		leftThreeQuartersBlock.addActionListener(this);
		leftFiveEighthsBlock.addActionListener(this);
		leftHalfBlock.addActionListener(this);
		leftThreeEighthsBlock.addActionListener(this);
		leftOneQuarterBlock.addActionListener(this);
		leftOneEighthBlock.addActionListener(this);
		rightHalfBlock.addActionListener(this);

		lightShade.addActionListener(this);
		mediumShade.addActionListener(this);
		darkShade.addActionListener(this);

		upperOneEighthBlock.addActionListener(this);
		rightOneEighthBlock.addActionListener(this);

		quadrantLowerLeft.addActionListener(this);
		quadrantLowerRight.addActionListener(this);
		quadrantUpperLeft.addActionListener(this);
		quadrantUpperLeftLowerLeftLowerRight.addActionListener(this);
		quadrantUpperLeftLowerRight.addActionListener(this);
		quadrantUpperLeftUpperRightLowerLeft.addActionListener(this);
		quadrantUpperLeftUpperRightLowerRight.addActionListener(this);
		quadrantUpperRight.addActionListener(this);
		quadrantUpperRightLowerLeft.addActionListener(this);
		quadrantUpperRightLowerLeftLowerRight.addActionListener(this);

		guidMenuItem.addActionListener(this);

		size1Checkbox.addItemListener(this);
		size2Checkbox.addItemListener(this);
		size3Checkbox.addItemListener(this);
		boldCheckbox.addItemListener(this);
		italicCheckbox.addItemListener(this);
		bolditalicCheckbox.addItemListener(this);
		monoCheckbox.addItemListener(this);

		bulletButton.addActionListener(this);

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
		if (e.getSource() == this.upperHalfBlock)
    		this.text.setText(this.text.getText() + "▀");
		if (e.getSource() == this.lowerOneEighthBlock)
		    this.text.setText(this.text.getText() + "▁");
		if (e.getSource() == this.lowerOneQuarterBlock)
		    this.text.setText(this.text.getText() + "▂");
		if (e.getSource() == this.lowerThreeEighthsBlock)
		    this.text.setText(this.text.getText() + "▃");
		if (e.getSource() == this.lowerHalfBlock)
		    this.text.setText(this.text.getText() + "▄");
		if (e.getSource() == this.lowerFiveEighthsBlock)
		    this.text.setText(this.text.getText() + "▅");
		if (e.getSource() == this.lowerThreeQuartersBlock)
		    this.text.setText(this.text.getText() + "▆");
		if (e.getSource() == this.lowerSevenEighthsBlock)
		    this.text.setText(this.text.getText() + "▇");
		if (e.getSource() == this.fullBlock)
		    this.text.setText(this.text.getText() + "█");
		if (e.getSource() == this.leftSevenEighthsBlock)
		    this.text.setText(this.text.getText() + "▉");
		if (e.getSource() == this.leftThreeQuartersBlock)
		    this.text.setText(this.text.getText() + "▊");
		if (e.getSource() == this.leftFiveEighthsBlock)
		    this.text.setText(this.text.getText() + "▋");
		if (e.getSource() == this.leftHalfBlock)
		    this.text.setText(this.text.getText() + "▌");
		if (e.getSource() == this.leftThreeEighthsBlock)
		    this.text.setText(this.text.getText() + "▍");
		if (e.getSource() == this.leftOneQuarterBlock)
		    this.text.setText(this.text.getText() + "▎"); 
		if (e.getSource() == this.leftOneEighthBlock)
		    this.text.setText(this.text.getText() + "▏");
		if (e.getSource() == this.rightHalfBlock)
		    this.text.setText(this.text.getText() + "▐");
		if (e.getSource() == this.lightShade)
		    this.text.setText(this.text.getText() + "░");
		if (e.getSource() == this.mediumShade)
		    this.text.setText(this.text.getText() + "▒");
		if (e.getSource() == this.darkShade)
		    this.text.setText(this.text.getText() + "▓");
		if (e.getSource() == this.upperOneEighthBlock)
		    this.text.setText(this.text.getText() + "▔");
		if (e.getSource() == this.rightOneEighthBlock)
		    this.text.setText(this.text.getText() + "▕");
		if (e.getSource() == this.quadrantLowerLeft)
		    this.text.setText(this.text.getText() + "▖");
		if (e.getSource() == this.quadrantLowerRight)
		    this.text.setText(this.text.getText() + "▗");
		if (e.getSource() == this.quadrantUpperLeft)
		    this.text.setText(this.text.getText() + "▘");
		if (e.getSource() == this.quadrantUpperLeftLowerLeftLowerRight)
		    this.text.setText(this.text.getText() + "▙");
		if (e.getSource() == this.quadrantUpperLeftLowerRight)
		    this.text.setText(this.text.getText() + "▚");
		if (e.getSource() == this.quadrantUpperLeftUpperRightLowerLeft)
		    this.text.setText(this.text.getText() + "▛");
		if (e.getSource() == this.quadrantUpperLeftUpperRightLowerRight)
		    this.text.setText(this.text.getText() + "▜");
		if (e.getSource() == this.quadrantUpperRight)
		    this.text.setText(this.text.getText() + "▝");
		if (e.getSource() == this.quadrantUpperRightLowerLeft)
		    this.text.setText(this.text.getText() + "▞");
		if (e.getSource() == this.quadrantUpperRightLowerLeftLowerRight)
		    this.text.setText(this.text.getText() + "▟");

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

		//Buttons//
		if (e.getSource() == this.bulletButton)
		{
			this.text.setText(this.text.getText() + "• ");
		}

		//Colors//
		if (e.getSource() == this.redButton)
		{
			this.text.setText(this.text.getText() + "[color=#ff0000]");
		}

		if (e.getSource() == this.blueButton)
		{
			this.text.setText(this.text.getText() + "[color=#0000ff]");
		}

		if (e.getSource() == this.yellowButton)
		{
			this.text.setText(this.text.getText() + "[color=#ffff00]");
		}

		if (e.getSource() == this.blackButton)
		{
			this.text.setText(this.text.getText() + "[/color]");
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
			.replace("\n", "<br>")
			.replace("\t", "&emsp;")
			.replace(" ", "&nbsp;")
			.replace("[head=1]", "<span style=\"font-size:28pt; font-weight:bold;\">")
			.replace("[head=2]", "<span style=\"font-size:20pt; font-weight:bold;\">")
			.replace("[head=3]", "<span style=\"font-size:17pt; font-weight:bold;\">")
			.replace("[/head]", "</span>")
			.replace("[bold]", "<b>")
			.replace("[/bold]", "</b>")
			.replace("[italic]", "<i>")
			.replace("[/italic]", "</i>")
			.replace("[bolditalic]", "<b><i>")
			.replace("[/bolditalic]", "</i></b>")
			.replace("[mono]", "<tt>")
			.replace("[/mono]", "</tt>")
			.replaceAll("\\[color=#([0-9-a-f-A-F]{6})\\]", "<span style=\"color:#$1;\">")
			.replace("[/color]", "</span>");
			//left color
	}

	public static void main(String[] args) {new SS14Printer();}
}