package GUI;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Levels extends BasicGameState {
	
	public static int flag = 0;
	
	int flagIcons = 0;
	
	Image background;
	Image banana;
	Image peach;
	Image melon;
	Image bananaSliced;
	Image peachSliced;
	Image melonSliced;
	Image Banana;
	Image Peach;
	Image Melon;
	Image Menu;
	
	Image Kunai;

	Image back;

	
	public Levels (int state) {
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		background = new Image("Images\\menu background.jpg");
		banana = new Image("Images\\Banana.png");
		bananaSliced = new Image("Images\\Banana Sliced.png");
		peach = new Image("Images\\Peach.png");
		peachSliced = new Image("Images\\Peach Sliced.png");
		melon = new Image("Images\\Melon.png");
		melonSliced = new Image("Images\\Melon Sliced.png");
		Menu = new Image("Images\\Menu.png");

		Kunai = new Image("Images\\Kunai.png");
		
		back = new Image("Images\\back.png");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		int posX = Mouse.getX();
		int posY = 720 - Mouse.getY();

		background.draw(0, 0, 1f);
		back.draw(20, 20, 0.8f);
		Menu.draw(0, 0);
		
		if (flagIcons == 0) {
			Banana = banana;
			Peach = peach;
			Melon = melon;
		}
		
		else if (flagIcons == 1) {
			Banana = bananaSliced;
			Peach = peach;
			Melon = melon;
		}
		
		else if (flagIcons == 2) {
			Banana = banana;
			Peach = peachSliced;
			Melon = melon;
		}
		
		else if (flagIcons == 3) {
			Banana = banana;
			Peach = peach;
			Melon = melonSliced;
		}
		
		Banana.draw(200, 300, 0.3f);
		Peach.draw(550, 300, 0.3f);
		Melon.draw(900, 300, 0.3f);
		
		Kunai.draw(posX, posY, 0.5f);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		int Xpos = Mouse.getX();
		int Ypos = Mouse.getY();
		
		Input io = gc.getInput();
		
		if( (Xpos>30 && Xpos<150) && (Ypos>630 && Ypos<700)) {
			if(Mouse.isButtonDown(0))
				sbg.enterState(0 , new FadeOutTransition(), new FadeInTransition());
		}
		
		if( (Xpos>200 && Xpos<400) && (Ypos>250 && Ypos<450)) {
			flagIcons = 1;
			if(io.isMouseButtonDown(0)) {
				flag = 1;
				sbg.addState(new Play(Game.Play));
				sbg.getState(Game.Play).init(gc, sbg);
				sbg.enterState(2 , new FadeOutTransition(), new FadeInTransition());
				}
		}
		
		else if( (Xpos>550 && Xpos<750) && (Ypos>250 && Ypos<450)) {
			flagIcons = 2;
			if(io.isMouseButtonDown(0)) {
				flag = 2;
				sbg.addState(new Play(Game.Play));
				sbg.getState(Game.Play).init(gc, sbg);
				sbg.enterState(2 , new FadeOutTransition(), new FadeInTransition());
				}
		}
		
		else if( (Xpos>900 && Xpos<1100) && (Ypos>250 && Ypos<450)) {
			flagIcons = 3;
			if(io.isMouseButtonDown(0)) {
				flag = 3;
				sbg.addState(new Play(Game.Play));
				sbg.getState(Game.Play).init(gc, sbg);
				sbg.enterState(2 , new FadeOutTransition(), new FadeInTransition());
				}
		}

		else 
			flagIcons = 0;
	}

	@Override
	public int getID() {
		return 1;
	}

}
