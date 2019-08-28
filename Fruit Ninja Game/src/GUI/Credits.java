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

public class Credits extends BasicGameState {
	
	Image background;
	Image back;
	
	Image Kunai;
	
	public Credits (int state) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("Images\\CreditsMenu.png");
		back = new Image("Images\\back.png");
		
		Kunai = new Image("Images\\Kunai.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int posX = Mouse.getX();
		int posY = 720 - Mouse.getY();

		background.draw(0, 0, 1f);
		back.draw(20, 20, 0.8f);
		
		Kunai.draw(posX, posY, 0.5f);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

		int Xpos = Mouse.getX();
		int Ypos = Mouse.getY();
		
		Input io = gc.getInput();
		
		if( (Xpos>30 && Xpos<150) && (Ypos>630 && Ypos<700)) {
			if(io.isMouseButtonDown(0))
				sbg.enterState(0 , new FadeOutTransition(), new FadeInTransition());
		}
	}

	@Override
	public int getID() {
		return 4;
	}

}