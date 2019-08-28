package GUI;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {
	
	public static final String gameName = "Fruit Ninja Game";
	public static final int mainMenu = 0;
	public static final int Levels = 1;
	public static final int Play = 2;
	public static final int Instructions = 3;
	public static final int Credits = 4;
	public static final int ArcadeMenu = 5;
	public static final int Arcade = 6;
	

	public Game(String gameName) {
		super(gameName);
		this.addState(new Menu(mainMenu));		
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(mainMenu).init(gc, this);
		this.enterState(mainMenu);
	}
	
	public static void main(String[] args) {
		
		try {
			AppGameContainer appgc = new AppGameContainer(new Game(gameName));
			appgc.setShowFPS(false);
			appgc.setMouseGrabbed(true);
			appgc.setDisplayMode(1280, 720, false);
			appgc.start();
			
		} catch (SlickException e) {
			System.out.println("Slick Exception Found");
		}
	}
}