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

public class ArcadeMenu extends BasicGameState {
	
	int flagIcons = 0;
	
	Image background;
	Image pom;
	Image pomSliced;
	Image Menu;
	
	Image fruit;
	Image fruitSliced;
	
	Image Kunai;

	Image back;

	
	public ArcadeMenu (int state) {
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		Levels.flag = 0;
		
		background = new Image("Images\\menu background.jpg");

		pom = new Image("Images\\Pomegranate.png");
		pomSliced = new Image("Images\\PomegranateSliced.png");
		
		Menu = new Image("Images\\MenuArcade.png");

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
		
		if (flagIcons == 1) {
			fruit = pomSliced;
		}
		
		else
			fruit = pom;
		
		fruit.draw(550, 300, 0.3f);
		
		Kunai.draw(posX, posY, 0.5f);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		int Xpos = Mouse.getX();
		int Ypos = Mouse.getY();
		
		Input io = gc.getInput();
		
		if((Xpos > 30 && Xpos<150) && (Ypos>630 && Ypos<700)) {
			if(Mouse.isButtonDown(0))
				sbg.enterState(0 , new FadeOutTransition(), new FadeInTransition());
		}
		
		if((Xpos>560 && Xpos<760) && (Ypos>230 && Ypos<430)) {
			flagIcons = 1;
			if(io.isMouseButtonDown(0)) {
				Levels.flag = 4;
				sbg.addState(new Play(Game.Play));
				sbg.getState(Game.Play).init(gc, sbg);
				sbg.enterState(Game.Play , new FadeOutTransition(), new FadeInTransition());
				}
		}

		else 
			flagIcons = 0;
	}

	@Override
	public int getID() {
		return 5;
	}
}
