package com.inda.hacksmack.input;

import org.newdawn.slick.*;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Input;
import java.util.ArrayList;

public class InputHandler implements InputListener {
	private final boolean DEBUG = true;
	private ArrayList<InputEvent> events;
	
	private static InputHandler _instance;

	static {  
		try {  
			_instance = new InputHandler(); 
		} catch (SlickException e) { 
			throw new RuntimeException("Failed to load inputhandler." + e.getMessage());
		}
	}


	private InputHandler()  throws SlickException {
		events = new ArrayList<InputEvent>();
	}



	public void purgeEvents(){
		events.clear();
	}

	public void addEvent(InputEvent e){
		events.add(e);
	}


	public final static InputHandler getInstance(){
		return _instance;
	}
	
	@Override
	public void keyPressed(int key, char c){
		if(DEBUG)
			System.out.println(key+ " " + c);
		for(InputEvent e: events)
			if(e.isAcceptingEvents())
				e.keyPressed(key, c);

	}
	
	@Override
	public void keyReleased(int key, char c){
		if(DEBUG)
			System.out.println(key + " " + c);
		for(InputEvent e: events)
			if(e.isAcceptingEvents())
				e.keyReleased(key, c);

	}
	
	@Override
	public void mouseClicked(int arg0, int arg1, int arg2, int arg3) {
		if(DEBUG)
			System.out.println(arg0 + " " + arg1 + " " + arg2 + " " + arg3);
		for(InputEvent e: events)
			if(e.isAcceptingEvents())
				e.mouseClicked(arg0, arg1, arg2, arg3);

	}
	
	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		if(DEBUG)
			System.out.println(arg0 + " " + arg1 + " " + arg2 + " " + arg3);
		for(InputEvent e: events)
			if(e.isAcceptingEvents())
				e.mouseDragged(arg0, arg1, arg2, arg3);
	}
	
	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
		if(DEBUG)
			System.out.println(arg0 + " " + arg1 + " " + arg2 + " " + arg3);
		for(InputEvent e: events)
			if(e.isAcceptingEvents())
				e.mouseMoved(arg0, arg1, arg2, arg3);

	}
	
	@Override
	public void mousePressed(int arg0, int arg1, int arg2) {
		if(DEBUG)
			System.out.println("Mouse pressed! Button: "+arg0 + " Position: " + arg1 + " " + arg2);
		for(InputEvent e: events)
			if(e.isAcceptingEvents())
				e.mousePressed(arg0, arg1, arg2);
		

	}
	
	@Override
	public void mouseReleased(int arg0, int arg1, int arg2) {
		if(DEBUG)
			System.out.println(arg0 + " " + arg1 + " " + arg2);
		for(InputEvent e: events)
			if(e.isAcceptingEvents())
				e.mouseReleased(arg0, arg1, arg2);

	}
	
	@Override
	public void mouseWheelMoved(int arg0) {
		if(DEBUG)
			System.out.println(arg0);
		for(InputEvent e: events)
			if(e.isAcceptingEvents())
				e.mouseWheelMoved(arg0);

	}
	
	@Override
	public boolean isAcceptingInput() {
		return true;
	}
	
	//Massa saker som inte används härifrån och nedåt
	@Override
	public void inputEnded() {


	}
	@Override
	public void inputStarted() {

	}

	@Override
	public void setInput(Input arg0) {

	}
	
	@Override
	public void controllerButtonPressed(int arg0, int arg1) {

	}
	@Override
	public void controllerButtonReleased(int arg0, int arg1) {


	}
	@Override
	public void controllerDownPressed(int arg0) {


	}
	@Override
	public void controllerDownReleased(int arg0) {


	}
	@Override
	public void controllerLeftPressed(int arg0) {


	}
	@Override
	public void controllerLeftReleased(int arg0) {


	}
	@Override
	public void controllerRightPressed(int arg0) {


	}
	@Override
	public void controllerRightReleased(int arg0) {


	}
	@Override
	public void controllerUpPressed(int arg0) {


	}
	@Override
	public void controllerUpReleased(int arg0) {


	}

}
