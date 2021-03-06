package br.com.joaofzm15.piccolo.ui.uiEntities;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import br.com.joaofzm15.piccolo.logic.CollisionCheck;
import br.com.joaofzm15.piccolo.ui.frames.GameFrame;


public class Blast {
	
	private Label label;
	private GameFrame gameFrameThisBlastBelongsTo;
	private Timer timer;
	
	public Blast(int x, int y, int xSize, int ySize,String iconURL, GameFrame gameFrame) {
		label = new Label(x,y,xSize,ySize, iconURL);
		gameFrameThisBlastBelongsTo=gameFrame;
		startMoving();
	}
	
	public Label getLabel() {
		return label;
	}
	
	public void pauseTimer() {
		timer.cancel();
	}
	
	public void resumeTimer() {
		Blast referenceToThisOwnClass = this;
		timer = new Timer();
		TimerTask myTask = new TimerTask() {
		    public void run() {
		    	label.getJComponent().setBounds(label.getJComponent().getX()-4, 600, 150, 150);
		    	boolean collided = CollisionCheck.checkCollision(gameFrameThisBlastBelongsTo, referenceToThisOwnClass);
		    	if (label.getJComponent().getX()<=-300 && gameFrameThisBlastBelongsTo.isPlayerAlive()) {
			    	label.getJComponent().setBounds(1400, 600, 150, 150);
		    	}
		    	if (collided) {
			    	label.getJComponent().setBounds(-1000, 600, 150, 150);
		    	}
		    }
		};
		timer.schedule(myTask, 0, 10);
	}
	
	public void startMoving() {
		Blast referenceToThisOwnClass = this;
		timer = new Timer();
		TimerTask myTask = new TimerTask() {
		    public void run() {
		    	label.getJComponent().setBounds(label.getJComponent().getX()-12, 600, 150, 150);
		    	boolean collided = CollisionCheck.checkCollision(gameFrameThisBlastBelongsTo, referenceToThisOwnClass);
		    	if (label.getJComponent().getX()<=-300 && gameFrameThisBlastBelongsTo.isPlayerAlive()) {
			    	label.getJComponent().setBounds(1400, 600, 150, 150);
		    	}
		    	if (collided) {
			    	label.getJComponent().setBounds(-1000, 600, 150, 150);
		    	}
		    }
		};
		timer.schedule(myTask, 0, 30);
	}
}
