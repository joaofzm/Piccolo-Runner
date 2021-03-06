package br.com.joaofzm15.piccolo.ui.uiEntities;

import java.awt.Font;
import java.awt.Color;

public class Score {
	
	private Label label;
	private int currentScore = 0;
	public int getScore() {
		return currentScore;
	}

	public Score(int x, int y, int xSize, int ySize) {
		label = new Label(x,y,xSize,ySize );
		label.getJComponent().setText("Score: "+currentScore);
		label.getJComponent().setFont(new Font("Impact",Font.BOLD, 60));
		label.getJComponent().setForeground(new Color(0,120,0));

	}
	
	public void resetScore() {
		currentScore=0;
		label.getJComponent().setText("Score: "+currentScore);
	}
	public void increaseScore() {
		currentScore++;
		label.getJComponent().setText("Score: "+currentScore);
	}
	
	public Label getLabel() {
		return label;
	}
}
