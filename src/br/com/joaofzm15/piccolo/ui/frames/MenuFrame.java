package br.com.joaofzm15.piccolo.ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.joaofzm15.piccolo.ui.uiEntities.Button;
import br.com.joaofzm15.piccolo.ui.uiEntities.ClickSound;
import br.com.joaofzm15.piccolo.ui.uiEntities.Frame;
import br.com.joaofzm15.piccolo.ui.uiEntities.Label;

public class MenuFrame implements ActionListener {

	private Frame frame;

	private Button startButton;
	private Button optionsButton;
	private Button creditsButton;
	private Button exitButton;

	private Label logo;

	public MenuFrame() {

		if (OptionsFrame.alternativeMenuArt) {
		frame = new Frame("darkmenuBackground.png");
		} else {
			frame = new Frame("menuBackground.png");
		}
			

		logo = new Label(700, 35, 465, 181, "logo.png");
		frame.add(logo);

		startButton = new Button(780, 280, 300, 100, "P L A Y", 0, 153, 0, 66);
		startButton.getJComponent().addActionListener(this);
		frame.add(startButton);

		optionsButton = new Button(805, 430, 250, 50, "O P T I O N S", 102, 0, 204, 22);
		optionsButton.getJComponent().addActionListener(this);
		frame.add(optionsButton);

		creditsButton = new Button(830, 530, 200, 50, "C R E D I T S", 255, 70, 0, 22);
		creditsButton.getJComponent().addActionListener(this);
		frame.add(creditsButton);

		exitButton = new Button(855, 630, 150, 50, "E X I T", 204, 0, 0, 22);
		exitButton.getJComponent().addActionListener(this);
		frame.add(exitButton);

		frame.makeFrameVisible();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		new Thread(new ClickSound()).start();
		
		if (e.getSource() == startButton.getJComponent()) {
			frame.dispose();
			new GameFrame();
		}
		if (e.getSource() == optionsButton.getJComponent()) {
			frame.dispose();
			new OptionsFrame();
		}
		if (e.getSource() == creditsButton.getJComponent()) {
			frame.dispose();
			new CreditsFrame();
		}
		if (e.getSource() == exitButton.getJComponent()) {
			try {
				Thread.sleep(900);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.exit(0);
		}
	}

}