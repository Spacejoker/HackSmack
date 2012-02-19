package com.inda.hacksmack.input;

public interface InputEvent  {

	public void keyPressed(int key, char c);

	public void keyReleased(int key, char c);

	public void mouseClicked(int button, int x, int y, int clickCount);

	public void	mouseDragged(int oldx, int oldy, int newx, int newy);

	public void	mouseMoved(int oldx, int oldy, int newx, int newy);

	public void mousePressed(int button, int x, int y);

	public void	mouseReleased(int button, int x, int y);

	public void	mouseWheelMoved(int change);
	
	public boolean isAcceptingEvents();
}
