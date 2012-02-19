package com.inda.hacksmack.input;

import org.newdawn.slick.*;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Input;

public class InputHandler implements InputListener {

	private static InputHandler _instance;

	static {  
		try {  
			_instance = new InputHandler(); 
		} catch (SlickException e) { 
			throw new RuntimeException("Failed to load inputhandler." + e.getMessage());
		}
	}


	private InputHandler()  throws SlickException {
	}

	@Override
	public void keyPressed(int key, char c){
		System.out.println(key+ " " + c);


	}

	public void keyReleased(int key, char c){
		System.out.println(key + " " + c);

	}


	public void printKeys(){


		//  System.out.println(getMouseX() + " " + getMouseY());

	}


	public void getInputEvents(){}

	public void purgeEvents(){}

	public boolean addEvent(){return true;}


	public final static InputHandler getInstance(){
		return _instance;
	}
	@Override
	public void mouseClicked(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		System.out.println("Mouse pressed!" + arg0 + " " + arg1 + " " + arg2);

	}
	@Override
	public void mouseReleased(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseWheelMoved(int arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub

	}
	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub

	}
	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void setInput(Input arg0) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void controllerButtonPressed(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}
	@Override
	public void controllerButtonReleased(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}
	@Override
	public void controllerDownPressed(int arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void controllerDownReleased(int arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void controllerLeftPressed(int arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void controllerLeftReleased(int arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void controllerRightPressed(int arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void controllerRightReleased(int arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void controllerUpPressed(int arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void controllerUpReleased(int arg0) {
		// TODO Auto-generated method stub

	}

}
