package GUI;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Menu extends BasicGameState {
	
	int flag = 0;
	
	private Music music;
	private Sound wood;
	
	Image classic;
	Image background;
	Image play;
	Image credits;
	Image instructions;
	Image exit;
	Image logo;
	
	Image Kunai;

	int xClassic = 100;
	int xPlay = 100;
	int xInst = 100;
	int xCred = 100;
	int xExit = 100;
	
	int yClassic = 100;
	int yPlay = 200;
	int yInst = 300;
	int yCred = 400;
	int yExit = 500;
	
	float scPlay = 0.5f;
	float scInst = 0.5f;
	float scCredits = 0.5f;
	float scExit = 0.5f;
	float scClassic = 0.5f;
	
	public Menu(int state) {
		
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("Images\\menu background.jpg");
		play = new Image("Images\\Arcade.png");
		instructions = new Image("Images\\Instructions.png");
		credits = new Image("Images\\Credits.png");
		exit = new Image("Images\\Exit.png");
		logo = new Image("Images\\Logo.png");
		Kunai = new Image("Images\\Kunai.png");
		classic = new Image("Images\\Classic.png");

		music = new Music("Music\\MusicTheme.ogg");
		wood = new Sound("Music\\wood.ogg");

		music.setVolume(0.5f);
		music.loop();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int posX = Mouse.getX();
		int posY = 720 - Mouse.getY();
			
		background.draw(0, 0, 1f);
		classic.draw(xClassic, yClassic, scClassic);
		play.draw(xPlay, yPlay, scPlay);
		instructions.draw(xInst, yInst, scInst);
		credits.draw(xCred, yCred, scCredits);
		exit.draw(xExit, yExit, scExit);
		
		logo.draw(600, yClassic + 140, 1.2f);
		
		Kunai.draw(posX, posY, 0.5f);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		int posX = Mouse.getX();
		int posY = Mouse.getY();

		if( (posX > 100 && posX < 0.5 * classic.getWidth() + 100) && (posY > 550 && posY < 620 )) {
			scClassic = 0.6f;
			if(Mouse.isButtonDown(0)) {
				wood.play(1f, 0.01f);
				sbg.addState(new Levels(Game.Levels));
				sbg.getState(Game.Levels).init(gc, sbg);
				flag = 1;
			}
		}
		else
			scClassic = 0.5f;
		
		if( (posX > 100 && posX < 0.5 * play.getWidth() + 100) && (posY > 450 && posY < 520 )) {
			scPlay = 0.6f;
			if(Mouse.isButtonDown(0)) {
				wood.play(1f, 0.01f);
				sbg.addState(new ArcadeMenu(Game.ArcadeMenu));
				sbg.getState(Game.ArcadeMenu).init(gc, sbg);
				flag = 6;
			}
		}
		else
			scPlay = 0.5f;
			
		
		if( (posX > 100 && posX < 0.5 * instructions.getWidth() + 100) && (posY > 350 && posY <420)) {
			scInst = 0.6f;
			if(Mouse.isButtonDown(0)) {
				wood.play(1f, 0.01f);
				sbg.addState(new Instructions(Game.Instructions));
				sbg.getState(Game.Instructions).init(gc, sbg);
				flag = 2;
			}
		}
		else 
			scInst = 0.5f;
			
		
		if( (posX > 100 && posX < 0.5 * credits.getWidth() + 100) && (posY > 250 && posY <320)) {
			scCredits = 0.6f;
			if(Mouse.isButtonDown(0)) {
				wood.play(1f, 0.01f);
				sbg.addState(new Credits(Game.Credits));
				sbg.getState(Game.Credits).init(gc, sbg);
				flag = 3;
			}
		}
		else 
			scCredits = 0.5f;
			
		
		if( (posX > 100 && posX < 0.5 * exit.getWidth() + 100) && (posY > 150 && posY <220)) {
			scExit = 0.6f;
			if(Mouse.isButtonDown(0)) {
				flag = 4;	
				wood.play(1f, 0.01f);
			}
		}
		else 
			scExit = 0.5f;
		
		if (flag == 0) {
			xPlay = 100;
			xInst = 100;
			xCred = 100;
			xExit = 100;
			xClassic = 100;
		}
		
		if(flag == 1)
			window("P", delta, sbg);
		
		if(flag == 2)
			window("I", delta, sbg);
		
		if(flag == 3)
			window("C", delta, sbg);
		
		if(flag == 4)
			window("E", delta, sbg);
		
		if(flag == 5 ) 
			window("N", delta, sbg);
		
		if(flag == 6 ) 
			window("A", delta, sbg);
	}
	
	public void window(String window, int delta, StateBasedGame sbg) {
		
		switch (window) {
		
			case("A"): {
				xClassic -= delta;
				xInst -= delta;
				xCred -= delta;
				xExit -= delta;
				
				if(xInst < 0 - instructions.getWidth()) {
					flag = 0;
					sbg.enterState(Game.ArcadeMenu, new FadeOutTransition(), new FadeInTransition());
				}				
				break;
			}
			case("P"): {
				xPlay -= delta;
				xInst -= delta;
				xCred -= delta;
				xExit -= delta;
				
				if(xInst < 0 - instructions.getWidth()) {
					flag = 0;
					sbg.enterState(1 , new FadeOutTransition(), new FadeInTransition());
				}				
				break;
			}
			
			case("I"): {
				xClassic -= delta;
				xPlay -= delta;
				xCred -= delta;
				xExit -= delta;
				
				if(xPlay < 0 - play.getWidth()) {
					flag = 0;
					sbg.enterState(3 , new FadeOutTransition(), new FadeInTransition());
				}	
				break;
			}

			case("C"): {
				xClassic -= delta;
				xInst -= delta;
				xPlay -= delta;
				xExit -= delta;
				
				if(xInst < 0 - instructions.getWidth()) {
					flag = 0;
					sbg.enterState(4 , new FadeOutTransition(), new FadeInTransition());
				}	
				break;
			}

			case("E"): {
				xClassic -= delta;
				xInst -= delta;
				xCred -= delta;
				xPlay -= delta;
				
				if(xInst < 0 - instructions.getWidth()) {
					music.stop();
					System.exit(0);
				}
				break;
			}
			
			case("N"): {
				//ySure -= delta;
				break;
			}
			
			default: return;
		}
	}

	public int getID() {
		return 0;
	}
}
